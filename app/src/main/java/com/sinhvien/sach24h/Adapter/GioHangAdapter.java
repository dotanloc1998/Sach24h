package com.sinhvien.sach24h.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.sach24h.CartActivity;
import com.sinhvien.sach24h.Model.GioHang;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.R;
import com.sinhvien.sach24h.ViewModel.ViewModelGioHang;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    List<ViewModelGioHang> gioHangs;
    MyDB db;

    public GioHangAdapter(Context context, List<ViewModelGioHang> gioHangs) {
        this.context = context;
        this.gioHangs = gioHangs;
    }

    @Override
    public int getCount() {
        return gioHangs.size();
    }

    @Override
    public Object getItem(int i) {
        return gioHangs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        ImageView imageViewHinhSanPham;
        Button buttonDauTru, buttonDauCong;
        TextView textViewTenSanPham, textViewGiaSanPham, textViewSoLuongSanPham;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_gio_hang, null);
            viewHolder = new ViewHolder();
            viewHolder.imageViewHinhSanPham = view.findViewById(R.id.imageViewHinhSanPham);
            viewHolder.buttonDauTru = view.findViewById(R.id.buttonDauTru);
            viewHolder.buttonDauCong = view.findViewById(R.id.buttonDauCong);
            viewHolder.textViewSoLuongSanPham = view.findViewById(R.id.textViewSoLuongSanPham);
            viewHolder.textViewTenSanPham = view.findViewById(R.id.textViewTenSanPham);
            viewHolder.textViewGiaSanPham = view.findViewById(R.id.textViewGiaSanPham);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final ViewModelGioHang gioHang = gioHangs.get(i);
        db = new MyDB(context);
        Picasso.with(context)
                .load(gioHang.getHinhAnhSach())
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(viewHolder.imageViewHinhSanPham);
        viewHolder.textViewSoLuongSanPham.setText(gioHang.getSoLuong() + "");
        viewHolder.textViewGiaSanPham.setText("Giá sản phẩm: " + (gioHang.getGia() * gioHang.getSoLuong()) + " $");
        viewHolder.textViewTenSanPham.setText(gioHang.getTenSach());

        viewHolder.buttonDauTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gioHang.getSoLuong() == 1) {
                    Toast.makeText(context, "SL không được nhỏ hơn 1", Toast.LENGTH_SHORT).show();
                } else {
                    gioHang.setSoLuong(gioHang.getSoLuong() - 1);
                    viewHolder.textViewSoLuongSanPham.setText("" + gioHang.getSoLuong());
                    db.CapNhatGioHang(new GioHang(gioHang.getIdSach(), gioHang.getSoLuong(), db.LayTaiKhoanDangDangNhap()));
                    viewHolder.textViewGiaSanPham.setText("Giá sản phẩm: " + (gioHang.getGia() * gioHang.getSoLuong()) + " $");

                    CartActivity.tongTien -= gioHang.getGia();
                    CartActivity.textViewTongTien.setText(context.getString(R.string.tongTien) + " " + CartActivity.tongTien + " $");
                }
            }
        });

        viewHolder.buttonDauCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gioHang.setSoLuong(gioHang.getSoLuong() + 1);
                viewHolder.textViewSoLuongSanPham.setText("" + gioHang.getSoLuong());
                db.CapNhatGioHang(new GioHang(gioHang.getIdSach(), gioHang.getSoLuong(), db.LayTaiKhoanDangDangNhap()));
                viewHolder.textViewGiaSanPham.setText("Giá sản phẩm: " + (gioHang.getGia() * gioHang.getSoLuong()) + " $");

                CartActivity.tongTien += gioHang.getGia();
                CartActivity.textViewTongTien.setText(context.getString(R.string.tongTien) + " " + CartActivity.tongTien + " $");

            }
        });

        return view;
    }
}
