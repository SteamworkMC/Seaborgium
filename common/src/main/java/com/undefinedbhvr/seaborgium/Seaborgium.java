package com.undefinedbhvr.seaborgium;

import com.undefinedbhvr.seaborgium.cache.CachedShaderProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Seaborgium {
    private static final HashMap<Integer, CachedShaderProgram> cached_shaders = new HashMap<>();

    public static Logger LOGGER = LoggerFactory.getLogger("Seaborgium");
    public static HashMap<Integer, CachedShaderProgram> get_cached_shaders() {
        return cached_shaders;
    }

    public static void invalidate_shaders() {
        LOGGER.info("Shaders invalidated!");
        cached_shaders.clear();
    }

    public static final String MOD_ID = "seaborgium";
    public static void init() {
        LOGGER.info("Seaborgium is live!");
    }
}