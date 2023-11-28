package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class HoaDon {
    private int idhoadon;
    private int idbienthe;
    private String tenkh;
    private int sdt;
    private String diaChi;
    private String tenSP;
    private String size;
    private String mau;
    private String ngayMua;
    private int soLuong;
    private int tongTien;
    private int trangThai;

    public HoaDon() {
    }

    public HoaDon(int idhoadon, int idbienthe, String tenkh, int sdt, String diaChi, String tenSP, String size, String mau, String ngayMua, int soLuong, int tongTien, int trangThai) {
        this.idhoadon = idhoadon;
        this.idbienthe = idbienthe;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.size = size;
        this.mau = mau;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public int getIdbienthe() {
        return idbienthe;
    }

    public void setIdbienthe(int idbienthe) {
        this.idbienthe = idbienthe;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
