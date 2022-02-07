package com.github.sirokuri_.jgserverwarp.listeners;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JgServerWarpInteract implements Listener{

    private final JgServerWarp plugin;

    public JgServerWarpInteract(JgServerWarp jgServerWarp) {
        this.plugin = jgServerWarp;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if ((event.getHand() != EquipmentSlot.HAND)) return;
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return;
        if (itemStack.getType() == Material.PAPER){
            if (itemMeta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&ajg内でサーバ移動をする"))){
                if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
                    player.performCommand("advancedportals warp jg");
                    plugin.getLogger().info(player.getName() + " issued server command: /advancedportals warp jg");
                }
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    player.performCommand("advancedportals warp jg1");
                    plugin.getLogger().info(player.getName() + " issued server command: /advancedportals warp jg1");
                }
            }
        }
    }
}
