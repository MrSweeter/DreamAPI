package com.mrsweeter.dreamAPI.Messages;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * 
 * @author MrSweeter
 * @author Chazmondo https://github.com/Chazmondo/AdvancementAPI/blob/master/src/main/java/io/chazza/advancementapi/AdvancementAPI.java
 * 
 */
public class AdvancementMessage	{

	private NamespacedKey id;
    private String icon;
    private String title, description;
    private String frame;
    private boolean announce = false, toast = true;
	private JavaPlugin pl;
    
	/**
	 * Create a Toast/Advancement display (Top right corner)
	 * @param id A unique id for this Advancement, will be the name if advancement file
	 * @param title 
	 * @param description
	 * @param icon
	 * @param frame
	 * @param pl
	 */
	public AdvancementMessage(NamespacedKey id, FormatedChatComponent title, String icon, String frame, JavaPlugin pl) {
		
		this.id = id;
		this.title = title.getFormatText();
		this.description = "§7This Toast was create with DreamAPI";
		this.icon = icon;
		this.frame = frame;
		this.pl = pl;
	}
	
	public void sendAdvancement(Player... players)	{
		add();
		grant(players);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				revoke(players);
				remove();
			}
		}.runTaskLater(pl, 20);
		
	}
	
	@SuppressWarnings("deprecation")
	private void add()	{
		try {
			Bukkit.getUnsafe().loadAdvancement(id, getJson());
			Bukkit.getLogger().info("Advancement " + id + " saved");
		} catch (IllegalArgumentException e){
			Bukkit.getLogger().info("Error while saving, Advancement " + id + " seems to already exist");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void remove()	{
		Bukkit.getUnsafe().removeAdvancement(id);
	}
	
	private void grant(Player... players) {
		System.out.println("granting");
		Advancement advancement = Bukkit.getAdvancement(id);
		AdvancementProgress progress;
		for (Player player : players)	{
			
			progress = player.getAdvancementProgress(advancement);
			if (!progress.isDone())	{
				for (String criteria : progress.getRemainingCriteria())	{
					progress.awardCriteria(criteria);
				}
			}
		}
    }
	
	private void revoke(Player...players)	{
		System.out.println("revoke");
		Advancement advancement = Bukkit.getAdvancement(id);
		AdvancementProgress progress;
		for (Player player : players)	{
			
			progress = player.getAdvancementProgress(advancement);
			if (progress.isDone())	{
				for (String criteria : progress.getAwardedCriteria())	{
					progress.revokeCriteria(criteria);
				}
			}
		}
	}
	
	public String getJson()	{
		
		JsonObject json = new JsonObject();

        JsonObject icon = new JsonObject();
        icon.addProperty("item", this.icon);

        JsonObject display = new JsonObject();
        display.add("icon", icon);
        display.addProperty("title", this.title);
        display.addProperty("description", this.description);
        display.addProperty("background", "minecraft:textures/gui/advancements/backgrounds/adventure.png");
        display.addProperty("frame", this.frame);
        display.addProperty("announce_to_chat", announce);
        display.addProperty("show_toast", toast);
        display.addProperty("hidden", true);

        JsonObject criteria = new JsonObject();
        JsonObject trigger = new JsonObject();

        trigger.addProperty("trigger", "minecraft:impossible");
        criteria.add("impossible", trigger);

        json.add("criteria", criteria);
        json.add("display", display);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);
		
	}
}
