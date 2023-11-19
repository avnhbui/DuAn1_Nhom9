package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;


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
        Button btndathang;
        ImageView imganh;
        TextView tvtensp, tvgiasp, tvmota;
        imganh = view.findViewById(R.id.imganh);
        tvtensp = view.findViewById(R.id.tvtensp);
        tvgiasp = view.findViewById(R.id.tvgiasp);
        tvmota = view.findViewById(R.id.tvmota);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String anh = bundle.getString("anh");
            String ten = bundle.getString("ten");
            String gia = bundle.getString("gia");
            String mota = bundle.getString("mota");
            Glide.with(this)
                    .load(anh)
                    .into(imganh);
            tvtensp.setText(ten);
            tvgiasp.setText(gia);
            tvmota.setText(mota);
        }
        btndathang = view.findViewById(R.id.btndathang);
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogTAODon();
            }
        });

    return view;
    }
    public void openDialogTAODon() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = (getActivity().getLayoutInflater());
        View view = inflater.inflate(R.layout.dialog_muahang, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        TextView soluong;
        ImageButton btntru, btncong;
        Spinner spnsize, spncolor;
        spnsize = view.findViewById(R.id.spnsize);
        spncolor  = view.findViewById(R.id.spncolor);
        soluong = view.findViewById(R.id.soluong);
        btntru =view.findViewById(R.id.btntru);
        btncong = view.findViewById(R.id.btncong);
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
    }
}