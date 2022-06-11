/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author DELL
 */
import MODEL.QL_NhanVien_239;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class QLNhanVien_Dao {
    public List<QL_NhanVien_239> getAllUsers() throws SQLException {
        List<QL_NhanVien_239> nhanvien = new ArrayList<QL_NhanVien_239>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM NhanVien";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                QL_NhanVien_239 nv = new QL_NhanVien_239();
                nv.setMaNV_239(rs.getInt("MANV"));
                nv.setTenNV_239(rs.getString("TENNV"));
                nv.setVaiTro_239(rs.getString("VAITRO"));
                nv.setDiaChi_239(rs.getString("DIACHI"));
                nv.setDienthoai_239(rs.getString("SDT"));
                nv.setNgaySinh_239(rs.getString("NGAYSINH"));
                nv.setGioiTinh_239(rs.getString("GIOITINH"));
                nv.setEmail_239(rs.getString("EMAIL"));
                nv.setTrangThai_239(rs.getString("TRANGTHAI"));
              
                nhanvien.add(nv);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvien;

    }

    public void addNV(QL_NhanVien_239 nv) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO NhanVien ( TENNV, VAITRO,  DIACHI, SDT, NGAYSINH, GIOITINH, EMAIL,  TRANGTHAI ) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nv.getTenNV_239());
            pstmt.setString(2, nv.getVaiTro_239()); 
            pstmt.setString(3, nv.getDiaChi_239());
            pstmt.setString(4, nv.getDienthoai_239());  
            pstmt.setString(5, nv.getNgaySinh_239());  
            pstmt.setString(6, nv.getGioiTinh_239()); 
            pstmt.setString(7, nv.getEmail_239());  
            pstmt.setString(8, nv.getTrangThai_239());  

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateNV(QL_NhanVien_239 nv) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE NhanVien SET TENNV = ?, VAITRO = ?, DIACHI = ?, SDT = ?, NGAYSINH =?,GIOITINH = ?,EMAIL = ?,TRANGTHAI = ? WHERE MANV =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTenNV_239());
            preparedStatement.setString(2, nv.getVaiTro_239());
            preparedStatement.setString(3, nv.getDiaChi_239());
            preparedStatement.setString(4, nv.getDienthoai_239());
            preparedStatement.setString(5, nv.getNgaySinh_239());
            preparedStatement.setString(6, nv.getGioiTinh_239());
            preparedStatement.setString(7, nv.getEmail_239());
            preparedStatement.setString(8, nv.getTrangThai_239());
            preparedStatement.setInt(9, nv.getMaNV_239());
           
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNV(int id) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "delete from NhanVien where MANV = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
}

