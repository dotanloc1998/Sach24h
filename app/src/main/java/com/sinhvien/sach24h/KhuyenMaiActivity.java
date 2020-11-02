package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinhvien.sach24h.Model.KhuyenMai;
import com.sinhvien.sach24h.Model.MyDB;
import com.squareup.picasso.Picasso;

public class KhuyenMaiActivity extends AppCompatActivity {
    ImageView hinhSuKien;
    TextView textViewTenSuKien, textViewNgayBatDau, textViewNgayKetThuc, textViewNoiDungSuKien, textViewGiaTriKhuyenMai;
    KhuyenMai khuyenMai;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai);
        AnhXa();
        if (khuyenMai != null) {
            String hinhAnh = khuyenMai.getDuongDanHinhAnh();
            String ten = khuyenMai.getTenKhuyenMai();
            String noiDung = khuyenMai.getNoiDung();
            String ngayBatDau = khuyenMai.getNgayBatDau();
            String ngayKetThuc = khuyenMai.getNgayKetThuc();
            String giaTri = khuyenMai.getGiaTriKhuyenMai() + "";

            Picasso.with(getApplicationContext())
                    .load(hinhAnh)
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.errorimg)
                    .into(hinhSuKien);

            textViewNgayBatDau.setText("Ngày bắt đầu: " + ngayBatDau);
            textViewNgayKetThuc.setText("Ngày kết thúc: " + ngayKetThuc);
            textViewNoiDungSuKien.setText(noiDung);
            textViewTenSuKien.setText(ten);
            textViewGiaTriKhuyenMai.setText("Giá trị khuyến mãi: " + giaTri);
        }
    }

    private void AnhXa() {
        hinhSuKien = findViewById(R.id.hinhSuKien);
        textViewTenSuKien = findViewById(R.id.textViewTenSuKien);
        textViewNgayBatDau = findViewById(R.id.textViewNgayBatDau);
        textViewNgayKetThuc = findViewById(R.id.textViewNgayKetThuc);
        textViewNoiDungSuKien = findViewById(R.id.textViewNoiDungSuKien);
        textViewGiaTriKhuyenMai = findViewById(R.id.textViewGiaTriKhuyenMai);
        db = new MyDB(getApplicationContext());
        Bundle thongTin = new Bundle();
        thongTin = getIntent().getExtras();
        khuyenMai = db.LayKhuyenMai(thongTin.getInt("makhuyenmai"));
    }
}
