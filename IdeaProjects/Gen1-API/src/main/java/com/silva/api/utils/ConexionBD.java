package com.silva.api.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD
{
    //atributos
    private static String url ="jdbc:oracle:thin:@//127.0.0.1:1521/xe";
    private static String username = "SYSTEM";
    private static String password = "Capuchino";

    //metodos
    //Metodos que establecen la conexion con el servidor de  BD oracle
    public static Connection getInstance()
    {
        try
        {
            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
