package anhbvph43899.fpoly.duan1_nhom9_wd18301.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName = "BanSneakers";
    private static final int version = 3;
    public DBHelper(@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SneakersTC = "CREATE TABLE SneakersTC(" +
                "idSPTC integer primary key autoincrement, " +
                "anhSP text not null, " +
                "tenSP text not null, " +
                "gia integer not null, " +
                "daBan integer not null)";
        String ThemSneakersTC = "INSERT INTO SneakersTC VALUES (1,'https://shopgiayreplica.com/wp-content/uploads/2020/12/Jordan-1-Mid-Digital-Pink.jpg', 'Air Jordan 1 Mid Giày Nữ', 6000000, 0)";
        db.execSQL(SneakersTC);
        db.execSQL(ThemSneakersTC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SneakersTC");
            ;
        }
    }
}
