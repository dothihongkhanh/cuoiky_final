/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;;

import MODEL.QL_KhachHang_212;
import MODEL.QL_SanPham_211;
import SERVICE.QLSanPham_Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khanhle
 */
public class QL_SanPham_JPanelForm extends javax.swing.JPanel {
      private List<QL_SanPham_211> list = new ArrayList<>();
        DefaultTableModel defaultTableModel;
        QLSanPham_Service spService;
        QL_SanPham_211 sp;
    /**
     * Creates new form QuanLy_SanPhamForm
     */
    public QL_SanPham_JPanelForm() throws SQLException {
        initComponents();
        spService = new QLSanPham_Service();
        sp = new QL_SanPham_211();

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tblSanPham_211.setModel(defaultTableModel);

        defaultTableModel.addColumn("MaSP");
        defaultTableModel.addColumn("TenSP");
        defaultTableModel.addColumn("DonGiaBan");
        defaultTableModel.addColumn("SoLuongHienCon");
        setTableData(spService.getAllUsers());

    }

     private void btnThem_211ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        if (txtTenSP_211.getText().equals("") || txtDonGiaBan_211.getText().equals("") || txtSoLuongHienCon_211.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
        } else {
            try {
                sp.setTenSP_211(txtTenSP_211.getText());
                sp.setDonGiaBan_211(txtDonGiaBan_211.getText());
                sp.setSoLuongHienCon_211(txtSoLuongHienCon_211.getText());
               
                spService.addSP(sp);
                defaultTableModel.setRowCount(0);
                setTableData(spService.getAllUsers());
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(QL_SanPham_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
    }   
     
      private void btnSua_211ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thay đổi không?");
        if (x == JOptionPane.NO_OPTION) {
            return;
        } else {
           
            try {
                QL_SanPham_211 sp = new QL_SanPham_211();
                sp.setMaSP_211(Integer.parseInt(txtMaSP_211.getText()));
                sp.setTenSP_211(txtTenSP_211.getText());
                sp.setDonGiaBan_211(txtDonGiaBan_211.getText());
                sp.setSoLuongHienCon_211(txtSoLuongHienCon_211.getText());                                
                spService.updateSP(sp);
                defaultTableModel.setRowCount(0);
                setTableData(spService.getAllUsers());
            } catch (SQLException ex) {
                Logger.getLogger(QL_KhachHang_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
    }  
      private void btnXoa_211ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        int row = tblSanPham_211.getSelectedRow();
        if (row == -1)//nguoi dung chua chon hang nao
        {
            JOptionPane.showMessageDialog(QL_SanPham_JPanelForm.this, "Vui lòng chọn sản phẩm cần xóa trước", "Lỗi", JOptionPane.ERROR_MESSAGE);

        } else {
            int confirm = JOptionPane.showConfirmDialog(QL_SanPham_JPanelForm.this, "Bạn chắc chắn muốn xóa không?");
            if (confirm == JOptionPane.YES_OPTION) {

                try {
                    int spId = Integer.valueOf(String.valueOf(tblSanPham_211.getValueAt(row, 0)));

                    spService.deleteSP(spId);

                    defaultTableModel.setRowCount(0);//de xoa het du lieu hien tai
                    setTableData(spService.getAllUsers());
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                } catch (SQLException ex) {
                    Logger.getLogger(QL_SanPham_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }          
    private void setTableData(List<QL_SanPham_211> sanpham) {
         for (QL_SanPham_211 sp : sanpham) {
            defaultTableModel.addRow(new Object[]{sp.getMaSP_211(), sp.getTenSP_211(), sp.getDonGiaBan_211(), sp.getSoLuongHienCon_211()});
 //To change body of generated methods, choose Tools | Templates.
         }
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    private void btnLamMoi_211ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        txtTenSP_211.setText("");
        txtDonGiaBan_211.setText("");
        txtSoLuongHienCon_211.setText("");
        
    }                                           
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham_211 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnLamMoi_211 = new javax.swing.JButton();
        txtMaSP_211 = new java.awt.TextField();
        txtTenSP_211 = new java.awt.TextField();
        txtDonGiaBan_211 = new java.awt.TextField();
        btnSua_211 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSoLuongHienCon_211 = new java.awt.TextField();
        btnXoa_211 = new javax.swing.JButton();
        btnthem_211 = new javax.swing.JButton();

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        setBackground(new java.awt.Color(204, 204, 204));
        setName("QL_SanPham_211"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tblSanPham_211.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá Bán", "Số Lượng Hiện Còn"
            }
        ));
        tblSanPham_211.setName("tblSanPham_211"); // NOI18N
        jScrollPane1.setViewportView(tblSanPham_211);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setText("Đơn Giá Bán");

        btnLamMoi_211.setBackground(new java.awt.Color(153, 153, 255));
        btnLamMoi_211.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnLamMoi_211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/refresh.png"))); // NOI18N
        btnLamMoi_211.setText("Làm mới");
        btnLamMoi_211.setName("Lammoi_211"); // NOI18N
        btnLamMoi_211.setPreferredSize(new java.awt.Dimension(125, 50));

        txtMaSP_211.setName("maSP_211"); // NOI18N
        txtMaSP_211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSP_211ActionPerformed(evt);
            }
        });

        txtTenSP_211.setName("tenSP_211"); // NOI18N

        txtDonGiaBan_211.setName("gia_211"); // NOI18N

        btnSua_211.setBackground(new java.awt.Color(153, 153, 255));
        btnSua_211.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnSua_211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/sua.png"))); // NOI18N
        btnSua_211.setText("Sửa");
        btnSua_211.setName("Sua_211"); // NOI18N
        btnSua_211.setPreferredSize(new java.awt.Dimension(125, 50));

        jLabel2.setText("Tên Sản Phẩm");

        jLabel5.setText("Số Lượng Hiện Còn");

        jLabel1.setText("Mã Sản Phẩm");

        txtSoLuongHienCon_211.setName("SLHienCon_211"); // NOI18N

        btnXoa_211.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnXoa_211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/xoa.png"))); // NOI18N
        btnXoa_211.setText("Xóa");

        btnthem_211.setText("Thêm ");
        btnthem_211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthem_211ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                            .addComponent(btnXoa_211, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnthem_211)
                        .addGap(23, 23, 23)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSoLuongHienCon_211, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(txtDonGiaBan_211, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTenSP_211, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLamMoi_211, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(btnSua_211, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaSP_211, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSP_211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenSP_211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDonGiaBan_211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuongHienCon_211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSua_211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem_211))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLamMoi_211, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa_211, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSP_211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSP_211ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSP_211ActionPerformed

    private void btnthem_211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthem_211ActionPerformed
        // TODO add your handling code here:
        txtMaSP_211.setEnabled(false);
        if (txtSoLuongHienCon_211.getText().equals("") || txtTenSP_211.getText().equals("") || txtDonGiaBan_211.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
        } else {
            try {
                sp.setTenSP_211(txtTenSP_211.getText());
                sp.setDonGiaBan_211(txtDonGiaBan_211.getText());
                sp.setSoLuongHienCon_211(txtSoLuongHienCon_211.getText());
                

                spService.addSP(sp);
                defaultTableModel.setRowCount(0);
                setTableData(spService.getAllUsers());
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(QL_KhachHang_JPanelForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnthem_211ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi_211;
    private javax.swing.JButton btnSua_211;
    private javax.swing.JButton btnXoa_211;
    private javax.swing.JButton btnthem_211;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSanPham_211;
    private java.awt.TextField txtDonGiaBan_211;
    private java.awt.TextField txtMaSP_211;
    private java.awt.TextField txtSoLuongHienCon_211;
    private java.awt.TextField txtTenSP_211;
    // End of variables declaration//GEN-END:variables
}
