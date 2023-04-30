package com.undefinedbhvr.seaborgium;

import com.undefinedbhvr.seaborgium.cache.CachedShaderProgram;

import java.util.HashMap;

public class Seaborgium {
    private static final HashMap<Integer, CachedShaderProgram> cached_shaders = new HashMap<>();

    public static HashMap<Integer, CachedShaderProgram> get_cached_shaders() {
        return cached_shaders;
    }

    public static void invalidate_shaders() {
        System.out.println("[Seaborgium] Shaders invalidated!");
        cached_shaders.clear();
    }

    public static final String MOD_ID = "seaborgium";
    public static void init() {
        System.out.println("Seaborgium is live!");
    }
}