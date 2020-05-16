package com.arsnole.awaa.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class ItemBlazeBow extends BowItem {

	private static final Ingredient REPAIR = Ingredient.fromItems(Items.BLAZE_ROD);
	
	public ItemBlazeBow() {
	
		super(new Item.Properties().maxDamage(384).group(ItemGroup.COMBAT));
		this.setRegistryName("awaa", "blaze_bow");
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		
		return REPAIR.test(repair);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return super.canApplyAtEnchantingTable(stack, enchantment) && enchantment != Enchantments.FLAME;
	}

	@Override 
	public AbstractArrowEntity customeArrow(AbstractArrowEntity arrow) {
		arrow.setFire(100);
		return super.customeArrow(arrow);
	} 
}