package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.sach24h.Adapter.ChiTietDonHangAdapter;
import com.sinhvien.sach24h.Model.FeedBack;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.ViewModel.ViewModelChiTietDonHang;

import java.util.List;

public class ChiTietDonHangActivity extends AppCompatActivity {
    EditText editTextNhanXet;
    Button buttonGuiDanhGia;
    TextView textViewTongTien;
    ListView listViewChiTietDonHang;
    MyDB db;
    List<ViewModelChiTietDonHang> chiTietDonHangs;
    ChiTietDonHangAdapter adapter;
    String maDonHang;
    int tongTien;
    FeedBack feedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_don_hang);
        AnhXa();
        listViewChiTietDonHang.setAdapter(adapter);
        textViewTongTien.setText(getText(R.string.tongTien) + " " + tongTien + " $");

        if (feedBack != null) {
            editTextNhanXet.setText(feedBack.getNoiDung());
        }
        buttonGuiDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNhanXet.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    if (feedBack == null) {
                        db.ThemFeedBack(new FeedBack(editTextNhanXet.getText().toString(), maDonHang));
                        Toast.makeText(getApplicationContext(),"Cám ơn bạn đã đánh giá",Toast.LENGTH_SHORT).show();
                    } else {
                        feedBack.setNoiDung(editTextNhanXet.getText().toString());
                        db.CapNhatFeedBack(feedBack);
                        Toast.makeText(getApplicationContext(),"Đã cập nhật đánh giá",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void AnhXa() {
        editTextNhanXet = findViewById(R.id.editTextNhanXet);
        buttonGuiDanhGia = findViewById(R.id.buttonGuiDanhGia);
        textViewTongTien = findViewById(R.id.textViewTongTien);
        listViewChiTietDonHang = findViewById(R.id.listViewChiTietDonHang);
        db = new MyDB(getApplicationContext());
        Bundle thongTin = getIntent().getExtras();
        maDonHang = thongTin.getString("madonhang");
        tongTien = thongTin.getInt("tongtien");
        chiTietDonHangs = db.LayChiTietDonHang(maDonHang);
        adapter = new ChiTietDonHangAdapter(getApplicationContext(), chiTietDonHangs);
        feedBack = db.LayFeedBackDonHang(maDonHang);
    }
}
