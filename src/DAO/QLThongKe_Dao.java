package DAO;

import MODEL.QL_SanPhamDaBan_203;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phank
 */
public class QLThongKe_Dao {
    
    public List<QL_SanPhamDaBan_203> getAllProduct () throws SQLException{
        List<QL_SanPhamDaBan_203> QL_SanPhamDaBans = new ArrayList<>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "select SanPham.maSP,tenSP,soLuongHienCon,soLuongDat\n" +
                        "from SanPham,ChiTietHoaDon";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                QL_SanPhamDaBan_203 qL_SanPhamDaBan = new QL_SanPhamDaBan_203();
                qL_SanPhamDaBan.setMaSP_203(rs.getInt(1));
                qL_SanPhamDaBan.setTenSP_203(rs.getString(2));
                qL_SanPhamDaBan.setSoLuongCon_203(rs.getInt(3));
                qL_SanPhamDaBan.setSoLuongDaBan_203(rs.getInt(4));
                QL_SanPhamDaBans.add(qL_SanPhamDaBan);
            }
            return QL_SanPhamDaBans;
    }
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectDB.getJBDCConnection()) {
            String sql = "select SanPham.maSP,tenSP,soLuongHienCon,soLuongDat\n" +
                    "from SanPham,ChiTietHoaDon";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //Di chuyển con trỏ xuống bản ghi kế tiếp
                int id = rs.getInt(1);
                String username = rs.getString(2);
                int password = rs.getInt(3);
                int email = rs.getInt(4);

                System.out.println(id + " - " + username + " - " + password + " - " + email);
            }
            //Đóng kết nối
        }
    }
}
