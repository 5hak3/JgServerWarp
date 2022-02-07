package com.github.sirokuri_.jgserverwarp;

import com.github.sirokuri_.jgserverwarp.command.JgServerWarpCommand;
import com.github.sirokuri_.jgserverwarp.listeners.JgServerWarpInteract;
import com.github.sirokuri_.jgserverwarp.listeners.JgServerWarpJoin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class JgServerWarp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JgServerWarpJoin(this), this);
        getServer().getPluginManager().registerEvents(new JgServerWarpInteract(this), this);
        getCommand("JgServerWarp").setExecutor(new JgServerWarpCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&ajg内でサーバ移動をする"));
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&d左クリックでjgに"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&d右クリックでjg1にサーバー移動ができます"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dこのアイテムを無くした場合は"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dspawn地点のウィザースケルトンの頭を触ってください"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
