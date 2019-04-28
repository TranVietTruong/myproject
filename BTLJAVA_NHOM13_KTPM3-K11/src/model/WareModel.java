/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Commic;
import entity.Coupon;
import entity.CouponDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class WareModel extends Model{
    ArrayList<Commic> listCommic;
    ArrayList<Coupon> listCoupon;
    ArrayList<CouponDetail> list;
    
    public ArrayList getListCommicByQuantity0() throws ClassNotFoundException
    {
        cnn = db.getConn();
        listCommic = new ArrayList<>();
        try {
            sql = "SELECT * FROM Commic "
                    + "INNER JOIN Catagory on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id WHERE Commic.is_delete = 0 AND Commic.quantity = 0";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
                Commic cm = new Commic();
                cm.setStt(i);i++;
                cm.setId(rs.getInt("id"));
                cm.setId_catagory(rs.getInt("id_catagory"));
                cm.setId_publisher(rs.getInt("id_publisher"));
                cm.setName_commic(rs.getString("name_commic"));
                cm.setName_catagory(rs.getString("name_catagory"));
                cm.setName_publisher(rs.getString("name_publisher"));
                cm.setPrice(rs.getInt("price"));
                cm.setQuantity(rs.getInt("quantity"));
                cm.setIs_delete(0);
                listCommic.add(cm);
            }
            cnn.close();
        } catch (Exception ex) {           
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCommic;
    }
    
    public ArrayList getListCommicByQuantity() throws ClassNotFoundException
    {
        cnn = db.getConn();
        listCommic = new ArrayList<>();
        try {
            sql = "SELECT * FROM Commic "
                    + "INNER JOIN Catagory on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id WHERE Commic.is_delete = 0 AND Commic.quantity > 0";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
                Commic cm = new Commic();
                cm.setStt(i);i++;
                cm.setId(rs.getInt("id"));
                cm.setId_catagory(rs.getInt("id_catagory"));
                cm.setId_publisher(rs.getInt("id_publisher"));
                cm.setName_commic(rs.getString("name_commic"));
                cm.setName_catagory(rs.getString("name_catagory"));
                cm.setName_publisher(rs.getString("name_publisher"));
                cm.setPrice(rs.getInt("price"));
                cm.setQuantity(rs.getInt("quantity"));
                cm.setIs_delete(0);
                listCommic.add(cm);
            }
            cnn.close();
        } catch (Exception ex) {           
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCommic;
    }
    
    public boolean SaveCoupon(Coupon cp,ArrayList<CouponDetail> listInput) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "INSERT INTO Coupon(name_suppiler,date_order,note,total_money,is_delete)"
                    + " VALUES(N'"+cp.getName_suppiler()+"','"+cp.getDate_order()+"',N'"+cp.getNote()+"','"+cp.getTotal()+"',"
                    + " 0)";
            int id;
            id = getIdLastInsert(sql);
            for(CouponDetail c:listInput)
            {
                sql = "INSERT INTO DetailCoupon(id_coupon,id_commic,quantity_order,import_price)"
                        + " VALUES('"+id+"','"+c.getId_commic()+"','"+c.getQuantity_order()+"','"+c.getImport_price()+"')";
                doSQL(sql);
                
                sql = "EXEC spud_input_quantity "+c.getId_commic()+","+c.getQuantity_order()+"";
                doSQL(sql);
            }
            cnn.close();
            return true;
        } catch (Exception e) {
            cnn.close();
            System.out.println(e.getMessage());
            return  false;
        }
    }
    
    public ArrayList getListCoupon() throws SQLException, ClassNotFoundException
    {
        cnn = db.getConn();
        listCoupon = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Coupon.date_order,'dd/MM/yyyy','en-gb') as dateorder FROM Coupon WHERE is_delete = 0";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
               Coupon cp = new Coupon();
               cp.setStt(i);
               cp.setId(rs.getInt("id"));
               cp.setDate_order(rs.getString("dateorder"));
               cp.setName_suppiler(rs.getString("name_suppiler"));
               cp.setNote(rs.getString("note"));
               cp.setTotal(rs.getInt("total_money"));
               listCoupon.add(cp);
               i++;
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCoupon;
    }
    
    public ArrayList getList(int id) throws SQLException, ClassNotFoundException
    {
        cnn = db.getConn();
        list = new ArrayList<>();
        try {
            sql = "SELECT * FROM DetailCoupon INNER JOIN Coupon ON DetailCoupon.id_coupon = Coupon.id"
                    + " INNER JOIN Commic ON DetailCoupon.id_commic = Commic.id WHERE DetailCoupon.id_coupon = "+id;
            rs = getDoSQL(sql);
            while (rs.next()) {
              CouponDetail cpd = new CouponDetail();
              cpd.setId(rs.getInt(1));
              cpd.setId_commic(rs.getInt("id_commic"));
              cpd.setId_coupon(rs.getInt("id_coupon"));
              cpd.setName_commic(rs.getString("name_commic"));
              cpd.setImport_price(rs.getInt("import_price"));
              cpd.setQuantity_order(rs.getInt("quantity_order"));
              list.add(cpd);
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu " +ex.getMessage());
            return null;
        }
        return list;
    }
    
    
    public ArrayList SearchById(String id) throws SQLException, ClassNotFoundException
    {
        cnn = db.getConn();
        listCoupon = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Coupon.date_order,'dd/MM/yyyy','en-gb') as dateorder FROM Coupon WHERE is_delete = 0 AND id like '%"+id+"%'";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
               Coupon cp = new Coupon();
               cp.setStt(i);
               cp.setId(rs.getInt("id"));
               cp.setDate_order(rs.getString("dateorder"));
               cp.setName_suppiler(rs.getString("name_suppiler"));
               cp.setNote(rs.getString("note"));
               cp.setTotal(rs.getInt("total_money"));
               listCoupon.add(cp);
               i++;
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCoupon;
    }
    
    public ArrayList FillterCoupon(String from,String to) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listCoupon = new ArrayList<>();
        try {
            sql = "SELECT *,FORMAT(Coupon.date_order,'dd/MM/yyyy','en-gb') as dateorder\n" +
                " FROM Coupon WHERE is_delete = 0 \n" +
                " AND FORMAT(Coupon.date_order,'dd/MM/yyyy','en-gb') >= '"+from+"'" +
                " AND FORMAT(Coupon.date_order,'dd/MM/yyyy','en-gb') <= '"+to+"'";
            rs = getDoSQL(sql);
            int i=1;
            while (rs.next()) {
               Coupon cp = new Coupon();
               cp.setStt(i);
               cp.setId(rs.getInt("id"));
               cp.setDate_order(rs.getString("dateorder"));
               cp.setName_suppiler(rs.getString("name_suppiler"));
               cp.setNote(rs.getString("note"));
               cp.setTotal(rs.getInt("total_money"));
               listCoupon.add(cp);
               i++;
            }
            cnn.close();
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCoupon;
    }
    
    
    public boolean DeleteCoupon(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "UPDATE Coupon SET Coupon.is_delete = 1 WHERE Coupon.id = "+id;
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
