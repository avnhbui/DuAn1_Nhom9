package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.BrandsViewHolder>{
   List<String> list;

    public BrandsAdapter(List<String> list1) {
        this.list= list1;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public BrandsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_btnbrands, parent, false);
        return new BrandsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsViewHolder holder, int position) {
        holder.imageView.setImageResource(Integer.parseInt(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BrandsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public BrandsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgbrands);
        }
    }
}
