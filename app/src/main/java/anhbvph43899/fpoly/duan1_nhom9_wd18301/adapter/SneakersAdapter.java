package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus.TaoDon;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment_cus.frag_muahang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class SneakersAdapter extends RecyclerView.Adapter<SneakersAdapter.ViewHolder>{
    private final Context context;
    private final List<SanPham> list;
    SanPham indexSP;
    SanPhamDAO sanPhamDAO;
    EditText txturl, txtid, txtten, txtgia;
    Button btnluu;
    FragmentManager fragmentManager;

    public SneakersAdapter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
        sanPhamDAO = new SanPhamDAO(context);
    }

    @NonNull
    @Override
    public SneakersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sneakers, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String imagePath = list.get(position).getAnh();
        Glide.with(context)
                .load(imagePath)
                .into(holder.imgsnk);
        holder.tensnk.setText(list.get(position).getTensp());
        holder.giasnk.setText(String.valueOf(list.get(position).getGia()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham spdcchon = list.get(position);
                Fragment fragment = new TaoDon();
                Bundle bundle = new Bundle();
                bundle.putString("anh", spdcchon.getAnh());
                bundle.putString("ten", spdcchon.getTensp());
                bundle.putString("gia", String.valueOf(spdcchon.getGia()));
                bundle.putString("mota", spdcchon.getMotaSP());
                bundle.putString("tenloaisp", spdcchon.getLoaisp());
                fragment.setArguments(bundle);

                Fragment fragment1 = new frag_muahang();
                Bundle bundle1 = new Bundle();
                bundle1.putString("anh1", spdcchon.getAnh());
                bundle1.putString("ten1", spdcchon.getTensp());
                bundle1.putString("gia1", String.valueOf(spdcchon.getGia()));
                bundle1.putString("mota1", spdcchon.getMotaSP());
                bundle1.putString("tenloaisp1", spdcchon.getLoaisp());
                fragment1.setArguments(bundle1);

                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

                // Bắt đầu giao dịch FragmentTransaction
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Thực hiện thay thế Fragment hiện tại bằng Fragment mới
                fragmentTransaction.replace(R.id.framelayout, fragment);

                // Thêm transaction vào Back Stack (nếu muốn)
                fragmentTransaction.addToBackStack(null);

                // Chấp nhận và thực hiện giao dịch
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgsnk;

        TextView tensnk, giasnk;
            public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgsnk = itemView.findViewById(R.id.imgsnk);
            tensnk = itemView.findViewById(R.id.tensnk);
            giasnk = itemView.findViewById(R.id.giasnk);
            }
    }




}
