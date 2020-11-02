package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.sinhvien.sach24h.Model.MyDB;

public class QuanLiNguoiDungActivity extends AppCompatActivity {
    ListView listViewNguoiDung;
    ImageButton buttonBack;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_nguoi_dung);
        listViewNguoiDung = findViewById(R.id.listViewNguoiDung);
        buttonBack = findViewById(R.id.buttonBack);
        db = new MyDB(getApplicationContext());
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Cursor nguoiDung = db.LayTatCaNguoiDung();
        String[] from = new String[]{"email", "hoten", "ngaysinh", "gioitinh", "diachi"};
        int[] to = new int[]{R.id.textViewEmailNguoiDung, R.id.textViewTenNguoiDung, R.id.textViewNgaySinh, R.id.textViewGioiTinh, R.id.textViewDiaChi};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.dong_nguoi_dung, nguoiDung, from, to, 0);
        listViewNguoiDung.setAdapter(adapter);
    }
}
