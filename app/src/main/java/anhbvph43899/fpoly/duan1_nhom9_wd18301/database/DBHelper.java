package anhbvph43899.fpoly.duan1_nhom9_wd18301.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName = "BanSneakers";
    private static final int version = 26;
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

        String User = "CREATE TABLE User(" +
                "idUser integer primary key autoincrement, " +
                "tenUser text not null , " +
                "password text not null, " +
                "fullname text, " +
                "sdt integer, " +
                "diaChi text, " +
                "quyenhan int not null)";
        db.execSQL(User);
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
                "idUser integer REFERENCES User(idUser), " +
                "size text not null, " +
                "mau text not null, " +
                "soLuong integer not null)";
        db.execSQL(SPBienThe);
        String LoaiSP = "CREATE TABLE LoaiSP(" +
                "idloaiSP integer primary key autoincrement, " +
                "tenLoaiSP text not null)";
        db.execSQL(LoaiSP);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            db.execSQL("DROP TABLE IF EXISTS User");
            db.execSQL("DROP TABLE IF EXISTS HoaDon");
            db.execSQL("DROP TABLE IF EXISTS SPBienThe");
            db.execSQL("DROP TABLE IF EXISTS LoaiSP");

            onCreate(db);
        }
    }
}
