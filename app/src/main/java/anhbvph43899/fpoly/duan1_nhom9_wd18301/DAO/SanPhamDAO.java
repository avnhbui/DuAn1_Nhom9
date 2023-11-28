package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class SanPhamDAO {
    private final DBHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM SanPham", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    SanPham sp = new SanPham();
                    sp.setIdSP(cursor.getInt(0));
                    sp.setIdloaiSP(cursor.getInt(1));
                    sp.setTensp(cursor.getString(2));
                    sp.setGia(cursor.getInt(3));
                    sp.setMotaSP(cursor.getString(4));
                    sp.setAnh(cursor.getString(5));
                    list.add(sp);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public SanPham getID(String id) {
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM SanPham WHERE idSP=?", new String[]{id});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    SanPham sp = new SanPham();
                    sp.setIdSP(cursor.getInt(0));
                    sp.setIdloaiSP(cursor.getInt(1));
                    sp.setTensp(cursor.getString(2));
                    sp.setGia(cursor.getInt(3));
                    sp.setMotaSP(cursor.getString(4));
                    sp.setAnh(cursor.getString(5));
                    list.add(sp);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list.get(0);
    }
    public boolean insert(SanPham sp) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idSP", sp.getIdSP());
        values.put("idloaiSP", sp.getIdloaiSP());
        values.put("tenSP", sp.getTensp());
        values.put("gia", sp.getGia());
        values.put("mota_SP", sp.getMotaSP());
        values.put("anhSP", sp.getAnh());
        long row = db.insert("SanPham", null, values);
        return (row > 0);
    }
    public boolean update(SanPham sp) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idSP", sp.getIdSP());
        values.put("idloaiSP", sp.getIdloaiSP());
        values.put("tenSP", sp.getTensp());
        values.put("gia", sp.getGia());
        values.put("mota_SP", sp.getMotaSP());
        values.put("anhSP", sp.getAnh());
        long row = db.update("SanPham", values, "idSP = ?", new String[]{String.valueOf(sp.getIdSP())});
        return (row > 0);
    }
    public boolean delete(int idSP) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long row = db.delete("SanPham", "idSP=?", new String[]{String.valueOf(idSP)});
        return (row > 0);
    }
}
