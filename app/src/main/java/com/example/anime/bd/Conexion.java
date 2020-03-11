package com.example.anime.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    // Constructor
    public Conexion(){

        String url = "jdbc:mysql://192.168.1.6:3306/animeflv";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "upp";
        String password = "upp";


        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){

        if (conn == null){
            new Conexion();
        }

        return conn;
    }
}
