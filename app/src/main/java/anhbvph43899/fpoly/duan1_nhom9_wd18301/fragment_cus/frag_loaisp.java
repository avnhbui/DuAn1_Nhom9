package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.LoaiSPCusApdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.QLSPAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;

public class frag_loaisp extends Fragment {
    RecyclerView rcvsneaker;
    LoaiSPCusApdapter loaiSPAdapter;
    ArrayList<LoaiSP> list = new ArrayList<>();
    LoaiSPDAO loaiSPDAO;


    public frag_loaisp() {
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
        View view = inflater.inflate(R.layout.fragment_frag_loaisp, container, false);
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        loaiSPDAO = new LoaiSPDAO(getContext());
        list = loaiSPDAO.selectAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvsneaker.setLayoutManager(linearLayoutManager);
        loaiSPAdapter = new LoaiSPCusApdapter(getContext(), list);
        rcvsneaker.setAdapter(loaiSPAdapter);
        return view;
    }
}