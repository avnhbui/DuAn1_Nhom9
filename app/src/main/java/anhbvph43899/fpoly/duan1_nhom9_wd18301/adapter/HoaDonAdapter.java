package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.HoaDon;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SPBienThe;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.ViewHolder>{
    private final Context context;
    private final List<HoaDon> list;

    public HoaDonAdapter(Context context, List<HoaDon> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HoaDonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HoaDonAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_hoadon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HoaDonAdapter.ViewHolder holder, int position) {
        holder.tvtenkh.setText(list.get(position).getTenkh());
        holder.tvsdt.setText(String.valueOf(list.get(position).getSdt()));
        holder.tvdiachi.setText(list.get(position).getDiaChi());
        holder.tvtensp.setText(list.get(position).getTenSP());
        holder.tvsize.setText(list.get(position).getSize());
        holder.tvmau.setText(list.get(position).getMau());
        holder.tvsoluong.setText(String.valueOf(list.get(position).getSoLuong()));
        holder.tvtongtien.setText(String.valueOf(list.get(position).getTongTien()));
        holder.tvngaymau.setText(list.get(position).getNgayMua());
        holder.tvngaymau.setText(list.get(position).getNgayMua());
        holder.tvtrangthai.setText(String.valueOf(list.get(position).getTrangThai()));
        if (list.get(position).getTrangThai() == 1) {
            holder.tvtrangthai.setText("Đã xác nhận");
            holder.tvtrangthai.setTextColor(Color.argb(255,22,255,22));
        } else {
            holder.tvtrangthai.setText("Đang chờ xác nhận");
            holder.tvtrangthai.setTextColor(Color.argb(255 ,255 ,22,22));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtenkh,tvsdt,tvdiachi,tvtensp,tvsize,tvmau,tvsoluong,tvtongtien,tvngaymau, tvtrangthai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtenkh = itemView.findViewById(R.id.tvtenkh);
            tvsdt = itemView.findViewById(R.id.tvsdt);
            tvdiachi = itemView.findViewById(R.id.tvdiachi);
            tvtensp = itemView.findViewById(R.id.tvtensp);
            tvsize = itemView.findViewById(R.id.tvsize);
            tvmau = itemView.findViewById(R.id.tvmau);
            tvsoluong = itemView.findViewById(R.id.tvsoluong);
            tvtongtien = itemView.findViewById(R.id.tvtongtien);
            tvngaymau = itemView.findViewById(R.id.tvngaymau);
            tvtrangthai = itemView.findViewById(R.id.tvtrangthai);

        }

    }

}
