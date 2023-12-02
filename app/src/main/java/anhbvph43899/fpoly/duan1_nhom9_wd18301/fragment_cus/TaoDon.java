package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;


public class TaoDon extends Fragment {


    public TaoDon() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tao_don, container, false);
        Button btndathang, themgiohang;
        ImageView imganh;
        TextView tvtensp, tvgiasp, tvmota, tvloaisp;
        imganh = view.findViewById(R.id.imganh);
        tvtensp = view.findViewById(R.id.tvtensp);
        tvgiasp = view.findViewById(R.id.tvgiasp);
        tvmota = view.findViewById(R.id.tvmota);
        tvloaisp = view.findViewById(R.id.tvloaisp);
        themgiohang = view.findViewById(R.id.themgiohang);

        Bundle bundle = getArguments();
            String anh = bundle.getString("anh");
            String ten = bundle.getString("ten");
            String gia = bundle.getString("gia");
            String mota = bundle.getString("mota");
            String loaisp = bundle.getString("tenloaisp");

            Glide.with(this)
                    .load(anh)
                    .into(imganh);
            tvtensp.setText(ten);
            tvgiasp.setText(gia);
            tvmota.setText(mota);
            tvloaisp.setText("vl" +loaisp);
        themgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentB();
            }
        });


    return view;
    }
    private void openFragmentB() {
        Fragment fragment = new frag_muahang();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.addToBackStack(null);  // Để có thể quay lại Fragment trước đó
        transaction.commit();
    }
}