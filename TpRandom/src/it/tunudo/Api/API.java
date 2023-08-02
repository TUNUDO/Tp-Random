package it.tunudo.Api;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

public class API {
    public void randomTeleportPlayer(Player player,String Message,String Big_Title,String Small_Title) {
        Random random = new Random();
        int x = random.nextInt(100000 - -1000000);
        int z = random.nextInt(100000 - -1000000);
        player.teleport(new Location(player.getWorld(),x,player.getWorld().getHighestBlockYAt(x,z),z));
        if(!(Message.isEmpty())) {
            player.sendMessage(Message.replaceAll("%world%", player.getLocation().getWorld().getName()).replaceAll("%z%",String.valueOf(z)).replaceAll("%x%",String.valueOf(x)));
        }
        if((!(Big_Title.isEmpty())) && Small_Title.isEmpty()) {
            player.sendTitle(
                    ChatColor.translateAlternateColorCodes('&',Big_Title),
                    null);
        } else if(!(Small_Title.isEmpty()) && Big_Title.isEmpty()) {
            player.sendTitle(
                    null,
                    ChatColor.translateAlternateColorCodes('&',Small_Title));
        } else if(!(Big_Title.isEmpty() || Small_Title.isEmpty())) {
            player.sendTitle(
                    ChatColor.translateAlternateColorCodes('&',Big_Title),
                    ChatColor.translateAlternateColorCodes('&',Small_Title)
            );
        }
    }
}
