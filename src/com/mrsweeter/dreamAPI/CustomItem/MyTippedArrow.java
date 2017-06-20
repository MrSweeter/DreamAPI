package com.mrsweeter.dreamAPI.CustomItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public enum MyTippedArrow {
	
	// Positive and brewable potions
	REGENERATION(MyPotion.REGENERATION, 45, 1),
	REGENERATION_LONG(MyPotion.REGENERATION_LONG, 90, 1),
	REGENERATION_II(MyPotion.REGENERATION_II, 22, 2),
	SPEED(MyPotion.SPEED, 180, 1),
	SPEED_LONG(MyPotion.SPEED_LONG, 480, 1),
	SPEED_II(MyPotion.SPEED_II, 90, 2),
	FIRE_RESISTANCE(MyPotion.FIRE_RESISTANCE, 180, 1),
	FIRE_RESISTANCE_LONG(MyPotion.FIRE_RESISTANCE_LONG, 480, 1),
	INSTANT_HEAL(MyPotion.INSTANT_HEAL, 1, 1),
	INSTANT_HEAL_II(MyPotion.INSTANT_HEAL_II, 1, 2),
	NIGHT_VISION(MyPotion.NIGHT_VISION, 180, 1),
	NIGHT_VISION_LONG(MyPotion.NIGHT_VISION_LONG, 480, 1),
	STRENGH(MyPotion.STRENGH, 180, 1),
	STRENGH_LONG(MyPotion.STRENGH_LONG, 480, 1),
	STRENGH_II(MyPotion.STRENGH_II, 90, 2),
	JUMP_BOOST(MyPotion.JUMP_BOOST, 180, 1),
	JUMP_BOOST_LONG(MyPotion.JUMP_BOOST_LONG, 480, 1),
	JUMP_BOOST_II(MyPotion.JUMP_BOOST_II, 90, 2),
	WATER_BREATHING(MyPotion.WATER_BREATHING, 180, 1),
	WATER_BREATHING_LONG(MyPotion.WATER_BREATHING_LONG, 480, 1),
	INVISIBILITY(MyPotion.INVISIBILITY, 180, 1),
	INVISIBILITY_LONG(MyPotion.INVISIBILITY_LONG, 480, 1),
	// Negative and brewable potions
	POISON(MyPotion.POISON, 45, 1),
	POISON_LONG(MyPotion.POISON_LONG, 90, 1),
	POISON_II(MyPotion.POISON_II, 21, 1),
	WEAKNESS(MyPotion.WEAKNESS, 90, 1),
	WEAKNESS_LONG(MyPotion.WEAKNESS_LONG, 240, 1),
	SLOWNESS(MyPotion.SLOWNESS, 90, 1),
	SLOWNESS_LONG(MyPotion.SLOWNESS_LONG, 240, 1),
	INSTANT_DAMAGE(MyPotion.INSTANT_DAMAGE, 1, 1),
	INSTANT_DAMAGE_II(MyPotion.INSTANT_DAMAGE_II, 1, 2),
	// Unbrewable potions
	REGENERATION_LONG_II(MyPotion.REGENERATION_LONG_II, 60, 2),
	SPEED_LONG_II(MyPotion.SPEED_LONG_II, 240, 2),
	STRENGH_LONG_II(MyPotion.STRENGH_LONG_II, 240, 2),
	JUMP_BOOST_LONG_II(MyPotion.JUMP_BOOST_LONG_II, 240, 2),
	POISON_LONG_II(MyPotion.POISON_LONG_II, 60, 2),
	WEAKESS_II(MyPotion.WEAKESS_II, 21, 1),
	WEAKNESS_LONG_II(MyPotion.WEAKNESS_LONG_II, 60, 2),
	SLOWNESS_II(MyPotion.SLOWNESS_II, 21, 1),
	SLOWNESS_LONG_II(MyPotion.SLOWNESS_LONG_II, 60, 2),
	LUCK(MyPotion.LUCK, 300, 1),;
	
	private ItemStack arrow;
	private static Map<String, MyTippedArrow> BY_NAME = new HashMap<>();
	
	private MyTippedArrow(MyPotion potion, int time, int lvl)	{
		arrow = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta meta = (PotionMeta) arrow.getItemMeta();
		Color c = ((PotionMeta) potion.getPotion().getItemMeta()).getColor();
		List<PotionEffect> t = ((PotionMeta) potion.getPotion().getItemMeta()).getCustomEffects();
		meta.setColor(c);
		for (PotionEffect p : t)	{
			meta.addCustomEffect(new PotionEffect(p.getType(), time*20, lvl-1), true);
		}
		meta.setDisplayName("§r§f" + name().replace("_", " "));
		arrow.setItemMeta(meta);
	}
	
	/**
	 * Gets the item of this arrow
	 * 
	 * @return Arrow item
	 */
	public ItemStack getArrow()	{return arrow;}
	
	public static MyTippedArrow getArrowWithName(final String name) {
        return BY_NAME.get(name);
    }
	
	static {
        for (MyTippedArrow arrow : values()) {
            BY_NAME.put(arrow.name(), arrow);
        }
    }
	
	/**
	 * Check if the arrow is a brewable in survival
	 * 
	 * @return true if arrow is brewable in survival (exist in creative inventory)
	 */
	public boolean isBrewable()	{
		switch (this)	{
		case SPEED_LONG_II:
		case STRENGH_LONG_II:
		case JUMP_BOOST_LONG_II:
		case POISON_LONG_II:
		case WEAKESS_II:
		case WEAKNESS_LONG_II:
		case SLOWNESS_II:
		case SLOWNESS_LONG_II:
		case LUCK:
			return false;
		default:
			return true;
		}
	}

	/**
	 * Check if the arrow give negatives effects
	 * 
	 * @return true if arrow give negatives effects
	 */
	public boolean isNegative()	{
		switch (this)	{
		case POISON:
		case POISON_LONG:
		case POISON_II:
		case WEAKNESS:
		case WEAKNESS_LONG:
		case SLOWNESS:
		case SLOWNESS_LONG:
		case INSTANT_DAMAGE:
		case INSTANT_DAMAGE_II:
		case POISON_LONG_II:
		case WEAKESS_II:
		case WEAKNESS_LONG_II:
		case SLOWNESS_II:
		case SLOWNESS_LONG_II:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Not yet implemented
	 * @return true if arrow is custom
	 */
	public boolean isCustom()	{
		switch (this)	{
		default:
			return false;
		}
	}
	
}
