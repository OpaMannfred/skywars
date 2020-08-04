// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars;

import de.stuporio.skywars.listener.*;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.LocationManager;
import de.stuporio.skywars.utils.SQLHandler;
import org.apache.commons.io.IOUtils;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import java.io.IOException;
import org.bukkit.plugin.PluginManager;
import de.stuporio.skywars.listener.kits.KitsListener;
import org.bukkit.Bukkit;
import de.stuporio.skywars.commands.CMD_Setloc;
import de.stuporio.skywars.commands.CMD_Coins;
import de.stuporio.skywars.commands.CMD_Build;
import de.stuporio.skywars.commands.CMD_Stats;
import de.stuporio.skywars.commands.CMD_Forcemap;
import de.stuporio.skywars.commands.CMD_Start;
import de.stuporio.skywars.commands.CMD_Addmap;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyWars extends JavaPlugin
{
    public static String currentMap;
    List<String> list = (List<String>)SkyWars.cfg.getStringList("Maps");
    public static File folder;
    public static File file;
    public static YamlConfiguration cfg;
    public static SQLHandler mySQL;
    public static boolean isChat;
    public static boolean g1;
    public static boolean g2;
    public static boolean g3;
    public static boolean g4;
    public static boolean g5;
    public static boolean g6;
    public static boolean g7;
    public static boolean g8;
    public static boolean gLobby;
    public static boolean gSpec;
    public static boolean starting;
    private static SkyWars instance;
    public static GameState state;
    public static boolean winMSG;

    public static boolean forcestarted;

    public void onEnable() {
        SkyWars.instance = this;
        register();
        setupFiles();
        SkyWars.mySQL = new SQLHandler("localhost", "3306", "server", "stuporio", "{{]1tn)66%AF");
        mySQL.update("CREATE TABLE IF NOT EXISTS SWStats (UUID varchar(255), KILLS int, DEATHS int, GAMES int, WINS int);");
        mySQL.update("CREATE TABLE IF NOT EXISTS SWKits (UUID varchar(255), KIT1 int, KIT2 int, KIT3 int, KIT4 int, KIT5 int, KIT6 int, KIT7 int, KIT8 int, KIT9 int, KIT10 int);");
        if (this.list.isEmpty()) {
            SkyWars.isChat = true;
            Setup.setup = 2;
        }
        LocationManager.setupFiles();
        SkyWars.state = GameState.LOBBY;
        setupFiles();
        pickRandom();
        loadConfig();
    }
    
    private void register() {
        getCommand("addmap").setExecutor(new CMD_Addmap());
        getCommand("start").setExecutor(new CMD_Start());
        getCommand("forcemap").setExecutor(new CMD_Forcemap());
        getCommand("stats").setExecutor(new CMD_Stats());
        getCommand("build").setExecutor(new CMD_Build());
        getCommand("coins").setExecutor(new CMD_Coins());
        getCommand("setloc").setExecutor(new CMD_Setloc());
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Setup(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new MainListener(), this);
        pm.registerEvents(new ChestListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ProtectListener(), this);
        pm.registerEvents(new KitsListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new PingListener(), this);
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new PlaceListener(), this);
        pm.registerEvents(new InventoryListener(), this);
    }
    
    private void loadConfig() {
        this.getConfig().options().copyDefaults(true);
        this.getConfig().addDefault("Message.Prefix", (Object)"&b&lSkyWars &8| &7");
        this.getConfig().addDefault("Message.Kit.NoCoins", (Object)"&7Du hast keine Coins");
        this.getConfig().addDefault("Message.Kit.Buyed", (Object)"&7Du hast dir das &b%kit% &7gekauft");
        this.getConfig().addDefault("Message.Kit.Current", (Object)"&7Du hast das Kit %kit% ausgew\u00e4hlt");
        this.saveConfig();
    }
    
    public static void setupFiles() {
        if (!SkyWars.folder.exists()) {
            SkyWars.folder.mkdir();
        }
        if (!SkyWars.file.exists()) {
            try {
                SkyWars.file.createNewFile();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void onDisable() {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.kickPlayer(Data.prefix + "Der Server reloaded");
        }
        Data.players.clear();
        final World world = this.getServer().getWorld(String.valueOf(Bukkit.getWorlds()));
        final List<Entity> entList = (List<Entity>)world.getEntities();
        for (final Entity current : entList) {
            if (current instanceof Item) {
                current.remove();
            }
        }
    }
    
    public void check(final URL url) throws IOException {
        BufferedReader reader = null;
        final StringBuilder builder = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            final char[] data = new char[5000];
            int count;
            while ((count = reader.read(data)) != 1) {
                builder.append(data, 0, count);
            }
        }
        finally {
            IOUtils.closeQuietly((Reader)reader);
        }
    }
    
    public static SkyWars getInstance() {
        return SkyWars.instance;
    }
    
    private void pickRandom() {
        if (!this.list.isEmpty()) {
            final int i = (int)(Math.random() * this.list.size());
            SkyWars.currentMap = this.list.get(i);
        }
    }
    
    static {
        SkyWars.folder = new File("plugins/SkyWars/");
        SkyWars.file = new File("plugins/SkyWars/maps.yml");
        SkyWars.cfg = YamlConfiguration.loadConfiguration(SkyWars.file);
        SkyWars.isChat = false;
        SkyWars.g1 = false;
        SkyWars.g2 = false;
        SkyWars.g3 = false;
        SkyWars.g4 = false;
        SkyWars.g5 = false;
        SkyWars.g6 = false;
        SkyWars.g7 = false;
        SkyWars.g8 = false;
        SkyWars.gLobby = false;
        SkyWars.gSpec = false;
        SkyWars.starting = false;
        SkyWars.winMSG = false;
    }
}
