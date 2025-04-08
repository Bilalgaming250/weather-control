package me.bilal.weatherControl.Listeners;

import me.bilal.weatherControl.Utils.Weather;
import me.bilal.weatherControl.Utils.WeatherGUI;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ChangeWeather implements Listener {

    private WeatherControl plugin;

    public ChangeWeather(WeatherControl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        FileConfiguration config = plugin.getConfig();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(config.getString("WeatherGUI.title"))) {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 0 -> WeatherGUI.openWeatherControl(player, plugin);
                case 3 -> Weather.setWeather(player, "thunder", plugin);
                case 4 -> Weather.setWeather(player, "rain", plugin);
                case 5 -> Weather.setWeather(player, "clear", plugin);
                case 8 -> player.closeInventory();
            }
        }
    }
}
