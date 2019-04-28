/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.ConnectDB;
import entity.Commic;
import entity.Employee;
import entity.Publisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Test {
    /*
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
       ConnectDB db = new ConnectDB();
       Connection cnn = db.getConn();
       Statement stm = cnn.createStatement();
       ResultSet rs = stm.executeQuery("SELECT Commic.id,Commic.name_commic,Catagory.name_catagory,"
                    + "Publisher.name_publisher,Commic.price,Commic.quantity "
                    + "FROM Commic INNER JOIN Catagory \n" +
                    "on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id");
       while(rs.next())
           System.out.println(rs.getString("name_commic"));
        SaleModel cm = new SaleModel();
        
        ArrayList<Publisher> l = new ArrayList<>();
        l = cm.getListPublisher();
        for(Publisher i:l)
        {
            System.out.println(i.getName_publisher());
        }*/
     /*   LoginModel lg = new LoginModel();
        Employee ep = new Employee();
        ep = lg.Login("admin","123");
        System.out.println(ep.getName_employee());
    }*/
}
