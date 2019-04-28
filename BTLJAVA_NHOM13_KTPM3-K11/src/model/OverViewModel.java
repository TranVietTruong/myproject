/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.BillDetail;
import entity.Commic;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class OverViewModel extends Model{
    ArrayList<Bill> listBill;
    ArrayList<BillDetail> listOrder;
    ArrayList<Commic> listTopCommic;
    
    public ArrayList getListBillToday() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listBill = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') as dateorder\n" +
                  "FROM Bill WHERE FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb') ";
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
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listBill;
    }
    
    public int NumberCommicSale() throws SQLException, ClassNotFoundException
    {
        cnn = db.getConn();
        int quantity = 0;
        try {
            sql = "SELECT Sum(quantity_oder) as sltruyendaban FROM Bill INNER JOIN DetailBill ON BILL.id = DetailBill.id_bill\n" +
                  "WHERE FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb')";
            rs = getDoSQL(sql);
            if(rs.next()) {
               quantity = rs.getInt(1);
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return -1;
        }
        return quantity;
    }
    
    
    public ArrayList getListTopCommic() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listTopCommic = new ArrayList<>();
        try {
            sql = "SELECT Commic.name_commic, Commic.id, sum(DetailBill.quantity_oder) as tongsoluong FROM Commic,Bill,DetailBill \n" +
                    "WHERE DetailBill.id_commic = Commic.id AND DetailBill.id_bill = Bill.id \n" +
                    "AND FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb')  \n" +
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
}
