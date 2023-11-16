//package anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO;
//
//import static android.service.controls.ControlsProviderService.TAG;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//import java.util.ArrayList;
//
//import anhbvph43899.fpoly.duan1_nhom9_wd18301.database.DBHelper;
//import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SneakersTrangChu;
//
//public class SneakersTCDAO {
//    private final DBHelper dbHelper;
//
//    public SneakersTCDAO(Context context) {
//        dbHelper = new DBHelper(context);
//    }
//    public ArrayList<SneakersTrangChu> selectAll() {
//        ArrayList<SneakersTrangChu> list = new ArrayList<>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor =db.rawQuery("SELECT * FROM Sach INNER JOIN LoaiSach ON Sach.maLoai = LoaiSach.maLoai", null);
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    SneakersTrangChu snk = new SneakersTrangChu();
//                    snk.setId_sptc(cursor.getInt(0));
//                    snk.setAnhsp(cursor.getString(1));
//                    snk.setTensp(cursor.getString(2));
//                    snk.setGia(cursor.getInt(3));
//                    snk.setDaban(cursor.getInt(4));
//                    list.add(snk);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return list;
//    }
//    public SneakersTrangChu getID(String id) {
//        ArrayList<SneakersTrangChu> list = new ArrayList<>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor =db.rawQuery("SELECT * FROM Sach WHERE maSach=?", new String[]{id});
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    SneakersTrangChu sneakersTrangChu = new SneakersTrangChu();
//                    sneakersTrangChu.setId_sptc(cursor.getInt(0));
//                    sneakersTrangChu.setAnhsp(cursor.getString(1));
//                    sneakersTrangChu.setTensp(cursor.getString(2));
//                    sneakersTrangChu.setGia(cursor.getInt(3));
//                    sneakersTrangChu.setDaban(cursor.getInt(4));
//                    list.add(sneakersTrangChu);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return list.get(0);
//    }
//    String anh;
//    public String GetAnh(int idSP) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor = db.rawQuery("SELECT anhSP FROM SneakersTC WHERE SneakersTC.idSPTC = ?", new String[] {String.valueOf(idSP)});
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    anh = cursor.getString(0);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return anh;
//    }
//    String tenSp;
//    public String getTenSP(int idSP) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor = db.rawQuery("SELECT tenSP FROM SneakersTC WHERE SneakersTC.idSPTC = ?", new String[] {String.valueOf(idSP)});
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    tenSp = cursor.getString(0);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return tenSp;
//    }
//    int gia;
//    public int getGia(String tenSP) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor = db.rawQuery("SELECT gia FROM SneakersTC WHERE SneakersTC.tenSP = ?", new String[] {tenSP});
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    gia = cursor.getInt(0);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return gia;
//    }
//    int daban;
//    public int getDaBan(String tenSP) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor = db.rawQuery("SELECT daBan FROM SneakersTC WHERE SneakersTC.tenSP = ?", new String[] {tenSP});
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    daban = cursor.getInt(0);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return daban;
//    }
//}
