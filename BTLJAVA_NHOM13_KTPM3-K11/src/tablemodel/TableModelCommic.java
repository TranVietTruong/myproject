/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import entity.Commic;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelCommic extends AbstractTableModel{
    private String name[] = {"STT","Mã Truyện","Tên Truyện","Thể Loại","Nhà Xuất Bản","Giá","Số Lượng"};
    ArrayList<Commic> listCommic = new ArrayList<Commic>();
   
    public TableModelCommic(ArrayList<Commic> listCommic)
    {
        this.listCommic = listCommic;
    }
    
    @Override
    public String getColumnName(int i)
    {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return this.listCommic.size();
    }

    @Override
    public int getColumnCount() {
        return this.name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listCommic.get(rowIndex).getStt();
            case 1: return listCommic.get(rowIndex).getId();
            case 2: return listCommic.get(rowIndex).getName_commic();
            case 3: return listCommic.get(rowIndex).getName_catagory();
            case 4: return listCommic.get(rowIndex).getName_publisher();
            case 5: return listCommic.get(rowIndex).getPrice();
            case 6: return listCommic.get(rowIndex).getQuantity();
            default: return null;
        }
    }
    
}
