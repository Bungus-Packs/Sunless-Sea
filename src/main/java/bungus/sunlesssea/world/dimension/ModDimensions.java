package bungus.sunlesssea.world.dimension;

import bungus.sunlesssea.Sunlesssea;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> SUNLESSSEA_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Sunlesssea.MOD_ID, "sunless_sea"));
    public static final RegistryKey<World> SUNLESSSEA_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Sunlesssea.MOD_ID, "sunless_sea"));
    public static final RegistryKey<DimensionType> SUNLESSSEA_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Sunlesssea.MOD_ID, "sunless_sea_type"));


    public static void register() {
    }
}

