package com.undefinedbhvr.seaborgium.mixin.core;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.undefinedbhvr.seaborgium.cache.CachedShaderProgram;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.HashMap;

@Mixin(GlStateManager.class)
public class MixinGLStateManager {
    private static final HashMap<Integer, CachedShaderProgram> cached_shaders = new HashMap<>();
    /**
     * @author UndefinedBHVR
     * @reason Implements a basic cache for _glGetUniformLocation().
     */
    @Overwrite
    public static int _glGetUniformLocation(int i, CharSequence charSequence) {
        RenderSystem.assertOnRenderThread();
        return cached_shaders.computeIfAbsent(i, v -> new CachedShaderProgram(i)).get_uniform_location((String) charSequence);
    }

}
