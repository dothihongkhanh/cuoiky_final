/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.QL_HoaDon_229;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QLHoaDon_Dao {
    public List<QL_HoaDon_229> getAllUsers() throws SQLException {
        List<QL_HoaDon_229> khachhang = new ArrayList<QL_HoaDon_229>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM HoaDon";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                QL_HoaDon_229 kh = new QL_HoaDon_229();
                kh.setMaDH_229(rs.getInt("MADH"));
                kh.setNgayTaoDH_229(rs.getString("NGAYTAODONHANG"));
                kh.setDiaChiGiaoHang_229(rs.getString("DIACHIGIAOHANG"));
                kh.setPhuongThucThanhToan_229(rs.getString("PHUONGTHUCTHANHTOAN"));
                kh.setThoiGianThanhToan_229(rs.getString("THOIGIANTHANHTOAN"));
                kh.setThoiGianGiaoHang_229(rs.getString("THOIGIANGIAOHANG"));
                kh.setMaKH_229(rs.getString("MAKH"));
                kh.setMaNV_229(rs.getString("MANV"));
                kh.setMaKM_229(rs.getString("MAKM"));
              
                khachhang.add(kh);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachhang;

    }

    public void addDH(QL_HoaDon_229 phong) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO KhachHang ( TENKH, DIACHI, SDT, GIOITINH) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phong.getNgayTaoDH_229());
            pstmt.setString(2, phong.getDiaChiGiaoHang_229());
            pstmt.setString(3, phong.getPhuongThucThanhToan_229());
            pstmt.setString(4, phong.getThoiGianThanhToan_229()); 
            pstmt.setString(5, phong.getThoiGianGiaoHang_229());
            pstmt.setString(6, phong.getMaKH_229());
            pstmt.setString(7, phong.getMaNV_229());
            pstmt.setString(8, phong.getMaKM_229());

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateDH(QL_HoaDon_229 dh) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE KhachHang SET TENKH = ?, DIACHI = ?, SDT = ?,GIOITINH = ? WHERE MAKH =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dh.getNgayTaoDH_229());
            preparedStatement.setString(2, dh.getDiaChiGiaoHang_229());
            preparedStatement.setString(3, dh.getPhuongThucThanhToan_229());
            preparedStatement.setString(4, dh.getThoiGianThanhToan_229());
            preparedStatement.setString(5, dh.getThoiGianGiaoHang_229());
            preparedStatement.setString(6, dh.getMaKH_229());
            preparedStatement.setString(7, dh.getMaNV_229());
            preparedStatement.setString(8, dh.getMaKM_229());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDH(int id) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "delete from HoaDon where MADH = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
}


