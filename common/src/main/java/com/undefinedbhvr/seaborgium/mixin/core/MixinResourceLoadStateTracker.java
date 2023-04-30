package com.undefinedbhvr.seaborgium.mixin.core;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.minecraft.client.ResourceLoadStateTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;

@Mixin(ResourceLoadStateTracker.class)
public class MixinResourceLoadStateTracker {
    @Inject(method = "finishReload", at = @At("HEAD"))
    private void sb$reloadResourcePacks(CallbackInfo ci) {
        Seaborgium.invalidate_shaders();
    }
}
