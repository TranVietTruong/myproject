/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.BillDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BillModel extends Model{
    ArrayList<Bill> listBill; // danh sách hóa đơn
    ArrayList<BillDetail> listOrder;
    
    // trả về một danh sách hóa đơn
    public ArrayList getListBill() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listBill = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') as dateorder FROM Bill WHERE is_delete = 0";
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
    // lấy hóa đơn theo id 
    public ArrayList getListOrderById(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listOrder = new ArrayList<>();
        try {
            sql = "SELECT * FROM DetailBill INNER JOIN Bill ON DetailBill.id_bill = Bill.id"
                    + " INNER JOIN Commic ON DetailBill.id_commic = Commic.id WHERE Detailbill.id_bill = "+id;
            rs = getDoSQL(sql);
            while (rs.next()) {
              BillDetail billdetail = new BillDetail();
              billdetail.setId(rs.getInt(1));
              billdetail.setId_bill(rs.getInt("id_bill"));
              billdetail.setId_commic(rs.getInt("id_commic"));
              billdetail.setName_commic(rs.getString("name_commic"));
              billdetail.setPrice(rs.getInt("price"));
              billdetail.setQuantity_order(rs.getInt("quantity_oder"));
              listOrder.add(billdetail);
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu " +ex.getMessage());
            return null;
        }
        return listOrder;
    }
    
    public ArrayList SearchById(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listBill = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') as dateorder FROM Bill WHERE is_delete = 0 AND Bill.id like '%"+id+"%'";
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
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return null;
        }
        return listBill;
    }
    
    public ArrayList FillterBillByTime(String from,String to) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listBill = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') as dateorder\n" +
                " FROM Bill WHERE is_delete = 0 \n" +
                " AND FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') >= '"+from+"'" +
                " AND FORMAT(Bill.date_order,'dd/MM/yyyy','en-gb') <= '"+to+"'";
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
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return null;
        }
        return listBill;
    }
    
    public boolean DeleteBill(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listBill = new ArrayList<>();
        try {
            sql = "UPDATE Bill SET Bill.is_delete = 1 WHERE Bill.id = "+id;
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
}
