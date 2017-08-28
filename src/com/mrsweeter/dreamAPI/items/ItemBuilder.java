package com.mrsweeter.dreamAPI.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mrsweeter.dreamAPI.enchantments.GlowingEnchantment;
import com.mrsweeter.dreamAPI.exceptions.InvalidConfigurationValueException;
import com.mrsweeter.dreamAPI.exceptions.InvalidSectionException;

public class ItemBuilder {
	
	private ItemStack item;
	private ItemMeta meta;
	
	/**
	 * Creates an item with a configuration section
	 * <pre>[identifier] (what you want)
	 *     material: ""
	 *     damage: 0 (optional)
	 *     amount: 1 (optional)
	 *     metadata: (optional)
	 *         name: "" (optional)
	 *         glowing: false (optional)
	 *         lores: (optional)
	 *         - ""
	 *         - ""
	 *         enchantments: (optional)
	 *         - [enchant]-[level]
	 *         - [enchant]-[level]</pre>
	 * 
	 * @param itemSection Configuration section respecting structure above
	 */
	public ItemBuilder(ConfigurationSection itemSection)	{
		
		if (!itemSection.contains("material"))	{throw new InvalidSectionException("Invalid section, material is required");}
		
		item = new ItemStack(ItemsUtils.getItemWithMaterial(itemSection.getString("material")));
		
		if (item.getType() == Material.AIR)	{throw new InvalidConfigurationValueException("You can't build a item with AIR");}
		
		if (itemSection.contains("damage"))	{this.damage((short) itemSection.getInt("damage"));}
		if (itemSection.contains("amount"))	{this.amount(itemSection.getInt("amount"));}
		
		if (itemSection.contains("metadata"))	{
			
			ConfigurationSection metadata = itemSection.getConfigurationSection("metadata");
			meta = item.getItemMeta();
			
			if (metadata.contains("name"))	{this.name(metadata.getString("name").replace("&", "§"));}
			if (metadata.contains("lores"))	{this.lores(metadata.getStringList("lores"));}
			if (metadata.contains("glowing") && metadata.getBoolean("glowing"))	{this.glowing(true);}
			
			if (metadata.contains("enchantments"))	{
				List<String> enchants = metadata.getStringList("enchantments");
				addEnchantments((String[]) enchants.toArray());
			}
		}
	}
	
	/**
	 * Creates an item with material
	 * @param material Material to use
	 */
	public ItemBuilder(Material material)	{
		item = new ItemStack(material);
		meta = item.getItemMeta();
	}
	
	/**
	 * Creates an item with an itemstack
	 * @param item Item to "clone"
	 */
	public ItemBuilder(ItemStack item)	{
		this.item = new ItemStack(item);
		meta = this.item.getItemMeta();
	}
	
	/**
	 * Sets damage of item
	 * @param value damage to set, durability to remove if it's an armor or a tool
	 * @return ItemBuilder instance
	 */
	public ItemBuilder damage(int value)	{
		item.setDurability((short) value);
		return this;
	}
	
	/**
	 * Sets amount of your item
	 * @param value Quantity of item
	 * @return ItemBuilder instance
	 */
	public ItemBuilder amount(int value)	{
		item.setAmount(value);
		return this;
	}
	
	/**
	 * @param value Metadata
	 * @return ItemBuilder instance
	 * @deprecated Sets metadata, not recommended metadata depends of your item
	 */
	@Deprecated
	public ItemBuilder metadata(ItemMeta value)	{
		item.setItemMeta(value);
		return this;
	}
	
	/**
	 * Sets name of your item
	 * @param value Name to set
	 * @return ItemBuilder instance
	 */
	public ItemBuilder name(String value)	{
		meta.setDisplayName(value.replace("&", "§"));
		return this;
	}
	
	/**
	 * Sets glowing item or not
	 * @param value True = glowing
	 * @return ItemBuilder instance
	 */
	public ItemBuilder glowing(boolean value)	{
		
		Enchantment glow = GlowingEnchantment.getEnchant();
		
		if (value)	{meta.addEnchant(glow, 1, true);}
		else if (meta.hasEnchant(glow))	{meta.removeEnchant(glow);}
		return this;
	}
	
	/**
	 * Sets lores of your item
	 * @param values Different value to add, in order
	 * @return ItemBuilder instance
	 */
	public ItemBuilder lores(String... values)	{
		this.lores(Arrays.asList(values));
		return this;
	}
	
	/**
	 * Sets lores of your item
	 * @param values List to add
	 * @return ItemBuilder instance
	 */
	public ItemBuilder lores(List<String> values)	{
		ArrayList<String> lores = new ArrayList<>();
		for (String value : values)	{
			lores.add(value.replace("&", "§"));
		}
		meta.setLore(lores);
		return this;
	}
	
	/**
	 * Adds enchants on your item
	 * @param values Enchantment to add, shape: ENCHANT-LEVEL
	 * @return ItemBuilder instance
	 */
	public ItemBuilder addEnchantments(String... values)	{
		String[] temp;
		for (String value : values)	{
			if (!value.contains("-"))	{value += "-1";}
			temp = value.split("-");
			meta.addEnchant(Enchantment.getByName(temp[0]), Integer.parseInt(temp[1]), true);
		}
		return this;
	}
	
	/**
	 * Adds enchant on your item
	 * @param value Enchantment to add
	 * @param level Level of enchantment
	 * @return ItemBuilder instance
	 */
	public ItemBuilder addEnchantment(Enchantment value, int level)	{
		meta.addEnchant(value, level, true);
		return this;
	}
	
	/**
	 * Creates your item
	 * @return The item created
	 */
	public ItemStack build()	{
		item.setItemMeta(meta);
		return item;
	}
}
