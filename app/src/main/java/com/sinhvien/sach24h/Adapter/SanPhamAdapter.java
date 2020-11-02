package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinhvien.sach24h.R;
import com.sinhvien.sach24h.ViewModel.ViewModelSach;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    Context context;
    List<ViewModelSach> saches;

    public SanPhamAdapter(Context context, List<ViewModelSach> saches) {
        this.context = context;
        this.saches = saches;
    }

    @Override
    public int getCount() {
        return saches.size();
    }

    @Override
    public Object getItem(int i) {
        return saches.get(i);
    }

    @Override
    public long getItemId(int i) {
        return saches.get(i).getId();
    }

    public class ViewHolder {
        ImageView imageViewHinhSanPham;
        TextView textViewTenSanPham, textViewGiaTruocGiam, textViewGiaSanPham, textViewMoTaSanPham;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_san_pham, null);
            viewHolder = new ViewHolder();
            viewHolder.imageViewHinhSanPham = view.findViewById(R.id.imageViewHinhSanPham);
            viewHolder.textViewTenSanPham = view.findViewById(R.id.textViewTenSanPham);
            //viewHolder.textViewGiaTruocGiam = view.findViewById(R.id.textViewGiaTruocGiam);
            viewHolder.textViewGiaSanPham = view.findViewById(R.id.textViewGiaSanPham);
            viewHolder.textViewMoTaSanPham = view.findViewById(R.id.textViewMoTaSanPham);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ViewModelSach sach = saches.get(i);
        Picasso.with(context).load(sach.getDuongDanHinhAnh())
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(viewHolder.imageViewHinhSanPham);
        viewHolder.textViewGiaSanPham.setText(sach.getGia() + " $");
        viewHolder.textViewTenSanPham.setText(sach.getTenSach());
        viewHolder.textViewMoTaSanPham.setText(sach.getMoTa());
        //Cho hiển thị tối đã 2 dòng ở ngoài
        viewHolder.textViewMoTaSanPham.setMaxLines(2);
        //Dấu 3 chấm ở cuối
        viewHolder.textViewMoTaSanPham.setEllipsize(TextUtils.TruncateAt.END);
        return view;
    }
}
