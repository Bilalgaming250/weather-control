package me.bilal.weatherControl.Utils;

import me.bilal.weatherControl.WeatherControl;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Weather {

    private static void transitionTime(World world, int targetTime, WeatherControl plugin) {
        long currentTime = world.getTime();
        long difference = targetTime - currentTime;
        int steps = 50;
        long timePerStep = difference / steps;

        new BukkitRunnable() {
            int currentStep = 0;

            @Override
            public void run() {
                if (currentStep >= steps) {
                    world.setTime(targetTime);
                    this.cancel();
                    return;
                }

                long newTime = currentTime + (timePerStep * currentStep);
                world.setTime(newTime);
                currentStep++;
            }
        }.runTaskTimer(plugin, 1L, 1L);
    }

    public static void setWeather(Player player, String weather, WeatherControl plugin) {
        World world = player.getWorld();

        switch (weather) {
            case "rain" -> world.setStorm(true);
            case "thunder" -> {
                world.setStorm(true);
                world.setThundering(true);
            }
            case "clear", "reset" -> {
                world.setStorm(false);
                world.setThundering(false);
            }
            default -> {
                player.sendMessage(plugin.getConfig().getString("MessagePrefix") + " " + plugin.getConfig().getString("InvalidWeather"));
                return;
            }
        }

        if (plugin.getConfig().getBoolean("NotifyPlayers.enabled")) {
            Bukkit.broadcastMessage(plugin.getConfig().getString("MessagePrefix") + " " + plugin.getConfig().getString("NotifyPlayers.WeatherChange"));
        }
    }

    public static void setTime(Player player, String time, WeatherControl plugin) {
        World world = player.getWorld();

        switch (time) {
            case "day" -> transitionTime(world, 0000, plugin);
            case "night" -> transitionTime(world, 18000, plugin);
            default -> {
                if (Integer.parseInt(time) <= 24 && Integer.parseInt(time) >= 0) {
                    int targetTime = Integer.parseInt(time + "000") - 6000;
                    transitionTime(world, targetTime, plugin);
                } else {
                    player.sendMessage(plugin.getConfig().getString("MessagePrefix") + " " + plugin.getConfig().getString("InvalidTime"));
                    return;
                }
            }
        }

        if (plugin.getConfig().getBoolean("NotifyPlayers.enabled")) {
            Bukkit.broadcastMessage(plugin.getConfig().getString("MessagePrefix") + " " + plugin.getConfig().getString("NotifyPlayers.TimeChange"));
        }
    }
}
