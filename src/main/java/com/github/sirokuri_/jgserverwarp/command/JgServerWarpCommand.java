package com.github.sirokuri_.jgserverwarp.command;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class JgServerWarpCommand implements CommandExecutor {

    private final JgServerWarp plugin;

    public JgServerWarpCommand(JgServerWarp jgServerWarp) {
        this.plugin = jgServerWarp;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("JgServerWarp")) {
            if (args.length <= 0) {
                return true;
            }
            if (args[0].equalsIgnoreCase("give")) {
                ItemStack itemStack1 = new ItemStack(Material.PAPER);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                if (itemMeta1 == null) return true;
                itemMeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&ajg内でサーバ移動をする"));
                List<String> lore1 = new ArrayList<String>();
                lore1.add(ChatColor.translateAlternateColorCodes('&', "&d左クリックでjgに"));
                lore1.add(ChatColor.translateAlternateColorCodes('&', "&d右クリックでjg1にサーバー移動ができます"));
                lore1.add(ChatColor.translateAlternateColorCodes('&', "&dこのアイテムを無くした場合は"));
                lore1.add(ChatColor.translateAlternateColorCodes('&', "&dspawn地点のウィザースケルトンの頭を触ってください"));
                itemMeta1.setLore(lore1);
                itemStack1.setItemMeta(itemMeta1);
                player.getInventory().addItem(itemStack1);
                return true;
            }
        }
        return true;
    }
}
