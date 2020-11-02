package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.sach24h.ChiTietTheLoaiActivity;
import com.sinhvien.sach24h.Model.TheLoai;
import com.sinhvien.sach24h.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LoaiSanPhamAdapter extends RecyclerView.Adapter<LoaiSanPhamAdapter.ViewHolder> {
    Context context;
    List<TheLoai> theLoaiSach;

    public LoaiSanPhamAdapter(Context context, List<TheLoai> theLoaiSach) {
        this.context = context;
        this.theLoaiSach = theLoaiSach;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_loai_sach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picasso.with(context).load(theLoaiSach.get(position).getDuongDanHinhAnh())
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(holder.hinhTheLoai);
        holder.textViewTenLoaiSach.setText(theLoaiSach.get(position).getTenTheLoai());
        holder.itemLoaiSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moGiaoDienLoaiSach = new Intent(context, ChiTietTheLoaiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("matheloai", theLoaiSach.get(position).getId());
                moGiaoDienLoaiSach.putExtras(bundle);
                context.startActivity(moGiaoDienLoaiSach);
            }
        });
    }

    @Override
    public int getItemCount() {
        return theLoaiSach.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hinhTheLoai;
        TextView textViewTenLoaiSach;
        CardView itemLoaiSach;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhTheLoai = itemView.findViewById(R.id.hinhTheLoai);
            textViewTenLoaiSach = itemView.findViewById(R.id.textViewTenLoaiSach);
            itemLoaiSach = itemView.findViewById(R.id.itemLoaiSach);
        }
    }
}
