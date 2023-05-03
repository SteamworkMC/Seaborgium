package com.undefinedbhvr.seaborgium.compat.iris.mixin.iris;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.coderbot.iris.Iris;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Iris.class, remap = false)
public class MixinIris {
    @Inject(method = "reload", at = @At("HEAD"))
    private static void sb$reload_uniform_locs(CallbackInfo ci) {
        Seaborgium.LOGGER.warn("Shader cache needs invalidated. Reason: Iris Shader Reload");
        Seaborgium.invalidate_shaders();
    };
}
