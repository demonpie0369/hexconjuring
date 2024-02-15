package net.hexconjuring.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hexconjuring.HexconjuringAbstractions;

import java.nio.file.Path;

public class HexconjuringAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexconjuringAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        HexconjuringConfigFabric.init();
    }
}
