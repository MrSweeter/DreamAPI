package com.mrsweeter.dreamAPI.items;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

public enum MySpawnEgg	{
	
	ELDER_GUARDIAN_EGG(EntityType.ELDER_GUARDIAN),
	WITHER_SKELETON_EGG(EntityType.WITHER_SKELETON),
	STRAY_EGG(EntityType.STRAY),
	CREEPER_EGG(EntityType.CREEPER),
	SKELETON_EGG(EntityType.SKELETON),
	SPIDER_EGG(EntityType.SPIDER),
//	GIANT_EGG(EntityType.GIANT),
	ZOMBIE_EGG(EntityType.ZOMBIE),
	SLIME_EGG(EntityType.SLIME),
	GHAST_EGG(EntityType.GHAST),
	PIG_ZOMBIE_EGG(EntityType.PIG_ZOMBIE),
	ENDERMAN_EGG(EntityType.ENDERMAN),
	CAVE_SPIDER_EGG(EntityType.CAVE_SPIDER),
	SILVERFISH_EGG(EntityType.SILVERFISH),
	BLAZE_EGG(EntityType.BLAZE),
	MAGMA_CUBE_EGG(EntityType.MAGMA_CUBE),
//	ENDER_DRAGON_EGG(EntityType.ENDER_DRAGON),
//	WITHER_EGG(EntityType.WITHER),
	BAT_EGG(EntityType.BAT),
	WITCH_EGG(EntityType.WITCH),
	ENDERMITE_EGG(EntityType.ENDERMITE),
	GUARDIAN_EGG(EntityType.GUARDIAN),
	SHULKER_EGG(EntityType.SHULKER),
	PIG_EGG(EntityType.PIG),
	SHEEP_EGG(EntityType.SHEEP),
	COW_EGG(EntityType.COW),
	CHICKEN_EGG(EntityType.CHICKEN),
	SQUID_EGG(EntityType.SQUID),
	WOLF_EGG(EntityType.WOLF),
	MUSHROOM_COW_EGG(EntityType.MUSHROOM_COW),
//	SNOWMAN_EGG(EntityType.SNOWMAN),
	OCELOT_EGG(EntityType.OCELOT),
//	IRON_GOLEM_EGG(EntityType.IRON_GOLEM),
	HORSE_EGG(EntityType.HORSE),
	RABBIT_EGG(EntityType.RABBIT),
	POLAR_BEAR_EGG(EntityType.POLAR_BEAR),
	LLAMA_EGG(EntityType.LLAMA),
	PARROT_EGG(EntityType.PARROT),
	VILLAGER_EGG(EntityType.VILLAGER),
	EVOKER_EGG(EntityType.EVOKER),
	VINDICATOR_EGG(EntityType.VINDICATOR),
//	ILLUSIONER_EGG(EntityType.ILLUSIONER),
	VEX_EGG(EntityType.VEX),;

	private ItemStack item;
	private static Map<String, MySpawnEgg> BY_NAME = new HashMap<>();
	
	private MySpawnEgg(EntityType type)	{
		
		item = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta meta = (SpawnEggMeta) item.getItemMeta();
		meta.setSpawnedType(type);
		item.setItemMeta(meta);
		
	}
	
	/**
	 * Gets the item of this spawn egg
	 * 
	 * @return SpawnEgg item
	 */
	public ItemStack getSpawnEgg()	{return item;}
	
	/**
	 * Attempts to get the spawn egg with the given name
	 * <p>
	 * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     * 
	 * @param name name of spawn egg to get
	 * @return MySpawnEgg if found, or null
	 */
	public static MySpawnEgg getSpawnEggWithName(String name)	{
		return BY_NAME.get(name);
	}
	
	static {
        for (MySpawnEgg egg : values()) {
            BY_NAME.put(egg.name(), egg);
        }
    }
	
}
