package com.undefinedbhvr.seaborgium.fabric.command;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.undefinedbhvr.seaborgium.Seaborgium;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class CacheSubcommand {
    public static ArgumentBuilder<FabricClientCommandSource, ?> command() {
        return ClientCommandManager.literal("invalidate").executes(CacheSubcommand::execute);
    }

    public static int execute(CommandContext<FabricClientCommandSource> context) {
        RenderSystem.assertOnRenderThread();
        Seaborgium.invalidate_shaders();
        context.getSource().sendFeedback(new TextComponent("Invalidating shader cache"));
        return 1;
    }
}
