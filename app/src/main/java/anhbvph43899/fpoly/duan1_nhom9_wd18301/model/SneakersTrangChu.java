package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class SneakersTrangChu {
    private int anhsp;
    private String tensp;
    private int gia;
    private int daban;

    public SneakersTrangChu() {
    }

    public SneakersTrangChu( int anhsp, String tensp, int gia, int daban) {
        this.anhsp = anhsp;
        this.tensp = tensp;
        this.gia = gia;
        this.daban = daban;
    }


    public int getAnhsp() {
        return anhsp;
    }

    public void setAnhsp(int anhsp) {
        this.anhsp = anhsp;
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
}
