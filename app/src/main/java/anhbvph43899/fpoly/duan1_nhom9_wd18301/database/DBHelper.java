package anhbvph43899.fpoly.duan1_nhom9_wd18301.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName = "BanSneakers";
    private static final int version = 37;
    public DBHelper(@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SanPham = "CREATE TABLE SanPham(" +
                "idSP integer primary key, " +
                "idloaiSP integer REFERENCES LoaiSP(idloaiSP), " +
                "tenSP text not null, " +
                "gia integer not null, " +
                "mota_SP integer not null, " +
                "anhSP text not null)";
        db.execSQL(SanPham);
        String data_SP = "INSERT INTO SanPham VALUES (1, 1, 'Giày pro', 200000, 'Giày nữ Vascara hàng hiệu cao cấp với phong cách thời trang công sở, đi tiệc, đi làm, đi học, đi chơi, du lịch theo xu hướng thời trang trendy, mẫu mới nhất ...','https://pos.nvncdn.net/80c639-72864/ps/20230619_g56PqYH9vP.jpeg')";
        db.execSQL(data_SP);

        String User = "CREATE TABLE User(" +
                "idUser integer primary key autoincrement, " +
                "tenUser text not null , " +
                "password text not null, " +
                "quyenhan int not null)";
        db.execSQL(User);
        String Custumer = "CREATE TABLE Custumer(" +
                "idCus integer primary key autoincrement, " +
                "fullname text, " +
                "sdt integer, " +
                "diaChi text)";
        db.execSQL(Custumer);
        String HoaDon = "CREATE TABLE HoaDon(" +
                "idHoaDon integer primary key, " +
                "idbienthe integer REFERENCES SPBienThe(idbienthe), " +
                "ngayMua text not null, " +
                "soLuong integer not null, " +
                "tongTien integer not null, " +
                "trangThai integer not null)";
        db.execSQL(HoaDon);
        String SPBienThe = "CREATE TABLE SPBienThe(" +
                "idbienthe integer primary key, " +
                "idSP integer REFERENCES SanPham(idSP), " +
                "size text not null, " +
                "mau text not null)";
        String GioHang = "CREATE TABLE GioHang(" +
                "idgiohang integer primary key autoincrement, " +
                "idSP integer REFERENCES SanPham(idSP), " +
                "size text not null, " +
                "mau text not null, " +
                "soLuong integer not null)";
        db.execSQL(GioHang);
        String data_gh = "INSERT INTO GioHang VALUES (1, 1, '40','Trắng', 1)";
        db.execSQL(data_gh);
        db.execSQL(SPBienThe);
        String LoaiSP = "CREATE TABLE LoaiSP(" +
                "idloaiSP integer primary key autoincrement, " +
                "tenLoaiSP text not null)";
        db.execSQL(LoaiSP);
        String data_LSP = "INSERT INTO LoaiSP VALUES (1, 'Đế cao')";
        db.execSQL(data_LSP);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            db.execSQL("DROP TABLE IF EXISTS User");
            db.execSQL("DROP TABLE IF EXISTS HoaDon");
            db.execSQL("DROP TABLE IF EXISTS SPBienThe");
            db.execSQL("DROP TABLE IF EXISTS LoaiSP");
            db.execSQL("DROP TABLE IF EXISTS GioHang");
            db.execSQL("DROP TABLE IF EXISTS Custumer");

            onCreate(db);
        }
    }
}
