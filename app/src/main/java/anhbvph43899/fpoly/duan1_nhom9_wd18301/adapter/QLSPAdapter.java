package anhbvph43899.fpoly.duan1_nhom9_wd18301.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.LoaiSPDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.DAO.SanPhamDAO;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.R;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.LoaiSP;
import anhbvph43899.fpoly.duan1_nhom9_wd18301.model.SanPham;

public class QLSPAdapter extends RecyclerView.Adapter<QLSPAdapter.ViewHolder>{
    private final Context context;
    private final List<SanPham> list;
    EditText txturl, txtid, txtten, txtgia, txtmota;
    Button btnluu;
    Spinner spnLoaiSP;
    SanPham indexSP;
    SanPhamDAO sanPhamDAO;
    int index;
    LoaiSPDAO loaiSPDAO;

    public QLSPAdapter(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
        sanPhamDAO = new SanPhamDAO(context);
        loaiSPDAO = new LoaiSPDAO(context);

    }

    @NonNull
    @Override
    public QLSPAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QLSPAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.qlsp_admin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QLSPAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.qlsp_idsp.setText(String.valueOf(list.get(position).getIdSP()));
        String imagePath = list.get(position).getAnh(); // Đường dẫn ảnh (string)
        Glide.with(context)
                .load(imagePath)
                .into(holder.qsp_img);
        holder.qlsp_tensp.setText(list.get(position).getTensp());
        holder.qlsp_giasp.setText(String.valueOf(list.get(position).getGia()));
        holder.qlsp_loaisp.setText(list.get(position).getLoaisp());
        holder.qlsp_motasp.setText(list.get(position).getMotaSP());
        holder.qlsp_btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexSP = list.get(position);
                openDialog_del();
            }
        });
        holder.qlsp_btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexSP = list.get(position);
                OpenDialog_Update();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView qsp_img;
        TextView qlsp_idsp, qlsp_tensp, qlsp_giasp, qlsp_motasp, qlsp_loaisp;
        ImageButton qlsp_btnxoa, qlsp_btnsua;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            qsp_img = itemView.findViewById(R.id.qsp_img);
            qlsp_idsp = itemView.findViewById(R.id.qlsp_idsp);
            qlsp_tensp = itemView.findViewById(R.id.qlsp_tensp);
            qlsp_giasp = itemView.findViewById(R.id.qlsp_giasp);
            qlsp_loaisp = itemView.findViewById(R.id.qlsp_loaisp);
            qlsp_motasp = itemView.findViewById(R.id.qlsp_motasp);
            qlsp_btnxoa = itemView.findViewById(R.id.qlsp_btnxoa);
            qlsp_btnsua = itemView.findViewById(R.id.qlsp_btnsua);
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
        spnLoaiSP = view.findViewById(R.id.spnLoaiSP);
        txtmota = view.findViewById(R.id.txtmota);
        btnluu = view.findViewById(R.id.btnluu);
        txturl.setText(String.valueOf(indexSP.getAnh()));
        txtid.setText(String.valueOf(indexSP.getIdSP()));
        txtten.setText(String.valueOf(indexSP.getTensp()));
        txtgia.setText(String.valueOf(indexSP.getGia()));
        txtmota.setText(String.valueOf(indexSP.getMotaSP()));
        ArrayList<LoaiSP> listLS = new ArrayList<>();
        listLS = loaiSPDAO.selectAll();
        ArrayList<String> loaiSPArr = new ArrayList<>();
        for (LoaiSP x: listLS) {
            loaiSPArr.add(x.getTenLoaiSP());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, loaiSPArr);
        spnLoaiSP.setAdapter(adapter);

        for (int i = 0; i < loaiSPArr.size(); i++) {
            if (loaiSPArr.get(i).toString().equals(indexSP.getLoaisp())) {
                spnLoaiSP.setSelection(i);
            }
        }
        spnLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = loaiSPDAO.getMaLoai(loaiSPArr.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = txturl.getText().toString();
                String id = txtid.getText().toString();
                String ten = txtten.getText().toString();
                String gia = txtgia.getText().toString();
                String mota = txtmota.getText().toString();
                indexSP.setAnh(url);
                indexSP.setIdSP(Integer.valueOf(id));
                indexSP.setTensp(ten);
                indexSP.setGia(Integer.valueOf(gia));
                indexSP.setMotaSP(mota);
                if(url.isEmpty() || id.isEmpty() || ten.isEmpty() ||gia.isEmpty()||mota.isEmpty()) {
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
