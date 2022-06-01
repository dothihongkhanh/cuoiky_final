package DAO;

import MODEL.QL_DanhSachDonHang_203;
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

    public List<QL_DanhSachDonHang_203> getAllProduct() throws SQLException {
        List<QL_DanhSachDonHang_203> qL_DanhSachDonHang_203s = new ArrayList<>();

        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "select HoaDon.maDH,tenSP,diaChiGiaoHang,soLuongDat,ngayTaoDH\n"
                + "from SanPham,ChiTietHoaDon,HoaDon";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            QL_DanhSachDonHang_203 qL_DanhSachDonHang_203 = new QL_DanhSachDonHang_203();
            qL_DanhSachDonHang_203.setMaDH_203(rs.getInt(1));
            qL_DanhSachDonHang_203.setTenSP_203(rs.getString(2));
            qL_DanhSachDonHang_203.setDiaChiGiaoHang_203(rs.getString(3));
            qL_DanhSachDonHang_203.setSoLuongDat_203(rs.getInt(4));
            qL_DanhSachDonHang_203.setNgayTaoDonHang_203(rs.getString(5));
            qL_DanhSachDonHang_203s.add(qL_DanhSachDonHang_203);
        }
        return qL_DanhSachDonHang_203s;
    }

    public int thongKeSOLuong(String tenSp) throws SQLException {
        int tong = 0;
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "select soLuongHienCon\n"
                + "from SanPham where tenSP=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tenSp);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            tong = rs.getInt(1);
        }
        return tong;
    }

    public int ThongKeSoLuongDaBan(String tenSp) throws SQLException {
        int tong = 0;
        Connection connection = ConnectDB.getJBDCConnection();

        String sql = "select soLuongDat\n"
                + "from SanPham,ChiTietHoaDon\n"
                + "where tenSP=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tenSp);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            tong += rs.getInt(1);
        }
        return tong;
    }

    public long ThongKeDoanhThu(String tenSp) throws SQLException {
        long doanhThu = 0;
        Connection connection = ConnectDB.getJBDCConnection();
        if (!"Tất cả".equals(tenSp)) {
            String sql = "select donGiaBan,soLuongDat\n"
                    + "from SanPham,ChiTietHoaDon\n"
                    + "where tenSP=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenSp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                doanhThu += rs.getInt(1) * rs.getInt(2);
            }
            return doanhThu;
        } else {
            String sql = "select donGiaBan,soLuongDat\n"
                    + "from SanPham,ChiTietHoaDon\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                doanhThu += rs.getInt(1) * rs.getInt(2);
            }
            return doanhThu;
        }
    }

}
