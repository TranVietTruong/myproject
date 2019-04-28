/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectDB {
    public Connection conn;
    Statement  stm = null;
    ResultSet rs = null;
    Connection cnn = null;
    String uRl = "jdbc:sqlserver://DESKTOP-4TBACV1\\SQLEXPRESS:1433;databaseName=ComMic";
    String userName = "sa";
    String pass = "123";
     
    // lấy kết nối
    public Connection getConn() throws ClassNotFoundException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(uRl,userName,pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    //đóng kết nối
    public void closeConn() {
        if (conn != null) {
            try {
                if (conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        conn = null;
    }
   
}
