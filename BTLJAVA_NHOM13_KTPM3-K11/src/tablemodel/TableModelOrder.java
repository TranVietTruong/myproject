/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.BillDetail;
import entity.Commic;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelOrder extends AbstractTableModel{
    private final String name[] = {"Tên Truyện","Số Lượng","Giá","Thành Tiền"};
     ArrayList<BillDetail> listOrder = new ArrayList<>();
   
    public TableModelOrder(ArrayList<BillDetail> listOrder)
    {
        this.listOrder = listOrder;
    }
    
    @Override
    public String getColumnName(int i)
    {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return this.listOrder.size();
    }

    @Override
    public int getColumnCount() {
        return this.name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listOrder.get(rowIndex).getName_commic();
            case 1: return listOrder.get(rowIndex).getQuantity_order();
            case 2: return listOrder.get(rowIndex).getPrice();
            case 3: return listOrder.get(rowIndex).getMoney();
            default: return null;
        }
    }
}
