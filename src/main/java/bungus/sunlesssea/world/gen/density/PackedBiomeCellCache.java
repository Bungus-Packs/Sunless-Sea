package bungus.sunlesssea.world.gen.density;

import bungus.sunlesssea.Sunlesssea;
import bungus.sunlesssea.world.gen.biome.ModBiomeMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public record PackedBiomeCellCache() implements DensityFunction.Base{
    public static final CodecHolder<PackedBiomeCellCache> CODEC=CodecHolder.of(MapCodec.unit(new PackedBiomeCellCache()));

    @Override
    public double sample(NoisePos pos) {
        return ModBiomeMap.INSTANCE.checkBiome(ModBiomeMap.INSTANCE.packBiomes(pos),"sulphur_pools")?1:0;
        /*
        if(pos.blockX()%16==0&&pos.blockY()%16==0&&pos.blockZ()%16==0){
            return 100;
                    //ModBiomeMap.INSTANCE.packBiomes(pos);
        }return 0;

         */

    }

    //boilerplate or smgth
    @Override public double minValue() {return ModDensityFunctions.DEFAULT_MIN_OUTPUT;}
    @Override public double maxValue() {return ModDensityFunctions.DEFAULT_MAX_OUTPUT;}
    @Override public CodecHolder<? extends DensityFunction> getCodecHolder() {return CODEC;}
}