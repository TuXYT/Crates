package com.Emile2250.ezcrates;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Config extends YamlConfiguration {

    private File file;
    private String configDefaults;
    private JavaPlugin pl;

    public Config(JavaPlugin pl, String fileName) {
        this(pl, fileName, null);
    }

    public Config(JavaPlugin pl, String fileName, String defaultsName) {
        this.pl = pl;
        this.configDefaults = defaultsName;
        this.file = new File(pl.getDataFolder(), fileName);
        reload();
    }

    public void reload() {

        if (!file.exists()) {

            try {
                file.getParentFile().mkdirs();
                file.createNewFile();

            } catch (IOException ex) {
                ex.printStackTrace();
                pl.getLogger().severe("Error while creating config file: " + file.getName());
            }
        }

        try {
            load(file);

            if (configDefaults != null) {

                InputStreamReader reader = new InputStreamReader(pl.getResource(configDefaults));
                FileConfiguration defaultsConfig = YamlConfiguration.loadConfiguration(reader);

                setDefaults(defaultsConfig);
                options().copyDefaults(true);

                reader.close();
                save();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
            pl.getLogger().severe("Error while loading the following config file: " + file.getName());

        } catch (InvalidConfigurationException ex) {
            ex.printStackTrace();
            pl.getLogger().severe("Error while loading the following config file " + file.getName());
        }
    }

    public void save() {

        try {
            options().indent(2);
            save(file);

        } catch (IOException ex) {
            ex.printStackTrace();
            pl.getLogger().severe("Error while saving the following config file: " + file.getName());
        }
    }

    public boolean isEmpty() {
        HashSet<Integer> keys = new HashSet<>();

        for (String key : this.getKeys(false)) {
            keys.add(Integer.valueOf(this.getConfigurationSection(key).getName()));
        }

        return keys.size() == 0;
    }
}
