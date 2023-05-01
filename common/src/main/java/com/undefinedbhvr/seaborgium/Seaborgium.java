package com.undefinedbhvr.seaborgium;

import com.mojang.blaze3d.systems.RenderSystem;
import com.undefinedbhvr.seaborgium.cache.CachedShaderProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Seaborgium {
    public static final String MOD_ID = "seaborgium";
    private static final HashMap<Integer, CachedShaderProgram> cached_shaders = new HashMap<>();
    public static Logger LOGGER = LoggerFactory.getLogger("Seaborgium");

    public static HashMap<Integer, CachedShaderProgram> get_cached_shaders() {
        return cached_shaders;
    }

    public static void invalidate_shaders() {
        RenderSystem.assertOnRenderThread();
        LOGGER.warn("Shader cache invalidated!");
        cached_shaders.clear();
    }

    public static void init() {
        LOGGER.info("Seaborgium is live!");
    }
}