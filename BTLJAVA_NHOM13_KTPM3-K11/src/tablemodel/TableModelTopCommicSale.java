/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.Commic;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelTopCommicSale extends AbstractTableModel{
    private String name[] = {"Top","Tên Truyện","Số lượng đã bán"};
    ArrayList<Commic> listTopCommic = new ArrayList<>();
    
    public TableModelTopCommicSale(ArrayList<Commic> listTopCommic)
    {
        this.listTopCommic = listTopCommic;
    }
    @Override
    public String getColumnName(int i) {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
       return listTopCommic.size();
    }

    @Override
    public int getColumnCount() {
       return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listTopCommic.get(rowIndex).getStt();
            case 1: return listTopCommic.get(rowIndex).getName_commic();
            case 2: return listTopCommic.get(rowIndex).getQuantity();
            default: return null;
        }
    }
    
}
