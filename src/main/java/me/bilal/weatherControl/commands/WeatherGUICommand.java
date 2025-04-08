package me.bilal.weatherControl.commands;

import me.bilal.weatherControl.managers.WeatherGUI;
import me.bilal.weatherControl.WeatherControl;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherGUICommand implements CommandExecutor {

    private WeatherControl plugin;

    public WeatherGUICommand(WeatherControl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("You are not a player!"); return true; }
        Player player = (Player) sender;

        if (!(player.hasPermission("weathercontrol.admin"))) { player.sendMessage(plugin.getConfig().getString("NoPermissionMessage")); return true; }
        if (player.getWorld().getEnvironment() != World.Environment.NORMAL) { player.sendMessage(plugin.getConfig().getString("NotInOverworld")); return true;  }

        WeatherGUI.openWeatherControl(player, plugin);
        return false;
    }
}
