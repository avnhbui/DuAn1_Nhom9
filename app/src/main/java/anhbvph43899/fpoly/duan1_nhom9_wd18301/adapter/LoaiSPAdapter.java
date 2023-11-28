package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;

public class LoaiSPAdapter extends RecyclerView.Adapter<LoaiSPAdapter.ViewHolder>{
    private final Context context;
    private final List<LoaiSP> list;
    LoaiSPDAO loaiSPDAO;
    LoaiSP loaiSP;
    public LoaiSPAdapter(Context context, List<LoaiSP> list) {
        this.context = context;
        this.list = list;
        loaiSPDAO = new LoaiSPDAO(context);
    }

    @NonNull
    @Override
    public LoaiSPAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoaiSPAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_qlloaisp, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSPAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvtidloai.setText(String.valueOf(list.get(position).getIdloaiSP()));
        holder.tvtenloai.setText(list.get(position).getTenLoaiSP());
        holder.btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaiSP = list.get(position);
                OpenDialog_Update();

            }
        });
        holder.btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaiSP = list.get(position);
                openDialog_del();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
TextView tvtenloai, tvtidloai;
ImageButton btnsua, btnxoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtenloai = itemView.findViewById(R.id.tvtenloai);
            tvtidloai = itemView.findViewById(R.id.tvtidloai);
            btnsua = itemView.findViewById(R.id.btnsua);
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
                if (loaiSPDAO.delete(loaiSP.getIdloaiSP())) {
                    list.clear();
                    list.addAll(loaiSPDAO.selectAll());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "XÓa thất bại", Toast.LENGTH_SHORT).show();
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
    public void OpenDialog_Update() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaisuasp, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        TextView btn_LSP,btnSua_tenSP;
        btnSua_tenSP = view.findViewById(R.id.btnSua_tenSP);

        btnSua_tenSP.setText(loaiSP.getTenLoaiSP());

        view.findViewById(R.id.btn_LSP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenLoai = btnSua_tenSP.getText().toString();

                loaiSP.setTenLoaiSP(tenLoai);

                if(tenLoai.isEmpty()) {
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(loaiSPDAO.update(loaiSP)) {
                        list.clear();
                        list.addAll(loaiSPDAO.selectAll());
                        dialog.dismiss();
                        notifyDataSetChanged();
                        Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Update thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
