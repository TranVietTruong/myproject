/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.BillDetail;
import entity.Catagory;
import entity.Commic;
import entity.Publisher;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SaleModel extends Model{
    ArrayList<Commic> listCommic;
    ArrayList<Publisher> listPublisher;
    ArrayList<Catagory> listCatagory;
    
    public ArrayList getListCommic() throws ClassNotFoundException {
        cnn = db.getConn();
        listCommic = new ArrayList<>();
        try {
            sql = "SELECT * FROM Commic "
                    + "INNER JOIN Catagory on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id WHERE Commic.is_delete = 0";
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
    
    public ArrayList getListPublisher() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listPublisher = new ArrayList<>();
        try{
            sql = "SELECT * FROM Publisher WHERE is_delete = 0";
            rs = getDoSQL(sql);
            while(rs.next()){
                Publisher pl = new Publisher();
                pl.setId(rs.getInt("id"));
                pl.setName_publisher(rs.getString("name_publisher"));
                pl.setIs_delete(0);
                listPublisher.add(pl);
            }
            cnn.close();
        }catch(Exception e){
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listPublisher;
    }
    
    public ArrayList getListCatagory() throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listCatagory = new ArrayList<>();
        try{
            sql = "SELECT * FROM Catagory WHERE is_delete = 0";
            rs = getDoSQL(sql);
            while(rs.next()){
                Catagory ct = new Catagory();
                ct.setId(rs.getInt("id"));
                ct.setName_catagory(rs.getString("name_catagory"));
                ct.setIs_delete(0);
                listCatagory.add(ct);
            }
            cnn.close();
        }catch(Exception e){
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCatagory;
    }
    
    public ArrayList getListCommicByIdPublisher(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listCommic = new ArrayList<>();
        try{
            sql = "SELECT * FROM Commic "
                    + "INNER JOIN Catagory on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id WHERE Commic.id_Publisher = "+id+" AND Commic.is_delete = 0";
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
        } 
        catch (Exception ex) { 
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCommic;
    }
    public ArrayList getListCommicByIdCatagory(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listCommic = new ArrayList<>();
        try{
            sql = "SELECT * FROM Commic "
                    + "INNER JOIN Catagory on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id WHERE Commic.id_Catagory = "+id+ " AND Commic.is_delete = 0";
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
        } 
        catch (Exception ex) {  
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCommic;
    }
    
    public ArrayList searchByNameCommic(String name) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        listCommic = new ArrayList<>();
        try{
            sql = "SELECT * FROM Commic "
                    + "INNER JOIN Catagory on Commic.id_catagory = Catagory.id \n" +
                    "INNER JOIN Publisher on Commic.id_publisher = Publisher.id WHERE Commic.is_delete = 0 AND Commic.name_commic like N'%"+name+"%'";
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
        } 
        catch (Exception ex) {  
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return null;
        }
        return listCommic;
    }
    
    public boolean Pay(Bill bill,ArrayList<BillDetail> listOrder) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try{
            sql = "INSERT INTO Bill(name_customer,name_employee,date_order,note,total_money,promotion,is_delete)"
                    + "VALUES(N'"+bill.getName_customer()+"',N'"+bill.getName_employee()+"','"+bill.getDate_order()+"',"
                    + " N'"+bill.getNote()+"',"+bill.getTota_money()+","+bill.getPromotion()+",0)";
            int id;
            id = getIdLastInsert(sql);
            for(BillDetail order : listOrder)
            {
                sql = "INSERT INTO DetailBill(id_bill,id_commic,quantity_oder)"
                        + "VALUES("+id+","+order.getId_commic()+","+order.getQuantity_order()+")";
                doSQL(sql);
                
                sql = "EXEC spud_update_quantity "+order.getId_commic()+","+order.getQuantity_order()+"";
                doSQL(sql);
            }
            cnn.close();
            return true;
        } 
        catch (HeadlessException | SQLException ex) {  
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu");
            return false;
        }
    }
    
    public boolean AddCommic(Commic cm) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try{
            sql = "INSERT INTO Commic(name_commic,id_catagory,id_publisher,quantity,price,is_delete)"
                    + " VALUES(N'"+cm.getName_commic()+"','"+cm.getId_catagory()+"','"+cm.getId_publisher()+"',0,"+cm.getPrice()+",0)";
            doSQL(sql);
            cnn.close();
            return true;
        } 
        catch (HeadlessException | SQLException ex) {  
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    public boolean EditCommic(Commic cm) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try{
            sql = "UPDATE Commic SET name_commic = N'"+cm.getName_commic()+"', id_catagory = '"+cm.getId_catagory()+"', "
                    + " price = '"+cm.getPrice()+"' WHERE id = "+cm.getId();
            doSQL(sql);
            cnn.close();
            return true;
        } 
        catch (HeadlessException | SQLException ex) {  
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    public boolean DeleteCommic(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "UPDATE Commic SET Commic.is_delete = 1 WHERE Commic.id = "+id;
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    
    public boolean AddCatagory(String nameCatagory) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "INSERT Catagory(name_catagory,is_delete) VALUES(N'"+nameCatagory+"',0)";
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
   
    public boolean EditCataroy(String name,int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "UPDATE Catagory SET name_catagory = N'"+name+"' WHERE id = "+id;
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    public boolean DeleteCatagory(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "UPDATE Catagory SET is_delete = 1 WHERE id = "+id;
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    //-------------------
    
    public boolean AddPublisher(String namePublisher) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "INSERT Publisher(name_publisher,is_delete) VALUES(N'"+namePublisher+"',0)";
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    public boolean EditPublisher(String name,int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "UPDATE Publisher SET name_publisher = N'"+name+"' WHERE id = "+id;
            doSQL(sql);
            cnn.close();
            return true;
        } catch (Exception ex) {          
            cnn.close();
            JOptionPane.showMessageDialog(null,"Không kết nối được cơ sở dữ liệu "+ex.getMessage());
            return false;
        }
    }
    
    public boolean DeletePublisher(int id) throws ClassNotFoundException, SQLException
    {
        cnn = db.getConn();
        try {
            sql = "UPDATE Publisher SET is_delete = 1 WHERE id = "+id;
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
