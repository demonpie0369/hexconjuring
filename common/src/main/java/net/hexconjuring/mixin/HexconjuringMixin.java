package net.hexconjuring.mixin;

import net.hexconjuring.items.HexconjuringItemRegistry;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class HexconjuringMixin {
	@Inject(at = @At("HEAD"), method = "getMaxDamage()I", cancellable = true)
	private void init(CallbackInfoReturnable<Integer> info) {
		ItemStack thisStack = (ItemStack)(Object)this;
		Item item = thisStack.getItem();
		if(item == HexconjuringItemRegistry.CONJURED_PICKAXE.get() || 
		   item == HexconjuringItemRegistry.CONJURED_AXE.get()) {
			info.setReturnValue(thisStack.getOrCreateNbt().getInt("durability"));
		}
		else {
			info.setReturnValue(item.getMaxDamage());
		}
	}
}