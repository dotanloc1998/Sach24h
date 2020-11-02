package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.sinhvien.sach24h.Adapter.SanPhamAdapter;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.ViewModel.ViewModelSach;

import java.util.List;

public class ChiTietTheLoaiActivity extends AppCompatActivity {
ImageButton buttonBack;
List<ViewModelSach> saches;
SanPhamAdapter sanPhamAdapter;
ListView listViewSanPham;
MyDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_the_loai);
        AnhXa();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listViewSanPham.setAdapter(sanPhamAdapter);
        listViewSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int idSach = (int) listViewSanPham.getItemIdAtPosition(i);
                HomeFragment.ClickVaoSanPham(getApplicationContext(), idSach);
            }
        });
    }
    private void AnhXa(){
        buttonBack = findViewById(R.id.buttonBack);
        Bundle bundle = getIntent().getExtras();
        int idLoaiSach = bundle.getInt("matheloai");
        db = new MyDB(getApplicationContext());
        saches = db.LaySachTheoTheLoai(idLoaiSach);
        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(),saches);
        listViewSanPham = findViewById(R.id.listViewSanPham);
    }
}
