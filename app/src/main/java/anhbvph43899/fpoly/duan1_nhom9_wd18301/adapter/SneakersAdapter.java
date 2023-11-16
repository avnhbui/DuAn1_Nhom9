package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SneakersTrangChu;

public class SneakersAdapter extends RecyclerView.Adapter<SneakersAdapter.ViewHolder>{
    private final Context context;
    private final List<SneakersTrangChu> list;

    public SneakersAdapter(Context context, ArrayList<SneakersTrangChu> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SneakersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sneakers, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SneakersAdapter.ViewHolder holder, int position) {
        holder.imgsnk.setImageResource(list.get(position).getAnhsp());
        holder.tensnk.setText(list.get(position).getTensp());
        holder.giasnk.setText(String.valueOf(list.get(position).getGia()));
        holder.dabansnk.setText(String.valueOf(list.get(position).getDaban()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgsnk;
        TextView tensnk, giasnk,dabansnk;
            public ViewHolder(@NonNull View itemView) {
            super(itemView);
                imgsnk = itemView.findViewById(R.id.imgsnk);
                tensnk = itemView.findViewById(R.id.tensnk);
                giasnk = itemView.findViewById(R.id.giasnk);
                dabansnk = itemView.findViewById(R.id.dabansnk);
            }
    }
}
