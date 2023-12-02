package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragadmin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.QLSPAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.SneakersAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;


public class fragad_qlsp extends Fragment {
    QLSPAdapter qlspAdapter;

    SearchView searchView;
    SanPhamDAO sanPhamDAO;
    ArrayList<SanPham> searchList;
    Spinner spnLoaiSP;
int index;
    ArrayList<SanPham> list = new ArrayList<>();
    TextView txturl, txtid, txtten, txtgia, txtmota;
    Button btnthem;
    LoaiSPDAO loaiSPDAO;
    FloatingActionButton fltbtnThem;

    public fragad_qlsp() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rcvsneaker;
        sanPhamDAO = new SanPhamDAO(getContext());
        loaiSPDAO = new LoaiSPDAO(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragad_qlsp, container, false);
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        list = sanPhamDAO.selectAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvsneaker.setLayoutManager(linearLayoutManager);
        qlspAdapter = new QLSPAdapter(getContext(), list);
        rcvsneaker.setAdapter(qlspAdapter);
        searchView = view.findViewById(R.id.searchview);
        fltbtnThem = view.findViewById(R.id.fltbtnThem);
        fltbtnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog_Them();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();
                if (query.length() > 0) {
                    for(int i = 0; i < list.size(); i++) {
                        if(list.get(i).getTensp().toUpperCase().contains(query.toUpperCase())) {
                            SanPham s = new SanPham();
                            s.setIdSP(list.get(i).getIdSP());
                            s.setAnh(list.get(i).getAnh());
                            s.setTensp(list.get(i).getTensp());
                            s.setGia(list.get(i).getGia());
                            s.setMotaSP(list.get(i).getMotaSP());
                            searchList.add(s);
                        }
                    }
                    GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),2);
                    rcvsneaker.setLayoutManager(gridLayoutManager1);
                    qlspAdapter = new QLSPAdapter(getContext(), searchList);
                    rcvsneaker.setAdapter(qlspAdapter);
                    qlspAdapter.notifyDataSetChanged();
                } else {
                    GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),2);
                    rcvsneaker.setLayoutManager(gridLayoutManager1);
                    qlspAdapter = new QLSPAdapter(getContext(), list);
                    rcvsneaker.setAdapter(qlspAdapter);
                    qlspAdapter.notifyDataSetChanged();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                if (newText.length() > 0) {
                    for(int i = 0; i < list.size(); i++) {
                        if(list.get(i).getTensp().toUpperCase().contains(newText.toUpperCase())) {
                            SanPham s = new SanPham();
                            s.setIdSP(list.get(i).getIdSP());
                            s.setAnh(list.get(i).getAnh());
                            s.setTensp(list.get(i).getTensp());
                            s.setGia(list.get(i).getGia());
                            s.setMotaSP(list.get(i).getMotaSP());
                            searchList.add(s);
                            searchList.add(s);
                        }
                    }
                    GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),2);
                    rcvsneaker.setLayoutManager(gridLayoutManager1);
                    qlspAdapter = new QLSPAdapter(getContext(), searchList);
                    rcvsneaker.setAdapter(qlspAdapter);
                    qlspAdapter.notifyDataSetChanged();
                } else {
                    GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),2);
                    rcvsneaker.setLayoutManager(gridLayoutManager1);
                    qlspAdapter = new QLSPAdapter(getContext(), list);
                    rcvsneaker.setAdapter(qlspAdapter);
                    qlspAdapter.notifyDataSetChanged();
                }
                return false;

            }
        });
        return view;
    }
    public void OpenDialog_Them() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.item_themsp, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        txturl = view.findViewById(R.id.txturl);
        txtid = view.findViewById(R.id.txtid);
        txtten = view.findViewById(R.id.txtten);
        txtgia = view.findViewById(R.id.txtgia);
        spnLoaiSP = view.findViewById(R.id.spnLoaiSP);
        txtmota = view.findViewById(R.id.txtmota);
        btnthem = view.findViewById(R.id.btnthem);
        ArrayList<LoaiSP> listLS = new ArrayList<>();
        listLS = loaiSPDAO.selectAll();
        ArrayList<String> loaiSPArr = new ArrayList<>();
        for (LoaiSP x: listLS) {
            loaiSPArr.add(x.getTenLoaiSP());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, loaiSPArr);
        spnLoaiSP.setAdapter(adapter);
        spnLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = loaiSPDAO.getMaLoai(loaiSPArr.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = txturl.getText().toString();
                String id = txtid.getText().toString();
                String ten = txtten.getText().toString();
                String gia = txtgia.getText().toString();
                String mota = txtmota.getText().toString();
                if(url.isEmpty() || id.isEmpty() || ten.isEmpty() || gia.isEmpty() || mota.isEmpty()) {
                    Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(gia.matches("\\d+") == false) {
                        Toast.makeText(getContext(), "Giá tiền sai định dạng", Toast.LENGTH_SHORT).show();
                    } else if(Integer.valueOf(gia) < 0) {
                        Toast.makeText(getContext(), "Giá tiền phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                    }
                    else if(sanPhamDAO.insert(new SanPham(Integer.parseInt(id), ten, Integer.parseInt(gia), index, mota, url))) {
                        list.clear();
                        list.addAll(sanPhamDAO.selectAll());
                        dialog.dismiss();
                        qlspAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}