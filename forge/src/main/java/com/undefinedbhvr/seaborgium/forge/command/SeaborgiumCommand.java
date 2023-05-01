package com.undefinedbhvr.seaborgium.forge.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SeaborgiumCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("sbx")
                .then(CacheSubcommand.command())
        );
    }
}
