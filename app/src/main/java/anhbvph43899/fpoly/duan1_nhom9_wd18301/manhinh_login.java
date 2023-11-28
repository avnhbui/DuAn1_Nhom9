package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.UserDAO;

public class manhinh_login extends AppCompatActivity {
    Button btndk;
    EditText sdt, password;
    Button btndnhap;
    CheckBox chkluu;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_login);
        sdt = findViewById(R.id.sdt);
        password = findViewById(R.id.password);
        btndnhap = findViewById(R.id.btndn);
        chkluu = findViewById(R.id.chkluu);
        btndk = findViewById(R.id.btndk);
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manhinh_login.this, manhinh_dangky.class);
                startActivity(intent);
            }
        });
    }

    public  void  luuTK(String sdt, String pass, Boolean status){
        SharedPreferences sPef = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sPef.edit();
        if (status == false){
            editor.clear();
        }
        else {
            editor.putString("SDT",sdt);
            editor.putString("pass",pass);
            editor.putBoolean("luu", status);
        }
        editor.commit();
    }
    public  int isLogin( String sdt,String pass){
        if(sdt.equals("hung")&& pass.equals("123")){
            return 1;
        }
        else {
            return -1;
        }
    }

    String strSdt; String strPass;
    public void checkLogin(View view) {
        strSdt = sdt.getText().toString();
        strPass = password.getText().toString();
        if (strPass.isEmpty() || strSdt.isEmpty()){
            Toast.makeText(this, "không được để trống", Toast.LENGTH_SHORT).show();
        }else {
            if (isLogin(strSdt,strPass)>0){
                Toast.makeText(this, "login thành công", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(manhinh_login.this, Nav_custumer.class));
                    }
                },1000);
            }
            else {
                Toast.makeText(this, "Sai pass", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void SaveUp(View view) {
        String s = sdt.getText().toString();
        String p = password.getText().toString();
        boolean status = chkluu.isChecked();
        luuTK(s,p,status);
    }
}