package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

//import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SneakersTCDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.BrandsAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.SneakersAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;


public class frag_trangchu extends Fragment {
    SneakersAdapter sneakersAdapter;
//    SneakersTCDAO sneakersTCDAO;
SearchView searchView;
SanPhamDAO sanPhamDAO;
    ArrayList<SanPham> searchList;

    ArrayList<SanPham> list = new ArrayList<>();
    TextView txturl, txtid, txtten, txtgia, txtmota;
    Button btnthem;
    FloatingActionButton fltbtnThem;
    public frag_trangchu() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rcv, rcvsneaker;
        sanPhamDAO = new SanPhamDAO(getContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_trangchu, container, false);

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

// imageList.add(new SlideModel("String Url" or R.drawable);
// imageList.add(new SlideModel("String Url" or R.drawable, "title"); You can add title

        imageList.add(new SlideModel("https://img.muji.net/img/item/4550344414644_1260.jpg",  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://pos.nvncdn.net/90be09-25766/ps/20221006_WfYTAEMDjtzmvBwrSrk5X9Yj.jpg",  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://1sneaker.vn/wp-content/uploads/2023/04/giay-sneaker-adidas-superstar-mau-trang-3.jpg", ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        rcv = view.findViewById(R.id.rcvbtn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rcv.setLayoutManager(linearLayoutManager);
        List<String> lists= new ArrayList<>();
        lists.add(String.valueOf(R.drawable.nike));
        lists.add(String.valueOf(R.drawable.puma));
        lists.add(String.valueOf(R.drawable.adidas));
        lists.add(String.valueOf(R.drawable.bitis));
        lists.add(String.valueOf(R.drawable.converse));
        lists.add(String.valueOf(R.drawable.vans));
        rcv.setAdapter(new BrandsAdapter(lists));
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        list = sanPhamDAO.selectAll();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rcvsneaker.setLayoutManager(gridLayoutManager);
        sneakersAdapter = new SneakersAdapter(getContext(), list);
        rcvsneaker.setAdapter(sneakersAdapter);
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
                    sneakersAdapter = new SneakersAdapter(getContext(), searchList);
                    rcvsneaker.setAdapter(sneakersAdapter);
                    sneakersAdapter.notifyDataSetChanged();
                } else {
                    GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),2);
                    rcvsneaker.setLayoutManager(gridLayoutManager1);
                    sneakersAdapter = new SneakersAdapter(getContext(), list);
                    rcvsneaker.setAdapter(sneakersAdapter);
                    sneakersAdapter.notifyDataSetChanged();
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
                    sneakersAdapter = new SneakersAdapter(getContext(), searchList);
                    rcvsneaker.setAdapter(sneakersAdapter);
                    sneakersAdapter.notifyDataSetChanged();
                } else {
                    GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),2);
                    rcvsneaker.setLayoutManager(gridLayoutManager1);
                    sneakersAdapter = new SneakersAdapter(getContext(), list);
                    rcvsneaker.setAdapter(sneakersAdapter);
                    sneakersAdapter.notifyDataSetChanged();
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
        txtmota = view.findViewById(R.id.txtmota);
        btnthem = view.findViewById(R.id.btnthem);
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
                    else if(sanPhamDAO.insert(new SanPham(Integer.parseInt(id), ten, Integer.parseInt(gia), mota, url))) {
                        list.clear();
                        list.addAll(sanPhamDAO.selectAll());
                        dialog.dismiss();
                        sneakersAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}