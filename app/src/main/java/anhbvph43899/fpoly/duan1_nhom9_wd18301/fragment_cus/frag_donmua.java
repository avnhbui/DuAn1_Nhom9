package anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.HoaDonDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.HoaDonAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.SneakersAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.HoaDon;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;


public class frag_donmua extends Fragment {

    HoaDonDAO hoaDonDAO;
    RecyclerView rcvsneaker;

    HoaDonAdapter hoaDonAdapter;
    ArrayList<HoaDon> list = new ArrayList<>();



    public frag_donmua() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        hoaDonDAO = new HoaDonDAO(getContext());
        View view = inflater.inflate(R.layout.fragment_frag_donmua, container, false);
        rcvsneaker = view.findViewById(R.id.rcvsneakersdonmua);
        list = hoaDonDAO.selectAll();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rcvsneaker.setLayoutManager(gridLayoutManager);
        hoaDonAdapter = new HoaDonAdapter(getContext(), list);
        rcvsneaker.setAdapter(hoaDonAdapter);
        return view;
    }
}