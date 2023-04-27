package com.undefinedbhvr.seaborgium.forge;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Seaborgium.MOD_ID)
public class SeaborgiumForge {
    public SeaborgiumForge() {
        Seaborgium.init();
    }
}