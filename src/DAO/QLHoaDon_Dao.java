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
        List<QL_HoaDon_229> hoadon = new ArrayList<QL_HoaDon_229>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM HoaDon";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                QL_HoaDon_229 hd = new QL_HoaDon_229();
                hd.setMaDH_229(rs.getInt("MADH"));
                hd.setNgayTaoDH_229(rs.getString("NGAYTAODH"));
                hd.setDiaChiGiaoHang_229(rs.getString("DIACHIGIAOHANG"));
                hd.setPhuongThucThanhToan_229(rs.getString("PHUONGTHUCTHANHTOAN"));
                hd.setThoiGianThanhToan_229(rs.getString("THOIGIANTHANHTOAN"));
                hd.setThoiGianGiaoHang_229(rs.getString("THOIGIANGIAOHANG"));
                hd.setMaKH_229(rs.getInt("MAKH"));
                hd.setMaNV_229(rs.getInt("MANV"));
                hd.setMaKM_229(rs.getInt("MAKM"));
              
                hoadon.add(hd);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoadon;

    }

    public void addDH(QL_HoaDon_229 hd) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO HoaDon ( NGAYTAODH, DIACHIGIAOHANG, PHUONGTHUCTHANHTOAN, THOIGIANTHANHTOAN, THOIGIANGIAOHANG, MAKH, MANV, MAKM) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, hd.getNgayTaoDH_229());
            pstmt.setString(2, hd.getDiaChiGiaoHang_229());
            pstmt.setString(3, hd.getPhuongThucThanhToan_229());
            pstmt.setString(4, hd.getThoiGianThanhToan_229()); 
            pstmt.setString(5, hd.getThoiGianGiaoHang_229());
            pstmt.setInt(6, hd.getMaKH_229());
            pstmt.setInt(7, hd.getMaNV_229());
            pstmt.setInt(8, hd.getMaKM_229());

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateDH(QL_HoaDon_229 hd) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE HoaDon SET NGAYTAODH = ?, DIACHIGIAOHANG = ?, PHUONGTHUCTHANHTOAN = ?,THOIGIANTHANHTOAN = ?,THOIGIANGIAOHANG = ? MAKH =?, MANV =?,MAKM =?  WHERE MADH =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hd.getNgayTaoDH_229());
            preparedStatement.setString(2, hd.getDiaChiGiaoHang_229());
            preparedStatement.setString(3, hd.getPhuongThucThanhToan_229());
            preparedStatement.setString(4, hd.getThoiGianThanhToan_229());
            preparedStatement.setString(5, hd.getThoiGianGiaoHang_229());
            preparedStatement.setInt(6, hd.getMaKH_229());
            preparedStatement.setInt(7, hd.getMaNV_229());
            preparedStatement.setInt(8, hd.getMaKM_229());
            preparedStatement.setInt(9, hd.getMaDH_229());
            
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


