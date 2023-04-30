package com.undefinedbhvr.seaborgium.fabric;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.fabricmc.api.ModInitializer;

public class SeaborgiumFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Seaborgium.init();
        Seaborgium.LOGGER.info("Loader detected: Fabric");
    }
}