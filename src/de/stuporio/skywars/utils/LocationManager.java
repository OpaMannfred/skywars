// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils;

import org.bukkit.Bukkit;
import de.stuporio.skywars.SkyWars;
import org.bukkit.Location;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;

public class LocationManager
{
    public static File folder;
    public static File file;
    public static YamlConfiguration cfg;
    
    public static void setupFiles() {
        if (!LocationManager.folder.exists()) {
            LocationManager.folder.mkdir();
        }
        if (!LocationManager.file.exists()) {
            try {
                LocationManager.file.createNewFile();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static Location teleportToArena(final int Spawn) {
        final double x = LocationManager.cfg.getDouble("Locations." + SkyWars.currentMap + "." + Spawn + ".X");
        final double y = LocationManager.cfg.getDouble("Locations." + SkyWars.currentMap + "." + Spawn + ".Y");
        final double z = LocationManager.cfg.getDouble("Locations." + SkyWars.currentMap + "." + Spawn + ".Z");
        final double yaw = LocationManager.cfg.getDouble("Locations." + SkyWars.currentMap + "." + Spawn + ".Yaw");
        final double pitch = LocationManager.cfg.getDouble("Locations." + SkyWars.currentMap + "." + Spawn + ".Pitch");
        final String worldName = LocationManager.cfg.getString("Locations." + SkyWars.currentMap + "." + Spawn + ".worldName");
        final Location loc = new Location(Bukkit.getWorld(worldName), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        return loc;
    }
    
    public static void saveLocations() {
        try {
            LocationManager.cfg.save(LocationManager.file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static double getSpawnHeight() {
        return LocationManager.cfg.getDouble("Locations.Spawn.Y");
    }
    
    public static double getHeight() {
        return LocationManager.cfg.getDouble("Locations.Height");
    }
    
    public static void setLocation(final String name, final Location loc) {
        final double x = loc.getBlockX() + 0.5;
        final double y = loc.getBlockY();
        final double z = loc.getBlockZ() + 0.5;
        final double yaw = Math.round(loc.getYaw() / 45.0f) * 45;
        final double pitch = Math.round(loc.getPitch() / 45.0f) * 45;
        final String worldName = loc.getWorld().getName();
        LocationManager.cfg.set("Locations." + name + ".X", (Object)x);
        LocationManager.cfg.set("Locations." + name + ".Y", (Object)y);
        LocationManager.cfg.set("Locations." + name + ".Z", (Object)z);
        LocationManager.cfg.set("Locations." + name + ".Yaw", (Object)yaw);
        LocationManager.cfg.set("Locations." + name + ".Pitch", (Object)pitch);
        LocationManager.cfg.set("Locations." + name + ".worldName", (Object)worldName);
        saveLocations();
    }
    
    public static void setHeight(final String name, final double height) {
        LocationManager.cfg.set("Locations." + name, (Object)height);
        saveLocations();
    }
    
    public static void removeLocation(final String name) {
        final String path = "Locations." + name;
        LocationManager.cfg.set(path, (Object)null);
        saveLocations();
    }
    
    public static void removeMap(final int name) {
        final String path = "Map." + name;
        LocationManager.cfg.set(path, (Object)null);
        saveLocations();
    }
    
    public static boolean locationIsExisting(final String name) {
        return LocationManager.cfg.get("Locations." + name) != null;
    }
    
    public static Location getLocation(final String name) {
        final double x = LocationManager.cfg.getDouble("Locations." + name + ".X");
        final double y = LocationManager.cfg.getDouble("Locations." + name + ".Y");
        final double z = LocationManager.cfg.getDouble("Locations." + name + ".Z");
        final double yaw = LocationManager.cfg.getDouble("Locations." + name + ".Yaw");
        final double pitch = LocationManager.cfg.getDouble("Locations." + name + ".Pitch");
        final String worldName = LocationManager.cfg.getString("Locations." + name + ".worldName");
        final Location loc = new Location(Bukkit.getWorld(worldName), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        return loc;
    }
    
    static {
        LocationManager.folder = new File("plugins/SkyWars/");
        LocationManager.file = new File("plugins/SkyWars/locations.yml");
        LocationManager.cfg = YamlConfiguration.loadConfiguration(LocationManager.file);
    }
}
