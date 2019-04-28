/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Employee;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class LoginModel extends Model{
    
    public Employee Login(String username,String password) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        Employee employee = new Employee();
        try {
            sql = "SELECT * FROM Employee WHERE name_user = '"+username+"' AND pass_word = '"+password+"'";
            rs = getDoSQL(sql);
            if(rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName_employee(rs.getString("name_employee"));
                employee.setName_user(rs.getString("name_user"));
                employee.setPassword(rs.getString("pass_word"));
                employee.setLevel(rs.getInt("level_employee"));
                cnn.close(); 
                return employee;
            }
            return null;
        } catch (Exception ex) {    
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu " + ex.getMessage());
            return null;
        }
        
    }
}
