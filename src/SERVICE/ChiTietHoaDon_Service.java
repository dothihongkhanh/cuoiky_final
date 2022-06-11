/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DAO.ChiTietHoaDon_Dao;
import MODEL.ChiTietHoaDon_229;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon_Service {
      private ChiTietHoaDon_Dao ctdao;

    public ChiTietHoaDon_Service() {
        ctdao = new ChiTietHoaDon_Dao();
    }

    public List<ChiTietHoaDon_229> getAllUsers() throws SQLException {
        return ctdao.getAllUsers();
    }

    public void addCT(ChiTietHoaDon_229 ct) throws SQLException {
        ctdao.addCT(ct);
    }

    public void deleteCT(int id) throws SQLException {
        ctdao.deleteCT(id);
    }
    public void updateCT(ChiTietHoaDon_229 ct) throws SQLException {
        ctdao.updateCT(ct);
    }
}
