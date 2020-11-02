package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sinhvien.sach24h.Model.DonHang;
import com.sinhvien.sach24h.R;

import java.util.List;

public class DonHangNguoiDungAdapter extends BaseAdapter {
    Context context;
    List<DonHang> donHangs;

    public DonHangNguoiDungAdapter(Context context, List<DonHang> donHangs) {
        this.context = context;
        this.donHangs = donHangs;
    }

    @Override
    public int getCount() {
        return donHangs.size();
    }

    @Override
    public Object getItem(int i) {
        return donHangs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        TextView textViewMaDonHang, textViewNgayGiao, textViewNgayTao, textViewTongTien, textViewTrangThai;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_don_hang_nguoi_dung, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewMaDonHang = view.findViewById(R.id.textViewMaDonHang);
            viewHolder.textViewNgayGiao = view.findViewById(R.id.textViewNgayGiao);
            viewHolder.textViewNgayTao = view.findViewById(R.id.textViewNgayTao);
            viewHolder.textViewTongTien = view.findViewById(R.id.textViewTongTien);
            viewHolder.textViewTrangThai = view.findViewById(R.id.textViewTrangThai);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DonHang donHang = donHangs.get(i);
        viewHolder.textViewMaDonHang.setText(context.getString(R.string.maDonHang) + " " + donHang.getMaHoaDon());
        viewHolder.textViewNgayGiao.setText(context.getString(R.string.ngayGiao) + " " + donHang.getNgayGiao());
        viewHolder.textViewNgayTao.setText(context.getString(R.string.ngayTao) + " " + donHang.getNgayTao());
        viewHolder.textViewTongTien.setText(context.getString(R.string.tongTien) + " " + donHang.getTongTien() + " $");
        viewHolder.textViewTrangThai.setText(context.getString(R.string.trangThai) + " " + donHang.getTrangThai());
        return view;
    }
}
