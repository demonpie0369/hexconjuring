/*package net.hexconjuring.fabric;

import at.petrak.hexcasting.fabric.cc.adimpl.CCIotaHolder;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import net.minecraft.item.Items;

public class HexconjuringIotaItemRegistryFabric implements ItemComponentInitializer {

	public static final ComponentKey<CCIotaHolder> IOTA_HOLDER = ComponentRegistry.getOrCreate(modLoc("iota_holder"),
	        CCIotaHolder.class);
	
	@Override
	public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {

		registry.register(Items.FEATHER, IOTA_HOLDER, stack -> new CCItemIotaHolder.Static(stack,
	            s -> new PatternIota()));
		
	}
	
}*/
