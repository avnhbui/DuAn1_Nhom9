package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.GioHangDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.GIoHang;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder>{

    private final Context context;
    private final List<GIoHang> list;
    GioHangDAO gioHangDAO;
    GIoHang index;

    public GioHangAdapter(Context context, List<GIoHang> list) {
        this.context = context;
        this.list = list;
        gioHangDAO = new GioHangDAO(context);

    }

    @NonNull
    @Override
    public GioHangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GioHangAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_giohang, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangAdapter.ViewHolder holder, int position) {
        String imagePath = list.get(position).getAnh();
        Glide.with(context)
                .load(imagePath)
                .into(holder.imgsp);
        holder.tensp.setText(list.get(position).getTen());
        holder.giasp.setText(String.valueOf(list.get(position).getGia()));
        holder.sizesp.setText(list.get(position).getSize());
        holder.mausp.setText(list.get(position).getMau());
        holder.soluong.setText(String.valueOf(1));
        holder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(holder.soluong.getText().toString());
                if (currentValue > 0) {
                    // Nếu giá trị hiện tại lớn hơn 0, thực hiện phép trừ
                    int newValue = currentValue - 1;
                    holder.soluong.setText(String.valueOf(newValue));
                } else {
                    // Nếu giá trị hiện tại là 0, không thực hiện phép trừ
                    // Bạn có thể hiển thị thông báo hoặc thực hiện hành động khác tùy thuộc vào yêu cầu của bạn.
                    Toast.makeText(v.getContext(), "Không thể giảm giá trị dưới 0", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = list.get(position);
                openDialog_del();
            }
        });
        holder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(holder.soluong.getText().toString());
                int newValue = currentValue + 1;
                holder.soluong.setText(String.valueOf(newValue));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgsp;
        ImageButton btntru, btncong, btnxoa;
        TextView tensp, giasp,sizesp, mausp, soluong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgsp = itemView.findViewById(R.id.imgsp);
            tensp = itemView.findViewById(R.id.tensp);
            giasp = itemView.findViewById(R.id.giasp);
            sizesp = itemView.findViewById(R.id.sizesp);
            mausp = itemView.findViewById(R.id.mausp);
            soluong = itemView.findViewById(R.id.soluong);
            btntru = itemView.findViewById(R.id.btntru);
            btncong = itemView.findViewById(R.id.btncong);
            btnxoa = itemView.findViewById(R.id.btnxoa);

        }
    }
    public void openDialog_del() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.warning);
        builder.setTitle("Warning");
        builder.setMessage("Bạn có chắc chắn muốn xóa không ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (gioHangDAO.delete(index.getIdgiohang())) {
                    list.clear();
                    list.addAll(gioHangDAO.selectAll());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }
}
