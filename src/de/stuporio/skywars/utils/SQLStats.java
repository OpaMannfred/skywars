// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import de.stuporio.skywars.SkyWars;

public class SQLStats
{
    public static boolean playerExists(final String uuid) {
        try {
            final ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWStats WHERE UUID= '" + uuid + "'");
            return rs.next() && rs.getString("UUID") != null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void createPlayer(final String uuid) {
        if (!playerExists(uuid)) {
            SkyWars.mySQL.update("INSERT INTO SWStats(UUID, KILLS, DEATHS, GAMES, WINS) VALUES ('" + uuid + "', '0', '0', '0', '0');");
        }
    }
    
    public static Integer getRanking(final String uuid) {
        int i = 0;
        final ResultSet rs = SkyWars.mySQL.query("SELECT UUID FROM SWStats ORDER BY KILLS DESC LIMIT 2000");
        boolean bol = true;
        try {
            while (rs.next() && bol) {
                ++i;
                if (rs.getString("UUID").equals(uuid)) {
                    bol = false;
                    return i;
                }
            }
        }
        catch (SQLException ex) {}
        return 2001;
    }
    
    public static Integer getKills(final String uuid) {
        Integer i = 0;
        if (playerExists(uuid)) {
            try {
                final ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWStats WHERE UUID= '" + uuid + "'");
                if (!rs.next() || Integer.valueOf(rs.getInt("KILLS")) == null) {}
                i = rs.getInt("KILLS");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            createPlayer(uuid);
            getKills(uuid);
        }
        return i;
    }
    
    public static void setKills(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWStats SET KILLS = '" + kills + "' WHERE UUID= '" + uuid + "';");
        }
        else {
            createPlayer(uuid);
            setKills(uuid, kills);
        }
    }
    
    public static void addKills(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setKills(uuid, getKills(uuid) + kills);
        }
        else {
            createPlayer(uuid);
            addKills(uuid, kills);
        }
    }
    
    public static void removeKills(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setKills(uuid, getKills(uuid) - kills);
        }
        else {
            createPlayer(uuid);
            removeKills(uuid, kills);
        }
    }
    
    public static Integer getDeaths(final String uuid) {
        Integer i = 0;
        if (playerExists(uuid)) {
            try {
                final ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWStats WHERE UUID= '" + uuid + "'");
                if (!rs.next() || Integer.valueOf(rs.getInt("DEATHS")) == null) {}
                i = rs.getInt("DEATHS");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            createPlayer(uuid);
            getDeaths(uuid);
        }
        return i;
    }
    
    public static void setDeaths(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWStats SET DEATHS = '" + kills + "' WHERE UUID= '" + uuid + "';");
        }
        else {
            createPlayer(uuid);
            setDeaths(uuid, kills);
        }
    }
    
    public static void addDeaths(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setDeaths(uuid, getDeaths(uuid) + kills);
        }
        else {
            createPlayer(uuid);
            addDeaths(uuid, kills);
        }
    }
    
    public static void removeDeaths(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setDeaths(uuid, getDeaths(uuid) - kills);
        }
        else {
            createPlayer(uuid);
            removeDeaths(uuid, kills);
        }
    }
    
    public static Integer getGames(final String uuid) {
        Integer i = 0;
        if (playerExists(uuid)) {
            try {
                final ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWStats WHERE UUID= '" + uuid + "'");
                if (!rs.next() || Integer.valueOf(rs.getInt("GAMES")) == null) {}
                i = rs.getInt("GAMES");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            createPlayer(uuid);
            getGames(uuid);
        }
        return i;
    }
    
    public static void setGames(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWStats SET GAMES = '" + kills + "' WHERE UUID= '" + uuid + "';");
        }
        else {
            createPlayer(uuid);
            setGames(uuid, kills);
        }
    }
    
    public static void addGames(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setGames(uuid, getGames(uuid) + kills);
        }
        else {
            createPlayer(uuid);
            addGames(uuid, kills);
        }
    }
    
    public static void removeGames(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setGames(uuid, getGames(uuid) - kills);
        }
        else {
            createPlayer(uuid);
            removeGames(uuid, kills);
        }
    }
    
    public static Integer getWins(final String uuid) {
        Integer i = 0;
        if (playerExists(uuid)) {
            try {
                final ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWStats WHERE UUID= '" + uuid + "'");
                if (!rs.next() || Integer.valueOf(rs.getInt("WINS")) == null) {}
                i = rs.getInt("WINS");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            createPlayer(uuid);
            getWins(uuid);
        }
        return i;
    }
    
    public static void setWins(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWStats SET WINS = '" + kills + "' WHERE UUID= '" + uuid + "';");
        }
        else {
            createPlayer(uuid);
            setWins(uuid, kills);
        }
    }
    
    public static void addWins(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setWins(uuid, getWins(uuid) + kills);
        }
        else {
            createPlayer(uuid);
            addWins(uuid, kills);
        }
    }
    
    public static void removeWins(final String uuid, final Integer kills) {
        if (playerExists(uuid)) {
            setWins(uuid, getWins(uuid) - kills);
        }
        else {
            createPlayer(uuid);
            removeWins(uuid, kills);
        }
    }
}
