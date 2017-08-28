package com.mrsweeter.dreamAPI.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public enum MyTippedArrow {
	
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

	POISON(MyPotion.POISON, 45, 1),
	POISON_LONG(MyPotion.POISON_LONG, 90, 1),
	POISON_II(MyPotion.POISON_II, 21, 1),
	WEAKNESS(MyPotion.WEAKNESS, 90, 1),
	WEAKNESS_LONG(MyPotion.WEAKNESS_LONG, 240, 1),
	SLOWNESS(MyPotion.SLOWNESS, 90, 1),
	SLOWNESS_LONG(MyPotion.SLOWNESS_LONG, 240, 1),
	INSTANT_DAMAGE(MyPotion.INSTANT_DAMAGE, 1, 1),
	INSTANT_DAMAGE_II(MyPotion.INSTANT_DAMAGE_II, 1, 2),

	REGENERATION_LONG_II(MyPotion.REGENERATION_LONG_II, 60, 2),
	SPEED_LONG_II(MyPotion.SPEED_LONG_II, 240, 2),
	STRENGH_LONG_II(MyPotion.STRENGH_LONG_II, 240, 2),
	JUMP_BOOST_LONG_II(MyPotion.JUMP_BOOST_LONG_II, 240, 2),
	POISON_LONG_II(MyPotion.POISON_LONG_II, 60, 2),
	WEAKESS_II(MyPotion.WEAKESS_II, 21, 1),
	WEAKNESS_LONG_II(MyPotion.WEAKNESS_LONG_II, 60, 2),
	SLOWNESS_II(MyPotion.SLOWNESS_II, 21, 1),
	SLOWNESS_LONG_II(MyPotion.SLOWNESS_LONG_II, 60, 2),
	LUCK(MyPotion.LUCK, 300, 1),

	HASTE(MyPotion.HASTE, 180, 1),
	HASTE_LONG(MyPotion.HASTE_LONG, 480, 1),
	HASTE_II(MyPotion.HASTE_II, 22, 2),
	HASTE_LONG_II(MyPotion.HASTE_LONG_II, 240, 2),
	RESISTANCE(MyPotion.RESISTANCE, 45, 1),
	RESISTANCE_LONG(MyPotion.RESISTANCE_LONG, 90, 1),
	RESISTANCE_II(MyPotion.RESISTANCE_II, 22, 2),
	RESISTANCE_LONG_II(MyPotion.RESISTANCE_LONG_II, 60, 2),
	HEALTH_BOOST(MyPotion.HEALTH_BOOST, 180, 1),
	HEALTH_BOOST_LONG(MyPotion.HEALTH_BOOST_LONG, 480, 1),
	HEALTH_BOOST_II(MyPotion.HEALTH_BOOST_II, 22, 2),
	HEALTH_BOOST_LONG_II(MyPotion.HEALTH_BOOST_LONG_II, 240, 2),
	ABSORPTION(MyPotion.ABSORPTION, 180, 1),
	ABSORPTION_LONG(MyPotion.ABSORPTION_LONG, 480, 1),
	ABSORPTION_II(MyPotion.ABSORPTION_II, 22, 2),
	ABSORPTION_LONG_II(MyPotion.ABSORPTION_LONG_II, 240, 2),
	SATURATION(MyPotion.SATURATION, 180, 1),
	SATURATION_LONG(MyPotion.SATURATION_LONG, 480, 1),
	SATURATION_II(MyPotion.SATURATION_II, 22, 2),
	SATURATION_LONG_II(MyPotion.SATURATION_LONG_II, 240, 2),
	GLOWING(MyPotion.GLOWING, 180, 1),
	GLOWING_LONG(MyPotion.GLOWING_LONG, 480, 1),
	GLOWING_II(MyPotion.GLOWING_II, 22, 2),
	GLOWING_LONG_II(MyPotion.GLOWING_LONG_II, 240, 2),

	BLINDNESS(MyPotion.BLINDNESS, 45, 1),
	BLINDNESS_LONG(MyPotion.BLINDNESS_LONG, 90, 1),
	BLINDNESS_II(MyPotion.BLINDNESS_II, 22, 2),
	BLINDNESS_LONG_II(MyPotion.BLINDNESS_LONG_II, 60, 2),
	NAUSEA(MyPotion.NAUSEA, 45, 1),
	NAUSEA_LONG(MyPotion.NAUSEA_LONG, 90, 1),
	NAUSEA_II(MyPotion.NAUSEA_II, 22, 2),
	NAUSEA_LONG_II(MyPotion.NAUSEA_LONG_II, 60, 2),
	MINING_FATIGUE(MyPotion.MINING_FATIGUE, 45, 1),
	MINING_FATIGUE_LONG(MyPotion.MINING_FATIGUE_LONG, 90, 1),
	MINING_FATIGUE_II(MyPotion.MINING_FATIGUE_II, 22, 2),
	MINING_FATIGUE_LONG_II(MyPotion.MINING_FATIGUE_LONG_II, 60, 2),
	HUNGER(MyPotion.HUNGER, 45, 1),
	HUNGER_LONG(MyPotion.HUNGER_LONG, 90, 1),
	HUNGER_II(MyPotion.HUNGER_II, 22, 2),
	HUNGER_LONG_II(MyPotion.HUNGER_LONG_II, 60, 2),
	LEVITATION(MyPotion.LEVITATION, 45, 1),
	LEVITATION_LONG(MyPotion.LEVITATION_LONG, 90, 1),
	LEVITATION_II(MyPotion.LEVITATION_II, 22, 2),
	LEVITATION_LONG_II(MyPotion.LEVITATION_LONG_II, 60, 2),
	BAD_LUCK(MyPotion.BAD_LUCK, 45, 1),
	BAD_LUCK_LONG(MyPotion.BAD_LUCK_LONG, 90, 1),
	BAD_LUCK_II(MyPotion.BAD_LUCK_II, 22, 2),
	BAD_LUCK_LONG_II(MyPotion.BAD_LUCK_LONG_II, 60, 2),;	
	
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
	
	/**
	 * Attempts to get the arrow with the given name
	 * <p>
	 * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     * 
	 * @param name name of arrow to get
	 * @return MyTippedArrow if found, or null
	 */
	public static MyTippedArrow getArrowWithName(final String name) {
        return BY_NAME.get(name);
    }
	
	static {
        for (MyTippedArrow arrow : values()) {
            BY_NAME.put(arrow.name(), arrow);
        }
    }
	
	/**
	 * Check if the arrow is a craftable in survival
	 * 
	 * @return true if arrow is craftable in survival (exist in creative inventory)
	 */
	public boolean isCraftable()	{
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
		case HASTE:
		case HASTE_LONG:
		case HASTE_II:
		case HASTE_LONG_II:
		case RESISTANCE:
		case RESISTANCE_LONG:
		case RESISTANCE_II:
		case RESISTANCE_LONG_II:
		case HEALTH_BOOST:
		case HEALTH_BOOST_LONG:
		case HEALTH_BOOST_II:
		case HEALTH_BOOST_LONG_II:
		case ABSORPTION:
		case ABSORPTION_LONG:
		case ABSORPTION_II:
		case ABSORPTION_LONG_II:
		case SATURATION:
		case SATURATION_LONG:
		case SATURATION_II:
		case SATURATION_LONG_II:
		case GLOWING:
		case GLOWING_LONG:
		case GLOWING_II:
		case GLOWING_LONG_II:
		case BLINDNESS:
		case BLINDNESS_LONG:
		case BLINDNESS_II:
		case BLINDNESS_LONG_II:
		case NAUSEA:
		case NAUSEA_LONG:
		case NAUSEA_II:
		case NAUSEA_LONG_II:
		case MINING_FATIGUE:
		case MINING_FATIGUE_LONG:
		case MINING_FATIGUE_II:
		case MINING_FATIGUE_LONG_II:
		case HUNGER:
		case HUNGER_LONG:
		case HUNGER_II:
		case HUNGER_LONG_II:
		case LEVITATION:
		case LEVITATION_LONG:
		case LEVITATION_II:
		case LEVITATION_LONG_II:
		case BAD_LUCK:
		case BAD_LUCK_LONG:
		case BAD_LUCK_II:
		case BAD_LUCK_LONG_II:
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
		case BLINDNESS:
		case BLINDNESS_LONG:
		case BLINDNESS_II:
		case BLINDNESS_LONG_II:
		case NAUSEA:
		case NAUSEA_LONG:
		case NAUSEA_II:
		case NAUSEA_LONG_II:
		case MINING_FATIGUE:
		case MINING_FATIGUE_LONG:
		case MINING_FATIGUE_II:
		case MINING_FATIGUE_LONG_II:
		case HUNGER:
		case HUNGER_LONG:
		case HUNGER_II:
		case HUNGER_LONG_II:
		case LEVITATION:
		case LEVITATION_LONG:
		case LEVITATION_II:
		case LEVITATION_LONG_II:
		case BAD_LUCK:
		case BAD_LUCK_LONG:
		case BAD_LUCK_II:
		case BAD_LUCK_LONG_II:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Check if the arrow is custom
	 * @return true if arrow is custom
	 */
	public boolean isCustom()	{
		switch (this)	{
		case HASTE:
		case HASTE_LONG:
		case HASTE_II:
		case HASTE_LONG_II:
		case RESISTANCE:
		case RESISTANCE_LONG:
		case RESISTANCE_II:
		case RESISTANCE_LONG_II:
		case HEALTH_BOOST:
		case HEALTH_BOOST_LONG:
		case HEALTH_BOOST_II:
		case HEALTH_BOOST_LONG_II:
		case ABSORPTION:
		case ABSORPTION_LONG:
		case ABSORPTION_II:
		case ABSORPTION_LONG_II:
		case SATURATION:
		case SATURATION_LONG:
		case SATURATION_II:
		case SATURATION_LONG_II:
		case GLOWING:
		case GLOWING_LONG:
		case GLOWING_II:
		case GLOWING_LONG_II:
		case BLINDNESS:
		case BLINDNESS_LONG:
		case BLINDNESS_II:
		case BLINDNESS_LONG_II:
		case NAUSEA:
		case NAUSEA_LONG:
		case NAUSEA_II:
		case NAUSEA_LONG_II:
		case MINING_FATIGUE:
		case MINING_FATIGUE_LONG:
		case MINING_FATIGUE_II:
		case MINING_FATIGUE_LONG_II:
		case HUNGER:
		case HUNGER_LONG:
		case HUNGER_II:
		case HUNGER_LONG_II:
		case LEVITATION:
		case LEVITATION_LONG:
		case LEVITATION_II:
		case LEVITATION_LONG_II:
		case BAD_LUCK:
		case BAD_LUCK_LONG:
		case BAD_LUCK_II:
		case BAD_LUCK_LONG_II:
			return true;
		default:
			return false;
		}
	}
	
}
