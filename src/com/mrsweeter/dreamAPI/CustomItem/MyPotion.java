package com.mrsweeter.dreamAPI.CustomItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *	An enum of all potions minecraft
 * 
 *	@author MrSweeter
 */
public enum MyPotion	{
	
	// Drink potions
	// Positive and brewable potions
	REGENERATION(Material.POTION, Color.fromRGB(0xcd, 0x5c, 0xab), PotionEffectType.REGENERATION, 45, 1),
	REGENERATION_LONG(Material.POTION, MyPotion.REGENERATION, 90, 1),
	REGENERATION_II(Material.POTION, MyPotion.REGENERATION, 22, 2),
	SPEED(Material.POTION, Color.fromRGB(0x7c, 0xaf, 0xc6), PotionEffectType.SPEED, 180, 1),
	SPEED_LONG(Material.POTION, MyPotion.SPEED, 480, 1),
	SPEED_II(Material.POTION, MyPotion.SPEED, 90, 2),
	FIRE_RESISTANCE(Material.POTION, Color.fromRGB(0xe4, 0x9a, 0x3a), PotionEffectType.FIRE_RESISTANCE, 180, 1),
	FIRE_RESISTANCE_LONG(Material.POTION, MyPotion.FIRE_RESISTANCE, 480, 1),
	INSTANT_HEAL(Material.POTION, Color.fromRGB(0xf8, 0x24, 0x23), PotionEffectType.HEAL, 1, 1),
	INSTANT_HEAL_II(Material.POTION, MyPotion.INSTANT_HEAL, 1, 2),
	NIGHT_VISION(Material.POTION, Color.fromRGB(0x1f, 0x1f, 0xa1), PotionEffectType.NIGHT_VISION, 180, 1),
	NIGHT_VISION_LONG(Material.POTION, MyPotion.NIGHT_VISION, 480, 1),
	STRENGH(Material.POTION, Color.fromRGB(0x93, 0x24, 0x23), PotionEffectType.INCREASE_DAMAGE, 180, 1),
	STRENGH_LONG(Material.POTION, MyPotion.STRENGH, 480, 1),
	STRENGH_II(Material.POTION, MyPotion.STRENGH, 90, 2),
	JUMP_BOOST(Material.POTION, Color.fromRGB(0x78, 0x62, 0x97), PotionEffectType.JUMP, 180, 1),
	JUMP_BOOST_LONG(Material.POTION, MyPotion.JUMP_BOOST, 480, 1),
	JUMP_BOOST_II(Material.POTION, MyPotion.JUMP_BOOST, 90, 2),
	WATER_BREATHING(Material.POTION, Color.fromRGB(0x2e, 0x52, 0x99), PotionEffectType.WATER_BREATHING, 180, 1),
	WATER_BREATHING_LONG(Material.POTION, MyPotion.WATER_BREATHING, 480, 1),
	INVISIBILITY(Material.POTION, Color.fromRGB(0x7f, 0x83, 0x92), PotionEffectType.INVISIBILITY, 180, 1),
	INVISIBILITY_LONG(Material.POTION, MyPotion.INVISIBILITY, 480, 1),
	// Negative and brewable potions
	POISON(Material.POTION, Color.fromRGB(0x4e, 0x93, 0x31), PotionEffectType.POISON, 45, 1),
	POISON_LONG(Material.POTION, MyPotion.POISON, 90, 1),
	POISON_II(Material.POTION, MyPotion.POISON, 21, 1),
	WEAKNESS(Material.POTION, Color.fromRGB(0x48, 0x4d, 0x48), PotionEffectType.WEAKNESS, 90, 1),
	WEAKNESS_LONG(Material.POTION, MyPotion.WEAKNESS, 240, 1),
	SLOWNESS(Material.POTION, Color.fromRGB(0x5a, 0x6c, 0x81), PotionEffectType.SLOW, 90, 1),
	SLOWNESS_LONG(Material.POTION, MyPotion.SLOWNESS, 240, 1),
	INSTANT_DAMAGE(Material.POTION, Color.fromRGB(0x43, 0x0a, 0x09), PotionEffectType.HARM, 1, 1),
	INSTANT_DAMAGE_II(Material.POTION, MyPotion.INSTANT_DAMAGE, 1, 2),
	// Unbrewable potions
	REGENERATION_LONG_II(Material.POTION, MyPotion.REGENERATION, 60, 2),
	SPEED_LONG_II(Material.POTION, MyPotion.SPEED, 240, 2),
	STRENGH_LONG_II(Material.POTION, MyPotion.STRENGH, 240, 2),
	JUMP_BOOST_LONG_II(Material.POTION, MyPotion.JUMP_BOOST, 240, 2),
	POISON_LONG_II(Material.POTION, MyPotion.POISON, 60, 2),
	WEAKESS_II(Material.POTION, MyPotion.WEAKNESS, 21, 1),
	WEAKNESS_LONG_II(Material.POTION, MyPotion.WEAKNESS, 60, 2),
	SLOWNESS_II(Material.POTION, MyPotion.SLOWNESS, 21, 1),
	SLOWNESS_LONG_II(Material.POTION, MyPotion.SLOWNESS, 60, 2),
	LUCK(Material.POTION, Color.fromRGB(0, 170, 0), PotionEffectType.LUCK, 300, 1),
	// Splash potions
	// Positive and brewable potions
	REGENERATION_SPLASH(Material.SPLASH_POTION, MyPotion.REGENERATION, 45, 1),
	REGENERATION_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.REGENERATION, 90, 1),
	REGENERATION_II_SPLASH(Material.SPLASH_POTION, MyPotion.REGENERATION, 22, 2),
	SPEED_SPLASH(Material.SPLASH_POTION, MyPotion.SPEED, 180, 1),
	SPEED_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.SPEED, 480, 1),
	SPEED_II_SPLASH(Material.SPLASH_POTION, MyPotion.SPEED, 90, 2),
	FIRE_RESISTANCE_SPLASH(Material.SPLASH_POTION, MyPotion.FIRE_RESISTANCE, 180, 1),
	FIRE_RESISTANCE_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.FIRE_RESISTANCE, 480, 1),
	INSTANT_HEAL_SPLASH(Material.SPLASH_POTION, MyPotion.INSTANT_HEAL, 1, 1),
	INSTANT_HEAL_II_SPLASH(Material.SPLASH_POTION, MyPotion.INSTANT_HEAL, 1, 2),
	NIGHT_VISION_SPLASH(Material.SPLASH_POTION, MyPotion.NIGHT_VISION, 180, 1),
	NIGHT_VISION_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.NIGHT_VISION, 480, 1),
	STRENGH_SPLASH(Material.SPLASH_POTION, MyPotion.STRENGH, 180, 1),
	STRENGH_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.STRENGH, 480, 1),
	STRENGH_II_SPLASH(Material.SPLASH_POTION, MyPotion.STRENGH, 90, 2),
	JUMP_BOOST_SPLASH(Material.SPLASH_POTION, MyPotion.JUMP_BOOST, 180, 1),
	JUMP_BOOST_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.JUMP_BOOST, 480, 1),
	JUMP_BOOST_II_SPLASH(Material.SPLASH_POTION, MyPotion.JUMP_BOOST, 90, 2),
	WATER_BREATHING_SPLASH(Material.SPLASH_POTION, MyPotion.WATER_BREATHING, 180, 1),
	WATER_BREATHING_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.WATER_BREATHING, 480, 1),
	INVISIBILITY_SPLASH(Material.SPLASH_POTION, MyPotion.INVISIBILITY, 180, 1),
	INVISIBILITY_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.INVISIBILITY, 480, 1),
	// Negative and brewable potions
	POISON_SPLASH(Material.SPLASH_POTION, MyPotion.POISON, 45, 1),
	POISON_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.POISON, 90, 1),
	POISON_II_SPLASH(Material.SPLASH_POTION, MyPotion.POISON, 21, 1),
	WEAKNESS_SPLASH(Material.SPLASH_POTION, MyPotion.WEAKNESS, 90, 1),
	WEAKNESS_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.WEAKNESS, 240, 1),
	SLOWNESS_SPLASH(Material.SPLASH_POTION, MyPotion.SLOWNESS, 90, 1),
	SLOWNESS_LONG_SPLASH(Material.SPLASH_POTION, MyPotion.SLOWNESS, 240, 1),
	INSTANT_DAMAGE_SPLASH(Material.SPLASH_POTION, MyPotion.INSTANT_DAMAGE, 1, 1),
	INSTANT_DAMAGE_II_SPLASH(Material.SPLASH_POTION, MyPotion.INSTANT_DAMAGE, 1, 2),
	// Unbrewable potions
	REGENERATION_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.REGENERATION, 60, 2),
	SPEED_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.SPEED, 240, 2),
	STRENGH_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.STRENGH, 240, 2),
	JUMP_BOOST_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.JUMP_BOOST, 240, 2),
	POISON_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.POISON, 60, 2),
	WEAKESS_II_SPLASH(Material.SPLASH_POTION, MyPotion.WEAKNESS, 21, 1),
	WEAKNESS_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.WEAKNESS, 60, 2),
	SLOWNESS_II_SPLASH(Material.SPLASH_POTION, MyPotion.SLOWNESS, 21, 1),
	SLOWNESS_LONG_II_SPLASH(Material.SPLASH_POTION, MyPotion.SLOWNESS, 60, 2),
	LUCK_SPLASH(Material.SPLASH_POTION, MyPotion.LUCK, 300, 1),
	// Lingering potions
	// Positive and brewable potions
	REGENERATION_LINGERING(Material.LINGERING_POTION, MyPotion.REGENERATION, 11, 1),
	REGENERATION_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.REGENERATION, 22, 1),
	REGENERATION_II_LINGERING(Material.LINGERING_POTION, MyPotion.REGENERATION, 5, 2),
	SPEED_LINGERING(Material.LINGERING_POTION, MyPotion.SPEED, 45, 1),
	SPEED_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.SPEED, 120, 1),
	SPEED_II_LINGERING(Material.LINGERING_POTION, MyPotion.SPEED, 22, 2),
	FIRE_RESISTANCE_LINGERING(Material.LINGERING_POTION, MyPotion.FIRE_RESISTANCE, 45, 1),
	FIRE_RESISTANCE_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.FIRE_RESISTANCE, 120, 1),
	INSTANT_HEAL_LINGERING(Material.LINGERING_POTION, MyPotion.INSTANT_HEAL, 1, 1),
	INSTANT_HEAL_II_LINGERING(Material.LINGERING_POTION, MyPotion.INSTANT_HEAL, 1, 2),
	NIGHT_VISION_LINGERING(Material.LINGERING_POTION, MyPotion.NIGHT_VISION, 45, 1),
	NIGHT_VISION_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.NIGHT_VISION, 120, 1),
	STRENGH_LINGERING(Material.LINGERING_POTION, MyPotion.STRENGH, 45, 1),
	STRENGH_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.STRENGH, 120, 1),
	STRENGH_II_LINGERING(Material.LINGERING_POTION, MyPotion.STRENGH, 22, 2),
	JUMP_BOOST_LINGERING(Material.LINGERING_POTION, MyPotion.JUMP_BOOST, 45, 1),
	JUMP_BOOST_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.JUMP_BOOST, 120, 1),
	JUMP_BOOST_II_LINGERING(Material.LINGERING_POTION, MyPotion.JUMP_BOOST, 22, 2),
	WATER_BREATHING_LINGERING(Material.LINGERING_POTION, MyPotion.WATER_BREATHING, 45, 1),
	WATER_BREATHING_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.WATER_BREATHING, 120, 1),
	INVISIBILITY_LINGERING(Material.LINGERING_POTION, MyPotion.INVISIBILITY, 45, 1),
	INVISIBILITY_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.INVISIBILITY, 120, 1),
	// Negative and brewable potions
	POISON_LINGERING(Material.LINGERING_POTION, MyPotion.POISON, 11, 1),
	POISON_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.POISON, 22, 1),
	POISON_II_LINGERING(Material.LINGERING_POTION, MyPotion.POISON, 5, 1),
	WEAKNESS_LINGERING(Material.LINGERING_POTION, MyPotion.WEAKNESS, 22, 1),
	WEAKNESS_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.WEAKNESS, 60, 1),
	SLOWNESS_LINGERING(Material.LINGERING_POTION, MyPotion.SLOWNESS, 22, 1),
	SLOWNESS_LONG_LINGERING(Material.LINGERING_POTION, MyPotion.SLOWNESS, 60, 1),
	INSTANT_DAMAGE_LINGERING(Material.LINGERING_POTION, MyPotion.INSTANT_DAMAGE, 1, 1),
	INSTANT_DAMAGE_II_LINGERING(Material.LINGERING_POTION, MyPotion.INSTANT_DAMAGE, 1, 2),
	// Unbrewable potions
	REGENERATION_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.REGENERATION, 15, 2),
	SPEED_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.SPEED, 60, 2),
	STRENGH_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.STRENGH, 60, 2),
	JUMP_BOOST_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.JUMP_BOOST, 60, 2),
	POISON_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.POISON, 15, 2),
	WEAKESS_II_LINGERING(Material.LINGERING_POTION, MyPotion.WEAKNESS, 5, 1),
	WEAKNESS_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.WEAKNESS, 15, 2),
	SLOWNESS_II_LINGERING(Material.LINGERING_POTION, MyPotion.SLOWNESS, 5, 1),
	SLOWNESS_LONG_II_LINGERING(Material.LINGERING_POTION, MyPotion.SLOWNESS, 15, 2),
	LUCK_LINGERING(Material.LINGERING_POTION, MyPotion.LUCK, 75, 1),;

	private ItemStack potion;
	private static Map<String, MyPotion> BY_NAME = new HashMap<>();
	
	private MyPotion(Material mat, Color color, PotionEffectType type, int time, int lvl) {
		potion = new ItemStack(mat);
		PotionMeta meta = (PotionMeta) potion.getItemMeta();
		meta.setColor(color);
		meta.addCustomEffect(new PotionEffect(type, time*20, lvl-1), true);
		meta.setDisplayName("§r§f" + name().replace("_", " "));
		potion.setItemMeta(meta);
	}
	
	private MyPotion(Material mat, MyPotion pot, int time, int lvl)	{
		potion = new ItemStack(mat);
		PotionMeta meta = (PotionMeta) potion.getItemMeta();
		Color c = ((PotionMeta) pot.potion.getItemMeta()).getColor();
		List<PotionEffect> t = ((PotionMeta) pot.potion.getItemMeta()).getCustomEffects();
		meta.setColor(c);
		for (PotionEffect p : t)	{
			meta.addCustomEffect(new PotionEffect(p.getType(), time*20, lvl-1), true);
		}
		meta.setDisplayName("§r§f" + name().replace("_", " "));
		potion.setItemMeta(meta);
	}
	
	/**
	 * Gets the item of this potion
	 * 
	 * @return Potion item
	 */
	public ItemStack getPotion()	{return potion;}
	
	/**
	 * Attempts to get the potion with the given name
	 * <p>
	 * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     * 
	 * @param name name of potion to get
	 * @return MyPotion if found, or null
	 */
	public static MyPotion getPotionWithName(final String name) {         return BY_NAME.get(name);
    }
	
	static {
        for (MyPotion potion : values()) {
            BY_NAME.put(potion.name(), potion);
        }
    }
	
	/**
	 * Check if the potion is a brewable in survival
	 * 
	 * @return true if potion is brewable in survival (exist in creative inventory)
	 */
	public boolean isBrewable()	{
		switch (this)	{
		case REGENERATION_LONG_II:
		case SPEED_LONG_II:
		case STRENGH_LONG_II:
		case JUMP_BOOST_LONG_II:
		case POISON_LONG_II:
		case WEAKESS_II:
		case WEAKNESS_LONG_II:
		case SLOWNESS_II:
		case SLOWNESS_LONG_II:
		case LUCK:
		case REGENERATION_LONG_II_SPLASH:
		case SPEED_LONG_II_SPLASH:
		case STRENGH_LONG_II_SPLASH:
		case JUMP_BOOST_LONG_II_SPLASH:
		case POISON_LONG_II_SPLASH:
		case WEAKESS_II_SPLASH:
		case WEAKNESS_LONG_II_SPLASH:
		case SLOWNESS_II_SPLASH:
		case SLOWNESS_LONG_II_SPLASH:
		case LUCK_SPLASH:
		case REGENERATION_LONG_II_LINGERING:
		case SPEED_LONG_II_LINGERING:
		case STRENGH_LONG_II_LINGERING:
		case JUMP_BOOST_LONG_II_LINGERING:
		case POISON_LONG_II_LINGERING:
		case WEAKESS_II_LINGERING:
		case WEAKNESS_LONG_II_LINGERING:
		case SLOWNESS_II_LINGERING:
		case SLOWNESS_LONG_II_LINGERING:
		case LUCK_LINGERING:
			return false;
		default:
			return true;
		}
	}

	/**
	 * Check if the potion give negatives effects
	 * 
	 * @return true if potion give negatives effects
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
		case POISON_SPLASH:
		case POISON_LONG_SPLASH:
		case POISON_II_SPLASH:
		case WEAKNESS_SPLASH:
		case WEAKNESS_LONG_SPLASH:
		case SLOWNESS_SPLASH:
		case SLOWNESS_LONG_SPLASH:
		case INSTANT_DAMAGE_SPLASH:
		case INSTANT_DAMAGE_II_SPLASH:
		case POISON_LINGERING:
		case POISON_LONG_LINGERING:
		case POISON_II_LINGERING:
		case WEAKNESS_LINGERING:
		case WEAKNESS_LONG_LINGERING:
		case SLOWNESS_LINGERING:
		case SLOWNESS_LONG_LINGERING:
		case INSTANT_DAMAGE_LINGERING:
		case INSTANT_DAMAGE_II_LINGERING:
		case POISON_LONG_II:
		case WEAKESS_II:
		case WEAKNESS_LONG_II:
		case SLOWNESS_II:
		case SLOWNESS_LONG_II:
		case POISON_LONG_II_SPLASH:
		case WEAKESS_II_SPLASH:
		case WEAKNESS_LONG_II_SPLASH:
		case SLOWNESS_II_SPLASH:
		case SLOWNESS_LONG_II_SPLASH:
		case POISON_LONG_II_LINGERING:
		case WEAKESS_II_LINGERING:
		case WEAKNESS_LONG_II_LINGERING:
		case SLOWNESS_II_LINGERING:
		case SLOWNESS_LONG_II_LINGERING:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Check if the potion is a splash potion
	 * 
	 * @return true if potion is splash
	 */
	public boolean isSplash()	{
		switch (this)	{
		case REGENERATION_SPLASH:
		case REGENERATION_LONG_SPLASH:
		case REGENERATION_II_SPLASH:
		case SPEED_SPLASH:
		case SPEED_LONG_SPLASH:
		case SPEED_II_SPLASH:
		case FIRE_RESISTANCE_SPLASH:
		case FIRE_RESISTANCE_LONG_SPLASH:
		case INSTANT_HEAL_SPLASH:
		case INSTANT_HEAL_II_SPLASH:
		case NIGHT_VISION_SPLASH:
		case NIGHT_VISION_LONG_SPLASH:
		case STRENGH_SPLASH:
		case STRENGH_LONG_SPLASH:
		case STRENGH_II_SPLASH:
		case JUMP_BOOST_SPLASH:
		case JUMP_BOOST_LONG_SPLASH:
		case JUMP_BOOST_II_SPLASH:
		case WATER_BREATHING_SPLASH:
		case WATER_BREATHING_LONG_SPLASH:
		case INVISIBILITY_SPLASH:
		case INVISIBILITY_LONG_SPLASH:
		case POISON_SPLASH:
		case POISON_LONG_SPLASH:
		case POISON_II_SPLASH:
		case WEAKNESS_SPLASH:
		case WEAKNESS_LONG_SPLASH:
		case SLOWNESS_SPLASH:
		case SLOWNESS_LONG_SPLASH:
		case INSTANT_DAMAGE_SPLASH:
		case INSTANT_DAMAGE_II_SPLASH:
		case REGENERATION_LONG_II_SPLASH:
		case SPEED_LONG_II_SPLASH:
		case STRENGH_LONG_II_SPLASH:
		case JUMP_BOOST_LONG_II_SPLASH:
		case POISON_LONG_II_SPLASH:
		case WEAKESS_II_SPLASH:
		case WEAKNESS_LONG_II_SPLASH:
		case SLOWNESS_II_SPLASH:
		case SLOWNESS_LONG_II_SPLASH:
		case LUCK_SPLASH:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Check if the potion is a lingering potion
	 * 
	 * @return true if potion is lingering
	 */
	public boolean isLingering()	{
		switch (this)	{
		case REGENERATION_LINGERING:
		case REGENERATION_LONG_LINGERING:
		case REGENERATION_II_LINGERING:
		case SPEED_LINGERING:
		case SPEED_LONG_LINGERING:
		case SPEED_II_LINGERING:
		case FIRE_RESISTANCE_LINGERING:
		case FIRE_RESISTANCE_LONG_LINGERING:
		case INSTANT_HEAL_LINGERING:
		case INSTANT_HEAL_II_LINGERING:
		case NIGHT_VISION_LINGERING:
		case NIGHT_VISION_LONG_LINGERING:
		case STRENGH_LINGERING:
		case STRENGH_LONG_LINGERING:
		case STRENGH_II_LINGERING:
		case JUMP_BOOST_LINGERING:
		case JUMP_BOOST_LONG_LINGERING:
		case JUMP_BOOST_II_LINGERING:
		case WATER_BREATHING_LINGERING:
		case WATER_BREATHING_LONG_LINGERING:
		case INVISIBILITY_LINGERING:
		case INVISIBILITY_LONG_LINGERING:
		case POISON_LINGERING:
		case POISON_LONG_LINGERING:
		case POISON_II_LINGERING:
		case WEAKNESS_LINGERING:
		case WEAKNESS_LONG_LINGERING:
		case SLOWNESS_LINGERING:
		case SLOWNESS_LONG_LINGERING:
		case INSTANT_DAMAGE_LINGERING:
		case INSTANT_DAMAGE_II_LINGERING:
		case REGENERATION_LONG_II_LINGERING:
		case SPEED_LONG_II_LINGERING:
		case STRENGH_LONG_II_LINGERING:
		case JUMP_BOOST_LONG_II_LINGERING:
		case POISON_LONG_II_LINGERING:
		case WEAKESS_II_LINGERING:
		case WEAKNESS_LONG_II_LINGERING:
		case SLOWNESS_II_LINGERING:
		case SLOWNESS_LONG_II_LINGERING:
		case LUCK_LINGERING:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Not yet implemented
	 * @return true if potion is custom
	 */
	public boolean isCustom()	{
		switch (this)	{
		default:
			return false;
		}
	}
}
