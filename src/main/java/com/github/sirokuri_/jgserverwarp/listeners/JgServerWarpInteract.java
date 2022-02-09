package com.github.sirokuri_.jgserverwarp.listeners;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import com.github.sirokuri_.jgserverwarp.holder.JgServerWarpHolder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
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
        String config = plugin.config().getString("serverName");
        if (config == null || config.equals("Default")){
            player.sendMessage(ChatColor.RED + "正しくサーバー名が指定されていません。" + ChatColor.DARK_PURPLE + "スクショをした上で" + ChatColor.RED + "運営へ報告しましょう");
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return;
        if (!(itemStack.getType() == Material.PAPER)) return;
        if (itemMeta.getDisplayName().equals(ChatColor.GREEN + "jg内でサーバ移動をする")) {
            if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (config.equals("jg") || config.equals("jg1")){
                player.performCommand("JgServerWarp gui");
            } else {
                player.sendMessage(ChatColor.RED + "正しくサーバー名が指定されていません。" + ChatColor.DARK_PURPLE + "スクショをした上で" + ChatColor.RED + "運営へ報告しましょう");
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getView().getPlayer();
        Inventory inventory = e.getInventory();
        ItemStack slot = e.getCurrentItem();
        String config = plugin.config().getString("serverName");
        if (config == null || config.equals("Default")) return;
        if (slot == null) return;
        InventoryHolder inventoryHolder = inventory.getHolder();
        if(!(inventoryHolder instanceof JgServerWarpHolder)) return;
        JgServerWarpHolder holder = (JgServerWarpHolder) inventoryHolder;
        if (holder.tags.get(0).equals("holder1")) {
            ItemMeta itemMeta = slot.getItemMeta();
            if (itemMeta == null) return;
            if (slot.getType() == Material.GREEN_STAINED_GLASS_PANE) {
                if (slot.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&aJGへ移動する"))) {
                    e.setCancelled(true);
                    if (config.equals("jg")){
                        player.sendMessage(ChatColor.RED + "既にあなたはそのサーバーに接続しています");
                    }else if (config.equals("jg1")) {
                        player.performCommand("advancedPortals warp jg");
                        plugin.getLogger().info(player.getName() + " issued server command: /advancedPortals warp jg");
                    } else {
                        player.sendMessage(ChatColor.RED + "正しくサーバー名が指定されていません。" + ChatColor.DARK_PURPLE + "スクショをした上で" + ChatColor.RED + "運営へ報告しましょう");
                    }
                }
            } else if (slot.getType() == Material.RED_STAINED_GLASS_PANE) {
                if (slot.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&aJG1へ移動する"))) {
                    e.setCancelled(true);
                    if (config.equals("jg")){
                        player.performCommand("advancedPortals warp jg1");
                        plugin.getLogger().info(player.getName() + " issued server command: /advancedPortals warp jg1");
                    }else if (config.equals("jg1")) {
                        player.sendMessage(ChatColor.RED + "既にあなたはそのサーバーに接続しています");
                    } else {
                        player.sendMessage(ChatColor.RED + "正しくサーバー名が指定されていません。" + ChatColor.DARK_PURPLE + "スクショをした上で" + ChatColor.RED + "運営へ報告しましょう");
                    }
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
