package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class manhinh_login extends AppCompatActivity {
Button btndk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_login);
        btndk = findViewById(R.id.btndk);
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manhinh_login.this, manhinh_dangky.class);
                startActivity(intent);
            }
        });
    }
}