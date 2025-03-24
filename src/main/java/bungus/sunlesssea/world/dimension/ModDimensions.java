package bungus.sunlesssea.world.dimension;

import bungus.sunlesssea.Sunlesssea;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> SUNLESSSEA_KEY=RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Sunlesssea.MOD_ID,"sunless_sea"));
    public static final RegistryKey<World> SUNLESSSEA_LEVEL_KEY=RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Sunlesssea.MOD_ID,"sunless_sea"));
    public static final RegistryKey<DimensionType> SUNLESSSEA_DIM_TYPE=RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Sunlesssea.MOD_ID,"sunless_sea_type"));




    public static void register(){}
}

