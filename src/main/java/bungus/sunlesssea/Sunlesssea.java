package bungus.sunlesssea;

import bungus.sunlesssea.command.TestCommand;
import bungus.sunlesssea.world.dimension.ModDimensionEffects;
import bungus.sunlesssea.world.dimension.ModDimensions;
import bungus.sunlesssea.world.gen.density.ModDensityFunctions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandRegistryAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sunlesssea implements ModInitializer {
    public static final String MOD_ID="sunlesssea";
    public static final Logger LOGGER= LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing "+MOD_ID);

        LOGGER.info("Registering Dimensions for "+MOD_ID);
        ModDimensions.register();
        ModDimensionEffects.register();

        LOGGER.info("Registering Commands for "+MOD_ID);
        CommandRegistrationCallback.EVENT.register(TestCommand::register);

        LOGGER.info("Registering Density Functions for "+MOD_ID);
        ModDensityFunctions.registerFunctions();
    }
}
