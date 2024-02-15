package net.hexconjuring.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexconjuring.Hexconjuring;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(Hexconjuring.MOD_ID)
public class HexconjuringForge {
    public HexconjuringForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Hexconjuring.MOD_ID, bus);
        bus.addListener(HexconjuringClientForge::init);
        Hexconjuring.init();
    }
}
