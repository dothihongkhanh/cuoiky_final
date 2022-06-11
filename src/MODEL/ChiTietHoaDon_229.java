/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon_229 {
    private int maDH_229;
    private int maSP_229;
    private int soLuongDat_229;
    private double donGia_229;

    public int getMaDH_229() {
        return maDH_229;
    }

    public void setMaDH_229(int maDH_229) {
        this.maDH_229 = maDH_229;
    }

    public int getMaSP_229() {
        return maSP_229;
    }

    public void setMaSP_229(int maSP_229) {
        this.maSP_229 = maSP_229;
    }

    public int getSoLuongDat_229() {
        return soLuongDat_229;
    }

    public void setSoLuongDat_229(int soLuongDat_229) {
        this.soLuongDat_229 = soLuongDat_229;
    }

    public double getDonGia_229() {
        return donGia_229;
    }

    public void setDonGia_229(double donGia_229) {
        this.donGia_229 = donGia_229;
    }
    
    public double getThanhTien() {
        return donGia_229*soLuongDat_229;
    }
}
