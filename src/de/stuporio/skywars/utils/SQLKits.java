package de.stuporio.skywars.utils;

import de.stuporio.skywars.SkyWars;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Developed
 * SQLHeads
 * by Max H.
 * at 20/05/2020
 */

public class SQLKits {

    public static boolean playerExists(String uuid){
        try {
            ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");
            if(rs.next()){
                return rs.getString("UUID") != null;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(String uuid){
        if(!(playerExists(uuid))){
            SkyWars.mySQL.update("INSERT INTO SWKits(UUID, KIT1, KIT2, KIT3, KIT4, KIT5, KIT6, KIT7, KIT8, KIT9, KIT10) VALUES ('" + uuid + "', '10', '0', '0', '0', '0', '0', '0', '0', '0', '0');");
        }
    }

    public static Integer getKopf1(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT1")) == null));

                i = rs.getInt("KIT1");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf2(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT2")) == null));

                i = rs.getInt("KIT2");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf3(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT3")) == null));

                i = rs.getInt("KIT3");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf4(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT4")) == null));

                i = rs.getInt("KIT4");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf5(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT5")) == null));

                i = rs.getInt("KIT5");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf6(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT6")) == null));

                i = rs.getInt("KIT6");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf7(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT7")) == null));

                i = rs.getInt("KIT7");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf8(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT8")) == null));

                i = rs.getInt("KIT8");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf9(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT9")) == null));

                i = rs.getInt("KIT9");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static Integer getKopf10(String uuid){
        Integer i = 0;

        if (playerExists(uuid)) {
            try {
                ResultSet rs = SkyWars.mySQL.query("SELECT * FROM SWKits WHERE UUID= '" + uuid + "'");

                if((!rs.next()) || (Integer.valueOf(rs.getInt("KIT10")) == null));

                i = rs.getInt("KIT10");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return i;
    }

    public static void setKopf1(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT1= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf1(uuid, coins);
        }

    }

    public static void setKopf2(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT2= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf2(uuid, coins);
        }

    }

    public static void setKopf3(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT3= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf3(uuid, coins);
        }

    }

    public static void setKopf4(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT4= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf4(uuid, coins);
        }

    }

    public static void setKopf5(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT5= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf5(uuid, coins);
        }

    }

    public static void setKopf6(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT6= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf6(uuid, coins);
        }

    }

    public static void setKopf7(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT7= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf7(uuid, coins);
        }

    }
    public static void setKopf8(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT8= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf8(uuid, coins);
        }

    }

    public static void setKopf9(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT9= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf9(uuid, coins);
        }

    }
    public static void setKopf10(String uuid, Integer coins){

        if (playerExists(uuid)) {
            SkyWars.mySQL.update("UPDATE SWKits SET KIT10= '" + coins + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setKopf10(uuid, coins);
        }

    }

    public static boolean hasKopf1(String uuid){
        return getKopf1(uuid) == 10;
    }

    public static boolean hasKopf2(String uuid){
        return getKopf2(uuid) == 10;
    }

    public static boolean hasKopf3(String uuid){
        return getKopf3(uuid) == 10;
    }

    public static boolean hasKopf4(String uuid){
        return getKopf4(uuid) == 10;
    }

    public static boolean hasKopf5(String uuid){
        return getKopf5(uuid) == 10;
    }

    public static boolean hasKopf6(String uuid){
        return getKopf6(uuid) == 10;
    }

    public static boolean hasKopf7(String uuid){
        return getKopf7(uuid) == 10;
    }

    public static boolean hasKopf8(String uuid){
        return getKopf8(uuid) == 10;
    }

    public static boolean hasKopf9(String uuid){
        return getKopf8(uuid) == 10;
    }

    public static boolean hasKopf10(String uuid){
        return getKopf8(uuid) == 10;
    }

}
