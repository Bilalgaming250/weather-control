package me.bilal.weatherControl.Commands;

import me.bilal.weatherControl.Utils.Weather;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {

    private WeatherControl plugin;

    public WeatherCommand(WeatherControl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("You are not a player!"); return true; }
        Player player = (Player) sender;

        if (!(player.hasPermission("weathercontrol.admin"))) { player.sendMessage(plugin.getConfig().getString("NoPermissionMessage")); return true; }
        if (player.getWorld().getEnvironment() != World.Environment.NORMAL) { player.sendMessage(plugin.getConfig().getString("NotInOverworld")); return true;  }

        if (args.length < 1) {
            player.sendMessage(plugin.getConfig().getString("MessagePrefix") + " " + "§cInvalid Usage! Valid Usages:\n/weather [clear/rain/thunder]\n/weather reset\n/weather time [day/night/<24hr time>]");
            return true;
        }

        if (args.length == 1) {
            if (!(args[0].equalsIgnoreCase("time"))) {
                Weather.setWeather(player, args[0], plugin);
            } else {
                player.sendMessage(plugin.getConfig().getString("MessagePrefix") + " " + "§cInvalid Usage! Valid Usage: /weather time [day/night/<24hr time>]");
                return true;
            }
        } else {
            if (!(args[0].equalsIgnoreCase("time"))) {
                player.sendMessage(plugin.getConfig().getString("MessagePrefix") + " " + "§cInvalid Usage! Valid Usages:\n/weather [clear/rain/thunder]\n/weather reset\n/weather time [day/night/<24hr time>]");
                return true;
            }

            Weather.setTime(player, args[1], plugin);
        }

        return false;
    }
}
