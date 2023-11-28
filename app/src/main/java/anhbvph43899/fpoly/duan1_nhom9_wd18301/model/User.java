package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class User {
    private int idUser;
    private String accout;
    private String password;
    private String fullname;
    private int quyenTruyCap;
    private int sdt;
    private String diaChi;

    public User() {
    }

    public User(int idUser, String accout, String password, String fullname, int quyenTruyCap, int sdt, String diaChi) {
        this.idUser = idUser;
        this.accout = accout;
        this.password = password;
        this.fullname = fullname;
        this.quyenTruyCap = quyenTruyCap;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getQuyenTruyCap() {
        return quyenTruyCap;
    }

    public void setQuyenTruyCap(int quyenTruyCap) {
        this.quyenTruyCap = quyenTruyCap;
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
}
