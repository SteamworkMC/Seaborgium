package com.undefinedbhvr.seaborgium.mixin.core;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {
    // We need to invalidate the cache at the title screen, to ensure we have a clean cache by the time world loading starts.
    // Hopefully.
    @Inject(
            method = "<init>(Z)V",
            at = @At("TAIL")
    )
    private void init(CallbackInfo info) {
        Seaborgium.LOGGER.warn("Shader cache needs invalidated. Reason: Title Screen Created.");
        Seaborgium.invalidate_shaders();
    }
}
