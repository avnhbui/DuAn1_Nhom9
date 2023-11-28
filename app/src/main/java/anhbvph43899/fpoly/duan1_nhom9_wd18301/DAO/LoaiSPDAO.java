package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;

public class LoaiSPDAO {
    private final DBHelper dbHelper;

    public LoaiSPDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public ArrayList<LoaiSP> selectAll() {
        ArrayList<LoaiSP> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM LoaiSP", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    LoaiSP loai = new LoaiSP();
                    loai.setIdloaiSP(cursor.getInt(0));
                    loai.setTenLoaiSP(cursor.getString(1));
                    list.add(loai);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public boolean update(LoaiSP loaiSP) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenLoaiSP", loaiSP.getTenLoaiSP());
        long row = db.update("LoaiSP", values, "idloaiSP = ?", new String[]{String.valueOf(loaiSP.getIdloaiSP())});
        return (row > 0);
    }
    public boolean delete(int maLoai) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long row = db.delete("LoaiSP", "idloaiSP=?", new String[]{String.valueOf(maLoai)});
        return (row > 0);
    }
    int row;
    public int getMaLoai(String tenLoai) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT idloaiSP FROM LoaiSP WHERE LoaiSP.tenLoaiSP = ?", new String[] {tenLoai});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    row = cursor.getInt(0);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return row;
    }public boolean insert(LoaiSP loai) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenLoaiSP", loai.getTenLoaiSP());
        long row = db.insert("LoaiSP", null, values);
        return (row > 0);
    }

}
