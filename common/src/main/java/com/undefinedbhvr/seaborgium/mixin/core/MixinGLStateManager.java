package com.undefinedbhvr.seaborgium.mixin.core;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.undefinedbhvr.seaborgium.cache.CachedShaderProgram;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import static com.undefinedbhvr.seaborgium.Seaborgium.get_cached_shaders;

@Mixin(GlStateManager.class)
public class MixinGLStateManager {
    /**
     * @author UndefinedBHVR
     * @reason Implements a basic cache for _glGetUniformLocation().
     */
    @Overwrite
    public static int _glGetUniformLocation(int i, CharSequence charSequence) {
        RenderSystem.assertOnRenderThread();
        return get_cached_shaders().computeIfAbsent(i, v -> new CachedShaderProgram(i)).get_uniform_location((String) charSequence);
    }

}
