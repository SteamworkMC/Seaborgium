package com.undefinedbhvr.seaborgium.fabric.command;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.undefinedbhvr.seaborgium.Seaborgium;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.network.chat.Component;

public class CacheSubcommand {
    public static ArgumentBuilder<FabricClientCommandSource, ?> command() {
        return ClientCommandManager.literal("invalidate").executes(CacheSubcommand::execute);
    }

    public static int execute(CommandContext<FabricClientCommandSource> context) {
        RenderSystem.assertOnRenderThread();
        Seaborgium.invalidate_shaders();
        context.getSource().sendFeedback(Component.literal("Invalidating shader cache"));
        return 1;
    }
}
