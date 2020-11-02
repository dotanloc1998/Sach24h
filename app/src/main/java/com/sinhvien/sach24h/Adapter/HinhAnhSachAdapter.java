package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.sach24h.ChiTietSanPhamActivity;
import com.sinhvien.sach24h.Model.HinhAnhSach;
import com.sinhvien.sach24h.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class HinhAnhSachAdapter extends RecyclerView.Adapter<HinhAnhSachAdapter.ViewHolder> {
    Context context;
    List<HinhAnhSach> hinhAnhSaches;

    public HinhAnhSachAdapter(Context context, List<HinhAnhSach> hinhAnhSaches) {
        this.context = context;
        this.hinhAnhSaches = hinhAnhSaches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_hinh_anh_san_pham, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String duongDanHinhAnh = hinhAnhSaches.get(position).getDuongDanHinhAnh();
        Picasso.with(context).load(duongDanHinhAnh)
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(holder.hinhAnhSanPham);
        holder.hinhAnhSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChiTietSanPhamActivity.GanHinhDaiDien(context, duongDanHinhAnh);
            }
        });
//        if (duongDanHinhAnh.substring(0, 4).equals("http")) {
//            Picasso.with(context).load(duongDanHinhAnh)
//                    .placeholder(R.drawable.logo)
//                    .error(R.drawable.errorimg)
//                    .into(holder.hinhAnhSanPham);
//            holder.hinhAnhSanPham.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ChiTietSanPhamActivity.GanHinhDaiDien(context, duongDanHinhAnh);
//                }
//            });
//        }
//        else {
//            Uri selectedImageUri = Uri.parse(duongDanHinhAnh);
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), selectedImageUri);
//                ChiTietSanPhamActivity.imageViewHinhSanPham.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            holder.hinhAnhSanPham.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });
//        }

    }

    @Override
    public int getItemCount() {
        return hinhAnhSaches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hinhAnhSanPham;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhAnhSanPham = itemView.findViewById(R.id.hinhAnhSanPham);
        }
    }
}
