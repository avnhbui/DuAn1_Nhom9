package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragadmin.frag_QLLoaiSP;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragadmin.fragad_qldonhang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragadmin.fragad_qlfeedback;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragadmin.fragad_qlsp;

public class Nav_admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;
    Toolbar toolbar;
    private static final int frag_qlsp =0;
    private static final int frag_qlfb =1;
    private static final int frag_qldh =2;
    private static final int frag_qllsp = 3;
    private int frag_ht = frag_qlsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_admin);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navad_open, R.string.navad_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);
        thaythefrag(new fragad_qlsp());
        navigationView.getMenu().findItem(R.id.navad_qlsp).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.navad_qlsp){
            if(frag_ht != frag_qlsp){
                thaythefrag(new fragad_qlsp());
                frag_ht = frag_qlsp;
            }
        }else  if (id == R.id.navad_qllsp){
            if(frag_ht != frag_qllsp){
                thaythefrag(new frag_QLLoaiSP());
                frag_ht = frag_qllsp;
            }
        }  if (id == R.id.navad_qlfeedback){
            if(frag_ht != frag_qlfb){
                thaythefrag(new fragad_qlfeedback());
                frag_ht = frag_qlfb;
            }
        }else  if (id == R.id.navad_qldonmua){
            if(frag_ht != frag_qldh){
                thaythefrag(new fragad_qldonhang());
                frag_ht = frag_qldh;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    private void thaythefrag(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }
}