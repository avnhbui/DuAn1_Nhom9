package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragadmin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.LoaiSPAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;


public class frag_QLLoaiSP extends Fragment {
    LoaiSPDAO loaiSPDAO;
    RecyclerView rcvsneaker;
    FloatingActionButton fltbtnThem;

    LoaiSPAdapter loaiSPAdapter;
    Button btnThem_LSP;
    EditText txtTenLoai, t;
    ArrayList<LoaiSP> list = new ArrayList<>();
    public frag_QLLoaiSP() {
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
        View view = inflater.inflate(R.layout.fragment_frag_ql_loai_s_p, container, false);
        loaiSPDAO = new LoaiSPDAO(getContext());
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        list = loaiSPDAO.selectAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvsneaker.setLayoutManager(linearLayoutManager);
        loaiSPAdapter = new LoaiSPAdapter(getContext(), list);
        rcvsneaker.setAdapter(loaiSPAdapter);
        fltbtnThem = view.findViewById(R.id.fltbtnThem);
        fltbtnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog_Them();
            }
        });
        return view;

    }
    public void openDialog_Them() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.item_themloaisp, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        txtTenLoai = view.findViewById(R.id.btnThem_LSP);
        txtTenLoai = view.findViewById(R.id.btnThem_LSP);
        view.findViewById(R.id.btnThemLSP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = txtTenLoai.getText().toString();
                if(ten.isEmpty()) {
                    Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(loaiSPDAO.insert(new LoaiSP(ten))) {
                        list.clear();
                        list.addAll(loaiSPDAO.selectAll());
                        dialog.dismiss();
                        loaiSPAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}