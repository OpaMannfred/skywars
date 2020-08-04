// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import java.sql.DriverManager;
import java.sql.Connection;

public class SQLHandler
{
    private String HOST;
    private String PORT;
    private String DATABASE;
    private String USER;
    private String PASSWORD;
    public static Connection con;
    
    public SQLHandler(final String host, final String port, final String database, final String user, final String password) {
        this.HOST = "";
        this.PORT = "";
        this.DATABASE = "";
        this.USER = "";
        this.PASSWORD = "";
        this.HOST = host;
        this.PORT = port;
        this.DATABASE = database;
        this.USER = user;
        this.PASSWORD = password;
        this.connect();
    }
    
    public void connect() {
        final String Prefix = Data.prefix;
        try {
            SQLHandler.con = DriverManager.getConnection("jdbc:mysql://" + this.HOST + ":" + this.PORT + "/" + this.DATABASE + "?autoReconnect=true", this.USER, this.PASSWORD);
            Bukkit.getConsoleSender().sendMessage(Prefix + "§aDie Verbindung mit MySQL wurde hergestellt!");
        }
        catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(Prefix + "§cDie Verbindung mit MySQL ist fehlgeschlagen! §4Fehler: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        return SQLHandler.con;
    }
    
    public boolean isConnected() {
        return SQLHandler.con != null;
    }
    
    public void close() {
        final String Prefix = Data.prefix;
        try {
            if (SQLHandler.con != null) {
                SQLHandler.con.close();
                Bukkit.getConsoleSender().sendMessage(Prefix + "§aDie Verbindung mit MySQL wurde beendet!");
            }
        }
        catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(Prefix + "§cDie Verbindung mit MySQL konnte nicht beendet werden! §4Fehler: " + e.getMessage());
        }
    }
    
    public void update(final String qre) {
        if (SQLHandler.con != null) {
            try {
                final Statement st = SQLHandler.con.createStatement();
                st.executeUpdate(qre);
                st.close();
            }
            catch (SQLException e) {
                this.connect();
                System.err.print(e);
            }
        }
    }
    
    public ResultSet query(final String qre) {
        if (SQLHandler.con != null) {
            ResultSet rs = null;
            try {
                final Statement st = SQLHandler.con.createStatement();
                rs = st.executeQuery(qre);
            }
            catch (SQLException e) {
                this.connect();
                System.err.print(e);
            }
            return rs;
        }
        return null;
    }
    
    
    public ResultSet getResult(final String qry) {
        if (this.isConnected()) {
            try {
                final FutureTask<ResultSet> task = new FutureTask<ResultSet>(new Callable<ResultSet>() {
                    PreparedStatement ps;
                    
                    @Override
                    public ResultSet call() throws Exception {
                        final SQLHandler this$0 = SQLHandler.this;
                        this.ps = SQLHandler.con.prepareStatement(qry);
                        return this.ps.executeQuery();
                    }
                });
                task.run();
                return task.get();
            }
            catch (InterruptedException | ExecutionException ex2) {
                final Exception ex = null;
                final Exception e = ex;
                e.printStackTrace();
                return null;
            }
        }
        this.connect();
        return null;
    }
}
