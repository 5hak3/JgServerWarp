package com.github.sirokuri_.jgserverwarp;

import com.github.sirokuri_.jgserverwarp.command.JgServerWarpCommand;
import com.github.sirokuri_.jgserverwarp.listeners.JgServerWarpInteract;
import com.github.sirokuri_.jgserverwarp.listeners.JgServerWarpJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class JgServerWarp extends JavaPlugin{

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
}
