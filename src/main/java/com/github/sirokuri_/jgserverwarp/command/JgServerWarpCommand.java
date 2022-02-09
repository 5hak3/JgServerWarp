package com.github.sirokuri_.jgserverwarp.command;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import com.github.sirokuri_.jgserverwarp.holder.JgServerWarpHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
                ItemStack itemStack1 = plugin.getItem();
                player.getInventory().addItem(itemStack1);
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")){
                plugin.reload();
                player.sendMessage("config reload...");
            }
            if (args[0].equalsIgnoreCase("gui")){
                Inventory gui = Bukkit.createInventory(new JgServerWarpHolder("holder1"), 18, "§cJG SERVER WARP");
                ItemStack menu1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemStack menu2 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta itemMeta1 = menu1.getItemMeta();
                ItemMeta itemMeta2 = menu2.getItemMeta();
                if (itemMeta1 == null || itemMeta2 == null) return true;
                itemMeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aJGへ移動する"));
                itemMeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aJG1へ移動する"));
                menu1.setItemMeta(itemMeta1);
                menu2.setItemMeta(itemMeta2);
                gui.setItem(0, menu1);
                gui.setItem(1, menu2);
                player.openInventory(gui);
            }
        }
        return true;
    }
}
