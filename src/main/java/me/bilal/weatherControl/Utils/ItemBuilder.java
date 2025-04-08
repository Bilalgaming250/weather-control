package me.bilal.weatherControl.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

    public static ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();

        meta.setItemName(name);
        item.setItemMeta(meta);

        return item;
    }

    public static void updateItemName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setItemName(name);
        item.setItemMeta(meta);
    }
}
