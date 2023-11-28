package anhbvph43899.fpoly.duan1_nhom9_wd18301.model;

public class LoaiSP {
   private int idloaiSP;
   private String tenLoaiSP;

    public LoaiSP() {
    }

    public LoaiSP(int idloaiSP, String tenLoaiSP) {
        this.idloaiSP = idloaiSP;
        this.tenLoaiSP = tenLoaiSP;
    }
    public LoaiSP( String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public int getIdloaiSP() {
        return idloaiSP;
    }

    public void setIdloaiSP(int idloaiSP) {
        this.idloaiSP = idloaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }
}
