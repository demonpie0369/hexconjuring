package net.hexconjuring.items;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexconjuring.Hexconjuring;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.registry.Registry;

import static net.hexconjuring.Hexconjuring.id;
import at.petrak.hexcasting.common.items.magic.ItemMediaHolder;

public class HexconjuringItemRegistry {
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Hexconjuring.MOD_ID, Registry.ITEM_KEY);
    private static ConjuredPickaxeItem conjuredpickaxe = new ConjuredPickaxeItem(ModToolMaterials.CONJUREDTOOL, 0, 0, new Item.Settings().maxCount(1));
    private static ConjuredAxeItem conjuredaxe = new ConjuredAxeItem(ModToolMaterials.CONJUREDTOOL, 0, 0, new Item.Settings().maxCount(1));

    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final ItemGroup HEX_CONJURING = CreativeTabRegistry.create(id("hex_conjuring"), () -> new ItemStack(HexconjuringItemRegistry.CONJURED_PICKAXE.get()));

    // During the loading phase, refrain from accessing sueppliers' items (e.g. EXAMPLE_ITEM.gt()), they will not be available
    public static final RegistrySupplier<ConjuredPickaxeItem> CONJURED_PICKAXE = ITEMS.register("conjured_pickaxe",
        () -> conjuredpickaxe);
    public static final RegistrySupplier<ConjuredAxeItem> CONJURED_AXE = ITEMS.register("conjured_axe",
        () -> conjuredaxe);


}
