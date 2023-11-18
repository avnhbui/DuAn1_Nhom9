package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class manhinh_dangky extends AppCompatActivity {
Button btndnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_dangky);
        btndnhap= findViewById(R.id.btndnhap);
        btndnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manhinh_dangky.this, manhinh_login.class);
                startActivity(intent);
            }
        });

    }
}