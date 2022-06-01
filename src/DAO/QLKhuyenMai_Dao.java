/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.QL_KhuyenMai_212;
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
public class QLKhuyenMai_Dao {
    public List<QL_KhuyenMai_212> getAllUsers() throws SQLException {
        List<QL_KhuyenMai_212> khuyenmai = new ArrayList<QL_KhuyenMai_212>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "SELECT * FROM KhuyenMai";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                QL_KhuyenMai_212 km = new QL_KhuyenMai_212();
                km.setMaKM_212(rs.getInt("MAKM"));
                km.setTenChuongTrinhKM_212(rs.getString("TENCTKM"));
                km.setMucGiamGia_212(rs.getString("MUCGIAMGIA"));
                km.setNgayBatDau_212(rs.getString("NGAYBATDAU"));
                km.setNgayKetThuc_212(rs.getString("NGAYKETTHUC"));
                km.setMoTa_212(rs.getString("MOTA"));
              
                khuyenmai.add(km);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khuyenmai;

    }

    public void addKM(QL_KhuyenMai_212 km) throws SQLException {
        Connection con = ConnectDB.getJBDCConnection();
        String sql = "INSERT INTO KhuyenMai ( tenCTKM , MUCGIAMGIA, NGAYBATDAU, NGAYKETTHUC, MOTA) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, km.getTenChuongTrinhKM_212());
            pstmt.setString(2, km.getMucGiamGia_212());
            pstmt.setString(3, km.getNgayBatDau_212());
            pstmt.setString(4, km.getNgayKetThuc_212());  
            pstmt.setString(5, km.getMoTa_212());  

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
