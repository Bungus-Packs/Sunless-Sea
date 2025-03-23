package bungus.sunlesssea;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sunlesssea implements ModInitializer {
    public static final String MOD_ID="sunlesssea";
    public static final Logger LOGGER= LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing "+MOD_ID);
    }
}
