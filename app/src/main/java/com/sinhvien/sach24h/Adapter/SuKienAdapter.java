package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.sinhvien.sach24h.R;
import com.sinhvien.sach24h.ViewModel.ViewModelSuKien;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SuKienAdapter extends BaseAdapter {
    Context context;
    List<ViewModelSuKien> suKiens;

    public SuKienAdapter(Context context, List<ViewModelSuKien> suKiens) {
        this.context = context;
        this.suKiens = suKiens;
    }

    @Override
    public int getCount() {
        return suKiens.size();
    }

    @Override
    public Object getItem(int i) {
        return suKiens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return suKiens.get(i).getIdSuKien();
    }

    public class ViewHolder {
        ImageView hinhSuKien;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_su_kien, null);
            viewHolder = new ViewHolder();
            viewHolder.hinhSuKien = view.findViewById(R.id.hinhSuKien);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ViewModelSuKien suKien = suKiens.get(i);
        Picasso.with(context)
                .load(suKien.getHinhAnhSuKien())
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(viewHolder.hinhSuKien);

        return view;
    }
}
