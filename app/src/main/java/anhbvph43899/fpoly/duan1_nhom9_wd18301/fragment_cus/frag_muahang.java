package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.HoaDonAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SPBienThe;


public class frag_muahang extends Fragment {

    ImageView imganhmua;
    HoaDonAdapter adapter;
    TextView tvtenspmua,tvgiaspmua,soluong, tvloai;
    ImageButton btntru, btncong, btndathang;
    Spinner spnsize, spncolor;
    public frag_muahang() {
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
        View view = inflater.inflate(R.layout.fragment_frag_muahang, container, false);
        spnsize = view.findViewById(R.id.spnsize);
        spncolor  = view.findViewById(R.id.spncolor);
        imganhmua = view.findViewById(R.id.imganhmua);
        tvtenspmua = view.findViewById(R.id.tvtenspmua);
        tvgiaspmua = view.findViewById(R.id.tvgiaspmua);
        tvloai = view.findViewById(R.id.tvloai);
        soluong = view.findViewById(R.id.soluong);
        btntru =view.findViewById(R.id.btntru);
        btncong = view.findViewById(R.id.btncong);
        btndathang = view.findViewById(R.id.btndathang);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String anh = bundle.getString("anh");
            String ten = bundle.getString("ten");
            String gia = bundle.getString("gia");
            String loaisp = bundle.getString("tenloaisp");

            Glide.with(this)
                    .load(anh)
                    .into(imganhmua);
            tvtenspmua.setText(ten);
            tvgiaspmua.setText(gia);
            tvloai.setText(loaisp);
        }
        final int[] counter = {0};
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter[0]++;
                soluong.setText(String.valueOf(counter[0]));
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter[0] > 0) {
                    counter[0]--;
                    soluong.setText(String.valueOf(counter[0]));
                } else {
                    // Giảm dưới 0 sẽ không được phép, không làm gì cả hoặc hiển thị thông báo
                    // Toast.makeText(MainActivity.this, "Giá trị không thể âm", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        ArrayList<String> arrspnsize = new ArrayList<>();
        arrspnsize.add("37");
        arrspnsize.add("38");
        arrspnsize.add("39");
        arrspnsize.add("40");
        arrspnsize.add("41");
        ArrayAdapter<String> adapterspnsize = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrspnsize);
        spnsize.setAdapter(adapterspnsize);

        ArrayList<String> arrspncolor = new ArrayList<>();
        arrspncolor.add("Xanh Dương");
        arrspncolor.add("Đỏ");
        arrspncolor.add("Trắng");
        arrspncolor.add("Xanh Lá Cây");
        arrspncolor.add("Đen");
        ArrayAdapter<String> adapterspncolor = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrspncolor);
        spncolor.setAdapter(adapterspncolor);

        return view;
    }



}