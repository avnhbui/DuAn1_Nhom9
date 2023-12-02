package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.GioHangDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.HoaDonAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.GIoHang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SPBienThe;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;


public class frag_muahang extends Fragment {

    ImageView imganhmua;
    HoaDonAdapter adapter;
    TextView tvtenspmua,tvgiaspmua,soluong, tvloai;
    Button btngiohang;
    Spinner spnsize, spncolor;
    GioHangDAO gioHangDAO;
    ArrayList<GIoHang> list = new ArrayList<>();
    public frag_muahang() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("WrongThread")
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
        btngiohang = view.findViewById(R.id.btngiohang);

        Bundle bundle1 = getArguments();
        if (bundle1 != null) {
            String anh = bundle1.getString("anh1");
            String ten = bundle1.getString("ten1");
            String gia = bundle1.getString("gia1");
            String mota = bundle1.getString("mota1");
            String loaisp = bundle1.getString("tenloaisp1");

            Glide.with(this)
                    .load(anh)
                    .into(imganhmua);
            tvtenspmua.setText(ten);
            tvgiaspmua.setText(gia);
        }
        String imagePath = "";

            BitmapDrawable bitmapDrawable = (BitmapDrawable) imganhmua.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();


        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        gioHangDAO = new GioHangDAO(getContext());
        btngiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String tensp = tvtenspmua.getText().toString();
                        String gia = tvgiaspmua.getText().toString();
                        String size = String.valueOf(spnsize.getSelectedItem());
                        String mau = String.valueOf(spncolor.getSelectedItem());

                if ( tensp.isEmpty() || gia.isEmpty() || size.isEmpty() || mau.isEmpty()){
                    Toast.makeText(getContext(), "Thiếu dữ liệu", Toast.LENGTH_SHORT).show();
                            } else if (gioHangDAO.insert(new GIoHang(tensp, Integer.parseInt(gia), size, mau, String.valueOf(byteArray)))) {
                                list.clear();
                                list.addAll(gioHangDAO.selectAll());
                                Toast.makeText(getContext(), "Thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
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

        return view;
    }



}