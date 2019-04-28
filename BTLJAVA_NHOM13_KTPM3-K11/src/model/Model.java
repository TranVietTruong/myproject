/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Model {
    ConnectDB db = new ConnectDB();
    Connection cnn;
    Statement stm = null;
    ResultSet rs = null;
    String sql;
    
     // Thực hiện truy vấn không trả về kết quả (insert, update, delete)
    public void doSQL(String sql) {
        try {
            stm = cnn.createStatement();
            stm.execute(sql);
        } catch (SQLException ex) {
            System.out.println(" khong thuc hien dc cau lẹnh sql\n"+sql);
        }
    }
    // Thực hiện truy vấn có trả về kết quả (Select)
    public ResultSet getDoSQL(String sql)
    {
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(" khong thuc hien dc cau lẹnh sql\n"+sql);
            return null;
        }
    }
    
    public int getIdLastInsert(String sql) {
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            rs = stm.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            System.out.println(" khong thuc hien dc cau lẹnh sql\n"+sql);
            return -1;
        }
    }
    
    
}
