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
                nv.setmaNV_239(rs.getInt("MANV"));
                nv.settenNV_239(rs.getString("TENNV"));
                nv.setdiaChi_239(rs.getString("DIACHI"));
                nv.setdienthoai_239(rs.getString("SDT"));
                nv.setgioiTinh_239(rs.getString("GIOITINH"));
                nv.setemail_239(rs.getString("EMAIL"));
                nv.setvaiTro_239(rs.getString("VAITRO"));
                nv.ngaySinh_239(rs.getString("NGAYSINH"));
                nv.trangThai_239(rs.getString("TRANGTHAI"));
              
                nhanvien.add(nv);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvien;

    }

    public void addNV(QL_NhanVien_239 phong) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO NhanVien ( TENNV, DIACHI, SDT, GIOITINH, VAITRO, EMAIL, TRANGTHAI, NGAYSINH ) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phong.gethoTen_239());
            pstmt.setString(2, phong.getdiaChi_239());
            pstmt.setString(3, phong.getdienthoai_239());
            pstmt.setString(4, phong.getgioiTinh_239());  
            pstmt.setString(5, phong.getvaiTro_239());  
            pstmt.setString(6, phong.getemail_239());  
            pstmt.setString(7, phong.gettrangThai_239());  
            pstmt.setString(8, phong.getngaySinh_239());  

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateNV(QL_NhanVien_239 nv) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE NhanVien SET TENNV = ?, DIACHI = ?, SDT = ?,GIOITINH = ?,VAITRO = ?,EMAIL = ?,TRANGTHAI = ?,NGAYSINH =? WHERE MAKH =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nv.gethoTen_239());
            preparedStatement.setString(2, nv.getdiaChi_239());
            preparedStatement.setString(3, nv.getdienthoai_239());
            preparedStatement.setString(4, nv.getgioiTinh_239());
            preparedStatement.setString(5, nv.getvaiTro_239());
            preparedStatement.setString(6, nv.getemail_239());
            preparedStatement.setString(7, nv.gettrangThai_239());
            preparedStatement.setString(8, nv.getngaySinh_239());
           
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNV(int id) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "delete from NhanVien where MAKH = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
}

