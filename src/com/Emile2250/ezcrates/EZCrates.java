package com.Emile2250.ezcrates;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EZCrates extends JavaPlugin {
        public void onEnable()


        {
            PluginDescriptionFile pdfFile = this.getDescription();

            getLogger().info("EZCrates - Starting Up" + pdfFile.getName() + "v" + pdfFile.getVersion());

            Bukkit.getPluginManager().registerEvents(new EZCratesHandler(this), this);

            saveDefaultConfig();
    }
}
