package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class Sneakers {
    private int id_sp;
    private int id_loai;
    private String tensp;
    private int gia;
    private int daban;
    private String size;
    private String mau;
    private String mota_sp;
    private String anhsp;

    public Sneakers() {
    }

    public Sneakers(int id_sp, int id_loai, String tensp, int gia, int daban, String size, String mau, String mota_sp, String anhsp) {
        this.id_sp = id_sp;
        this.id_loai = id_loai;
        this.tensp = tensp;
        this.gia = gia;
        this.daban = daban;
        this.size = size;
        this.mau = mau;
        this.mota_sp = mota_sp;
        this.anhsp = anhsp;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getId_loai() {
        return id_loai;
    }

    public void setId_loai(int id_loai) {
        this.id_loai = id_loai;
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

    public int getDaban() {
        return daban;
    }

    public void setDaban(int daban) {
        this.daban = daban;
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

    public String getMota_sp() {
        return mota_sp;
    }

    public void setMota_sp(String mota_sp) {
        this.mota_sp = mota_sp;
    }

    public String getAnhsp() {
        return anhsp;
    }

    public void setAnhsp(String anhsp) {
        this.anhsp = anhsp;
    }
}
