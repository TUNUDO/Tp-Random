package it.tunudo.Teleport;

import it.tunudo.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class TpRandom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("tprandom")) {
            if(args.length==0) {
                if(commandSender.hasPermission("TpRandom.teleport")) {
                    if(commandSender instanceof Player) {
                        Random random = new Random();
                        int x = random.nextInt(100000 - -1000000) + 1;
                        int z = random.nextInt(100000 - -1000000) + 1;
                        ((Player) commandSender).teleport(new Location(((Player) commandSender).getWorld()
                                , x,
                                ((Player) commandSender).getWorld().getHighestBlockYAt(x,z)
                                ,z));
                        ((Player) commandSender).sendTitle(
                                "§aTeleporting...",
                                "At random coordinates"
                        );
                        commandSender.sendMessage("§1[Server] §aYou have been teleported to the coordinates: x: "
                                + x +
                                ", z: "
                                + z +
                                " at your world("
                                + ((Player) commandSender).getWorld().getName() +
                                ")"
                        );
                    } else {
                        commandSender.sendMessage("§1[Server] §cIncorrect instance");
                    }
                } else {
                    commandSender.sendMessage("§1[Server] §cYou do not have permession");
                }
            } else {
                commandSender.sendMessage("§1[Server] §cIncorrect arguments");
            }
        }
        return false;
    }
}
