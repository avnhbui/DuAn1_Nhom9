package anhbvph43899.fpoly.duan1_nhom9_wd18301;

import android.os.Bundle;

import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

//import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SneakersTCDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.BrandsAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter.SneakersAdapter;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SneakersTrangChu;


public class frag_trangchu extends Fragment {
    SneakersAdapter sneakersAdapter;
//    SneakersTCDAO sneakersTCDAO;
SearchView searchView;
    ArrayList<SneakersTrangChu> searchList;

    ArrayList<SneakersTrangChu> list = new ArrayList<>();
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
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air1 Puma", 600000,0));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air2 Adidas", 700000,1));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air3 Nike", 800000,2));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air4 Converse", 900000,3));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air5 Vans", 1000000,4));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air6 Tesla", 2000000,5));
        list.add(new SneakersTrangChu(R.drawable.airnu,"Air7 Way", 3000000,6));
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
                            SneakersTrangChu s = new SneakersTrangChu();
                            s.setAnhsp(list.get(i).getAnhsp());
                            s.setTensp(list.get(i).getTensp());
                            s.setGia(list.get(i).getGia());
                            s.setDaban(list.get(i).getDaban());
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
                            SneakersTrangChu s = new SneakersTrangChu();
                            s.setAnhsp(list.get(i).getAnhsp());
                            s.setTensp(list.get(i).getTensp());
                            s.setGia(list.get(i).getGia());
                            s.setDaban(list.get(i).getDaban());
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