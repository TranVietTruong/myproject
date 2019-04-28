/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.Publisher;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelPublisher extends AbstractTableModel{
     private String name[] = {"ID","Tên Nhà Xuất Bản"};
    ArrayList<Publisher> listPublisher = new ArrayList<>();
    
    public TableModelPublisher(ArrayList<Publisher> listPublisher)
    {
        this.listPublisher = listPublisher;
    }
    @Override
    public String getColumnName(int i) {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return listPublisher.size();
    }

    @Override
    public int getColumnCount() {
        return this.name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listPublisher.get(rowIndex).getId();
            case 1: return listPublisher.get(rowIndex).getName_publisher();
            default: return null;
        }
    }
}
