/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DAO.QLHoaDon_Dao;
import MODEL.QL_HoaDon_229;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QLHoaDon_Service {
    private QLHoaDon_Dao dhDao;

    public QLHoaDon_Service() {
        dhDao = new QLHoaDon_Dao();
    }

    public List<QL_HoaDon_229> getAllUsers() throws SQLException {
        return dhDao.getAllUsers();
    }

    public void addPhong(QL_HoaDon_229 dh) throws SQLException {
        dhDao.addDH(dh);
    }

    public void deletePhong(int id) throws SQLException {
        dhDao.deleteDH(id);
    }
}
