package net.hexconjuring.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexconjuring.Hexconjuring;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

import static net.hexconjuring.Hexconjuring.id;

public class HexconjuringItemRegistry {
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Hexconjuring.MOD_ID, Registry.ITEM_KEY);

    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    public static final ItemGroup HEX_CONJURING = CreativeTabRegistry.create(id("hex_conjuring"), () -> new ItemStack(HexconjuringItemRegistry.CONJURED_PICKAXE.get()));

    // During the loading phase, refrain from accessing sueppliers' items (e.g. EXAMPLE_ITEM.gt()), they will not be available
    public static final RegistrySupplier<PickaxeItem> CONJURED_PICKAXE = ITEMS.register("conjured_pickaxe", () -> new PickaxeItem(new Item.Settings().maxCount(1)));


}
