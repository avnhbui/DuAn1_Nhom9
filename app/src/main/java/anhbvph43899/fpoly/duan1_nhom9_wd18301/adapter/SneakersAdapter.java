package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.fragment.TaoDon;
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
        holder.idsp.setText(String.valueOf(list.get(position).getIdSP()));
        String imagePath = list.get(position).getAnh(); // Đường dẫn ảnh (string)
        Glide.with(context)
                .load(imagePath)
                .into(holder.imgsnk);
        holder.tensnk.setText(list.get(position).getTensp());
        holder.giasnk.setText(String.valueOf(list.get(position).getGia()));
        holder.btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexSP = list.get(position);
                openDialog_del();
            }
        });
        holder.btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexSP = list.get(position);
                OpenDialog_Update();
            }
        });
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
                fragment.setArguments(bundle);
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
        ImageButton btnxoa, btnsua;
        TextView idsp,tensnk, giasnk;
            public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnxoa = itemView.findViewById(R.id.btnxoa);
            btnsua = itemView.findViewById(R.id.btnsua);
            idsp = itemView.findViewById(R.id.tvidsp);
            imgsnk = itemView.findViewById(R.id.imgsnk);
            tensnk = itemView.findViewById(R.id.tensnk);
            giasnk = itemView.findViewById(R.id.giasnk);
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
                if (sanPhamDAO.delete(indexSP.getIdSP())) {
                    list.clear();
                    list.addAll(sanPhamDAO.selectAll());
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
    public void OpenDialog_Update() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_suasp, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        txturl = view.findViewById(R.id.txturl);
        txtid = view.findViewById(R.id.txtid);
        txtten = view.findViewById(R.id.txtten);
        txtgia = view.findViewById(R.id.txtgia);
        btnluu = view.findViewById(R.id.btnluu);

        txturl.setText(String.valueOf(indexSP.getAnh()));
        txtid.setText(String.valueOf(indexSP.getIdSP()));
        txtten.setText(String.valueOf(indexSP.getTensp()));
        txtgia.setText(String.valueOf(indexSP.getGia()));

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = txturl.getText().toString();
                String id = txtid.getText().toString();
                String ten = txtten.getText().toString();
                String gia = txtgia.getText().toString();
                indexSP.setAnh(url);
                indexSP.setIdSP(Integer.valueOf(id));
                indexSP.setTensp(ten);
                indexSP.setGia(Integer.valueOf(gia));
                if(url.isEmpty() || id.isEmpty() || ten.isEmpty() ||gia.isEmpty()  ) {
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(gia.matches("\\d+") == false) {
                        Toast.makeText(context, "Giá thuê sai định dạng", Toast.LENGTH_SHORT).show();
                    } else if(Integer.valueOf(gia) < 0) {
                        Toast.makeText(context, "Giá thuê phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                    }
                    else if(sanPhamDAO.update(indexSP)) {
                        list.clear();
                        list.addAll(sanPhamDAO.selectAll());
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
