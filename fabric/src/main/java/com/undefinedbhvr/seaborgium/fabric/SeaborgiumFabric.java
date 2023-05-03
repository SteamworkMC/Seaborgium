package com.undefinedbhvr.seaborgium.fabric;

import com.mojang.brigadier.CommandDispatcher;
import com.undefinedbhvr.seaborgium.Seaborgium;
import com.undefinedbhvr.seaborgium.fabric.command.SeaborgiumCommand;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.commands.CommandBuildContext;

public class SeaborgiumFabric implements ClientModInitializer {
    public static void client_commands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandBuildContext registryAccess) {
        SeaborgiumCommand.register(dispatcher);
    }

    @Override
    public void onInitializeClient() {
        Seaborgium.init();
        Seaborgium.LOGGER.info("Loader detected: Fabric");
        ClientCommandRegistrationCallback.EVENT.register(SeaborgiumFabric::client_commands);
    }
}