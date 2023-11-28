package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class SPBienThe {
    private int idbienthe;
    private int idSP;
    private int idUser;
    private String anhsp;
    private String tensp;
    private String size;
    private String mau;
    private int soluong;

    public SPBienThe() {
    }

    public SPBienThe(int idbienthe, int idSP, int idUser, String size, String mau, int soluong) {
        this.idbienthe = idbienthe;
        this.idSP = idSP;
        this.idUser = idUser;
        this.size = size;
        this.mau = mau;
        this.soluong = soluong;
    }

    public int getIdbienthe() {
        return idbienthe;
    }

    public void setIdbienthe(int idbienthe) {
        this.idbienthe = idbienthe;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
