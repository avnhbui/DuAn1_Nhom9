package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment.frag_donmua;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment.frag_feedback;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment.frag_giohang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment.frag_trangchu;

public class Nav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int frag_tc = 0;
    private static final int frag_gh = 1;
    private static final int frag_dm = 2;
    private static final int frag_fb = 3;
    private int fraght = frag_tc;

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav);
        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);
        thaythefrag(new frag_trangchu());
        navigationView.getMenu().findItem(R.id.nav_trangchu).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_trangchu){
            if(fraght != frag_tc){
                thaythefrag(new frag_trangchu());
                fraght = frag_tc;
            }
        }else if(id == R.id.nav_giohang){
            if(fraght != frag_gh){
                thaythefrag(new frag_giohang());
                fraght = frag_gh;
            }
        }else if(id == R.id.nav_donmua){
            if(fraght != frag_dm){
                thaythefrag(new frag_donmua());
                fraght = frag_dm;
            }
        }else if(id == R.id.nav_feedback){
            if(fraght != frag_fb){
                thaythefrag(new frag_feedback());
                fraght = frag_fb;
            }
        }else if(id == R.id.nav_dangxuat){
            Intent intent = new Intent(Nav.this, manhinh_login.class);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void thaythefrag(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }
}