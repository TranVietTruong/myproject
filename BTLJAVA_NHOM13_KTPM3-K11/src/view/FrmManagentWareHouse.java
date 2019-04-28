/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import TableModel.TableModelCommic;
import entity.Catagory;
import entity.Commic;
import entity.Coupon;
import entity.CouponDetail;
import entity.Publisher;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.SaleModel;
import model.WareModel;
import tablemodel.TableModelCoupon;
import tablemodel.TableModelInputCommic;

/**
 *
 * @author Admin
 */
public class FrmManagentWareHouse extends javax.swing.JFrame {

    SaleModel model = new SaleModel(); // khởi tạo đối tượng model để lấy dữ liệu
    WareModel waremodel = new WareModel(); // khởi tạo đối tượng model để lấy dữ liệu
    ArrayList<Commic> listCommic = new ArrayList<>(); // danh sách truyện tranh để hiển thị lên table Commic (bảng to)
    ArrayList<CouponDetail> listInput = new ArrayList<>();  // danh sách truyện nhập 
    ArrayList<CouponDetail> listInput2 = new ArrayList<>(); // dùng để lưu các truyện đã nhập
    ArrayList<Catagory> listCatagory = new ArrayList<>();// danh sách thể loại
    ArrayList<Publisher> listPublisher = new ArrayList<>(); // danh sách nhà xuất bản
    ArrayList<Coupon> listCoupon = new ArrayList<>(); // danh sách phiếu nhập
    int dongchon = -1; // dòng chọn của table commic (bảng to đầu tiên)
    NumberFormat numf = NumberFormat.getInstance(); // định dạng số
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // định dạng ngày tháng

    // load giao diện cho table commic (bảng to đầu tiên)
    public void LoadTableCommic() {
        tb_Comic.setModel(new TableModelCommic(listCommic));
        tb_Comic.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_Comic.getWidth() * 0.07));
        tb_Comic.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_Comic.getWidth() * 0.15));
        tb_Comic.getColumnModel().getColumn(2).setPreferredWidth((int) (tb_Comic.getWidth() * 0.2));
        tb_Comic.getColumnModel().getColumn(3).setPreferredWidth((int) (tb_Comic.getWidth() * 0.2));
        tb_Comic.getColumnModel().getColumn(4).setPreferredWidth((int) (tb_Comic.getWidth() * 0.2));
        tb_Comic.getColumnModel().getColumn(5).setPreferredWidth((int) (tb_Comic.getWidth() * 0.15));
        tb_Comic.getColumnModel().getColumn(6).setPreferredWidth((int) (tb_Comic.getWidth() * 0.15));
    }
    // load giao diện cho table Input commic (bảng nhỏ đầu tiên)
    public void LoadTableInputCommic()
    {
        tb_InputComic.setModel(new TableModelInputCommic(listInput));
        lbl_Money.setText(numf.format(TotalMoney())+"");
    }
    // load dữ liệu cho table commic (bảng to đầu tiên)
    public void LoadListCommic() throws ClassNotFoundException {
        listCommic = model.getListCommic();
        LoadTableCommic();
    }
    // load combobox trạng thái
    public void LoadChoiceOption() {
        c_Option.add("-----     Trạng Thái    -----");
        c_Option.add("Còn Hàng");
        c_Option.add("Hết Hàng");
    }
    // load combobox thể loại
    public void LoadChoiceCatagory() throws ClassNotFoundException, SQLException {
        listCatagory = model.getListCatagory();
        c_Catagory.add("-----     Thể loại    -----");
        listCatagory.stream().forEach((catagory) -> {
            c_Catagory.add(catagory.getName_catagory());
        });
    }
    // load combobox nhà xuất bản
    public void LoadChoicePublisher() throws ClassNotFoundException, SQLException {
        listPublisher = model.getListPublisher();
        c_Publisher.add("---    Nhà xuất bản    ---");
        listPublisher.stream().forEach((publisher) -> {
            c_Publisher.add(publisher.getName_publisher());
        });
    }
    // Tính tổng tiền nhập truyện
    public int TotalMoney()
    {
        int tongtien = 0;
        for(CouponDetail c:listInput)
        {
            tongtien += c.getMoney();
        }
        return tongtien;
    }
    // load giao diện cho bảng phiếu nhập (bảng to thứ 2)
    public void LoadTableCoupon()
    {
        tb_PromissoryNote.setModel(new TableModelCoupon(listCoupon));
        tb_PromissoryNote.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_PromissoryNote.getWidth() * 0.05));
        tb_PromissoryNote.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_PromissoryNote.getWidth() * 0.1));
        tb_PromissoryNote.getColumnModel().getColumn(2).setPreferredWidth((int) (tb_PromissoryNote.getWidth() * 0.15));
        tb_PromissoryNote.getColumnModel().getColumn(3).setPreferredWidth((int) (tb_PromissoryNote.getWidth() * 0.15));
        tb_PromissoryNote.getColumnModel().getColumn(4).setPreferredWidth((int) (tb_PromissoryNote.getWidth() * 0.1));
        //tb_PromissoryNote.getColumnModel().getColumn(5).setPreferredWidth((int) (tb_PromissoryNote.getWidth() * 0.15));
    }
    // load dữ liệu cho bảng phiếu nhập (bảng to thứ 2)
    public void LoadListCoupon() throws SQLException, ClassNotFoundException
    {
        listCoupon = waremodel.getListCoupon();
        LoadTableCoupon();
    }
    // load dữ liệu cho bảng chi tiết phiếu nhập (bảng nhỏ thứ 2)
    public void LoadTableDetailPN()
    {
        tb_DetailPN.setModel(new TableModelInputCommic(listInput2));
    }
            /**
     * Creates new form FrmManagentWareHouse
     */
    public FrmManagentWareHouse() throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        LoadListCommic();
        LoadChoiceOption();
        LoadChoiceCatagory();
        LoadChoicePublisher();
        LoadTableInputCommic();
        LoadListCoupon();
        
        String date = sdf.format(new Date()); // lấy ngày tháng năm hiện tại
        lbl_DateTime.setText(date); // lấy ngày tháng hiện tại trong java
        

        tb_Comic.getTableHeader().setOpaque(false);
        tb_Comic.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        tb_Comic.getTableHeader().setForeground(new Color(0, 153, 153));
        tb_Comic.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        Border border = BorderFactory.createLineBorder(new Color(0, 153, 153));
        tb_Comic.getTableHeader().setBorder(border);
        
        tb_PromissoryNote.getTableHeader().setOpaque(false);
        tb_PromissoryNote.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        tb_PromissoryNote.getTableHeader().setForeground(new Color(0, 153, 153));
        tb_PromissoryNote.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        tb_PromissoryNote.getTableHeader().setBorder(border);

        tb_DetailPN.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_InputComic.getWidth() * 0.05));
        
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Comic = new javax.swing.JTable();
        c_Option = new java.awt.Choice();
        c_Catagory = new java.awt.Choice();
        c_Publisher = new java.awt.Choice();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txt_Search = new javax.swing.JTextField();
        btn_InputComic = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txt_NameNCC = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        lbl_DateTime = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txt_Note = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_InputComic = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lbl_Money = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_DeleteInput = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_PromissoryNote = new javax.swing.JTable();
        date_From = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        date_To = new com.toedter.calendar.JDateChooser();
        btn_Filter = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        txt_SearchPN = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_DetailPN = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        lbl_Money2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_Delete2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_Date = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_Notes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1119, 782));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1119, 223));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_data_configuration_filled_100px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản Lí Kho");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        btn_Exit.setBackground(new java.awt.Color(0, 153, 153));
        btn_Exit.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_Exit.setForeground(new java.awt.Color(204, 0, 0));
        btn_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Exit.setText("x");
        btn_Exit.setToolTipText("");
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

        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 153));
        jTabbedPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Comic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_Comic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Conan", "Trinh Thám", "Kim Đồng", "5000", "100"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Truyện", "Thể Loại", "Nhà Xuất Bản", "Giá", "Số Lượng Còn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Comic.setFocusable(false);
        tb_Comic.setRowHeight(30);
        tb_Comic.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_Comic.setShowVerticalLines(false);
        tb_Comic.getTableHeader().setReorderingAllowed(false);
        tb_Comic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_ComicMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Comic);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 620, 380));

        c_Option.setFocusable(false);
        c_Option.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_Option.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_OptionItemStateChanged(evt);
            }
        });
        jPanel4.add(c_Option, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, -1));

        c_Catagory.setFocusable(false);
        c_Catagory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_Catagory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_CatagoryItemStateChanged(evt);
            }
        });
        jPanel4.add(c_Catagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 180, -1));

        c_Publisher.setFocusable(false);
        c_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_Publisher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_PublisherItemStateChanged(evt);
            }
        });
        jPanel4.add(c_Publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 180, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_24px.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

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
        jPanel4.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 230, -1));

        btn_InputComic.setBackground(new java.awt.Color(204, 204, 204));
        btn_InputComic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_24px.png"))); // NOI18N
        btn_InputComic.setText("Nhập truyện");
        btn_InputComic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InputComicActionPerformed(evt);
            }
        });
        jPanel4.add(btn_InputComic, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 130, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 3));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 390, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_commercial_development_management_filled_25px.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        txt_NameNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_NameNCC.setText("Nhà cung cấp");
        txt_NameNCC.setBorder(null);
        jPanel4.add(txt_NameNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 350, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 3));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 108, 390, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_calendar_24px.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, -1));

        lbl_DateTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_DateTime.setText("23/03/2019");
        jPanel4.add(lbl_DateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOpaque(true);
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 3));
        jSeparator4.setRequestFocusEnabled(false);
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 167, 390, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_24px.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        txt_Note.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Note.setText("Ghi Chú");
        txt_Note.setBorder(null);
        jPanel4.add(txt_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 350, -1));

        jScrollPane2.setAutoscrolls(true);

        tb_InputComic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_InputComic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Conan", "100", "3000"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên Truyện", "Số Lượng Nhập", "Đơn Giá Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_InputComic.setRowHeight(25);
        tb_InputComic.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_InputComic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_InputComicMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_InputComic);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 390, 180));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Tổng Tiền : ");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        lbl_Money.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Money.setForeground(new java.awt.Color(204, 0, 0));
        lbl_Money.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Money.setText("0");
        jPanel4.add(lbl_Money, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 420, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("VNĐ");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, -1, -1));

        btn_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_save_25px.png"))); // NOI18N
        btn_Save.setText("Lưu");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 130, 40));

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_24px.png"))); // NOI18N
        btn_Delete.setText("Hủy");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, 130, 40));

        btn_DeleteInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_left_squared_50px.png"))); // NOI18N
        btn_DeleteInput.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_DeleteInputMouseReleased(evt);
            }
        });
        jPanel4.add(btn_DeleteInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        jTabbedPane1.addTab("Nhập Kho", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_PromissoryNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_PromissoryNote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "001", "23/01/2019", "Hà Phương", "Đéo Có", "350000"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Phiếu", "Ngày Nhập", "Nhà Cung Cấp", "Ghi Chú", "Đơn Giá Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_PromissoryNote.setFocusable(false);
        tb_PromissoryNote.setRowHeight(30);
        tb_PromissoryNote.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_PromissoryNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_PromissoryNoteMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tb_PromissoryNote);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 680, 430));

        date_From.setBackground(new java.awt.Color(255, 255, 255));
        date_From.setDateFormatString("dd/MM/yyyy");
        date_From.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(date_From, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 170, 30));

        jLabel7.setText("To");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        date_To.setBackground(new java.awt.Color(255, 255, 255));
        date_To.setDateFormatString("dd/MM/yyyy");
        date_To.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(date_To, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 170, 30));

        btn_Filter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Filter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_filled_filter_26px.png"))); // NOI18N
        btn_Filter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_FilterMouseReleased(evt);
            }
        });
        jPanel5.add(btn_Filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 40, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 3));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 47, 190, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_24px.png"))); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txt_SearchPN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SearchPN.setText("Nhập mã phiếu");
        txt_SearchPN.setBorder(null);
        txt_SearchPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_SearchPNMouseReleased(evt);
            }
        });
        txt_SearchPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchPNKeyReleased(evt);
            }
        });
        jPanel5.add(txt_SearchPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 160, -1));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOpaque(true);
        jSeparator6.setPreferredSize(new java.awt.Dimension(50, 3));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 47, 350, -1));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOpaque(true);
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 3));
        jPanel5.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 350, -1));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setOpaque(true);
        jSeparator8.setPreferredSize(new java.awt.Dimension(50, 3));
        jPanel5.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 350, -1));

        tb_DetailPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên Truyện", "Số Lượng Nhập", "Đơn Giá Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_DetailPN.setFocusable(false);
        tb_DetailPN.setRowHeight(25);
        tb_DetailPN.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane4.setViewportView(tb_DetailPN);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 350, 180));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tổng Tiền :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 80, -1));

        lbl_Money2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Money2.setForeground(new java.awt.Color(0, 153, 51));
        lbl_Money2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Money2.setText("350000");
        lbl_Money2.setToolTipText("");
        jPanel5.add(lbl_Money2, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 420, 90, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("VNĐ");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, -1, -1));

        btn_Delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_24px.png"))); // NOI18N
        btn_Delete2.setText("Xóa");
        btn_Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete2ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_Delete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 130, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_commercial_development_management_filled_25px.png"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        lbl_Name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Name.setText("null");
        jPanel5.add(lbl_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 310, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_calendar_24px.png"))); // NOI18N
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        lbl_Date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Date.setText("23/01/2019");
        jPanel5.add(lbl_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 310, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_24px.png"))); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        txt_Notes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Notes.setText("ghi chú");
        txt_Notes.setBorder(null);
        jPanel5.add(txt_Notes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 310, -1));

        jTabbedPane1.addTab("Quản Lí Phiếu Nhập", jPanel5);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 560));

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
        btn_Exit.setBackground(new Color(204, 0, 0));
        btn_Exit.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_ExitMouseMoved

    private void btn_ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseExited
        btn_Exit.setBackground(new Color(0, 153, 153));
        btn_Exit.setForeground(new Color(204, 0, 0));
    }//GEN-LAST:event_btn_ExitMouseExited
    // thoát
    private void btn_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExitMouseClicked
        FrmMain frm = new FrmMain();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_ExitMouseClicked
    
    // load dữ liệu theo combobox đc chọn
    private void c_PublisherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_PublisherItemStateChanged
        int selectedItem = c_Publisher.getSelectedIndex();
        if(selectedItem == 0)
        {
            try {
                LoadListCommic();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            int idPublisher = listPublisher.get(selectedItem - 1).getId();
            try {
                listCommic = model.getListCommicByIdPublisher(idPublisher);
                LoadTableCommic();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_c_PublisherItemStateChanged
    // load dữ liệu theo thể loại đc chọn
    private void c_CatagoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_CatagoryItemStateChanged
        int selectedItem = c_Catagory.getSelectedIndex();
        if(selectedItem == 0)
        {
            try {
                LoadListCommic();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            int idCatagory = listCatagory.get(selectedItem - 1).getId();
            try {
                listCommic = model.getListCommicByIdCatagory(idCatagory);
                LoadTableCommic();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_c_CatagoryItemStateChanged

    private void txt_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchMouseClicked
        txt_Search.setText("");
    }//GEN-LAST:event_txt_SearchMouseClicked
    // tìm kiếm phiếu nhập
    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        String key = txt_Search.getText();
        try {
            listCommic = model.searchByNameCommic(key);
            LoadTableCommic();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_txt_SearchKeyReleased
    // load dữ liệu theo trạng thái được chọn
    private void c_OptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_OptionItemStateChanged
        int selectedItem = c_Option.getSelectedIndex();
        switch(selectedItem)
        {
            case 0: try {  // 0 tức là load hết 
                LoadListCommic();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            } 
            break;
            case 1:  try { // load những truyện có số lượng > 0
                listCommic = waremodel.getListCommicByQuantity();
                LoadTableCommic();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            case 2:  try { // load những truyện có số lượng = 0 
                listCommic = waremodel.getListCommicByQuantity0();
                LoadTableCommic();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }break;
            default: return;
        }
    }//GEN-LAST:event_c_OptionItemStateChanged
    // lấy dòng đc chọn của tablecommic (bảng to đầu tiên)
    private void tb_ComicMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ComicMouseReleased
        dongchon = tb_Comic.getSelectedRow();
    }//GEN-LAST:event_tb_ComicMouseReleased
    // nhập truyện
    private void btn_InputComicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InputComicActionPerformed
        try {                                               
            if(dongchon == -1)
            {
                JOptionPane.showMessageDialog(null,"Chọn truyện muốn nhập");
                return;
            }
            int soluongnhap;
            int dongianhap;
            try {
                soluongnhap = Integer.parseInt(JOptionPane.showInputDialog(rootPane,"Số lượng nhập","Nhập truyện: "+listCommic.get(dongchon).getName_commic(),1));
                
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Dữ liệu nhập không hợp lệ");
                return;
            }
            if(soluongnhap > 1000)
            {
                JOptionPane.showMessageDialog(null,"Số lượng phải nhỏ hơn 1000");
                return;
            }
            try {
                dongianhap = Integer.parseInt(JOptionPane.showInputDialog(rootPane,"Đơn giá nhập","Nhập truyện: "+listCommic.get(dongchon).getName_commic(),1));
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Dữ liệu nhập không hợp lệ");
                return;
            }
            if(dongianhap > 100000)
            {
                JOptionPane.showMessageDialog(null,"Đơn giá phải nhỏ hơn 100000");
                return;
            }
            CouponDetail cp = new CouponDetail();
            cp.setId_commic(listCommic.get(dongchon).getId());
            cp.setName_commic(listCommic.get(dongchon).getName_commic());
            cp.setQuantity_order(soluongnhap);
            cp.setImport_price(dongianhap);
            for(CouponDetail c : listInput)
            {
                if(c.getId_commic() == cp.getId_commic())
                {
                    JOptionPane.showMessageDialog(null,"Truyện đã được nhập");
                    return;
                }
            }
            listInput.add(cp);
            LoadTableInputCommic();
            LoadListCoupon();
            dongchon = -1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmManagentWareHouse.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_btn_InputComicActionPerformed
    // xóa 1 truyện vừa nhập
    private void btn_DeleteInputMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteInputMouseReleased
       if(dongchonTableInput != -1)
       { 
            listInput.remove(dongchonTableInput);
            LoadTableInputCommic(); 
            lbl_Money.setText(numf.format(TotalMoney())+"");
            dongchonTableInput = -1;
       }
    }//GEN-LAST:event_btn_DeleteInputMouseReleased
    
    // lấy dòng đc chọn của tableinputcommic (bảng nhỏ đầu tiên)
    int dongchonTableInput = -1;
    private void tb_InputComicMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_InputComicMouseReleased
        dongchonTableInput = tb_InputComic.getSelectedRow();
    }//GEN-LAST:event_tb_InputComicMouseReleased
    // Lưu phiếu nhập
    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        try {
            if(txt_NameNCC.getText().equals("") || txt_NameNCC.getText().equals("Nhà cung cấp"))
            {
                JOptionPane.showMessageDialog(null,"Nhập tên nhà cung cấp");
                return;
            }
            if(txt_NameNCC.getText().length() > 255)
            {
                JOptionPane.showMessageDialog(null,"Dữ liệu không hợp lệ");
                return;
            }
            if(txt_Note.getText().length() > 255)
            {
                JOptionPane.showMessageDialog(null,"Dữ liệu không hợp lệ");
                return;
            }
            if(listInput.size() < 1)
            {
                return;
            }
            
            Coupon cp = new Coupon();
            cp.setName_suppiler(txt_NameNCC.getText());
            SimpleDateFormat sf;
            sf = new SimpleDateFormat("yyyy/MM/dd");
            cp.setDate_order(sf.format(new Date()));
            if(txt_Note.getText().equals("Ghi Chú"))
            {
                cp.setNote("");
            }
            else
            {
                cp.setNote(txt_Note.getText());
            }
            cp.setTotal(TotalMoney());
            if(waremodel.SaveCoupon(cp,listInput))
            {
                listInput.removeAll(listInput);
                LoadTableInputCommic();
                LoadListCommic();
                LoadListCoupon();
                txt_NameNCC.setText("Nhà cung cấp");
                txt_Note.setText("Ghi Chú");
                lbl_Money.setText("0");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Lỗi");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmManagentWareHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SaveActionPerformed
    // lấy dòng được chọn của bảng phiếu nhập (bảng to thứ 2)
    int dongchonTableCoupon = -1;
    private void tb_PromissoryNoteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PromissoryNoteMouseReleased
        dongchonTableCoupon = tb_PromissoryNote.getSelectedRow();
        if(dongchonTableCoupon != -1)
        {
            try {
                // lấy thông tin chi tiết của dòng chọn đó hiển thị lên giao diện
                lbl_Name.setText(listCoupon.get(dongchonTableCoupon).getName_suppiler());
                lbl_Date.setText(listCoupon.get(dongchonTableCoupon).getDate_order());
                txt_Notes.setText(listCoupon.get(dongchonTableCoupon).getNote());
                lbl_Money2.setText(numf.format(listCoupon.get(dongchonTableCoupon).getTotal()));
                listInput2 = waremodel.getList(listCoupon.get(dongchonTableCoupon).getId());
                LoadTableDetailPN(); // load những truyện đã nhập của phiếu nhập đó
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FrmManagentWareHouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tb_PromissoryNoteMouseReleased

    private void txt_SearchPNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchPNMouseReleased
       txt_SearchPN.setText("");
    }//GEN-LAST:event_txt_SearchPNMouseReleased
    // tìm kiếm phiếu nhập
    private void txt_SearchPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchPNKeyReleased
        try {
            listCoupon = waremodel.SearchById(txt_SearchPN.getText());
            LoadTableCoupon();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_SearchPNKeyReleased
    // lọc phiếu nhập theo thời gian
    private void btn_FilterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FilterMouseReleased
       try {
            String from  = ((JTextField)date_From.getDateEditor().getUiComponent()).getText();
            String to  = ((JTextField)date_To.getDateEditor().getUiComponent()).getText();
            if(from.equals("") || to.equals(""))
            {
                return;
            }
            listCoupon = waremodel.FillterCoupon(from, to);
            LoadTableCoupon();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_FilterMouseReleased
    // xóa một phiếu nhập 
    private void btn_Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete2ActionPerformed
        if(dongchonTableCoupon != -1)
        {
            try {
                int id = listCoupon.get(dongchonTableCoupon).getId();
                if(waremodel.DeleteCoupon(id))
                {
                    listCoupon.remove(dongchonTableCoupon);
                    LoadTableCoupon();
                    JOptionPane.showMessageDialog(null,"Xóa thành công");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Xóa thất bại");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_Delete2ActionPerformed
    // xóa dữ liệu của phiếu nhập trên giao diện
    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        txt_NameNCC.setText("Nhà cung cấp");
        txt_Note.setText("Ghi chú");
        listInput.removeAll(listInput);
        lbl_Money.setText("0");
        LoadTableInputCommic();
    }//GEN-LAST:event_btn_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmManagentWareHouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmManagentWareHouse().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(FrmManagentWareHouse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Delete2;
    private javax.swing.JLabel btn_DeleteInput;
    private javax.swing.JLabel btn_Exit;
    private javax.swing.JLabel btn_Filter;
    private javax.swing.JButton btn_InputComic;
    private javax.swing.JButton btn_Save;
    private java.awt.Choice c_Catagory;
    private java.awt.Choice c_Option;
    private java.awt.Choice c_Publisher;
    private com.toedter.calendar.JDateChooser date_From;
    private com.toedter.calendar.JDateChooser date_To;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_Date;
    private javax.swing.JLabel lbl_DateTime;
    private javax.swing.JLabel lbl_Money;
    private javax.swing.JLabel lbl_Money2;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JTable tb_Comic;
    private javax.swing.JTable tb_DetailPN;
    private javax.swing.JTable tb_InputComic;
    private javax.swing.JTable tb_PromissoryNote;
    private javax.swing.JTextField txt_NameNCC;
    private javax.swing.JTextField txt_Note;
    private javax.swing.JTextField txt_Notes;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_SearchPN;
    // End of variables declaration//GEN-END:variables
}
