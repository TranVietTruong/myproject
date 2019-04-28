/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.Catagory;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelCatagory extends AbstractTableModel{
    private String name[] = {"ID","Tên Danh Mục"};
    ArrayList<Catagory> listCaragory = new ArrayList<>();
    
    public TableModelCatagory(ArrayList<Catagory> listCatagory)
    {
        this.listCaragory = listCatagory;
    }
    @Override
    public String getColumnName(int i) {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return listCaragory.size();
    }

    @Override
    public int getColumnCount() {
        return this.name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listCaragory.get(rowIndex).getId();
            case 1: return listCaragory.get(rowIndex).getName_catagory();
            default: return null;
        }
    }
    
}
