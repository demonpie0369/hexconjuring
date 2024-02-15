package net.hexconjuring.forge;

import net.hexconjuring.HexconjuringAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class HexconjuringAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexconjuringAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        HexconjuringConfigForge.init();
    }
}
