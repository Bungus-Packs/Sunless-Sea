package bungus.sunlesssea.world.gen.density;

import bungus.sunlesssea.Sunlesssea;
import bungus.sunlesssea.world.gen.biome.ModBiomeMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;

public record BiomeCell(DensityFunction biomeCache) implements DensityFunction{
    public static final MapCodec<BiomeCell> MAP_CODEC= RecordCodecBuilder.mapCodec(
            (instance)->instance.group(DensityFunction.FUNCTION_CODEC.fieldOf("argument").forGetter(BiomeCell::biomeCache))
                    .apply(instance,BiomeCell::new));
    public static final CodecHolder<BiomeCell> CODEC=CodecHolder.of(MAP_CODEC);

    @Override
    public double sample(NoisePos pos) {
        return biomeCache.sample(pos);

    }

    @Override
    public void fill(double[] densities, EachApplier applier) {
        applier.fill(densities,this);
    }

    @Override
    public DensityFunction apply(DensityFunctionVisitor visitor) {
        return visitor.apply(new BiomeCell(biomeCache.apply(visitor)));
    }

    //boilerplate or smgth
    @Override public double minValue() {return ModDensityFunctions.DEFAULT_MIN_OUTPUT;}
    @Override public double maxValue() {return ModDensityFunctions.DEFAULT_MAX_OUTPUT;}
    @Override public CodecHolder<? extends DensityFunction> getCodecHolder() {return CODEC;}
    public DensityFunction biomeCache(){return biomeCache;}
}