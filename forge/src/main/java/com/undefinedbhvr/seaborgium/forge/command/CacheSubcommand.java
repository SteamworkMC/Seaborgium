package com.undefinedbhvr.seaborgium.forge.command;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.undefinedbhvr.seaborgium.Seaborgium;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class CacheSubcommand {
    public static ArgumentBuilder<CommandSourceStack, ?> command() {
        return Commands.literal("invalidate").executes(CacheSubcommand::execute);
    }

    public static int execute(CommandContext<CommandSourceStack> context) {
        RenderSystem.assertOnRenderThread();
        Seaborgium.invalidate_shaders();
        context.getSource().sendSuccess(new TextComponent("Invalidated shader cache"), false);
        return 1;
    }
}
