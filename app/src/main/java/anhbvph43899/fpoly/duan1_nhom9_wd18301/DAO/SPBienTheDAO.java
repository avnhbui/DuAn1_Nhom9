package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SPBienThe;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class SPBienTheDAO {
    private final DBHelper dbHelper;

    public SPBienTheDAO(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
    public ArrayList<SPBienThe> selectAll() {
        ArrayList<SPBienThe> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM SPBienThe", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    SPBienThe sp = new SPBienThe();
                    sp.setIdbienthe(cursor.getInt(0));
                    sp.setIdSP(cursor.getInt(1));
                    sp.setIdUser(cursor.getInt(2));
                    sp.setSize(cursor.getString(3));
                    sp.setMau(cursor.getString(4));
                    sp.setSoluong(cursor.getInt(5));
                    list.add(sp);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public boolean insert(SPBienThe sp) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idbienthe", sp.getIdbienthe());
        values.put("idSP", sp.getIdSP());
        values.put("idUser", sp.getIdUser());
        values.put("size", sp.getSize());
        values.put("mau", sp.getMau());
        values.put("soLuong", sp.getSoluong());
        long row = db.insert("SPBienThe", null, values);
        return (row > 0);
    }
    public boolean delete(int idbienthe) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long row = db.delete("SPBienThe", "idbienthe=?", new String[]{String.valueOf(idbienthe)});
        return (row > 0);
    }

}
