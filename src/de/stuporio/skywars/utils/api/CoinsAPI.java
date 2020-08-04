package de.stuporio.skywars.utils.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CoinsAPI {

    public static Integer getKills(final String name){
        final File file = new File("plugins//SkyWars", "DONTDELETE.yml");
        final FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
        final int coins = cfg.getInt(name + ".kills");
        return coins;
    }

    public static void addKills(final String name, final int amount){
        final File file = new File("plugins//SkyWars", "DONTDELETE.yml");
        final FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
        int coins = cfg.getInt(name + ".kills");
        coins += amount;
        cfg.set(name + ".kills", coins);
        try {
            cfg.save(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
