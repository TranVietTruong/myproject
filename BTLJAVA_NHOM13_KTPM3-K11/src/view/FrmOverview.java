/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Bill;
import entity.Commic;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import javax.swing.border.Border;
import model.OverViewModel;
import tablemodel.TableModelTopCommicSale;
//import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Admin
 */
public class FrmOverview extends javax.swing.JFrame {
    OverViewModel ov = new OverViewModel();
    ArrayList<Bill> listBillToday = new ArrayList<>();
    ArrayList<Commic> listTopCommic = new ArrayList<>();
    
    NumberFormat numf = NumberFormat.getInstance(); // định dạng số
    /**
     * Creates new form FrmOverview
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void TotalBill() throws ClassNotFoundException, SQLException
    {
       listBillToday =  ov.getListBillToday();
       lb_TotalBill.setText(listBillToday.size()+"");
    }
    public  void TotalMoney()
    {
        int totalMoney = 0;
        for(Bill b : listBillToday)
        {
            totalMoney += (b.getTota_money() - b.getPromotion());
        }
        lb_TotalMoney.setText(numf.format(totalMoney)+" VNĐ");
    }
    public void NumberCommicSale() throws SQLException, ClassNotFoundException
    {
        lb_NumberSale.setText(ov.NumberCommicSale()+"");
    }
    public void LoadTableTopCommic()
    {
        tb_TopSaleComic.setModel(new TableModelTopCommicSale(listTopCommic));
        tb_TopSaleComic.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_TopSaleComic.getWidth()*0.2));
        tb_TopSaleComic.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_TopSaleComic.getWidth()*0.5));
        tb_TopSaleComic.getColumnModel().getColumn(2).setPreferredWidth((int) (tb_TopSaleComic.getWidth()*0.3));
    }
    public void LoadListTopCommic() throws ClassNotFoundException, SQLException
    {
        listTopCommic = ov.getListTopCommic();
        LoadTableTopCommic();
    }
    
    
    public FrmOverview() throws ClassNotFoundException, SQLException {
        
        initComponents();
        setLocationRelativeTo(null);
        TotalBill();
        TotalMoney();
        NumberCommicSale();
        LoadListTopCommic();
     /*
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment( SwingConstants.LEFT );
        
        tb_TopSaleStory.getColumnModel().getColumn(0).setHeaderRenderer(leftRenderer);
        tb_TopSaleStory.getColumnModel().getColumn(1).setHeaderRenderer(centerRenderer);
        tb_TopSaleStory.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);*/
          
        tb_TopSaleComic.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,16));
        tb_TopSaleComic.getTableHeader().setOpaque(false);
        tb_TopSaleComic.getTableHeader().setBackground(new Color(0,0,0,0));
        tb_TopSaleComic.getTableHeader().setForeground(new Color(0,153,153));
        tb_TopSaleComic.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,16));
        
        Border border = BorderFactory.createLineBorder(new Color(0,153,153));
        tb_TopSaleComic.getTableHeader().setBorder(border);
        
     
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pn_ToTalBill = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_TotalBill = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pn_Money = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lb_TotalMoney = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pn_StorySale = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_NumberSale = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_TopSaleComic = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1119, 782));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_filled_100px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tổng Quan");

        btn_Exit.setBackground(new java.awt.Color(0, 153, 153));
        btn_Exit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Exit.setForeground(new java.awt.Color(204, 0, 0));
        btn_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Exit.setText("x");
        btn_Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Exit.setOpaque(true);
        btn_Exit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_ExitMouseMoved(evt);
            }
        });
        btn_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ExitMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(715, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Exit)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pn_ToTalBill.setBackground(new java.awt.Color(204, 103, 132));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_purchase_order_filled_75px.png"))); // NOI18N

        lb_TotalBill.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lb_TotalBill.setForeground(new java.awt.Color(255, 255, 255));
        lb_TotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TotalBill.setText("10");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tổng Số Hóa Đơn: ");

        javax.swing.GroupLayout pn_ToTalBillLayout = new javax.swing.GroupLayout(pn_ToTalBill);
        pn_ToTalBill.setLayout(pn_ToTalBillLayout);
        pn_ToTalBillLayout.setHorizontalGroup(
            pn_ToTalBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ToTalBillLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_TotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ToTalBillLayout.setVerticalGroup(
            pn_ToTalBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ToTalBillLayout.createSequentialGroup()
                .addGroup(pn_ToTalBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ToTalBillLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pn_ToTalBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lb_TotalBill)))
                    .addGroup(pn_ToTalBillLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pn_Money.setBackground(new java.awt.Color(0, 158, 138));
        pn_Money.setPreferredSize(new java.awt.Dimension(324, 127));
        pn_Money.setRequestFocusEnabled(false);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_money_bag_75px.png"))); // NOI18N

        lb_TotalMoney.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lb_TotalMoney.setForeground(new java.awt.Color(255, 255, 255));
        lb_TotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TotalMoney.setText("1.250.000 VNĐ");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Doanh Thu: ");

        javax.swing.GroupLayout pn_MoneyLayout = new javax.swing.GroupLayout(pn_Money);
        pn_Money.setLayout(pn_MoneyLayout);
        pn_MoneyLayout.setHorizontalGroup(
            pn_MoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MoneyLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(lb_TotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pn_MoneyLayout.setVerticalGroup(
            pn_MoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_MoneyLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(25, 25, 25))
            .addGroup(pn_MoneyLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pn_MoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lb_TotalMoney))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pn_StorySale.setBackground(new java.awt.Color(78, 118, 66));
        pn_StorySale.setPreferredSize(new java.awt.Dimension(324, 127));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_book_filled_75px.png"))); // NOI18N

        lb_NumberSale.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lb_NumberSale.setForeground(new java.awt.Color(255, 255, 255));
        lb_NumberSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_NumberSale.setText("300");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Số Cuốn Đã Bán: ");

        javax.swing.GroupLayout pn_StorySaleLayout = new javax.swing.GroupLayout(pn_StorySale);
        pn_StorySale.setLayout(pn_StorySaleLayout);
        pn_StorySaleLayout.setHorizontalGroup(
            pn_StorySaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_StorySaleLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(lb_NumberSale, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_StorySaleLayout.setVerticalGroup(
            pn_StorySaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_StorySaleLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pn_StorySaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_NumberSale)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_StorySaleLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setFocusable(false);

        tb_TopSaleComic.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tb_TopSaleComic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_TopSaleComic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Conan", "30"},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Truyện Bán Chạy", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_TopSaleComic.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_TopSaleComic.setFocusable(false);
        tb_TopSaleComic.setGridColor(new java.awt.Color(0, 0, 0));
        tb_TopSaleComic.setRowHeight(41);
        tb_TopSaleComic.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_TopSaleComic.setShowVerticalLines(false);
        tb_TopSaleComic.getTableHeader().setResizingAllowed(false);
        tb_TopSaleComic.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_TopSaleComic);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pn_Money, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addComponent(pn_ToTalBill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_StorySale, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pn_ToTalBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(pn_Money, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(pn_StorySale, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseMoved
        btn_Exit.setBackground(new Color(204,0,0));
        btn_Exit.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btn_ExitMouseMoved

    private void btn_ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseExited
        btn_Exit.setBackground(new Color(0,153,153));
        btn_Exit.setForeground(new Color(204,0,0));
    }//GEN-LAST:event_btn_ExitMouseExited

    private void btn_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseClicked
            FrmMain frm = new FrmMain();
            frm.setVisible(true);
            dispose();
    }//GEN-LAST:event_btn_ExitMouseClicked

    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmOverview().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(FrmOverview.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    }  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_NumberSale;
    private javax.swing.JLabel lb_TotalBill;
    private javax.swing.JLabel lb_TotalMoney;
    private javax.swing.JPanel pn_Money;
    private javax.swing.JPanel pn_StorySale;
    private javax.swing.JPanel pn_ToTalBill;
    private javax.swing.JTable tb_TopSaleComic;
    // End of variables declaration//GEN-END:variables
}
