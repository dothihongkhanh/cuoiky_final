/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DAO.QLSanPham_Dao;
import MODEL.QL_SanPham_211;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Khanhle
 */
public class QLSanPham_Service {
    private QLSanPham_Dao spDao;

    public QLSanPham_Service() {
        spDao = new QLSanPham_Dao();
    }

    public List<QL_SanPham_211> getAllUsers() throws SQLException {
        return spDao.getAllUsers();
    }

    public void addSP(QL_SanPham_211 sp) throws SQLException {
        spDao.addSP(sp);
    }

    public void deletePhong(int id) throws SQLException {
        spDao.deleteSP(id);
    }

    
}

