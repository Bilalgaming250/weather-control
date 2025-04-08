package me.bilal.weatherControl.Listeners;

import me.bilal.weatherControl.Utils.Weather;
import me.bilal.weatherControl.Utils.WeatherGUI;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ChangeTime implements Listener {

    private WeatherControl plugin;

    public ChangeTime(WeatherControl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        FileConfiguration config = plugin.getConfig();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(config.getString("TimeGUI.title"))) {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 0 -> WeatherGUI.openWeatherControl(player, plugin);
                case 3 -> Weather.setTime(player, "day", plugin);
                case 4 -> Weather.setTime(player, "night", plugin);
                case 5 -> WeatherGUI.openCustomTime(player);
                case 8 -> player.closeInventory();
            }
        }
    }
}
