/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

/**
 *
 * @author DELL
 */
import DAO.QLNhanVien_Dao;
import MODEL.QL_NhanVien_239;
import java.sql.SQLException;
import java.util.List;
public class QLNhanVien_Service {
    private final QLNhanVien_Dao nvDao;

    public QLNhanVien_Service() {
        nvDao = new QLNhanVien_Dao();
    }

    public List<QL_NhanVien_239> getAllUsers() throws SQLException {
        return nvDao.getAllUsers();
    }

    public void addNV(QL_NhanVien_239 nv) throws SQLException {
        nvDao.addNV(nv);
    }

    public void deleteNV(int id) throws SQLException {
        nvDao.deleteNV(id);
    }
    public void updateNV(QL_NhanVien_239 nv) throws SQLException {
        nvDao.updateNV(nv);
    }
}
