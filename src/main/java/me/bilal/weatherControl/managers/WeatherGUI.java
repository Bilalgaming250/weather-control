package me.bilal.weatherControl.managers;

import me.bilal.weatherControl.listeners.CustomTime;
import me.bilal.weatherControl.utils.ItemBuilder;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WeatherGUI {

    public static void openWeatherControl(Player player, WeatherControl plugin) {
        FileConfiguration config = plugin.getConfig();

        Inventory inventory = Bukkit.createInventory(player,
                9,
                config.getString("WeatherControlGUI.title"));

        ItemStack filler = ItemBuilder.createItem(Material.GRAY_STAINED_GLASS_PANE, config.getString("WeatherControlGUI.filler"));
        ItemStack changeWeather = ItemBuilder.createItem(Material.WIND_CHARGE, config.getString("WeatherControlGUI.changeWeather"));
        ItemStack changeTime = ItemBuilder.createItem(Material.CLOCK, config.getString("WeatherControlGUI.changeTime"));
        ItemStack resetWeatherTime = ItemBuilder.createItem(Material.GREEN_WOOL, config.getString("WeatherControlGUI.resetWeatherTime"));
        ItemStack closeMenu = ItemBuilder.createItem(Material.BARRIER, config.getString("WeatherControlGUI.closeMenu"));

        inventory.setItem(3, changeWeather);
        inventory.setItem(4, changeTime);
        inventory.setItem(5, resetWeatherTime);
        inventory.setItem(8, closeMenu);

        for (int i=0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                inventory.setItem(i, filler);
            }
        }

        player.openInventory(inventory);
    }

    public static void openWeatherGUI(Player player, WeatherControl plugin) {
        FileConfiguration config = plugin.getConfig();

        Inventory inventory = Bukkit.createInventory(player,
                9,
                config.getString("WeatherGUI.title"));

        ItemStack filler = ItemBuilder.createItem(Material.GRAY_STAINED_GLASS_PANE, config.getString("WeatherGUI.filler"));
        ItemStack thunder = ItemBuilder.createItem(Material.TRIDENT, config.getString("WeatherGUI.thunder"));
        ItemStack rain = ItemBuilder.createItem(Material.WATER_BUCKET, config.getString("WeatherGUI.rain"));
        ItemStack clear = ItemBuilder.createItem(Material.GREEN_WOOL, config.getString("WeatherGUI.clear"));
        ItemStack backToMainPage = ItemBuilder.createItem(Material.OAK_SIGN, config.getString("WeatherGUI.backToMainPage"));
        ItemStack closeMenu = ItemBuilder.createItem(Material.BARRIER, config.getString("WeatherGUI.closeMenu"));

        inventory.setItem(3, thunder);
        inventory.setItem(4, rain);
        inventory.setItem(5, clear);
        inventory.setItem(0, backToMainPage);
        inventory.setItem(8, closeMenu);
        for (int i=0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                inventory.setItem(i, filler);
            }
        }

        player.openInventory(inventory);
    }

    public static void openTimeGUI(Player player, WeatherControl plugin) {
        FileConfiguration config = plugin.getConfig();

        Inventory inventory = Bukkit.createInventory(player,
                9,
                config.getString("TimeGUI.title"));

        ItemStack filler = ItemBuilder.createItem(Material.GRAY_STAINED_GLASS_PANE, config.getString("TimeGUI.filler"));
        ItemStack day = ItemBuilder.createItem(Material.YELLOW_WOOL, config.getString("TimeGUI.day"));
        ItemStack night = ItemBuilder.createItem(Material.BLUE_WOOL, config.getString("TimeGUI.night"));
        ItemStack custom = ItemBuilder.createItem(Material.CLOCK, config.getString("TimeGUI.custom"));
        ItemStack backToMainPage = ItemBuilder.createItem(Material.OAK_SIGN, config.getString("TimeGUI.backToMainPage"));
        ItemStack closeMenu = ItemBuilder.createItem(Material.BARRIER, config.getString("TimeGUI.closeMenu"));

        inventory.setItem(3, day);
        inventory.setItem(4, night);
        inventory.setItem(5, custom);
        inventory.setItem(0, backToMainPage);
        inventory.setItem(8, closeMenu);
        for (int i=0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                inventory.setItem(i, filler);
            }
        }

        player.openInventory(inventory);
    }

    public static void openCustomTime(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 9, "§cCustom Time");

        ItemStack filler = ItemBuilder.createItem(Material.GRAY_STAINED_GLASS_PANE, "§8|");
        ItemStack decreaseItem = ItemBuilder.createItem(Material.RED_BANNER,"§cDecrease Time");
        ItemStack clock = ItemBuilder.createItem(Material.CLOCK, "§c" + CustomTime.time);
        ItemStack increaseTime = ItemBuilder.createItem(Material.GREEN_BANNER,"§cIncrease Time");
        ItemStack backToMainPage = ItemBuilder.createItem(Material.OAK_SIGN, "§cGo Back");
        ItemStack setTime = ItemBuilder.createItem(Material.GREEN_WOOL, "§eSet Time");

        inventory.setItem(3, decreaseItem);
        inventory.setItem(4, clock);
        inventory.setItem(5, increaseTime);
        inventory.setItem(0, backToMainPage);
        inventory.setItem(8, setTime);
        for (int i=0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                inventory.setItem(i, filler);
            }
        }

        player.openInventory(inventory);
    }
}
