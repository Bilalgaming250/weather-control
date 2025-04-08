package me.bilal.weatherControl.Listeners;

import me.bilal.weatherControl.Utils.Weather;
import me.bilal.weatherControl.Utils.WeatherGUI;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WeatherMain implements Listener {

    private WeatherControl plugin;

    public WeatherMain (WeatherControl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        FileConfiguration config = plugin.getConfig();
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(config.getString("WeatherControlGUI.title"))) {
            event.setCancelled(true);

            switch (event.getSlot()) {
                case 3 -> WeatherGUI.openWeatherGUI(player, plugin);
                case 4 -> WeatherGUI.openTimeGUI(player, plugin);
                case 5 -> Weather.setWeather(player, "reset", plugin);
                case 8 -> player.closeInventory();
            }
        }
    }
}
