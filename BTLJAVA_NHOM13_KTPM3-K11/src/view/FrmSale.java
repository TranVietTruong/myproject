/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import TableModel.TableModelCommic;
import entity.Bill;
import entity.BillDetail;
import entity.Catagory;
import entity.Commic;
import entity.Publisher;
import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import model.SaleModel;
import tablemodel.TableModelOrder;
import vendor.DigitDocument;

/**
 *
 * @author Admin
 */
public class FrmSale extends javax.swing.JFrame {
    SaleModel saleModel = new SaleModel();  // Gọi lớp bên model
    ArrayList<Commic> listCommic = new ArrayList<>();  // danh sách truyện tranh để hiển thị lên giao diện
    ArrayList<Publisher> listPublisher = new ArrayList<>(); // danh sách nhà xuất bản để hiển thị lên giao diện
    ArrayList<Catagory> listCatagory = new ArrayList<>();  // danh sách thể loại để hiển thị lên giao diện
    ArrayList<BillDetail> listOrder = new ArrayList<>();  // danh sách order để hiển thị lên giao diện
    int dongchon = -1;  // dòng mà người dùng sẽ chọn ở bảng Truyện tranh (bảng to)
    int dongchon2 = -1; // dòng mà ng dùng sẽ chọn ở bảng order (bảng nhỏ)
    NumberFormat numf = NumberFormat.getInstance(); // định dạng số
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // định dạng ngày tháng
    int promotionMoney = 0; // lưu tiền khuyến mãi
 
    /**
     * Creates new form FrmSale
     */
    
    // Load giao diện cho table order (bảng nhỏ)
    public void LoadTableOrder()
    {
        tb_Order.setModel(new TableModelOrder(listOrder));
        lb_TotalMoney.setText(numf.format(TotalMoney())); // tính tổng tiền 
        lb_PayMoney.setText(numf.format(TotalMoney()));   // số tiền phải trả sau khi khuyến mãi
    }
    // Set TableModel cho bảng trong giao diện
    public void LoadTableCommicSale()
    {
        tb_ComicSale.setModel(new TableModelCommic(listCommic));
        tb_ComicSale.getColumnModel().getColumn(0).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.07));
        tb_ComicSale.getColumnModel().getColumn(1).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.15));
        tb_ComicSale.getColumnModel().getColumn(2).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.2));
        tb_ComicSale.getColumnModel().getColumn(3).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.2));
        tb_ComicSale.getColumnModel().getColumn(4).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.2));
        tb_ComicSale.getColumnModel().getColumn(5).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.1));
        tb_ComicSale.getColumnModel().getColumn(6).setPreferredWidth((int) (tb_ComicSale.getWidth() * 0.2));
    }
    // Load dữ liệu lên bảng trong giao diện
    public void LoadListCommic() throws ClassNotFoundException
    {
        listCommic = saleModel.getListCommic();
        LoadTableCommicSale();
    }
    // Load dữ liệu lên Choice(Choice còn gọi là combobox) Publisher trong giao diện
    public void LoadChoicePublisher() throws ClassNotFoundException, SQLException
    {
        listPublisher = saleModel.getListPublisher();
        c_Publisher.add("-----    Nhà xuất bản    -----");
        listPublisher.stream().forEach((publisher) -> {
            c_Publisher.add(publisher.getName_publisher());
        });
    }
    // Load dữ liệu lên Choice(Choice còn gọi là combobox) Catagory trong giao diện
    public void LoadChoiceCatagory() throws ClassNotFoundException, SQLException
    {
        listCatagory = saleModel.getListCatagory();
        c_Catagory.add("------       Thể loại    ------");
        listCatagory.stream().forEach((catagory) -> {
            c_Catagory.add(catagory.getName_catagory());
        });
    }
    // Tính tổng tiền thanh toán
    public int TotalMoney()
    {
        int totalMoney = 0; // tiền thanh toán
        totalMoney = listOrder.stream().map((Order) -> Order.getMoney()).reduce(totalMoney, Integer::sum);
        return totalMoney;
    }
    
    
    
    public FrmSale() throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        LoadListCommic();
        LoadChoicePublisher();
        LoadChoiceCatagory();
        LoadTableOrder();
         
        String date = sdf.format(new Date()); // lấy ngày tháng năm hiện tại
        lb_Date.setText(date); // lấy ngày tháng hiện tại trong java
        
        txt_Promotion.setDocument(new DigitDocument());// chỉ cho phép nhập số vào textfiled
        txt_Persent.setDocument(new DigitDocument()); // chỉ cho phép nhập số vào textfiled
        
        tb_ComicSale.getTableHeader().setOpaque(false);
        tb_ComicSale.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        tb_ComicSale.getTableHeader().setForeground(new Color(0, 153, 153));
        tb_ComicSale.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        Border border = BorderFactory.createLineBorder(new Color(0, 153, 153));
        tb_ComicSale.getTableHeader().setBorder(border);
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_Exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ComicSale = new javax.swing.JTable();
        c_Publisher = new java.awt.Choice();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txt_Search = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Order = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lb_TotalMoney = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Promotion = new javax.swing.JTextField();
        txt_Persent = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lb_PayMoney = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_PrintBill = new javax.swing.JButton();
        btn_Pay = new javax.swing.JButton();
        btn_ClearBill = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_NameCustomer = new javax.swing.JTextField();
        lb_Date = new javax.swing.JLabel();
        txt_Note = new javax.swing.JTextField();
        c_Catagory = new java.awt.Choice();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_AddOrder = new javax.swing.JLabel();
        btn_DeleteOrder = new javax.swing.JLabel();
        btn_AddQuantity = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_MinusOrder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1119, 782));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_sale_96px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quản Lí Bán Hàng");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        btn_Exit.setBackground(new java.awt.Color(0, 153, 153));
        btn_Exit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
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
        jPanel1.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 50, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tb_ComicSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_ComicSale.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_ComicSale.setFillsViewportHeight(true);
        tb_ComicSale.setFocusable(false);
        tb_ComicSale.setGridColor(new java.awt.Color(255, 255, 255));
        tb_ComicSale.setOpaque(false);
        tb_ComicSale.setRowHeight(35);
        tb_ComicSale.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_ComicSale.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_ComicSale.setShowVerticalLines(false);
        tb_ComicSale.getTableHeader().setReorderingAllowed(false);
        tb_ComicSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_ComicSaleMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ComicSale);

        c_Publisher.setFocusable(false);
        c_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_Publisher.setMinimumSize(new java.awt.Dimension(30, 35));
        c_Publisher.setName(""); // NOI18N
        c_Publisher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_PublisherItemStateChanged(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator1.setFocusable(true);
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 3));
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(40, 20));
        jSeparator1.setRequestFocusEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_24px.png"))); // NOI18N

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

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOpaque(true);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 3));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOpaque(true);
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 3));

        jScrollPane2.setBorder(null);

        tb_Order.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Conan", "2", "5000", "10000"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Truyện", "Số Lượng", "Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Order.setFocusable(false);
        tb_Order.setRowHeight(20);
        tb_Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_OrderMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Order);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tổng Tiền : ");

        lb_TotalMoney.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TotalMoney.setForeground(new java.awt.Color(153, 0, 0));
        lb_TotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TotalMoney.setText("0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("VNĐ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giảm Giá : ");

        txt_Promotion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Promotion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Promotion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_Promotion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PromotionKeyReleased(evt);
            }
        });

        txt_Persent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Persent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Persent.setToolTipText("");
        txt_Persent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_Persent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PersentKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Thành Tiền : ");

        lb_PayMoney.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_PayMoney.setForeground(new java.awt.Color(0, 153, 0));
        lb_PayMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_PayMoney.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("VNĐ");

        btn_PrintBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_bill_24px.png"))); // NOI18N
        btn_PrintBill.setText("In Hóa Đơn");
        btn_PrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintBillActionPerformed(evt);
            }
        });

        btn_Pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_coins_25px_1.png"))); // NOI18N
        btn_Pay.setText("Thanh Toán");
        btn_Pay.setPreferredSize(new java.awt.Dimension(136, 33));
        btn_Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PayActionPerformed(evt);
            }
        });

        btn_ClearBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_25px.png"))); // NOI18N
        btn_ClearBill.setText("Hủy");
        btn_ClearBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearBillActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_male_25px.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_calendar_24px.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_24px.png"))); // NOI18N

        txt_NameCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_NameCustomer.setText("Nhập tên khách hàng");
        txt_NameCustomer.setBorder(null);
        txt_NameCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_NameCustomerMouseClicked(evt);
            }
        });

        lb_Date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Date.setText("08/03/2019");

        txt_Note.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Note.setText("Ghi Chú");
        txt_Note.setBorder(null);
        txt_Note.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_NoteMouseClicked(evt);
            }
        });

        c_Catagory.setFocusable(false);
        c_Catagory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_Catagory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_CatagoryItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("VNĐ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("%");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("-");

        btn_AddOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_right_squared_50px.png"))); // NOI18N
        btn_AddOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddOrderMouseClicked(evt);
            }
        });

        btn_DeleteOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_left_squared_50px.png"))); // NOI18N
        btn_DeleteOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteOrderMouseClicked(evt);
            }
        });

        btn_AddQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_up_squared_50px.png"))); // NOI18N
        btn_AddQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddQuantityMouseClicked(evt);
            }
        });

        btn_MinusOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_down_squared_50px.png"))); // NOI18N
        btn_MinusOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_MinusOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MinusOrderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(c_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(c_Catagory, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_AddOrder)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_DeleteOrder, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_AddQuantity))
                    .addComponent(jLabel18)
                    .addComponent(btn_MinusOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_PrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ClearBill, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_NameCustomer))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_Date))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Note))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_PayMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(37, 37, 37)
                                .addComponent(txt_Promotion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Persent, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_TotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_NameCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_Catagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(lb_Date))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_AddOrder))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btn_DeleteOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_AddQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_MinusOrder)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lb_TotalMoney)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_Promotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Persent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lb_PayMoney)
                                    .addComponent(jLabel8))
                                .addGap(34, 34, 34)
                                .addComponent(btn_PrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_ClearBill, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txt_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchMouseClicked
        txt_Search.setText("");
    }//GEN-LAST:event_txt_SearchMouseClicked

    // Khi combobox thay đổi thì dữ liệu sẽ thay đổi theo combobox
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
                listCommic = saleModel.getListCommicByIdPublisher(idPublisher);
                LoadTableCommicSale();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_c_PublisherItemStateChanged
    // Khi combobox thay đổi thì dữ liệu sẽ thay đổi theo combobox
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
                listCommic = saleModel.getListCommicByIdCatagory(idCatagory);
                LoadTableCommicSale();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_c_CatagoryItemStateChanged
    // Tìm kiếm
    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        String key = txt_Search.getText();
        try {
            listCommic = saleModel.searchByNameCommic(key);
            LoadTableCommicSale();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_SearchKeyReleased
    // thêm một order
    private void btn_AddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddOrderMouseClicked
        if(dongchon != -1)
        {
            if(listCommic.get(dongchon).getQuantity() < 1)
            {
                JOptionPane.showMessageDialog(null,"Truyện đã hết hàng");
                return;
            }
            for (BillDetail Order : listOrder) {
                if (listCommic.get(dongchon).getId() == Order.getId_commic()) {
                    JOptionPane.showMessageDialog(null,"Truyện đã được thêm vào rồi !");
                    return; 
                }
            }
            BillDetail order = new BillDetail();
            order.setId_commic(listCommic.get(dongchon).getId());
            order.setName_commic(listCommic.get(dongchon).getName_commic());
            order.setPrice(listCommic.get(dongchon).getPrice());
            order.setQuantity_order(1);
            listOrder.add(order);
            LoadTableOrder();
            listCommic.get(dongchon).setQuantity(listCommic.get(dongchon).getQuantity()-1);
            LoadTableCommicSale();
            dongchon = -1;
        }
    }//GEN-LAST:event_btn_AddOrderMouseClicked
    // xóa 1 order
    private void btn_DeleteOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteOrderMouseClicked
        if(dongchon2 != -1)
        {
            try {
                for(Commic commic : listCommic)
                {
                    if(commic.getId() == listOrder.get(dongchon2).getId_commic())
                    {
                        commic.setQuantity(commic.getQuantity() + listOrder.get(dongchon2).getQuantity_order());
                        break;
                    }
                }
                listOrder.remove(dongchon2);
                LoadTableOrder();
                LoadTableCommicSale();
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_btn_DeleteOrderMouseClicked
    // tăng số lượng order
    private void btn_AddQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddQuantityMouseClicked
        if(dongchon2 != -1)
        {
            int quantity = listOrder.get(dongchon2).getQuantity_order();
            for(Commic commic : listCommic)
            {
                if(commic.getId() == listOrder.get(dongchon2).getId_commic())
                {
                    if(commic.getQuantity() > 0)
                    {
                        if(quantity < 10)
                        {
                            commic.setQuantity(commic.getQuantity()- 1);
                            LoadTableCommicSale();           
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Hết hàng");
                        return;
                    }
                    break;
                }
            }
            if(quantity > 9)   
                return;
            listOrder.get(dongchon2).setQuantity_order(quantity+1);
            LoadTableOrder();
        }
    }//GEN-LAST:event_btn_AddQuantityMouseClicked
    // giảm số lượng order
    private void btn_MinusOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MinusOrderMouseClicked
        if(dongchon2 != -1)
        {
            int quantity = listOrder.get(dongchon2).getQuantity_order();
            for(Commic commic : listCommic)
            {
                if(commic.getId() == listOrder.get(dongchon2).getId_commic())
                {
                    if(quantity < 2)
                    {
                        return;
                    }
                    else if(quantity > 0)
                    {
                        commic.setQuantity(commic.getQuantity()+ 1);
                        LoadTableCommicSale();
                        break;
                    }
                }
            }
            if(quantity < 2)
                return;
            listOrder.get(dongchon2).setQuantity_order(quantity-1);
            LoadTableOrder();
        }
    }//GEN-LAST:event_btn_MinusOrderMouseClicked
    // lấy dòng chọn của table commic(bảng to)
    private void tb_ComicSaleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ComicSaleMouseReleased
        dongchon = tb_ComicSale.getSelectedRow();
    }//GEN-LAST:event_tb_ComicSaleMouseReleased
    // lấy dòng chọn của table order(bảng nhỏ)
    private void tb_OrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_OrderMouseReleased
        dongchon2 = tb_Order.getSelectedRow();
    }//GEN-LAST:event_tb_OrderMouseReleased
    // khuyến mãi
    private void txt_PromotionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PromotionKeyReleased
        if(txt_Promotion.getText().equals(""))
        {
            lb_PayMoney.setText(numf.format(TotalMoney())+"");
            return;
        }
        int totalMoney = TotalMoney();
        int promotion = Integer.parseInt(txt_Promotion.getText());
        if(promotion > totalMoney)
        {
            JOptionPane.showMessageDialog(null,"Khuyến mãi không hợp lệ !");
            txt_Promotion.setText("0");
            promotion = 0;
        }
        promotionMoney = promotion;
        lb_PayMoney.setText(numf.format(totalMoney - promotion) + "");

    }//GEN-LAST:event_txt_PromotionKeyReleased
    // khuyễn mãi theo phần trăm
    private void txt_PersentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PersentKeyReleased
        if(txt_Persent.getText().equals(""))
        {
            lb_PayMoney.setText(numf.format(TotalMoney())+"");
            return;
        }
        int persent = Integer.parseInt(txt_Persent.getText());
        int totalMoney = TotalMoney();
        if(persent > 100)
        {
            JOptionPane.showMessageDialog(null,"Khuyễn mãi không hợp lệ");
            txt_Persent.setText("0");
            persent = 0;
        }
        promotionMoney = (totalMoney * persent/100);
        int payMoney = totalMoney - (totalMoney * persent/100);
        lb_PayMoney.setText(numf.format(payMoney)+""); 
    }//GEN-LAST:event_txt_PersentKeyReleased

    private void txt_NameCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_NameCustomerMouseClicked
        txt_NameCustomer.setText("");
    }//GEN-LAST:event_txt_NameCustomerMouseClicked

    private void txt_NoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_NoteMouseClicked
        txt_Note.setText("");
    }//GEN-LAST:event_txt_NoteMouseClicked
    // xóa all order
    private void btn_ClearBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearBillActionPerformed
        listOrder.removeAll(listOrder);
        LoadTableOrder();
        txt_NameCustomer.setText("Nhập tên khách hàng");
        txt_Note.setText("Ghi chú");
    }//GEN-LAST:event_btn_ClearBillActionPerformed
    // thanh toán
    private void btn_PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PayActionPerformed
        if(txt_NameCustomer.getText().equals("") || txt_NameCustomer.getText().equals("Nhập tên khách hàng"))
        {
            JOptionPane.showMessageDialog(null,"Nhập tên khách hàng");
            return;
        }
        int confim;
        confim = JOptionPane.showConfirmDialog(null,"Thanh toán "+lb_PayMoney.getText() +" VNĐ","Thông báo",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
        if(confim == JOptionPane.YES_OPTION) 
        {
            Bill bill = new Bill();
            bill.setName_customer(txt_NameCustomer.getText());
            bill.setName_employee(FrmLogin.inforEmployee.getName_employee());
            SimpleDateFormat sf;
            sf = new SimpleDateFormat("yyyy/MM/dd");
            bill.setDate_order(sf.format(new Date()));
            
            if(txt_Note.getText().equals("Ghi Chú"))
            {
                 bill.setNote("");
            }
            else
            {
                 bill.setNote(txt_Note.getText());
            }
            bill.setTota_money(TotalMoney());
            bill.setPromotion(promotionMoney);
            bill.setIs_delete(0);
            try {
                if(saleModel.Pay(bill,listOrder))
                {
                    listOrder.removeAll(listOrder);
                    LoadTableOrder();
                    txt_NameCustomer.setText("Nhập tên khách hàng");
                    txt_Note.setText("Ghi chú");
                    txt_Promotion.setText("");
                    txt_Persent.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Lỗi");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_btn_PayActionPerformed

    private void btn_PrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintBillActionPerformed
        try {
            if(txt_NameCustomer.getText().equals("")||txt_NameCustomer.getText().equals("Nhập tên khách hàng"))
            {
                JOptionPane.showMessageDialog(this,"Nhập tên khách hàng");
                return;
            }
            if(listOrder.size()== 0)
            {
                JOptionPane.showMessageDialog(this,"Không có truyện được bán");
                return;
            }
            String list = "";
            for(BillDetail od : listOrder)
            {
                String name = od.getName_commic();
                if(od.getName_commic().length()>15)
                    name = name.substring(0,11)+"...";
                list += name+"\t\t"+od.getQuantity_order()+"\t"+od.getPrice()+"\t"+od.getMoney()+"\n";
            }
            
            JTextArea ta_bill = new JTextArea();
            ta_bill.append("\t\tMY STORE \n\n"+
                    "Nhân viên: \t"+FrmLogin.inforEmployee.getName_employee()+"\n"+
                    "Khách hàng: \t"+txt_NameCustomer.getText()+"\n"+
                    "Ngày : \t"+lb_Date.getText()+
                    "\n================================================\n"+
                    "Tên truyện\t\tSố Lượng\tĐơn Giá\tThành Tiền\n"+
                    list+
                    "\n================================================\n"+
                    "Tổng cộng: \t"+lb_TotalMoney.getText()+"\n"+
                    "Khuyến Mãi: \t"+numf.format(promotionMoney)+"\n"+
                    "Thành Tiền: \t"+lb_PayMoney.getText()
            );
            ta_bill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_PrintBillActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmSale().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(FrmSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_AddOrder;
    private javax.swing.JLabel btn_AddQuantity;
    private javax.swing.JButton btn_ClearBill;
    private javax.swing.JLabel btn_DeleteOrder;
    private javax.swing.JLabel btn_Exit;
    private javax.swing.JLabel btn_MinusOrder;
    private javax.swing.JButton btn_Pay;
    private javax.swing.JButton btn_PrintBill;
    private java.awt.Choice c_Catagory;
    private java.awt.Choice c_Publisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lb_Date;
    private javax.swing.JLabel lb_PayMoney;
    private javax.swing.JLabel lb_TotalMoney;
    private javax.swing.JTable tb_ComicSale;
    private javax.swing.JTable tb_Order;
    private javax.swing.JTextField txt_NameCustomer;
    private javax.swing.JTextField txt_Note;
    private javax.swing.JTextField txt_Persent;
    private javax.swing.JTextField txt_Promotion;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
