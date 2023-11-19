package anhbvph43899.fpoly.duan1_nhom9_wd18301.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName = "BanSneakers";
    private static final int version = 11;
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
        String ThemSP = "INSERT INTO SanPham VALUES (0, 'Giày Thời Trang Unisex Converse', 6000000,'Ra mắt lần đầu năm 1917 với tư cách là một đôi giày bóng rổ, giày Converse All Star ban đầu được bậc thầy bóng rổ Chuck Taylor quảng bá cho sự linh hoạt và lợi ích trên sân bóng. Tuy nhiên qua nhiều thập kỷ, một điều đáng kinh ngạc đã xảy ra: đôi giày thể thao với kiểu dáng mang phong cách vượt thời gian và logo đặc trưng ở mắt cá này đã được các nghệ sĩ, nhạc sĩ và những người nổi tiếng yêu thích và mang biểu diễn tạo nên cơn sốt trên toàn cầu – và chúng vẫn được yêu thích cho đến ngày nay.', " +
                "'https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQ7btw4CUQylfpS8BspF9VSg-VKRQYKctmfU6_-RpbE9wW_SqhdklInpq9afnYkvNmonO74ceM5Sbkx9kl3Aogv7wSn3chmuBW5NFQY5gE&usqp=CAc')," +
                "(1, 'Giày Nike Air Jordan 1 Low Panda',500000,'Nike Air Force 1 là một trong những dòng sản phẩm đầu tiên của thương hiệu Nike được trình làng vào năm 1982 (tức sau 11 năm thành lập Công ty). Ngay từ những ngày đầu ra mắt, Nike Air Force 1 được nhà thiết kế ông Bruce Kilgore với định vị là dòng giày dành cho dân chơi bóng rổ và vô cùng thành công ở thời điểm bấy giờ về cả doanh thu lẫn độ phổ biến. ', "+" 'https://product.hstatic.net/200000581855/product/giay_nike_air_jordan_1_low_panda_w_dc0774-1014_0416e0b3b8ad4425aa489da3d25adfb0_grande.jpeg')";
        db.execSQL(SanPham);
        db.execSQL(ThemSP);

        String User = "CREATE TABLE User(" +
                "idUser integer primary key, " +
                "tenUser text not null, " +
                "password text not null, " +
                "fullname text, " +
                "sdt integer, " +
                "diaChi text, " +
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
        String SPBienThe = "CREATE TABLE SPBienThe(" +
                "idbienthe integer primary key, " +
                "idSP text not null, " +
                "size text not null, " +
                "mau text not null, " +
                "soLuong integer not null)";
        db.execSQL(SPBienThe);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            db.execSQL("DROP TABLE IF EXISTS User");
            db.execSQL("DROP TABLE IF EXISTS HoaDon");
            db.execSQL("DROP TABLE IF EXISTS SPBienThe");
            onCreate(db);
        }
    }
}
