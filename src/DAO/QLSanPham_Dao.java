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
                QL_SanPham_211 kh = new QL_SanPham_211();
                kh.setMaSP_211(rs.getInt("MASP"));
                kh.settenSP_211(rs.getString("TENSP"));
                kh.setdongiaban_211(rs.getString("DONGIABAN"));
                kh.setsoluonghiencon_211(rs.getString("SOLUONGHIENCON"));
                
                 sanpham.add(sp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanpham;

    }

    public void addKH(QL_SanPham_211 phong) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO SanPham ( TENSP, DONGIABAN, SOLUONGHIENCON) VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phong.gettenSP_211());
            pstmt.setString(2, phong.getdongiaban_211());
            pstmt.setString(3, phong.getsoluonghiencon_211());
                      

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateKH(QL_SanPham_211 kh) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE SanPham SET TENSP = ?, DONGIABAN = ?, SOLUONGHIENCON = ? WHERE MASP =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kh.gettenSP_211());
            preparedStatement.setString(2, kh.getdongiaban_211());
            preparedStatement.setString(3, kh.getsoluonghiencon_211());
           
            
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

