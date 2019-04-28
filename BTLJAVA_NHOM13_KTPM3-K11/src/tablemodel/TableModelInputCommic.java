/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;


import entity.CouponDetail;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelInputCommic extends AbstractTableModel{
private final String name[] = {"Tên Truyện","Số Lượng Nhập","Đơn Giá Nhập","Thành Tiền"};
     ArrayList<CouponDetail> listInput = new ArrayList<>();
   
    public TableModelInputCommic(ArrayList<CouponDetail> listInput)
    {
        this.listInput = listInput;
    }
    
    @Override
    public String getColumnName(int i)
    {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return this.listInput.size();
    }

    @Override
    public int getColumnCount() {
        return this.name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listInput.get(rowIndex).getName_commic();
            case 1: return listInput.get(rowIndex).getQuantity_order();
            case 2: return listInput.get(rowIndex).getImport_price();
            case 3: return listInput.get(rowIndex).getMoney();
            default: return null;
        }
    }
}
