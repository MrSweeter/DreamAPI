package com.mrsweeter.dreamAPI.items;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum MyDiscRecord {
	
	RECORD_13(Material.GOLD_RECORD),
	RECORD_CAT(Material.GREEN_RECORD),
	RECORD_WARD(Material.RECORD_10),
	RECORD_11(Material.RECORD_11),
	RECORD_WAIT(Material.RECORD_12),
	RECORD_BLOCKS(Material.RECORD_3),
	RECORD_CHIRP(Material.RECORD_4),
	RECORD_FAR(Material.RECORD_5),
	RECORD_MALL(Material.RECORD_6),
	RECORD_MELLOHI(Material.RECORD_7),
	RECORD_STAL(Material.RECORD_8),
	RECORD_STRAD(Material.RECORD_9),;
	
	private Material material;
	private static Map<String, MyDiscRecord> BY_NAME = new HashMap<>();
	
	private MyDiscRecord(Material material)	{
		this.material = material;
	}
	
	/**
	 * Gets the item of this disc
	 * 
	 * @return disc item
	 */
	public ItemStack getDiscRecord()	{
		return new ItemStack(material);
	}
	
	/**
	 * Attempts to get the disc with the given name
	 * <p>
	 * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     * 
	 * @param name name of disc to get
	 * @return MyDiscRecord if found, or null
	 */
	public static MyDiscRecord getDiscWithName(String name)	{
		return BY_NAME.get(name);
	}
	
	static	{
		for (MyDiscRecord disc : values())	{
			BY_NAME.put(disc.name(), disc);
		}
	}
}
