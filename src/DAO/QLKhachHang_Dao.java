/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.QL_KhachHang_212;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class QLKhachHang_Dao {
    public List<QL_KhachHang_212> getAllUsers() throws SQLException {
        List<QL_KhachHang_212> khachhang = new ArrayList<QL_KhachHang_212>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM KhachHang";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                QL_KhachHang_212 kh = new QL_KhachHang_212();
                kh.setMaKH_212(rs.getInt("MAKH"));
                kh.setHoTen_212(rs.getString("TENKH"));
                kh.setDiachi_212(rs.getString("DIACHI"));
                kh.setSdt_212(rs.getString("SDT"));
                kh.setGioiTinh_212(rs.getString("GIOITINH"));
              
                khachhang.add(kh);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachhang;

    }

    public void addKH(QL_KhachHang_212 kh) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO KhachHang ( TENKH, DIACHI, SDT, GIOITINH) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, kh.getHoTen_212());
            pstmt.setString(2, kh.getDiachi_212());
            pstmt.setString(3, kh.getSdt_212());
            pstmt.setString(4, kh.getGioiTinh_212());             

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateKH(QL_KhachHang_212 kh) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE KhachHang SET TENKH = ?, DIACHI = ?, SDT = ?,GIOITINH = ? WHERE MAKH =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kh.getHoTen_212());
            preparedStatement.setString(2, kh.getDiachi_212());
            preparedStatement.setString(3, kh.getSdt_212());
            preparedStatement.setString(4, kh.getGioiTinh_212());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKH(int id) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "delete from KhachHang where MAKH = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
}
