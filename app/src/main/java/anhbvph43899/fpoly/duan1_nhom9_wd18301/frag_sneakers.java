package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.SneakersAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SneakersTrangChu;


public class frag_sneakers extends Fragment {
    SneakersAdapter sneakersAdapter;
    //    SneakersTCDAO sneakersTCDAO;
    ArrayList<SneakersTrangChu> list = new ArrayList<>();

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
        RecyclerView rcvsneaker;

        View view = inflater.inflate(R.layout.fragment_frag_sneakers, container, false);
        rcvsneaker = view.findViewById(R.id.rcvsneakers);
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air1", 600000,0));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air2", 700000,1));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air3", 800000,2));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air4", 900000,3));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air5", 1000000,4));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air6", 2000000,5));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air7", 3000000,6));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rcvsneaker.setLayoutManager(gridLayoutManager);
        sneakersAdapter = new SneakersAdapter(getContext(), list);
        rcvsneaker.setAdapter(sneakersAdapter);
        return view;
    }
}