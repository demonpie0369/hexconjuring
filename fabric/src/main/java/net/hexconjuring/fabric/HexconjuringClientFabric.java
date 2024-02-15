package net.hexconjuring.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexconjuring.HexconjuringClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexconjuringClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HexconjuringClient.init();
    }
}
