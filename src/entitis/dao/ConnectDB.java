/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import stockex.util.DataProperties;

/**
 *
 * @author zrik
 */
public class ConnectDB {
    private Connection connect;
    private String URL;
    private String USER;
    private String PASS;
    
    public ConnectDB() {
        DataProperties data = new DataProperties("config.properties");
        Properties properties = data.getProperties();
        
        URL = properties.getProperty("URL");
        USER = properties.getProperty("USER");
        PASS = properties.getProperty("PASS");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Connection getConnect() {
        try {
            connect = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return connect;
    }
    
    
    public void closeConnect() {
        try {
            if (!connect.isClosed() || connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
}
