/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import DAO.QLKhachHang_Dao;
import MODEL.QL_KhachHang_212;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class QLKhachHang_Service {
    private QLKhachHang_Dao khDao;

    public QLKhachHang_Service() {
        khDao = new QLKhachHang_Dao();
    }

    public List<QL_KhachHang_212> getAllUsers() throws SQLException {
        return khDao.getAllUsers();
    }

    public void addPhong(QL_KhachHang_212 kh) throws SQLException {
        khDao.addKH(kh);
    }

    public void deletePhong(int id) throws SQLException {
        khDao.deleteKH(id);
    }
}
