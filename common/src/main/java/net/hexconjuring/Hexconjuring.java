package net.hexconjuring;

import net.hexconjuring.registry.HexconjuringIotaTypeRegistry;
import net.hexconjuring.registry.HexconjuringItemRegistry;
import net.hexconjuring.registry.HexconjuringPatternRegistry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class Hexconjuring {
    public static final String MOD_ID = "hexconjuring";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("Hex Conjuring says hello!");

        HexconjuringAbstractions.initPlatformSpecific();
        HexconjuringItemRegistry.init();
        HexconjuringIotaTypeRegistry.init();
        HexconjuringPatternRegistry.init();

        LOGGER.info(HexconjuringAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static Identifier id(String string) {
        return new Identifier(MOD_ID, string);
    }
}
