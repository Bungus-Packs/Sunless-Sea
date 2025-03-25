package bungus.sunlesssea.world.gen.biome;

import bungus.sunlesssea.world.dimension.ModDimensions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.minecraft.world.World;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import qouteall.q_misc_util.MiscHelper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ModBiomeMap {
    public static final int RESOLUTION = 4;
    public static final ModBiomeMap INSTANCE = new ModBiomeMap();
    public final World world;
    private final HashMap<String, Integer> biomes = new HashMap<>();
    private final Cache<String, Integer> cache = CacheBuilder.newBuilder().maximumSize(50000).expireAfterAccess(10, TimeUnit.SECONDS).build();
    private int outputIndex = 1;

    public ModBiomeMap(World w) {
        world = w;
    }

    public ModBiomeMap() {
        world = MiscHelper.getServer().getWorld(ModDimensions.SUNLESSSEA_LEVEL_KEY);
    }

    public boolean checkBiome(int key, String biome) {
        return biomes.getOrDefault(biome, 0) == key;
    }

    public int packBiomes(DensityFunction.NoisePos pos) {
        //off by one error (but not for x) (???)
        String key = pos.blockX() / RESOLUTION + " " + pos.blockY() / RESOLUTION + " " + pos.blockZ() / RESOLUTION;
        Integer val = cache.getIfPresent(key);
        if (val != null) {
            return val;
        }
        String worldBiome = world.getBiomeForNoiseGen((pos.blockX()) / 4, (pos.blockY()) / 4, (pos.blockZ()) / 4).getKey().get().getValue().getPath();
        Integer prevVal = biomes.putIfAbsent(worldBiome, outputIndex);
        if (prevVal == null) {
            prevVal = outputIndex;
            outputIndex++;
        }
        cache.put(key, prevVal);
        return prevVal;
    }

    public String toString() {
        return biomes.toString();
    }
}
