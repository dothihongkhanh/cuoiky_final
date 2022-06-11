/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.ChiTietHoaDon_229;
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
public class ChiTietHoaDon_Dao {
   
    public List<ChiTietHoaDon_229> getAllUsers() throws SQLException {
        List<ChiTietHoaDon_229> cthd = new ArrayList<ChiTietHoaDon_229>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM ChiTietHoaDon";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon_229 ct = new ChiTietHoaDon_229();
                ct.setMaDH_229(rs.getInt("MADH"));
                ct.setMaSP_229(rs.getInt("MASP"));
                ct.setSoLuongDat_229(rs.getInt("SOLUONGDAT"));
                ct.setDonGia_229(rs.getDouble("DONGIA"));
                
              
                cthd.add(ct);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cthd;

    }

    public void addCT(ChiTietHoaDon_229 ct) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO ChiTietHoaDon ( MADH, MASP, SOLUONGDAT) VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ct.getMaDH_229());
            pstmt.setInt(2, ct.getMaSP_229());
            pstmt.setInt(3, ct.getSoLuongDat_229());        

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateCT(ChiTietHoaDon_229 ct) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();
        String sql = "UPDATE ChiTietHoaDon SET  SOLUONGDAT = ? WHERE MADH =? AND MASP = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ct.getSoLuongDat_229());
            preparedStatement.setInt(2, ct.getMaDH_229());
            preparedStatement.setInt(3, ct.getMaSP_229());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCT(int id) throws SQLException {
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "delete from ChiTietHoaDon where MADH = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
 }
