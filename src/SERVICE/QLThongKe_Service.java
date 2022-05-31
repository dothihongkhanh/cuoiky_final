/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import DAO.QLThongKe_Dao;
import MODEL.QL_SanPhamDaBan_203;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author phank
 */
public class QLThongKe_Service {
    private QLThongKe_Dao qLThongKe_Dao;

    public QLThongKe_Service() {
        qLThongKe_Dao = new QLThongKe_Dao();
    }
    
    public List<QL_SanPhamDaBan_203> getAllL_SanPhamDaBan() throws SQLException{
            return qLThongKe_Dao.getAllProduct();
    }
    public int thongKeHangTonKho(String tenSP) throws SQLException{
        return qLThongKe_Dao.thongKeSOLuong(tenSP);
    }
    public int thongKeSoLuongDaBan(String tenSP) throws SQLException{
        return qLThongKe_Dao.ThongKeSoLuongDaBan(tenSP);
    }

}