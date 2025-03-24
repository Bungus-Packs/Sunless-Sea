package bungus.sunlesssea.world.gen.density;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;

public record BiomeCell(DensityFunction tempMap, DensityFunction waterMap,String biome) implements DensityFunction{
    public static final MapCodec<BiomeCell> MAP_CODEC= RecordCodecBuilder.mapCodec(
            (instance)->instance.group(
                    DensityFunction.FUNCTION_CODEC.fieldOf("tempMap").forGetter(BiomeCell::tempMap),
                    DensityFunction.FUNCTION_CODEC.fieldOf("waterMap").forGetter(BiomeCell::waterMap),
                    Codec.STRING.fieldOf("biome").forGetter(BiomeCell::biome))
                    .apply(instance,BiomeCell::new));
    public static final CodecHolder<BiomeCell> CODEC=CodecHolder.of(MAP_CODEC);

    @Override
    public double sample(NoisePos pos) {
        return 0;
    }

    //boilerplate or smgth
    @Override public void fill(double[] densities, EachApplier applier) {applier.fill(densities,this);}
    @Override public DensityFunction apply(DensityFunctionVisitor visitor) {return visitor.apply(new BiomeCell(tempMap.apply(visitor),waterMap.apply(visitor),biome));}
    @Override public double minValue() {return ModDensityFunctions.DEFAULT_MIN_OUTPUT;}
    @Override public double maxValue() {return ModDensityFunctions.DEFAULT_MAX_OUTPUT;}
    @Override public CodecHolder<? extends DensityFunction> getCodecHolder() {return CODEC;}
    public DensityFunction tempMap(){return tempMap;}
    public DensityFunction waterMap(){return waterMap;}
    public String biome(){return biome;}
}