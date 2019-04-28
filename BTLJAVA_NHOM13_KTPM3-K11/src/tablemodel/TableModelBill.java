/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.Bill;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelBill extends AbstractTableModel{
    private String name[] = {"STT","Mã Hóa Đơn","Nhân Viên","Khách Hàng","Ngày","Tổng Tiền","Khuyễn Mãi","Ghi Chú"};
    ArrayList<Bill> listBill = new ArrayList<Bill>();
    public TableModelBill(ArrayList<Bill> listBill)
    {
        this.listBill = listBill;
    }
    
    @Override
    public String getColumnName(int i)
    {
        return name[i];
    }
    
    @Override
    public int getRowCount() {
        return this.listBill.size();
    }

    @Override
    public int getColumnCount() {
        return this.name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return listBill.get(rowIndex).getStt();
            case 1: return listBill.get(rowIndex).getId();
            case 2: return listBill.get(rowIndex).getName_employee();
            case 3: return listBill.get(rowIndex).getName_customer();
            case 4: return listBill.get(rowIndex).getDate_order();
            case 5: return listBill.get(rowIndex).getTota_money();
            case 6: return listBill.get(rowIndex).getPromotion();
            case 7: return listBill.get(rowIndex).getNote();
            default: return null;
        }
    }
}
