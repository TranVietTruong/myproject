/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import TableModel.TableModelCommic;
import entity.Catagory;
import entity.Commic;
import entity.Publisher;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import model.SaleModel;
import tablemodel.TableModelCatagory;
import tablemodel.TableModelPublisher;

/**
 *
 * @author Admin
 */
public final class FrmManagementComic extends javax.swing.JFrame {
    SaleModel commicModel = new SaleModel(); // khởi tạo đối tượng model để lấy dữ liệu
    ArrayList<Commic> listCommic = new ArrayList<>(); // danh sách truyện tranh
    ArrayList<Publisher> listPublisher = new ArrayList<>(); // danh sách nhà cung cấp
    ArrayList<Catagory> listCatagory = new ArrayList<>();  // danh sách thể loại
    int dongchon = -1; // dòng được chọn của bảng truyện tranh 
    int dongchonTableCatagory = -1; // dòng đc chọn của bảng thể loại
    int dongchonTablePublisher = -1; // dòng đc chọn của bảng nhà xuất bản
     /**
     * Creates new form FrmManagementComic
     */
    // load giao diện cho bảng thể loại
    public void LoadTableCatagory()
    {
        tb_Catagory.setModel(new TableModelCatagory(listCatagory));
        tb_Catagory.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_Catagory.getWidth()*0.2));
        tb_Catagory.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_Catagory.getWidth()*0.8));
    }
    // load dữ liệu cho bảng thể loại
    public void LoadListCatagory() throws ClassNotFoundException, SQLException
    {
        listCatagory = commicModel.getListCatagory();
        LoadTableCatagory();
    }
    // load giao diện cho bảng nhà xuất bản
    public void LoadTablePublisher()
    {
        tb_Publisher.setModel(new TableModelPublisher(listPublisher));
        tb_Publisher.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_Publisher.getWidth()*0.2));
        tb_Publisher.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_Publisher.getWidth()*0.8));
    }
    // load dữ liệu cho bảng nhà xuất bản 
    public void LoadListPublisher() throws ClassNotFoundException, SQLException
    {
        listPublisher = commicModel.getListPublisher();
        LoadTablePublisher();
    }
    // load giao diện cho bảng truyện tranh
    public void LoadTableCommic()
    {
        tb_Comic.setModel(new TableModelCommic(listCommic));
        tb_Comic.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_Comic.getWidth()*0.1));
        tb_Comic.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_Comic.getWidth()*0.1));
        tb_Comic.getColumnModel().getColumn(2).setPreferredWidth((int) (tb_Comic.getWidth()*0.2));
        tb_Comic.getColumnModel().getColumn(3).setPreferredWidth((int) (tb_Comic.getWidth()*0.2));
        tb_Comic.getColumnModel().getColumn(4).setPreferredWidth((int) (tb_Comic.getWidth()*0.2));
        tb_Comic.getColumnModel().getColumn(5).setPreferredWidth((int) (tb_Comic.getWidth()*0.1));
        tb_Comic.getColumnModel().getColumn(6).setPreferredWidth((int) (tb_Comic.getWidth()*0.1));
    }
    // load dữ liệu cho bảng truyện tranh
    public void LoadListCommic() throws ClassNotFoundException
    {
        listCommic = commicModel.getListCommic();
        LoadTableCommic();
    }
    // load combobox nhà xuất bản
    public void LoadChoicePublisher() throws ClassNotFoundException, SQLException
    {
        c_Publisher.removeAll();
        listPublisher = commicModel.getListPublisher();
        c_Publisher.add("------          Nhà xuất bản      ------");
        listPublisher.stream().forEach((publisher) -> {
            c_Publisher.add(publisher.getName_publisher());
        });
    }
    // load combobox thể loại
    public void LoadChoiceCatagory() throws ClassNotFoundException, SQLException
    {
        c_Catagory.removeAll();
        listCatagory = commicModel.getListCatagory();
        c_Catagory.add("------             Thể loại        ------");
        listCatagory.stream().forEach((catagory) -> {
            c_Catagory.add(catagory.getName_catagory());
        });
    }
    
    
    public FrmManagementComic() throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        LoadListCommic();
        LoadChoicePublisher();
        LoadChoiceCatagory();
        LoadListCatagory();
        LoadListPublisher();
        
        tb_Comic.getTableHeader().setOpaque(false);
        tb_Comic.getTableHeader().setBackground(new Color(0,0,0,0));
        tb_Comic.getTableHeader().setForeground(new Color(0,153,153));
        tb_Comic.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        
        Border border = BorderFactory.createLineBorder(new Color(0,153,153));
        tb_Comic.getTableHeader().setBorder(border);
        
        tb_Catagory.getTableHeader().setOpaque(false);
        tb_Catagory.getTableHeader().setBackground(new Color(0,0,0,0));
        tb_Catagory.getTableHeader().setForeground(new Color(0,153,153));
        tb_Catagory.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        
        tb_Catagory.getTableHeader().setBorder(border);
      
        tb_Publisher.getTableHeader().setOpaque(false);
        tb_Publisher.getTableHeader().setBackground(new Color(0,0,0,0));
        tb_Publisher.getTableHeader().setForeground(new Color(0,153,153));
        tb_Publisher.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        
        tb_Publisher.getTableHeader().setBorder(border);
        
        
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Comic = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        c_Publisher = new java.awt.Choice();
        c_Catagory = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        txt_NameComic = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Price = new javax.swing.JTextField();
        btn_AddComic = new javax.swing.JButton();
        btn_EditComic = new javax.swing.JButton();
        btn_DeleteComic = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Publisher = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txt_Catagory = new javax.swing.JTextField();
        btn_AddCatagory = new javax.swing.JLabel();
        btn_EditCatagory = new javax.swing.JLabel();
        btn_DeleteCatagory = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_Catagory = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txt_NamePulisher = new javax.swing.JTextField();
        btn_AddPulisher = new javax.swing.JLabel();
        btn_EditPulisher = new javax.swing.JLabel();
        btn_DeletePulisher = new javax.swing.JLabel();
        lb_Amount = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txt_Search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1119, 782));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_book_104px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản Lí Truyện");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        btn_Exit.setBackground(new java.awt.Color(0, 153, 153));
        btn_Exit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Exit.setForeground(new java.awt.Color(204, 0, 0));
        btn_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Exit.setText("x");
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
        jPanel1.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 50, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        tb_Comic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_Comic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "S001", "Conan", "Trinh Thám", "Kim Đồng", "100", "5000"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Truyện", "Tên Truyện", "Thể Loại", "Nhà Xuất Bản", "Số Lượng Còn", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Comic.setFocusable(false);
        tb_Comic.setRowHeight(30);
        tb_Comic.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_Comic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_ComicMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Comic);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 670, 350));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 170, 10));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 10));

        c_Publisher.setFocusable(false);
        c_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(c_Publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 230, -1));

        c_Catagory.setFocusable(false);
        c_Catagory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(c_Catagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 230, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_book_25px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_NameComic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_NameComic.setText("Nhập tên truyện ");
        txt_NameComic.setBorder(null);
        jPanel2.add(txt_NameComic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 310, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số Lượng : ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_money_25px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        txt_Price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Price.setText("VNĐ");
        txt_Price.setBorder(null);
        jPanel2.add(txt_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 110, -1));

        btn_AddComic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_24px.png"))); // NOI18N
        btn_AddComic.setText("Thêm");
        btn_AddComic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddComicActionPerformed(evt);
            }
        });
        jPanel2.add(btn_AddComic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 40));

        btn_EditComic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_24px_1.png"))); // NOI18N
        btn_EditComic.setText("Sửa");
        btn_EditComic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditComicActionPerformed(evt);
            }
        });
        jPanel2.add(btn_EditComic, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 120, 40));

        btn_DeleteComic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_24px.png"))); // NOI18N
        btn_DeleteComic.setText("Xóa");
        btn_DeleteComic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteComicActionPerformed(evt);
            }
        });
        jPanel2.add(btn_DeleteComic, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 120, 40));

        jScrollPane2.setBorder(null);

        tb_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_Publisher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Trinh Thám"},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Nhà Xuất Bản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Publisher.setFocusable(false);
        tb_Publisher.setRowHeight(25);
        tb_Publisher.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_Publisher.setShowVerticalLines(false);
        tb_Publisher.getTableHeader().setResizingAllowed(false);
        tb_Publisher.getTableHeader().setReorderingAllowed(false);
        tb_Publisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_PublisherMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Publisher);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 370, 160));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 370, 10));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_autograph_26px.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        txt_Catagory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Catagory.setText("Nhập tên thể loại");
        txt_Catagory.setBorder(null);
        jPanel2.add(txt_Catagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 320, -1));

        btn_AddCatagory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_24px.png"))); // NOI18N
        btn_AddCatagory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddCatagory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddCatagoryMouseClicked(evt);
            }
        });
        jPanel2.add(btn_AddCatagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, -1));

        btn_EditCatagory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_24px_1.png"))); // NOI18N
        btn_EditCatagory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_EditCatagory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EditCatagoryMouseClicked(evt);
            }
        });
        jPanel2.add(btn_EditCatagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, -1, -1));

        btn_DeleteCatagory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_24px.png"))); // NOI18N
        btn_DeleteCatagory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteCatagory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteCatagoryMouseClicked(evt);
            }
        });
        jPanel2.add(btn_DeleteCatagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, -1, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 370, 10));

        jScrollPane3.setBorder(null);

        tb_Catagory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_Catagory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Trinh Thám"},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Tên Thể Loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Catagory.setFocusable(false);
        tb_Catagory.setRowHeight(25);
        tb_Catagory.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_Catagory.setShowVerticalLines(false);
        tb_Catagory.getTableHeader().setResizingAllowed(false);
        tb_Catagory.getTableHeader().setReorderingAllowed(false);
        tb_Catagory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_CatagoryMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tb_Catagory);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 370, 160));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_client_company_filled_25px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, -1, -1));

        txt_NamePulisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_NamePulisher.setText("Nhà xuất bản");
        txt_NamePulisher.setBorder(null);
        jPanel2.add(txt_NamePulisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 320, -1));

        btn_AddPulisher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_24px.png"))); // NOI18N
        btn_AddPulisher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddPulisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddPulisherMouseClicked(evt);
            }
        });
        jPanel2.add(btn_AddPulisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, -1, -1));

        btn_EditPulisher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_24px_1.png"))); // NOI18N
        btn_EditPulisher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_EditPulisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EditPulisherMouseClicked(evt);
            }
        });
        jPanel2.add(btn_EditPulisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, -1, -1));

        btn_DeletePulisher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_24px.png"))); // NOI18N
        btn_DeletePulisher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeletePulisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeletePulisherMouseClicked(evt);
            }
        });
        jPanel2.add(btn_DeletePulisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, -1, -1));

        lb_Amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Amount.setText("0");
        jPanel2.add(lb_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 90, -1));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 240, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_24px.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        txt_Search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Search.setText("Nhập tên truyện");
        txt_Search.setBorder(null);
        txt_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_SearchMouseClicked(evt);
            }
        });
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
        });
        jPanel2.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 200, 20));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    // thoát
    private void btn_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseClicked
        FrmMain frm = new FrmMain();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_ExitMouseClicked
    // khi click vào bảng truyện tranh thì hiển thị dữ liệu lên các textbox tương ứng
    private void tb_ComicMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ComicMouseReleased
        dongchon = tb_Comic.getSelectedRow();
        if(dongchon != -1)
        {
            txt_NameComic.setText(listCommic.get(dongchon).getName_commic());
            lb_Amount.setText(listCommic.get(dongchon).getQuantity()+"");
            txt_Price.setText(listCommic.get(dongchon).getPrice()+"");
            c_Catagory.select(listCommic.get(dongchon).getName_catagory());
            c_Publisher.select(listCommic.get(dongchon).getName_publisher());
            
        }
    }//GEN-LAST:event_tb_ComicMouseReleased
    // khi click vào bảng thể loại thì  hiển thị dữ liệu tương ứng
    private void tb_CatagoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_CatagoryMouseReleased
        dongchonTableCatagory = tb_Catagory.getSelectedRow();
        if(dongchonTableCatagory != -1)
        {
            txt_Catagory.setText(listCatagory.get(dongchonTableCatagory).getName_catagory());
        }
    }//GEN-LAST:event_tb_CatagoryMouseReleased
    // khi click vào bảng nhà xuất bảng thì hiển thị dữ liệu tương ứng 
    private void tb_PublisherMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PublisherMouseReleased
        dongchonTablePublisher = tb_Publisher.getSelectedRow();
        if(dongchonTablePublisher != -1)
        {
            txt_NamePulisher.setText(listPublisher.get(dongchonTablePublisher).getName_publisher());
        }
    }//GEN-LAST:event_tb_PublisherMouseReleased
    
    private void txt_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchMouseClicked
        txt_Search.setText("");
    }//GEN-LAST:event_txt_SearchMouseClicked
    // tìm kiếm
    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
       String key = txt_Search.getText();
        try {
            listCommic = commicModel.searchByNameCommic(key);
            LoadTableCommic();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_SearchKeyReleased
    // thêm truyện
    private void btn_AddComicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddComicActionPerformed
        try {                                             
            if(txt_NameComic.getText().equals("") || txt_NameComic.getText().equals("Nhập tên truyện "))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên truyện");
                return;
            }
            if(txt_NameComic.getText().length() > 100)
            {
                JOptionPane.showMessageDialog(null,"Tên truyện quá dài");
                return;
            }
            if(txt_Price.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Nhập giá tiền");
                return;
            }
            if(txt_Price.getText().length() > 6)
            {
                JOptionPane.showMessageDialog(null,"Giá tiền không hợp lệ");
                return;
            }
            if(c_Catagory.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Chọn thể loại");
                return;
            }
            if(c_Publisher.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Chọn nhà xuất bản");
                return;
            }
            int price;
            try {
                price = Integer.parseInt(txt_Price.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Giá tiền không hợp lệ");
                return;
            }
            Commic cm = new Commic();
            cm.setName_commic(txt_NameComic.getText());
            cm.setId_catagory(listCatagory.get(c_Catagory.getSelectedIndex()-1).getId());
            cm.setId_publisher(listPublisher.get(c_Publisher.getSelectedIndex()-1).getId());
            cm.setPrice(price);
            if(commicModel.AddCommic(cm))
            {
                LoadListCommic();
                JOptionPane.showMessageDialog(null,"Thêm thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Thêm thất bại");
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE,null, ex);
        }  
    }//GEN-LAST:event_btn_AddComicActionPerformed
    // cập nhật truyện
    private void btn_EditComicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditComicActionPerformed
        try {  
             if(dongchon == -1)
            {
                JOptionPane.showMessageDialog(null,"Chọn truyện muốn sửa");
                return;
            }
            if(txt_NameComic.getText().equals("") || txt_NameComic.getText().equals("Nhập tên truyện "))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên truyện");
                return;
            }
            if(txt_NameComic.getText().length() > 100)
            {
                JOptionPane.showMessageDialog(null,"Tên truyện quá dài");
                return;
            }
            if(txt_Price.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Nhập giá tiền");
                return;
            }
            if(txt_Price.getText().length() > 6)
            {
                JOptionPane.showMessageDialog(null,"Giá tiền không hợp lệ");
                return;
            }
            if(c_Catagory.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Chọn thể loại");
                return;
            }
            if(c_Publisher.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Chọn nhà xuất bản");
                return;
            }
            int price;
            try {
                price = Integer.parseInt(txt_Price.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Giá tiền không hợp lệ");
                return;
            }
            Commic cm = new Commic();
            cm.setId(listCommic.get(dongchon).getId());
            cm.setName_commic(txt_NameComic.getText());
            cm.setId_catagory(listCatagory.get(c_Catagory.getSelectedIndex()-1).getId());
            cm.setId_publisher(listPublisher.get(c_Publisher.getSelectedIndex()-1).getId());
            cm.setPrice(price);
            if(commicModel.EditCommic(cm))
            {
                LoadListCommic();
                JOptionPane.showMessageDialog(null,"Sửa thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sửa thất bại");
            }  
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_btn_EditComicActionPerformed
    // xóa truyện
    private void btn_DeleteComicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteComicActionPerformed
        if(dongchon != -1)
        {
            try {
                if(commicModel.DeleteCommic(listCommic.get(dongchon).getId()))
                {
                    JOptionPane.showMessageDialog(null,"Xóa thành công");
                    LoadListCommic();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Xóa thất bại");
        }
    }//GEN-LAST:event_btn_DeleteComicActionPerformed
    // thêm danh mục 
    private void btn_AddCatagoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddCatagoryMouseClicked
        try {
            if(txt_Catagory.getText().equals("") || txt_Catagory.getText().equals("Nhập tên thể loại"))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên thể loại");
                return;
            }
            if(txt_Catagory.getText().length() > 100)
            {
                JOptionPane.showMessageDialog(null,"Tên danh mục không hợp lệ");
                return;
            }
            if(commicModel.AddCatagory(txt_Catagory.getText()))
            {
                LoadListCommic();
                LoadListCatagory();
                LoadChoiceCatagory();
                JOptionPane.showMessageDialog(null,"Thêm thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Thêm thất bại");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_AddCatagoryMouseClicked
    // cập nhật danh mục 
    private void btn_EditCatagoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditCatagoryMouseClicked
        try {
            if(dongchonTableCatagory == -1)
            {
                JOptionPane.showMessageDialog(null,"Chọn thể loại muốn sửa");
                return;
            }
            if(txt_Catagory.getText().equals("") || txt_Catagory.getText().equals("Nhập tên thể loại"))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên thể loại");
                return;
            }
            if(commicModel.EditCataroy(txt_Catagory.getText(),listCatagory.get(dongchonTableCatagory).getId()))
            {
                LoadListCommic();
                LoadListCatagory();
                LoadChoiceCatagory();
                JOptionPane.showMessageDialog(null,"Sửa thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sửa thất bại");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btn_EditCatagoryMouseClicked
    // xóa danh mục
    private void btn_DeleteCatagoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteCatagoryMouseClicked
        try {
            if(dongchonTableCatagory == -1)
            {
                JOptionPane.showMessageDialog(null,"Chọn thể loại muốn xóa");
                return;
            }
            if(commicModel.DeleteCatagory(listCatagory.get(dongchonTableCatagory).getId()))
            {
                LoadListCommic();
                LoadListCatagory();
                LoadChoiceCatagory();
                JOptionPane.showMessageDialog(null,"Xóa thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Xóa thất bại");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btn_DeleteCatagoryMouseClicked
    // thêm nhà xuất bản
    private void btn_AddPulisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddPulisherMouseClicked
        try {
            if(txt_NamePulisher.getText().equals("") || txt_NamePulisher.getText().equals("Nhà xuất bản"))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên nhà xuất bản");
                return;
            }
            if(txt_NamePulisher.getText().length() > 100)
            {
                JOptionPane.showMessageDialog(null,"Tên nhà sản xuất không hợp lệ");
                return;
            }
            if(commicModel.AddPublisher(txt_NamePulisher.getText()))
            {
                LoadListCommic();
                LoadListPublisher();
                LoadChoicePublisher();
                JOptionPane.showMessageDialog(null,"Thêm thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Thêm thất bại");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_AddPulisherMouseClicked
    // cập nhật nhà xuất bản 
    private void btn_EditPulisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditPulisherMouseClicked
        try {
            if(dongchonTablePublisher == -1)
            {
                JOptionPane.showMessageDialog(null,"Chọn nhà xuất bản muốn sửa");
                return;
            }
            if(txt_NamePulisher.getText().equals("") || txt_NamePulisher.getText().equals("Nhập tên nhà xuất bản"))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên nhà xuất bản");
                return;
            }
            if(commicModel.EditPublisher(txt_NamePulisher.getText(),listPublisher.get(dongchonTablePublisher).getId()))
            {
                LoadListCommic();
                LoadListPublisher();
                LoadChoicePublisher();
                JOptionPane.showMessageDialog(null,"Sửa thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sửa thất bại");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btn_EditPulisherMouseClicked
    // xóa nhà xuất bản
    private void btn_DeletePulisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeletePulisherMouseClicked
        try {
            if(dongchonTablePublisher == -1)
            {
                JOptionPane.showMessageDialog(null,"Chọn nhà xuất bản muốn xóa");
                return;
            }
            if(commicModel.DeletePublisher(listPublisher.get(dongchonTablePublisher).getId()))
            {
                LoadListCommic();
                LoadListPublisher();
                LoadChoicePublisher();
                JOptionPane.showMessageDialog(null,"Xóa thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Xóa thất bại");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btn_DeletePulisherMouseClicked

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
            java.util.logging.Logger.getLogger(FrmManagementComic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        new FrmManagementComic().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmManagementComic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_AddCatagory;
    private javax.swing.JButton btn_AddComic;
    private javax.swing.JLabel btn_AddPulisher;
    private javax.swing.JLabel btn_DeleteCatagory;
    private javax.swing.JButton btn_DeleteComic;
    private javax.swing.JLabel btn_DeletePulisher;
    private javax.swing.JLabel btn_EditCatagory;
    private javax.swing.JButton btn_EditComic;
    private javax.swing.JLabel btn_EditPulisher;
    private javax.swing.JLabel btn_Exit;
    private java.awt.Choice c_Catagory;
    private java.awt.Choice c_Publisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lb_Amount;
    private javax.swing.JTable tb_Catagory;
    private javax.swing.JTable tb_Comic;
    private javax.swing.JTable tb_Publisher;
    private javax.swing.JTextField txt_Catagory;
    private javax.swing.JTextField txt_NameComic;
    private javax.swing.JTextField txt_NamePulisher;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
