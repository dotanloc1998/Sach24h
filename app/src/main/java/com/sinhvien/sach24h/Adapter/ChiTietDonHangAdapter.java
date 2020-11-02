package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinhvien.sach24h.R;
import com.sinhvien.sach24h.ViewModel.ViewModelChiTietDonHang;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChiTietDonHangAdapter extends BaseAdapter {
    Context context;
    List<ViewModelChiTietDonHang> chiTietDonHangs;

    public ChiTietDonHangAdapter(Context context, List<ViewModelChiTietDonHang> chiTietDonHangs) {
        this.context = context;
        this.chiTietDonHangs = chiTietDonHangs;
    }

    @Override
    public int getCount() {
        return chiTietDonHangs.size();
    }

    @Override
    public Object getItem(int i) {
        return chiTietDonHangs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        ImageView imageViewHinhSanPham;
        TextView textViewTenSanPham, textViewGiaSanPham, textViewSoLuongSanPham, textViewThanhTien;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_chi_tiet_don_hang_nguoi_dung, null);
            viewHolder = new ViewHolder();
            viewHolder.imageViewHinhSanPham = view.findViewById(R.id.imageViewHinhSanPham);
            viewHolder.textViewTenSanPham = view.findViewById(R.id.textViewTenSanPham);
            viewHolder.textViewGiaSanPham = view.findViewById(R.id.textViewGiaSanPham);
            viewHolder.textViewSoLuongSanPham = view.findViewById(R.id.textViewSoLuongSanPham);
            viewHolder.textViewThanhTien = view.findViewById(R.id.textViewThanhTien);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ViewModelChiTietDonHang chiTietDonHang = chiTietDonHangs.get(i);

        Picasso.with(context)
                .load(chiTietDonHang.getHinhAnhSach())
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(viewHolder.imageViewHinhSanPham);

        viewHolder.textViewTenSanPham.setText(chiTietDonHang.getTenSach());
        viewHolder.textViewGiaSanPham.setText("Giá sản phẩm: " + chiTietDonHang.getGia() + " $");
        viewHolder.textViewSoLuongSanPham.setText("Số lượng sản phẩm: " + chiTietDonHang.getSoLuong());
        viewHolder.textViewThanhTien.setText("Thành tiền: " + (chiTietDonHang.getGia() * chiTietDonHang.getSoLuong()) + " $");

        return view;
    }
}
