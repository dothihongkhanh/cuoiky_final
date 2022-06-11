/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import DAO.QLKhuyenMai_Dao;
import MODEL.QL_KhuyenMai_212;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class QLKhuyenMai_Service {
     private QLKhuyenMai_Dao kmDao;

    public QLKhuyenMai_Service() {
        kmDao = new QLKhuyenMai_Dao();
    }

    public List<QL_KhuyenMai_212> getAllUsers() throws SQLException {
        return kmDao.getAllUsers();
    }

    public void addKM(QL_KhuyenMai_212 km) throws SQLException {
        kmDao.addKM(km);
    }
    public void updateKM(QL_KhuyenMai_212 km) throws SQLException {
        kmDao.updateKM(km);
    }
    public void deleteKM(int id) throws SQLException {;
        kmDao.deleteKM(id);
    }
}
