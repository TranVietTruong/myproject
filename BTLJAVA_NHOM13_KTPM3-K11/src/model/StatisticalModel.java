/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.Commic;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Admin
 */
public class StatisticalModel extends  Model{
    ArrayList<Commic> listTopCommic;
    int totalMoney = 0;
    
    
    public ArrayList getListTopCommic() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listTopCommic = new ArrayList<>();
        try {
            sql = "SELECT Commic.name_commic, Commic.id, sum(DetailBill.quantity_oder) as tongsoluong FROM Commic,Bill,DetailBill \n" +
                    "WHERE DetailBill.id_commic = Commic.id AND DetailBill.id_bill = Bill.id \n" +
                    "GROUP BY Commic.name_commic, Commic.id ORDER BY tongsoluong DESC";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
               Commic cm = new Commic();
               cm.setStt(i);
               cm.setName_commic(rs.getString("name_commic"));
               cm.setQuantity(rs.getInt("tongsoluong"));
               listTopCommic.add(cm);
               i++;
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listTopCommic;
    }
    
    
    public int getTotalMoney() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        ArrayList<Bill> listBill = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') as dateorder FROM Bill";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
               Bill bill = new Bill();
               bill.setStt(i);
               bill.setId(rs.getInt("id"));
               bill.setName_customer(rs.getString("name_customer"));
               bill.setName_employee(rs.getString("name_employee"));
               bill.setDate_order(rs.getString("dateorder"));
               bill.setNote(rs.getString("note"));
               bill.setTota_money(rs.getInt("total_money"));
               bill.setPromotion(rs.getInt("promotion"));
               bill.setIs_delete(rs.getInt("is_delete"));
               listBill.add(bill);
               i++;
            }
            cnn.close();
            for(Bill b:listBill)
            {
                totalMoney += (b.getTota_money() - b.getPromotion());
            }
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
        }
        return totalMoney;
    }
    
    int numberBill = 0;
    public int getNumberBill() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        ArrayList<Bill> listBill = new ArrayList<>();
        try {
            sql = "SELECT COUNT(*) FROM Bill";
            rs = getDoSQL(sql);
            while (rs.next()) {
                numberBill = rs.getInt(1);
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
        }
        return numberBill;
    }
    
    
    int numberCommic = 0;
    public int getNumberCommic() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        ArrayList<Bill> listBill = new ArrayList<>();
        try {
            sql = "SELECT SUM(quantity_oder) FROM DetailBill JOIN Bill \n" +
                  "ON Bill.id = DetailBill.id_bill";
            rs = getDoSQL(sql);
            while (rs.next()) {
                numberCommic = rs.getInt(1);
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
        }
        return numberCommic;
    }
    
    DefaultCategoryDataset dataset;
    public DefaultCategoryDataset Dataset() throws SQLException, ClassNotFoundException
    {
        cnn = db.getConn();
        dataset = new DefaultCategoryDataset();
        try {
            sql = "SELECT DATEPART(m,Bill.date_order) as 'month', SUM(total_money) - SUM(promotion) as 'money' \n" +
                    "FROM Bill GROUP BY DATEPART(m,Bill.date_order)";
            rs = getDoSQL(sql);
            while (rs.next()) {
                dataset.addValue(rs.getInt("money"),"Tháng","Tháng "+rs.getInt("month"));
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
        }
        return dataset;
    }
}
