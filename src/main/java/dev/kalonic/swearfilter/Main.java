package dev.kalonic.swearfilter;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new SwearFilter(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
