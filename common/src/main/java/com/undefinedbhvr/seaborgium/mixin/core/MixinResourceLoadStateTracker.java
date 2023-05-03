package com.undefinedbhvr.seaborgium.mixin.core;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.minecraft.client.ResourceLoadStateTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ResourceLoadStateTracker.class)
public class MixinResourceLoadStateTracker {
    @Inject(method = "finishReload", at = @At("HEAD"))
    private void sb$reloadResourcePacks(CallbackInfo ci) {
        Seaborgium.LOGGER.warn("Shader cache needs invalidated. Reason: Resource Pack Reload");
        Seaborgium.invalidate_shaders();
    }
}
