package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class GIoHang {
    private int idgiohang;
   private int idsp;
   private String ten;
   private int gia;
   private String size;
   private String mau;
   private int soLuong;
   private String anh;

    public GIoHang() {
    }

    public GIoHang(int idgiohang ,int idsp, String ten, int gia, String size, String mau, int soLuong, String anh) {
        this.idgiohang = idgiohang;
        this.idsp = idsp;
        this.ten = ten;
        this.gia = gia;
        this.size = size;
        this.mau = mau;
        this.soLuong = soLuong;
        this.anh = anh;
    }

    public GIoHang(String ten, int gia, String size, String mau, String anh) {
        this.ten = ten;
        this.gia = gia;
        this.size = size;
        this.mau = mau;
        this.anh = anh;
    }

    public int getIdgiohang() {
        return idgiohang;
    }

    public void setIdgiohang(int idgiohang) {
        this.idgiohang = idgiohang;
    }


    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idspbienthe) {
        this.idsp = idspbienthe;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
