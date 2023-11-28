package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.HoaDon;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class HoaDonDAO {
    private final DBHelper dbHelper;

    public HoaDonDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM HoaDon", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    HoaDon hd = new HoaDon();
                    hd.setIdhoadon(cursor.getInt(0));
                    hd.setIdbienthe(cursor.getInt(1));
                    hd.setNgayMua(cursor.getString(2));
                    hd.setSoLuong(cursor.getInt(3));
                    hd.setTongTien(cursor.getInt(4));
                    hd.setTrangThai(cursor.getInt(4));
                    list.add(hd);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
}
