package net.hexconjuring.forge;

import net.hexconjuring.HexconjuringClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class HexconjuringClientForge {
    public static void init(FMLClientSetupEvent event) {
        HexconjuringClient.init();
    }
}
