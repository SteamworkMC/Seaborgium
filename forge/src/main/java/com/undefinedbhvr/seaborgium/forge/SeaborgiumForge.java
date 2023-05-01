package com.undefinedbhvr.seaborgium.forge;

import com.undefinedbhvr.seaborgium.Seaborgium;
import com.undefinedbhvr.seaborgium.forge.command.SeaborgiumCommand;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Seaborgium.MOD_ID)
public class SeaborgiumForge {
    public SeaborgiumForge() {
        Seaborgium.init();
        Seaborgium.LOGGER.info("Loader detected: Forge");
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
    }


    @Mod.EventBusSubscriber(modid = Seaborgium.MOD_ID)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void client_commands(RegisterClientCommandsEvent event) {
            SeaborgiumCommand.register(event.getDispatcher());
        }
    }
}