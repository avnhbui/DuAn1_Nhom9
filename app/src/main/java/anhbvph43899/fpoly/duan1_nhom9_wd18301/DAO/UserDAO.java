package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.User;

public class UserDAO {
    SQLiteDatabase db;
    DBHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<User> selectAll() {
        ArrayList<User> list = new ArrayList<>();
         db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM User", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    User user = new User();
                    user.setIdUser(cursor.getInt(0));
                    user.setAccout(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    user.setFullname(cursor.getString(3));
                    user.setSdt(cursor.getInt(4));
                    user.setDiaChi(cursor.getString(5));
                    user.setQuyenTruyCap(cursor.getInt(6));
                    list.add(user);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public boolean CheckLogin( String username, String password){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from User where tenUser = ? and password = ? ", new String[]{username, password} );
        if (cursor.getCount() >0  ){
            cursor.moveToFirst();
            int index = cursor.getColumnIndex("quyenhan");
            int quyenhan = cursor.getInt(index);
            if ( quyenhan == 1 ){
                cursor.close();
                return true;
            }
        }
        return false;
    }
}