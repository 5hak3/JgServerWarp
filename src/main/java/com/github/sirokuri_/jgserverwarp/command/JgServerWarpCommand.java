package com.github.sirokuri_.jgserverwarp.command;

import com.github.sirokuri_.jgserverwarp.JgServerWarp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
        }
        return true;
    }
}
