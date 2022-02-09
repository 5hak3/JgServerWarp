package com.github.sirokuri_.jgserverwarp.holder;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JgServerWarpHolder implements InventoryHolder {
    public List<String> tags = new ArrayList<>();

    public JgServerWarpHolder(String... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    public List<String> getTags(){
        return tags;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
