package com.github.sirokuri_.jgserverwarp.listeners;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JgServerWarpJoin implements Listener {

    private final JgServerWarp plugin;

    public JgServerWarpJoin(JgServerWarp jgServerWarp) {
        this.plugin = jgServerWarp;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();
        ItemStack itemStack = plugin.getItem();
        if (!inventory.contains(itemStack)){
            inventory.addItem(itemStack);
        }
    }
    //現状不要な機能
    /*@EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();
        ItemStack itemStack = plugin.getItem();
        if (!inventory.contains(itemStack)){
            inventory.addItem(itemStack);
        }
    }*/
}
