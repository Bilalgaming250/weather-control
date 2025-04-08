package me.bilal.weatherControl.listeners;

import me.bilal.weatherControl.utils.ItemBuilder;
import me.bilal.weatherControl.managers.Weather;
import me.bilal.weatherControl.managers.WeatherGUI;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class CustomTime implements Listener {

    private WeatherControl plugin;

    public CustomTime(WeatherControl plugin) {
        this.plugin = plugin;
    }

    public static int time = 0;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("§cCustom Time")) {
            event.setCancelled(true);
            Inventory inventory = event.getInventory();


            switch (event.getSlot()) {
                case 0 -> WeatherGUI.openTimeGUI(player, plugin);
                case 5 -> {
                    if (time < 24 && time >= 0) {
                        time = time + 1;
                        System.out.println(time);
                        ItemBuilder.updateItemName(inventory.getItem(4), "§c" + time);
                    }
                }
                case 3 -> {
                    if (time > 0) {
                        time = time - 1;
                        System.out.println(time);
                        ItemBuilder.updateItemName(inventory.getItem(4), "§c" + time);
                    }
                }
                case 8 -> Weather.setTime(player, Integer.toString(time), plugin);
            }
        }
    }
}
