/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FrmMain extends javax.swing.JFrame {
    FrmLogin frmlg = new FrmLogin();
    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        lb_NameEmployee.setText(frmlg.inforEmployee.getName_employee());
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
        lb_NameEmployee = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_Exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_OverView = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_Sale = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_ManagementStory = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_ManagamentWareHouse = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_Statictical = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_Bill = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_paper_plane_filled_100px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome To");

        lb_NameEmployee.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lb_NameEmployee.setForeground(new java.awt.Color(255, 255, 255));
        lb_NameEmployee.setText("tranviettruong");

        btn_Exit.setBackground(new java.awt.Color(0, 153, 153));
        btn_Exit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Exit.setForeground(new java.awt.Color(204, 0, 0));
        btn_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Exit.setText("x");
        btn_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_NameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(576, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_NameEmployee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_OverView.setBackground(new java.awt.Color(204, 204, 204));
        btn_OverView.setForeground(new java.awt.Color(204, 204, 204));
        btn_OverView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_OverView.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_OverViewMouseMoved(evt);
            }
        });
        btn_OverView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_OverViewMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_OverViewMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_filled_50px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Tổng Quan");

        javax.swing.GroupLayout btn_OverViewLayout = new javax.swing.GroupLayout(btn_OverView);
        btn_OverView.setLayout(btn_OverViewLayout);
        btn_OverViewLayout.setHorizontalGroup(
            btn_OverViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_OverViewLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(btn_OverViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_OverViewLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_OverViewLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40))))
        );
        btn_OverViewLayout.setVerticalGroup(
            btn_OverViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_OverViewLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(37, 37, 37))
        );

        btn_Sale.setBackground(new java.awt.Color(204, 204, 204));
        btn_Sale.setForeground(new java.awt.Color(204, 204, 204));
        btn_Sale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Sale.setPreferredSize(new java.awt.Dimension(177, 170));
        btn_Sale.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_SaleMouseMoved(evt);
            }
        });
        btn_Sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SaleMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SaleMouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_sale_48px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Bán Hàng");

        javax.swing.GroupLayout btn_SaleLayout = new javax.swing.GroupLayout(btn_Sale);
        btn_Sale.setLayout(btn_SaleLayout);
        btn_SaleLayout.setHorizontalGroup(
            btn_SaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_SaleLayout.createSequentialGroup()
                .addGroup(btn_SaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_SaleLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7))
                    .addGroup(btn_SaleLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        btn_SaleLayout.setVerticalGroup(
            btn_SaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_SaleLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(37, 37, 37))
        );

        btn_ManagementStory.setBackground(new java.awt.Color(204, 204, 204));
        btn_ManagementStory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManagementStory.setPreferredSize(new java.awt.Dimension(177, 170));
        btn_ManagementStory.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_ManagementStoryMouseMoved(evt);
            }
        });
        btn_ManagementStory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManagementStoryMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManagementStoryMouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_52px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Quản Lí Truyện ");

        javax.swing.GroupLayout btn_ManagementStoryLayout = new javax.swing.GroupLayout(btn_ManagementStory);
        btn_ManagementStory.setLayout(btn_ManagementStoryLayout);
        btn_ManagementStoryLayout.setHorizontalGroup(
            btn_ManagementStoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManagementStoryLayout.createSequentialGroup()
                .addGroup(btn_ManagementStoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_ManagementStoryLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9))
                    .addGroup(btn_ManagementStoryLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        btn_ManagementStoryLayout.setVerticalGroup(
            btn_ManagementStoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManagementStoryLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btn_ManagamentWareHouse.setBackground(new java.awt.Color(204, 204, 204));
        btn_ManagamentWareHouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManagamentWareHouse.setPreferredSize(new java.awt.Dimension(177, 170));
        btn_ManagamentWareHouse.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_ManagamentWareHouseMouseMoved(evt);
            }
        });
        btn_ManagamentWareHouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManagamentWareHouseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManagamentWareHouseMouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_database_filled_50px.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Quản Lí Kho");

        javax.swing.GroupLayout btn_ManagamentWareHouseLayout = new javax.swing.GroupLayout(btn_ManagamentWareHouse);
        btn_ManagamentWareHouse.setLayout(btn_ManagamentWareHouseLayout);
        btn_ManagamentWareHouseLayout.setHorizontalGroup(
            btn_ManagamentWareHouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManagamentWareHouseLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ManagamentWareHouseLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(33, 33, 33))
        );
        btn_ManagamentWareHouseLayout.setVerticalGroup(
            btn_ManagamentWareHouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManagamentWareHouseLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btn_Statictical.setBackground(new java.awt.Color(204, 204, 204));
        btn_Statictical.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Statictical.setPreferredSize(new java.awt.Dimension(177, 170));
        btn_Statictical.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_StaticticalMouseMoved(evt);
            }
        });
        btn_Statictical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_StaticticalMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_StaticticalMouseReleased(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_combo_chart_filled_50px.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Thống Kê");

        javax.swing.GroupLayout btn_StaticticalLayout = new javax.swing.GroupLayout(btn_Statictical);
        btn_Statictical.setLayout(btn_StaticticalLayout);
        btn_StaticticalLayout.setHorizontalGroup(
            btn_StaticticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_StaticticalLayout.createSequentialGroup()
                .addGroup(btn_StaticticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_StaticticalLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel13))
                    .addGroup(btn_StaticticalLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel14)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        btn_StaticticalLayout.setVerticalGroup(
            btn_StaticticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_StaticticalLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btn_Bill.setBackground(new java.awt.Color(204, 204, 204));
        btn_Bill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Bill.setPreferredSize(new java.awt.Dimension(177, 170));
        btn_Bill.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_BillMouseMoved(evt);
            }
        });
        btn_Bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BillMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_BillMouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_money_bag_filled_50px.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Hóa Đơn");

        javax.swing.GroupLayout btn_BillLayout = new javax.swing.GroupLayout(btn_Bill);
        btn_Bill.setLayout(btn_BillLayout);
        btn_BillLayout.setHorizontalGroup(
            btn_BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_BillLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(btn_BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_BillLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_BillLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(46, 46, 46))))
        );
        btn_BillLayout.setVerticalGroup(
            btn_BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_BillLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_OverView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btn_Sale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ManagamentWareHouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ManagementStory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Statictical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btn_OverView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Sale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ManagementStory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ManagamentWareHouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Statictical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_OverViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OverViewMouseMoved
        btn_OverView.setBackground(new Color(235,235,235));
    }//GEN-LAST:event_btn_OverViewMouseMoved

    private void btn_OverViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OverViewMouseExited
        btn_OverView.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_OverViewMouseExited

    private void btn_SaleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SaleMouseMoved
        btn_Sale.setBackground(new Color(235,235,235));
    }//GEN-LAST:event_btn_SaleMouseMoved

    private void btn_SaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SaleMouseExited
        btn_Sale.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_SaleMouseExited

    private void btn_ManagementStoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManagementStoryMouseMoved
        btn_ManagementStory.setBackground(new Color(235,235,235));
    }//GEN-LAST:event_btn_ManagementStoryMouseMoved

    private void btn_ManagementStoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManagementStoryMouseExited
       btn_ManagementStory.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_ManagementStoryMouseExited

    private void btn_ManagamentWareHouseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManagamentWareHouseMouseMoved
        btn_ManagamentWareHouse.setBackground(new Color(235,235,235));
    }//GEN-LAST:event_btn_ManagamentWareHouseMouseMoved

    private void btn_ManagamentWareHouseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManagamentWareHouseMouseExited
        btn_ManagamentWareHouse.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_ManagamentWareHouseMouseExited

    private void btn_StaticticalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_StaticticalMouseMoved
        btn_Statictical.setBackground(new Color(235,235,235));
    }//GEN-LAST:event_btn_StaticticalMouseMoved

    private void btn_StaticticalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_StaticticalMouseExited
        btn_Statictical.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_StaticticalMouseExited
    // thoát chương trình
    private void btn_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseClicked

        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ExitMouseClicked

    private void btn_BillMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BillMouseMoved
        btn_Bill.setBackground(new Color(235,235,235));
    }//GEN-LAST:event_btn_BillMouseMoved

    private void btn_BillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BillMouseExited
        btn_Bill.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_BillMouseExited

    private void btn_ExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseMoved
        btn_Exit.setBackground(new Color(204,0,51));
        btn_Exit.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btn_ExitMouseMoved

    private void btn_ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseExited
        btn_Exit.setBackground(new Color(0,153,153));
        btn_Exit.setForeground(new Color(204,0,0));
    }//GEN-LAST:event_btn_ExitMouseExited
    // click thì hiển thị form tổng quan
    private void btn_OverViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OverViewMouseClicked
        try {
            FrmOverview frmoverview = new FrmOverview();
            frmoverview.setVisible(true);
            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_OverViewMouseClicked
    //click thì hiển thị form bán hàng
    private void btn_SaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SaleMouseClicked
        try {
            FrmSale frmsale = new FrmSale();
            frmsale.setVisible(true);
            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SaleMouseClicked
    // click thì hiển thị form quản lí hóa đơn
    private void btn_BillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BillMouseClicked
        try {
            FrmBill frmbill = new FrmBill();
            frmbill.setVisible(true);
            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_BillMouseClicked
    // click thì hiển thị form Quản lí truyện
    private void btn_ManagementStoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManagementStoryMouseClicked
        try {
            FrmManagementComic frm;
            try {
                frm = new FrmManagementComic();
                frm.setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ManagementStoryMouseClicked
    // click thì hiển thị form quản lí kho
    private void btn_ManagamentWareHouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManagamentWareHouseMouseClicked
        try {
            FrmManagentWareHouse frm = new FrmManagentWareHouse();
            frm.setVisible(true);
            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ManagamentWareHouseMouseClicked

    private void btn_StaticticalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_StaticticalMouseReleased
        try {
            FrmStatistical frm = new FrmStatistical();
            frm.setVisible(true);
            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_StaticticalMouseReleased

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_Bill;
    private javax.swing.JLabel btn_Exit;
    private javax.swing.JPanel btn_ManagamentWareHouse;
    private javax.swing.JPanel btn_ManagementStory;
    private javax.swing.JPanel btn_OverView;
    private javax.swing.JPanel btn_Sale;
    private javax.swing.JPanel btn_Statictical;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_NameEmployee;
    // End of variables declaration//GEN-END:variables
}