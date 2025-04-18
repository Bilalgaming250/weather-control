package me.bilal.weatherControl;

import me.bilal.weatherControl.commands.WeatherCommand;
import me.bilal.weatherControl.commands.WeatherGUICommand;
import me.bilal.weatherControl.commands.WeatherTabCompletor;
import me.bilal.weatherControl.listeners.ChangeTime;
import me.bilal.weatherControl.listeners.ChangeWeather;
import me.bilal.weatherControl.listeners.CustomTime;
import me.bilal.weatherControl.listeners.WeatherMain;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WeatherControl extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("weather").setExecutor(new WeatherCommand(this));
        getCommand("weather").setTabCompleter(new WeatherTabCompletor());
        getCommand("weathergui").setExecutor(new WeatherGUICommand(this));

        Bukkit.getPluginManager().registerEvents(new ChangeTime(this), this);
        Bukkit.getPluginManager().registerEvents(new ChangeWeather(this), this);
        Bukkit.getPluginManager().registerEvents(new WeatherMain(this), this);
        Bukkit.getPluginManager().registerEvents(new CustomTime(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
