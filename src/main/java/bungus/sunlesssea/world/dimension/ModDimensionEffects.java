package bungus.sunlesssea.world.dimension;

import bungus.sunlesssea.Sunlesssea;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class ModDimensionEffects {
    public static void register(){
        DimensionRenderingRegistry.registerDimensionEffects(new Identifier(Sunlesssea.MOD_ID,"sunless_sea_effects"),
                new DimensionEffects(224,false, DimensionEffects.SkyType.NONE,false,false){
                    @Override
                    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
                        return color.multiply(0.15f);
                    }

                    @Override
                    public boolean useThickFog(int camX, int camY) {
                        return false;
                    }
                });
    }
}
