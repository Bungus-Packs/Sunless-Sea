package bungus.sunlesssea.command;

import bungus.sunlesssea.Sunlesssea;
import bungus.sunlesssea.world.gen.biome.ModBiomeMap;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import qouteall.imm_ptl.core.mixin.common.MixinServerLevel;

public class TestCommand {
    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        BlockPos pos=context.getSource().getPlayer().getBlockPos();
        Sunlesssea.LOGGER.info(context.getSource().getWorld().getBiomeForNoiseGen(pos.getX()/4,pos.getY()/4,pos.getZ()/4).getKey().get().getValue().getPath());
        return 1;
    }
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment){
    dispatcher.register(CommandManager.literal("sunlesstest").executes(TestCommand::run));
    }
}
