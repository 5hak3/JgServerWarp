package com.github.sirokuri_.jgserverwarp.listeners;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class JgServerWarpJoin implements Listener {

    private final JgServerWarp plugin;

    public JgServerWarpJoin(JgServerWarp jgServerWarp) {
        this.plugin = jgServerWarp;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return;
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&ajg内でサーバ移動をする"));
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&d左クリックでjgに"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&d右クリックでjg1にサーバー移動ができます"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dこのアイテムを無くした場合は"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dspawn地点のウィザースケルトンの頭を触ってください"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        player.getInventory().addItem(itemStack);
    }
}
