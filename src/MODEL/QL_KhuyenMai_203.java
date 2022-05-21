package MODEL;

class QL_KhuyenMai_203 {

    private int maKM;

    private String tenCTKM;
    private int mucGiamGia;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String moTa;
    public QL_KhuyenMai_203() {
    }
    public QL_KhuyenMai_203(int maKM, String tenCTKM, int mucGiamGia, String ngayBatDau, String ngayKetThuc,
            String moTa) {
        this.maKM = maKM;
        this.tenCTKM = tenCTKM;
        this.mucGiamGia = mucGiamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
    }
    public int getMaKM() {
        return maKM;
    }
    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }
    public String getTenCTKM() {
        return tenCTKM;
    }
    public void setTenCTKM(String tenCTKM) {
        this.tenCTKM = tenCTKM;
    }
    public int getMucGiamGia() {
        return mucGiamGia;
    }
    public void setMucGiamGia(int mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }
    public String getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public String getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}