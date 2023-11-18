package anhbvph43899.fpoly.duan1_nhom9_wd18301.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName = "BanSneakers";
    private static final int version = 8;
    public DBHelper(@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SanPham = "CREATE TABLE SanPham(" +
                "idSP integer primary key, " +
                "tenSP text not null, " +
                "gia integer not null, " +
                "mota_SP integer not null, " +
                "anhSP text not null)";
        String ThemSP = "INSERT INTO SanPham VALUES (0, 'Giay', 6000000,'Giày này rất đẹp', " +
                "'https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQ7btw4CUQylfpS8BspF9VSg-VKRQYKctmfU6_-RpbE9wW_SqhdklInpq9afnYkvNmonO74ceM5Sbkx9kl3Aogv7wSn3chmuBW5NFQY5gE&usqp=CAc')," +
                "(1, 'Cung la Giay',500000,'Bình Thường', "+" 'https://pos.nvncdn.net/80c639-72864/ps/20230619_g56PqYH9vP.jpeg')";
        db.execSQL(SanPham);
        db.execSQL(ThemSP);
        String MauSac = "CREATE TABLE MauSac(" +
                "idMau integer primary key, " +
                "mau text not null)";
        db.execSQL(MauSac);
        String Size = "CREATE TABLE Size(" +
                "idSize integer primary key, " +
                "size text not null)";
        db.execSQL(Size);

        String User = "CREATE TABLE User(" +
                "idUser integer primary key, " +
                "tenUser text not null, " +
                "password text not null, " +
                "fullname text, " +
                "sdt integer, " +
                "diaChi text, " +
                "email text, " +
                "quyenhan int not null, " +
                "anhUser text)";
        db.execSQL(User);
        String HoaDon = "CREATE TABLE HoaDon(" +
                "idHoaDon integer primary key, " +
                "idSP text not null, " +
                "idUser text not null, " +
                "ngayMua text not null, " +
                "soLuong integer not null, " +
                "tongTien text not null, " +
                "trangThai text not null)";
        db.execSQL(HoaDon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            db.execSQL("DROP TABLE IF EXISTS Size");
            db.execSQL("DROP TABLE IF EXISTS User");
            db.execSQL("DROP TABLE IF EXISTS MauSac");
            db.execSQL("DROP TABLE IF EXISTS HoaDon");

            onCreate(db);
        }
    }
}
