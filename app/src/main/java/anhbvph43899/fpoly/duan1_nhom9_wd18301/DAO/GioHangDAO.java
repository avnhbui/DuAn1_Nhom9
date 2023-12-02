package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.GIoHang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.HoaDon;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class GioHangDAO {
    private final DBHelper dbHelper;

    public GioHangDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public ArrayList<GIoHang> selectAll() {
        ArrayList<GIoHang> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM GioHang", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    GIoHang gh = new GIoHang();
                    gh.setIdgiohang(cursor.getInt(0));
                    gh.setIdsp(cursor.getInt(1));
                    gh.setSoLuong(cursor.getInt(4));
                    gh.setSize(cursor.getString(2));
                    gh.setMau(cursor.getString(3));
                    list.add(gh);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public boolean insert(GIoHang gh) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idSP", gh.getIdsp());
        values.put("size", gh.getSize());
        values.put("mau", gh.getMau());
        values.put("soLuong", gh.getSoLuong());
        long row = db.insert("GioHang", null, values);
        return (row > 0);
    }
    public boolean delete(int idgh) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long row = db.delete("GioHang", "idgiohang=?", new String[]{String.valueOf(idgh)});
        return (row > 0);
    }
}
