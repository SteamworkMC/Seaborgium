# OBSOLETE
### As of July 2023, this mod is obsolete. Sodium has implemented a uniform cache into their own codebase, making the existence of this mod pointless.

# Seaborgium
Seaborgium is a free and open source optimization mod for Minecraft. It improves the rendering performance of the game by implementing optimizations that are overlooked by other mods.

## Installation
### Manual Installation
In order to install Seaborgium, it is preferred you download the mod from our [Modrinth](https://modrinth.com/mod/seaborgium) page.

Then, you just need to place the appropriate version into your `mods` folder. Seaborgium provides a `unified` jar, which means it contains both the Fabric and Forge versions of the mod. 
You do not need to download a loader specific version.

### Custom Builds
`TODO: Write custom builds section, discussing how to compile mod.`

## Optimizations
Seaborgium implements a simple cache that stores the locations of uniform variables for each shader program. 

When GLStateManager invokes `glGetUniformLocation` for the first time, Seaborgium checks if it has a cached location for the requested uniform. 
If it does, it returns the cached location without invoking `glGetUniformLocation`. 
If it does not, it invokes `glGetUniformLocation` and stores the result in the cache for future use.

This optimization reduces the number of OpenGL calls and avoids unnecessary overhead. 
Invoking `glGetUniformLocation` is known to be quite slow, and it is not uncommon for drivers to consume noticeable CPU time to process this function. 
By caching the result of this function, Seaborgium is able to avoid wasting CPU cycles waiting for a function to return data we should already have on hand.

## Incompatibilities
Seaborgium has no reported incompatibilities with other mods as of now. It targets a niche function that is not modified by other mods. However, any mod that changes the rendering API from OpenGL to another one such as Vulkan will likely cause issues with Seaborgium. Such mods are not recommended.

Also, any mod that dynamically recompiles shaders and changes the uniform locations will invalidate Seaborgium’s cache. This is a rare scenario, but it could happen. Seaborgium does not currently have a way to handle such a scenario.
