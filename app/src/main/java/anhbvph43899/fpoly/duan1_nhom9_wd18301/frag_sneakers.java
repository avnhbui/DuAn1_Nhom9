package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.SneakersAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;


public class frag_sneakers extends Fragment {
    SearchView searchView;
    SneakersAdapter sneakersAdapter;
    //    SneakersTCDAO sneakersTCDAO;
    ArrayList<SanPham> searchList;
    ArrayList<SanPham> list = new ArrayList<>();
    RecyclerView rcvsneaker;
    SanPhamDAO sanPhamDAO;
    public frag_sneakers() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sanPhamDAO = new SanPhamDAO(getContext());


        View view = inflater.inflate(R.layout.fragment_frag_sneakers, container, false);
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        list = sanPhamDAO.selectAll();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rcvsneaker.setLayoutManager(gridLayoutManager);
        sneakersAdapter = new SneakersAdapter(getContext(), list);
        rcvsneaker.setAdapter(sneakersAdapter);
        searchView = view.findViewById(R.id.searchview);
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
    }
