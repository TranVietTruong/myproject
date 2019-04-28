/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.Coupon;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelCoupon extends AbstractTableModel{
    private String name[] = {"STT","Mã Phiếu Nhập","Ngày Nhập","Nhà Cung Cấp","Tổng Tiền"};

    ArrayList<Coupon> listCoupon = new ArrayList<>();
    
    public TableModelCoupon(ArrayList listCoupon)
    {
        this.listCoupon = listCoupon;
    }
    
    @Override
    public String getColumnName(int i) {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return listCoupon.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex)
       {
           case 0: return listCoupon.get(rowIndex).getStt();
           case 1: return listCoupon.get(rowIndex).getId();
           case 2: return listCoupon.get(rowIndex).getDate_order();
           case 3: return listCoupon.get(rowIndex).getName_suppiler();
           case 4: return listCoupon.get(rowIndex).getTotal();
           default: return null;
       }
    }
    
}
