package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder>{

    private final Context context;
    private final List<SanPham> list;

    public GioHangAdapter(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GioHangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GioHangAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_giohang, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgsp;
        TextView tensp, giasp, soluong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgsp = itemView.findViewById(R.id.imgsp);
            tensp = itemView.findViewById(R.id.tensp);
            giasp = itemView.findViewById(R.id.giasp);
            soluong = itemView.findViewById(R.id.soluong);
        }
    }
}
