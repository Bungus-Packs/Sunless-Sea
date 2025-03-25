package bungus.sunlesssea.command;

import bungus.bunguslib.config.BungusLibConfig;
import bungus.sunlesssea.Sunlesssea;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;

public class TestCommand {
    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        BlockPos pos = context.getSource().getPlayer().getBlockPos();
        Sunlesssea.LOGGER.info(context.getSource().getWorld().getBiomeForNoiseGen(pos.getX() / 4, pos.getY() / 4, pos.getZ() / 4).getKey().get().getValue().getPath());
        context.getSource().getWorld().getRegistryManager().get(RegistryKeys.CHUNK_GENERATOR_SETTINGS).getKeys().stream().forEach(key -> Sunlesssea.LOGGER.info(key + "   "));
        Sunlesssea.LOGGER.info(BungusLibConfig.lavaAquiferData + "");
        return 1;
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("sunlesstest").executes(TestCommand::run));
    }
}
