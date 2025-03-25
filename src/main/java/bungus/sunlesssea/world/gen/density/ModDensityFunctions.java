package bungus.sunlesssea.world.gen.density;

import bungus.sunlesssea.Sunlesssea;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModDensityFunctions {
    public static final double DEFAULT_MIN_OUTPUT=-1000;
    public static final double DEFAULT_MAX_OUTPUT=1000;
    public static final double DEFAULT_ERROR_OUTPUT=0;

    public static void registerFunctions(){
        Registry.register(Registries.DENSITY_FUNCTION_TYPE,new Identifier(Sunlesssea.MOD_ID,"biomecell"),BiomeCell.CODEC.codec());
        Registry.register(Registries.DENSITY_FUNCTION_TYPE,new Identifier(Sunlesssea.MOD_ID,"packedbiomecellcache"),PackedBiomeCellCache.CODEC.codec());
    }
}
