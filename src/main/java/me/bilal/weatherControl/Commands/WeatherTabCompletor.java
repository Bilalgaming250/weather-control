package me.bilal.weatherControl.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherTabCompletor implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("clear", "rain", "thunder", "reset", "time"), new ArrayList<>());
        } else if (args.length == 2) {
            if (args[1].equalsIgnoreCase("time")) {
                List <String> list = Arrays.asList("day", "night");

                for (int i = 0; i < 24; i++) {
                    list.add(Integer.toString(i));
                }

                return StringUtil.copyPartialMatches(args[1], list, new ArrayList<>());
            }
        }

        return new ArrayList<>();
    }
}
