package com.undefinedbhvr.seaborgium.cache;

import org.lwjgl.opengl.GL20;

import java.util.HashMap;

// Class containing cached data (Currently just uniform locations) for a ShaderProgram.
public class CachedShaderProgram {

    public CachedShaderProgram(int id) {
        this.id = id;
        this.uniform_locations = new HashMap<>();
    }
    // Our program id
    private final int id;
    private final HashMap<String, Integer> uniform_locations;
    public int get_uniform_location(String uniform_name) {
        return uniform_locations.computeIfAbsent(uniform_name, value -> GL20.glGetUniformLocation(this.id, uniform_name));
    }
}
