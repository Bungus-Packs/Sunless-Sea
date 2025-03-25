package bungus.sunlesssea.world.gen.biome;

import bungus.sunlesssea.Sunlesssea;
import bungus.sunlesssea.world.dimension.ModDimensions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.fabricmc.fabric.impl.biome.BiomeSourceAccess;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import qouteall.imm_ptl.core.mixin.common.MixinMinecraftServer;
import qouteall.imm_ptl.peripheral.mixin.common.dim_stack.MixinMinecraftServer_DimStack;
import qouteall.q_misc_util.MiscHelper;
import qouteall.q_misc_util.mixin.MixinMinecraftServer_Misc;

import java.io.File;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class ModBiomeMap {
    public final World world;
    public static final int RESOLUTION=4;
    public static final ModBiomeMap INSTANCE = new ModBiomeMap();
    private final HashMap<String,Integer> biomes=new HashMap<>();
    private int outputIndex=1;
    private final Cache<String,Integer> cache=CacheBuilder.newBuilder().maximumSize(10000).build();
    public ModBiomeMap(World w){
        world=w;
    }
    public ModBiomeMap(){
        world=MiscHelper.getServer().getWorld(ModDimensions.SUNLESSSEA_LEVEL_KEY);
    }

    public boolean checkBiome(int key, String biome){
        return biomes.getOrDefault(biome,0)==key;
    }

    public int packBiomes(DensityFunction.NoisePos pos){
        //off by one error (but not for x) (???)
        String key=pos.blockX()/RESOLUTION+" "+pos.blockY()/RESOLUTION+" "+pos.blockZ()/RESOLUTION;
        Integer val= cache.getIfPresent(key);
        if(val!=null){
            return val;
        }
        String worldBiome=world.getBiomeForNoiseGen((pos.blockX())/4,(pos.blockY())/4,(pos.blockZ())/4).getKey().get().getValue().getPath();
        Integer prevVal=biomes.putIfAbsent(worldBiome,outputIndex);
        if(prevVal==null){
            prevVal=outputIndex;
            outputIndex++;
        }
        cache.put(key,prevVal);
        return prevVal;
    }

    public String toString(){
        return biomes.toString();
    }
}
