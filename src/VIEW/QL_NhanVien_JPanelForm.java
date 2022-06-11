/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VIEW;

/**
 *
 * @author DELL
 */

import MODEL.QL_NhanVien_239;
import SERVICE.QLNhanVien_Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QL_NhanVien_JPanelForm extends javax.swing.JPanel {

    private List<QL_NhanVien_239> list = new ArrayList<>();
    DefaultTableModel defaultTableModel;
    QLNhanVien_Service nvService;
    QL_NhanVien_239 nv;

    public QL_NhanVien_JPanelForm() throws SQLException {
        initComponents();
        maNV_239.setEnabled(false);
        nvService = new QLNhanVien_Service();
        nv = new QL_NhanVien_239();

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tblNhanVien_239.setModel(defaultTableModel);

        defaultTableModel.addColumn("MaNV");
        defaultTableModel.addColumn("TenNV");
        defaultTableModel.addColumn("VaiTro");
        defaultTableModel.addColumn("DiaChi");
        defaultTableModel.addColumn("SoDienThoai");
        defaultTableModel.addColumn("NgaySinh");
        defaultTableModel.addColumn("GioiTinh");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("TrangThai");
        setTableData(nvService.getAllUsers());     
       

    }

    private void setTableData(List<QL_NhanVien_239> nhanvien) {
        for (QL_NhanVien_239 nv : nhanvien) {
            defaultTableModel.addRow(new Object[]{nv.getMaNV_239(), nv.getTenNV_239(), nv.getVaiTro_239(), nv.getDiaChi_239(), nv.getDienthoai_239(),nv.getNgaySinh_239(),nv.getGioiTinh_239(),nv.getEmail_239(),nv.getTrangThai_239()});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JPanelTTNV = new javax.swing.JPanel();
        jLabel2_239 = new javax.swing.JLabel();
        jLabel3_239 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tenNV_239 = new javax.swing.JTextField();
        diaChi_239 = new javax.swing.JTextField();
        labelDienthoai_239 = new javax.swing.JLabel();
        labelNgaysinh_239 = new javax.swing.JLabel();
        label_Email_239 = new javax.swing.JLabel();
        label_Gioitinh_239 = new javax.swing.JLabel();
        label_Trangthai_239 = new javax.swing.JLabel();
        rdobtnDanglamviec_239 = new javax.swing.JRadioButton();
        rdobtnNghiviec_239 = new javax.swing.JRadioButton();
        rdobtnNam_239 = new javax.swing.JRadioButton();
        rdobtnNu_239 = new javax.swing.JRadioButton();
        email_239 = new javax.swing.JTextField();
        ngaysinh_239 = new javax.swing.JTextField();
        dienthoai_239 = new javax.swing.JTextField();
        btThem_239 = new javax.swing.JButton();
        btSua_239 = new javax.swing.JButton();
        btLammoi_239 = new javax.swing.JButton();
        btXoa_239 = new javax.swing.JButton();
        vaitro_239 = new javax.swing.JTextField();
        MaNV_239 = new javax.swing.JLabel();
        maNV_239 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12_239 = new javax.swing.JLabel();
        jComboBox4_239 = new javax.swing.JComboBox<>();
        jLabel10_239 = new javax.swing.JLabel();
        Loc_239 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien_239 = new javax.swing.JTable();

        jRadioButton1.setText("jRadioButton1");

        setBackground(new java.awt.Color(204, 255, 204));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        JPanelTTNV.setBackground(new java.awt.Color(204, 255, 204));
        JPanelTTNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết lập thông tin nhân viên"));
        JPanelTTNV.setLayout(new java.awt.GridBagLayout());

        jLabel2_239.setText("Tên NV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 82, 0, 0);
        JPanelTTNV.add(jLabel2_239, gridBagConstraints);

        jLabel3_239.setText("Vai trò");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 81, 0, 0);
        JPanelTTNV.add(jLabel3_239, gridBagConstraints);

        jLabel4.setText("Địa chỉ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 81, 0, 0);
        JPanelTTNV.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        JPanelTTNV.add(tenNV_239, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 8, 0, 0);
        JPanelTTNV.add(diaChi_239, gridBagConstraints);

        labelDienthoai_239.setText("Điện thoại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 81, 0, 0);
        JPanelTTNV.add(labelDienthoai_239, gridBagConstraints);

        labelNgaysinh_239.setText("Ngày sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 111, 0, 0);
        JPanelTTNV.add(labelNgaysinh_239, gridBagConstraints);

        label_Email_239.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 111, 0, 0);
        JPanelTTNV.add(label_Email_239, gridBagConstraints);

        label_Gioitinh_239.setText("Giới tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 111, 0, 0);
        JPanelTTNV.add(label_Gioitinh_239, gridBagConstraints);

        label_Trangthai_239.setText("Trạng thái");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 109, 0, 0);
        JPanelTTNV.add(label_Trangthai_239, gridBagConstraints);

        buttonGroup1.add(rdobtnDanglamviec_239);
        rdobtnDanglamviec_239.setText("Đang làm việc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 18, 0, 0);
        JPanelTTNV.add(rdobtnDanglamviec_239, gridBagConstraints);

        buttonGroup1.add(rdobtnNghiviec_239);
        rdobtnNghiviec_239.setText("Nghỉ việc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 18, 0, 0);
        JPanelTTNV.add(rdobtnNghiviec_239, gridBagConstraints);

        buttonGroup2.add(rdobtnNam_239);
        rdobtnNam_239.setText("Nam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        JPanelTTNV.add(rdobtnNam_239, gridBagConstraints);

        buttonGroup2.add(rdobtnNu_239);
        rdobtnNu_239.setText("Nữ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        JPanelTTNV.add(rdobtnNu_239, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 188;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 178);
        JPanelTTNV.add(email_239, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 188;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 18, 0, 178);
        JPanelTTNV.add(ngaysinh_239, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        JPanelTTNV.add(dienthoai_239, gridBagConstraints);

        btThem_239.setBackground(new java.awt.Color(153, 153, 255));
        btThem_239.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThem_239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/plus.png"))); // NOI18N
        btThem_239.setText("Thêm");
        btThem_239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThem_239ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 64, 17, 0);
        JPanelTTNV.add(btThem_239, gridBagConstraints);

        btSua_239.setBackground(new java.awt.Color(153, 153, 255));
        btSua_239.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSua_239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/sua.png"))); // NOI18N
        btSua_239.setText("Sửa");
        btSua_239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSua_239ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 1, 17, 0);
        JPanelTTNV.add(btSua_239, gridBagConstraints);

        btLammoi_239.setBackground(new java.awt.Color(153, 153, 255));
        btLammoi_239.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLammoi_239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/refresh.png"))); // NOI18N
        btLammoi_239.setText("Làm mới");
        btLammoi_239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLammoi_239ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 18, 17, 0);
        JPanelTTNV.add(btLammoi_239, gridBagConstraints);

        btXoa_239.setBackground(new java.awt.Color(153, 153, 255));
        btXoa_239.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btXoa_239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/xoa.png"))); // NOI18N
        btXoa_239.setText("Xóa");
        btXoa_239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoa_239ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 18, 17, 178);
        JPanelTTNV.add(btXoa_239, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 0);
        JPanelTTNV.add(vaitro_239, gridBagConstraints);

        MaNV_239.setText("Mã NV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 82, 0, 0);
        JPanelTTNV.add(MaNV_239, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 10, 0, 0);
        JPanelTTNV.add(maNV_239, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelTTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JPanelTTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel12_239.setText("Lọc theo vai  trò");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 87, 6, 0);
        jPanel3.add(jLabel12_239, gridBagConstraints);

        jComboBox4_239.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên kho", "Nhân viên bán hàng", "Nhân viên giữ xe", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(44, 35, 0, 0);
        jPanel3.add(jComboBox4_239, gridBagConstraints);

        jLabel10_239.setText("Lọc theo giới tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 92, 0, 0);
        jPanel3.add(jLabel10_239, gridBagConstraints);

        Loc_239.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam ", "Nữ", " " }));
        Loc_239.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Loc_239ItemStateChanged(evt);
            }
        });
        Loc_239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loc_239ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(44, 32, 0, 300);
        jPanel3.add(Loc_239, gridBagConstraints);

        tblNhanVien_239.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "Vai trò", "Địa chỉ", "Điện thoại", "Ngảy sinh", "Giới tính", "Email", "Trạng thái"
            }
        ));
        tblNhanVien_239.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVien_239MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien_239);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 869, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 615, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThem_239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThem_239ActionPerformed
        // TODO add your handling code here:
        maNV_239.setEnabled(false);
        if (tenNV_239.getText().equals("") || dienthoai_239.getText().equals("") || diaChi_239.getText().equals("")|| vaitro_239.getText().equals("") || email_239.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
        } else {
            try {

                nv.setTenNV_239(tenNV_239.getText());
                nv.setDiaChi_239(diaChi_239.getText());
                nv.setDienthoai_239(dienthoai_239.getText());
                nv.setVaiTro_239(vaitro_239.getText());
                nv.setNgaySinh_239(ngaysinh_239.getText());

                //////EMAIL
                nv.setEmail_239(email_239.getText());

                /////

                String gt = "Nam";
                if (rdobtnNam_239.isSelected()) {
                    gt = "Nam";// lua chon 1 trong 2
                }
                if (rdobtnNu_239.isSelected()) {
                    gt = "Nữ";
                }
                nv.setGioiTinh_239(gt);

                String tt = "Đang làm việc ";
                if (rdobtnDanglamviec_239.isSelected()) {
                    tt = "Đang làm việc";// lua chon 1 trong 2
                }
                if (rdobtnNghiviec_239.isSelected()) {
                    tt = "Nghỉ việc";
                }
                nv.setTrangThai_239(tt);

                nvService.addNV(nv);
                defaultTableModel.setRowCount(1);
                setTableData(nvService.getAllUsers());
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(QL_NhanVien_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btThem_239ActionPerformed

    private void tblNhanVien_239MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVien_239MouseClicked
        // TODO add your handling code here:
         int i = tblNhanVien_239.getSelectedRow();
        maNV_239.setText(tblNhanVien_239.getValueAt(i,0).toString());
        tenNV_239.setText(tblNhanVien_239.getValueAt(i,1).toString());
        vaitro_239.setText(tblNhanVien_239.getValueAt(i,2).toString());
        diaChi_239.setText(tblNhanVien_239.getValueAt(i,3).toString());
        dienthoai_239.setText(tblNhanVien_239.getValueAt(i,4).toString());
        ngaysinh_239.setText(tblNhanVien_239.getValueAt(i,5).toString());
        email_239.setText(tblNhanVien_239.getValueAt(i,7).toString());
        String gioitinh = tblNhanVien_239.getValueAt(i,6).toString();
        if (gioitinh.equalsIgnoreCase("Nam")){
            rdobtnNam_239.setSelected(true);
            rdobtnNu_239.setSelected(false);
        }
        else{
            rdobtnNu_239.setSelected(true);
            rdobtnNam_239.setSelected(false);
        }
        String trangthai = tblNhanVien_239.getValueAt(i,8).toString();
        if (trangthai.equalsIgnoreCase("Đang làm việc")){
            rdobtnDanglamviec_239.setSelected(true);
            rdobtnNghiviec_239.setSelected(false);
        }
        else{
            rdobtnNghiviec_239.setSelected(true);
            rdobtnDanglamviec_239.setSelected(false);
        }
        
       
       
        
        
    }//GEN-LAST:event_tblNhanVien_239MouseClicked

    private void btLammoi_239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLammoi_239ActionPerformed
        // TODO add your handling code here:
        maNV_239.setText("");
        tenNV_239.setText("");
        dienthoai_239.setText("");
        diaChi_239.setText("");
        vaitro_239.setText("");
        email_239.setText("");
        ngaysinh_239.setText("");        
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_btLammoi_239ActionPerformed

    private void btXoa_239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoa_239ActionPerformed
        // TODO add your handling code here:
        int row = tblNhanVien_239.getSelectedRow();
        if (row == -1)//nguoi dung chua chon hang nao
        {
            JOptionPane.showMessageDialog(QL_NhanVien_JPanelForm.this, "Vui lòng chọn nhân viên cần xóa trước", "Lỗi", JOptionPane.ERROR_MESSAGE);

        } else {
            int confirm = JOptionPane.showConfirmDialog(QL_NhanVien_JPanelForm.this, "Bạn chắc chắn muốn xóa không?");
            if (confirm == JOptionPane.YES_OPTION) {

                try {
                    int nvId = Integer.valueOf(String.valueOf(tblNhanVien_239.getValueAt(row, 0)));

                    nvService.deleteNV(nvId);

                    defaultTableModel.setRowCount(0);//de xoa het du lieu hien tai
                    setTableData(nvService.getAllUsers());
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                } catch (SQLException ex) {
                    Logger.getLogger(QL_NhanVien_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_btXoa_239ActionPerformed

    private void btSua_239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSua_239ActionPerformed
 // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thay đổi không?");
        if (x == JOptionPane.NO_OPTION) {
            return;
        } else {

            try {
                QL_NhanVien_239 nv = new QL_NhanVien_239();
                nv.setMaNV_239(Integer.parseInt(maNV_239.getText()));
                nv.setTenNV_239(tenNV_239.getText());
                nv.setDiaChi_239(diaChi_239.getText());
                nv.setDienthoai_239(dienthoai_239.getText());
                nv.setVaiTro_239(vaitro_239.getText());
                nv.setEmail_239(email_239.getText());
                nv.setNgaySinh_239(ngaysinh_239.getText());

                String gioiTinh_239 = "Nam";
                if (rdobtnNam_239.isSelected()) {
                    gioiTinh_239 = "Nam";// lua chon 1 trong 2
                }
                if (rdobtnNu_239.isSelected()) {
                    gioiTinh_239 = "Nữ";
                }
                nv.setGioiTinh_239(gioiTinh_239);

                String trangThai_239 = "Đang làm việc";
                if (rdobtnDanglamviec_239.isSelected()) {
                    trangThai_239 = "Đang làm việc";// lua chon 1 trong 2
                }
                if (rdobtnNghiviec_239.isSelected()) {
                    trangThai_239 = "Nghỉ việc";
                }
                nv.setTrangThai_239(trangThai_239);

                nvService.updateNV(nv);
                defaultTableModel.setRowCount(0);
                setTableData(nvService.getAllUsers());
                JOptionPane.showMessageDialog(this, "Sửa thông tin nhân viên thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(QL_NhanVien_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btSua_239ActionPerformed

    private void Loc_239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc_239ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Loc_239ActionPerformed

    private void Loc_239ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Loc_239ItemStateChanged
         // TODO add your handling code here:
       Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=QUANLITHIETBICONGNGHE_KLN", "sa", "123456");
            // Câu lệnh xem dữ liệu
            String sql = "select * from NhanVien ";
            // Nếu tìm kiếm theo title

            sql = sql + " where gioiTinh like '%" + Loc_239.getSelectedItem() + "%'";

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();
            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            defaultTableModel.setRowCount(0);

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt("maNV"));
                data.add(rs.getString("tenNV"));
                data.add(rs.getString("vaiTro"));
                data.add(rs.getString("SDT"));
                data.add(rs.getString("ngaySinh"));
                data.add(rs.getString("gioiTinh"));
                data.add(rs.getString("email"));
                data.add(rs.getString("trangThai"));

                // Thêm một dòng vào table model
                defaultTableModel.addRow(data);
            }
            tblNhanVien_239.setModel(defaultTableModel); // Thêm dữ liệu vào table
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_Loc_239ItemStateChanged

    private void ngaysinh_239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaysinh_239ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaysinh_239ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelTTNV;
    private javax.swing.JComboBox<String> Loc_239;
    private javax.swing.JLabel MaNV_239;
    private javax.swing.JButton btLammoi_239;
    private javax.swing.JButton btSua_239;
    private javax.swing.JButton btThem_239;
    private javax.swing.JButton btXoa_239;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField diaChi_239;
    private javax.swing.JTextField dienthoai_239;
    private javax.swing.JTextField email_239;
    private javax.swing.JComboBox<String> jComboBox4_239;
    private javax.swing.JLabel jLabel10_239;
    private javax.swing.JLabel jLabel12_239;
    private javax.swing.JLabel jLabel2_239;
    private javax.swing.JLabel jLabel3_239;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDienthoai_239;
    private javax.swing.JLabel labelNgaysinh_239;
    private javax.swing.JLabel label_Email_239;
    private javax.swing.JLabel label_Gioitinh_239;
    private javax.swing.JLabel label_Trangthai_239;
    private javax.swing.JTextField maNV_239;
    private javax.swing.JTextField ngaysinh_239;
    private javax.swing.JRadioButton rdobtnDanglamviec_239;
    private javax.swing.JRadioButton rdobtnNam_239;
    private javax.swing.JRadioButton rdobtnNghiviec_239;
    private javax.swing.JRadioButton rdobtnNu_239;
    private javax.swing.JTable tblNhanVien_239;
    private javax.swing.JTextField tenNV_239;
    private javax.swing.JTextField vaitro_239;
    // End of variables declaration//GEN-END:variables
}
