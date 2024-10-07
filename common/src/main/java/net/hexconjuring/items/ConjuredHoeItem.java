package net.hexconjuring.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.MathHelper;

public class ConjuredHoeItem extends HoeItem {

	public ConjuredHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}
	
	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}
	
	@Override
	public int getItemBarStep(ItemStack stack) {
		return Math.round(13.0F - (float)stack.getDamage() * 13.0F / (float)stack.getMaxDamage());
	}
	
	@Override
	public int getItemBarColor(ItemStack stack) {
		float f = Math.max(0.0F, ((float)stack.getMaxDamage() - (float)stack.getDamage()) / (float)stack.getMaxDamage());
		return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
	}
}
