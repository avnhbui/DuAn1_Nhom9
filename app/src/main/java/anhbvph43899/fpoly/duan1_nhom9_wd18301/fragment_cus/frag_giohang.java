package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.GioHangDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.GioHangAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.LoaiSPCusApdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.GIoHang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;


public class frag_giohang extends Fragment {

    RecyclerView rcvsneaker;
    GioHangAdapter gioHangAdapter;
    ArrayList<GIoHang> list = new ArrayList<>();
    GioHangDAO gioHangDAO;
    public frag_giohang() {
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
        View view = inflater.inflate(R.layout.fragment_frag_giohang, container, false);
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        gioHangDAO = new GioHangDAO(getContext());
        list = gioHangDAO.selectAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvsneaker.setLayoutManager(linearLayoutManager);
        gioHangAdapter = new GioHangAdapter(getContext(), list);
        rcvsneaker.setAdapter(gioHangAdapter);
        gioHangAdapter.notifyDataSetChanged();

        return view;
    }
}