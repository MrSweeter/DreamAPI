package com.mrsweeter.dreamAPI.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.mrsweeter.dreamAPI.DreamAPI;

public class ItemsUtils {
	
	/**
	 * Attempts to get the item with the given name
	 * <p>
	 * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     * 
	 * @param materialName name of the material (ignoreCase)
	 * @return item corresponding of material name
	 */
	public static ItemStack getItemWithMaterial(String materialName)	{
		
		materialName = materialName.toUpperCase();
		
		if (MyDiscRecord.getDiscWithName(materialName) != null)	{return MyDiscRecord.getDiscWithName(materialName).getDiscRecord();}
		if (MySpawnEgg.getSpawnEggWithName(materialName) != null)	{return MySpawnEgg.getSpawnEggWithName(materialName).getSpawnEgg();}
		if (MyTippedArrow.getArrowWithName(materialName) != null)	{return MyTippedArrow.getArrowWithName(materialName).getArrow();}
		if (MyPotion.getPotionWithName(materialName) != null)	{return MyPotion.getPotionWithName(materialName).getPotion();}
		
		if (Material.getMaterial(materialName) != null)	{return new ItemStack(Material.getMaterial(materialName));}
		
		DreamAPI.instance.getLogger().info("Material: " + materialName + " is not a valid material");
		return null;
		
	}
}
