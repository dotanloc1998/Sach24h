package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sinhvien.sach24h.Model.BinhLuan;
import com.sinhvien.sach24h.R;

import java.util.List;

public class BinhLuanAdapter extends BaseAdapter {
    Context context;
    List<BinhLuan> binhLuans;

    public BinhLuanAdapter(Context context, List<BinhLuan> binhLuans) {
        this.context = context;
        this.binhLuans = binhLuans;
    }

    @Override
    public int getCount() {
        return binhLuans.size();
    }

    @Override
    public Object getItem(int i) {
        return binhLuans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return binhLuans.get(i).getId();
    }

    public class ViewHolder {
        TextView textViewTenNguoiDung, textViewSoDiem, textViewNoiDungComment;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_binh_luan, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewTenNguoiDung = view.findViewById(R.id.textViewTenNguoiDung);
            viewHolder.textViewSoDiem = view.findViewById(R.id.textViewSoDiem);
            viewHolder.textViewNoiDungComment = view.findViewById(R.id.textViewNoiDungComment);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BinhLuan binhLuan = binhLuans.get(i);
        viewHolder.textViewTenNguoiDung.setText(binhLuan.getEmail());
        viewHolder.textViewSoDiem.setText(binhLuan.getSoDiem() + "");
        viewHolder.textViewNoiDungComment.setText(binhLuan.getNoiDung());
        return view;
    }
}
