package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class SanPham {
    private int idSP;
    private int idloaiSP;
    private String tensp;
    private int gia;
    private String loaisp;
    private String motaSP;
    private String anh;


    public SanPham(int idSP, String tensp, int gia, String loaisp, String motaSP, String anh) {
        this.idSP = idSP;
        this.tensp = tensp;
        this.gia = gia;
        this.loaisp = loaisp;
        this.motaSP = motaSP;
        this.anh = anh;
    }
    public SanPham(int idSP, String tensp, int gia,String motaSP, String anh, int idloaiSP) {
        this.idSP = idSP;
        this.tensp = tensp;
        this.gia = gia;
        this.motaSP = motaSP;
        this.anh = anh;
        this.idloaiSP = idloaiSP;
    }
    public SanPham() {
    }
    public int getIdloaiSP() {
        return idloaiSP;
    }

    public void setIdloaiSP(int idloaiSP) {
        this.idloaiSP = idloaiSP;
    }
    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getMotaSP() {
        return motaSP;
    }

    public void setMotaSP(String motaSP) {
        this.motaSP = motaSP;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
