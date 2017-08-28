package com.mrsweeter.dreamAPI.enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

public class GlowingEnchantment extends EnchantmentWrapper	{
	
	private static Enchantment glowing = new GlowingEnchantment(207);
	
	public static Enchantment getEnchant()	{
		return glowing;
	}
	
	private GlowingEnchantment(int id) {
		super(id);
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Glowing";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return true;
	}

}
