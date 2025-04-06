package me.bilal.weatherControl;

import me.bilal.weatherControl.Commands.WeatherCommand;
import me.bilal.weatherControl.Commands.WeatherTabCompletor;
import org.bukkit.plugin.java.JavaPlugin;

public final class WeatherControl extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("weather").setExecutor(new WeatherCommand());
        getCommand("weather").setTabCompleter(new WeatherTabCompletor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
