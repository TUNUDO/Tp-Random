package it.tunudo;

import it.tunudo.Teleport.TpRandom;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN + "Enabling TpRandom");
        getCommand("tprandom").setExecutor(new TpRandom());
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Disabling TpRandom");
    }
    public Plugin getInstance() {
        return plugin;
    }

}
