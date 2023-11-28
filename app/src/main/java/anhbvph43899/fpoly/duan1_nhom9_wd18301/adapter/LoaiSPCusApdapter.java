package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;

public class LoaiSPCusApdapter extends RecyclerView.Adapter<LoaiSPCusApdapter.ViewHolder>{

    private final Context context;
    private final List<LoaiSP> list;
    LoaiSPDAO loaiSPDAO;

    public LoaiSPCusApdapter(Context context, List<LoaiSP> list) {
        this.context = context;
        this.list = list;
        loaiSPDAO = new LoaiSPDAO(context);

    }

    @NonNull
    @Override
    public LoaiSPCusApdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoaiSPCusApdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_loaispcus, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSPCusApdapter.ViewHolder holder, int position) {
        holder.tvtenloaisp.setText(list.get(position).getTenLoaiSP());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtenloaisp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtenloaisp = itemView.findViewById(R.id.tvtenloaisp);

        }
    }
}
