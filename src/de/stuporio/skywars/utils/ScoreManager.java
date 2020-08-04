package de.stuporio.skywars.utils;

import de.stuporio.core.utils.scoreboard.ScoreboardAPI;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.api.CoinsAPI;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import de.stuporio.skywars.listener.kits.KitsListener;
import de.stuporio.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreManager
{

    private static ScoreboardAPI scoreboardAPI;

    private static String[] animation = {
            "§9•",
            "§9•§3● ",
            "§9•§3● S",
            "§9•§3● Sk",
            "§9•§3● Sky",
            "§9•§3● SkyW",
            "§9•§3● SkyWa",
            "§9•§3● SkyWar",
            "§9•§3● SkyWars",
            "§9•§3● SkyWars §8§l▏ §7",
            "§9•§3● SkyWars §8§l▏ §7s",
            "§9•§3● SkyWars §8§l▏ §7st",
            "§9•§3● SkyWars §8§l▏ §7stu",
            "§9•§3● SkyWars §8§l▏ §7stup",
            "§9•§3● SkyWars §8§l▏ §7stupo",
            "§9•§3● SkyWars §8§l▏ §7stupor",
            "§9•§3● SkyWars §8§l▏ §7stupori",
            "§9•§3● SkyWars §8§l▏ §7stuporio"
    };

    private static void initial(Player player){
        scoreboardAPI = new ScoreboardAPI(player, "§2•§a● stuporio §8§l▏ §7SkyWars");
        scoreboardAPI.addAnimation(animation, SkyWars.getInstance());
    }

    private static void load(Player player){
        if(SkyWars.state == GameState.LOBBY){
            scoreboardAPI.setLine(9, "§8§m---------", "§8§m---------");
            scoreboardAPI.setLine(8, "§8•§7● ", "§7Map");
            scoreboardAPI.setLine(7, "§8➜ §a", "§a" + SkyWars.currentMap);
            scoreboardAPI.setLine(6, " ", " ");
            scoreboardAPI.setLine(5, "§8•§7● ", "§7Spieler");
            scoreboardAPI.setLine(4, "§8➜ §a", "§a" + Data.players.size());
            scoreboardAPI.setLine(3, " ", " ");
            scoreboardAPI.setLine(2, "§8•§7● ", "§7Kit");
            scoreboardAPI.setLine(1, "§8➜ §a", "§a" + getKit(player));
            scoreboardAPI.setLine(0, "§8§m---------", "§8§m---------");
        }else if(SkyWars.state == GameState.INGAME){
            scoreboardAPI.setLine(9, "§8§m---------", "§8§m---------");
            scoreboardAPI.setLine(8, "§8•§7● ", "§7Map");
            scoreboardAPI.setLine(7, "§8➜ §a", "§a" + SkyWars.currentMap);
            scoreboardAPI.setLine(6, " ", " ");
            scoreboardAPI.setLine(5, "§8•§7● ", "§7Kills");
            scoreboardAPI.setLine(4, "§8➜ §a", "§a" + CoinsAPI.getKills(player.getName()));
            scoreboardAPI.setLine(3, " ", " ");
            scoreboardAPI.setLine(2, "§8•§7● ", "§7Kit");
            scoreboardAPI.setLine(1, "§8➜ §a", "§a" + getKit(player));
            scoreboardAPI.setLine(0, "§8§m---------", "§8§m---------");
        }
    }

    public static void update(Player p){
        if(SkyWars.state == GameState.LOBBY){
            scoreboardAPI.updateBoard(p,4, "§8➜ §a", "§a" + Data.players.size());
            scoreboardAPI.updateBoard(p, 1, "§8➜ §a", "§a" + getKit(p));
        }else if(SkyWars.state == GameState.INGAME){
            scoreboardAPI.updateBoard(p, 5, "§8•§7● ", "§7Kills");
            scoreboardAPI.updateBoard(p, 4, "§8➜ §a", "§a" + CoinsAPI.getKills(p.getName()));
        }
    }

    public static void setScoreboard(Player p){
        initial(p);
        load(p);
        scoreboardAPI.setBoard(p);
    }

    public static String getKit(Player p){
        if (KitsListener.assasine.contains(p)) {
            return "Assasine";
        } else if (KitsListener.poseidon.contains(p)) {
            return "Poseidon";
        }else if(KitsListener.enderman.contains(p)){
            return "Enderman";
        } else if (KitsListener.uhc.contains(p)) {
            return "UHC";
        } else if (KitsListener.tank.contains(p)) {
            return "Tank";
        } else if (KitsListener.crafter.contains(p)) {
            return "Crafter";
        } else if (KitsListener.starter.contains(p)) {
            return "Starter";
        } else if (KitsListener.creeper.contains(p)) {
            return "Creeper";
        } else if (KitsListener.angler.contains(p)) {
            return "Angler";
        } else if (KitsListener.knocker.contains(p)) {
            return "Knocker";
        }
        return "KEINS";
    }

}
