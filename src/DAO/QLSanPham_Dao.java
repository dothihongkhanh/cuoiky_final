/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.QL_SanPham_211;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanhle
 */
public class QLSanPham_Dao {

    private QL_SanPham_211 sp;
    public List<QL_SanPham_211> getAllUsers() throws SQLException {
        List<QL_SanPham_211> sanpham = new ArrayList<QL_SanPham_211>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM SanPham";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                QL_SanPham_211 sp = new QL_SanPham_211();
                sp.setMaSP_211(rs.getInt("MASP"));
                sp.setTenSP_211(rs.getString("TENSP"));
                sp.setDonGiaBan_211(rs.getString("DONGIABAN"));
                sp.setSoLuongHienCon_211(rs.getString("SOLUONGHIENCON"));
                
                sanpham.add(sp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanpham;

    }

    public void addSP(QL_SanPham_211 sp) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO SanPham ( TENSP, DONGIABAN, SOLUONGHIENCON) VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sp.getTenSP_211());
            pstmt.setString(2, sp.getDonGiaBan_211());
            pstmt.setString(3, sp.getSoLuongHienCon_211());
           
                      

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateSP(QL_SanPham_211 sp) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE SanPham SET TENSP = ?, DONGIABAN = ? ,SOLUONGHIENCON=? WHERE MASP =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sp.getTenSP_211());
            preparedStatement.setString(2, sp.getDonGiaBan_211());
            preparedStatement.setString(3, sp.getSoLuongHienCon_211());
            preparedStatement.setInt(4, sp.getMaSP_211());
           
           
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSP(int id) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "delete from SanPham where MASP = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
}

