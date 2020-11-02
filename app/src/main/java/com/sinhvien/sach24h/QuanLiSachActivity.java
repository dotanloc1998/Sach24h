package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.sinhvien.sach24h.Model.MyDB;

public class QuanLiSachActivity extends AppCompatActivity {
    Button buttonThemSach, buttonThemHinhAnhSach;
    ImageButton buttonBack;
    ListView listViewSach;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_sach);
        AnhXa();

        Cursor sachs = db.LayTatCaSach();
        String[] from = new String[]{"_id", "tensach", "gia", "soluong", "luotview"};
        int[] to = new int[]{R.id.textViewMaSach, R.id.textViewtTenSach, R.id.textViewGiaSach, R.id.textViewSoLuong, R.id.textViewLuotXem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.dong_sach, sachs, from, to, 0);
        listViewSach.setAdapter(adapter);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent themSach = new Intent(getApplicationContext(), ThemSachActivity.class);
                startActivity(themSach);
            }
        });
        buttonThemHinhAnhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent themHinh = new Intent(getApplicationContext(), ThemHinhAnhSachActivity.class);
                startActivity(themHinh);
            }
        });

        listViewSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int idSach = (int) listViewSach.getItemIdAtPosition(i);
                Intent suaSach = new Intent(getApplicationContext(), SuaSachActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("masach", idSach);
                suaSach.putExtras(bundle);
                startActivity(suaSach);
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        buttonThemSach = findViewById(R.id.buttonThemSach);
        listViewSach = findViewById(R.id.listViewSach);
        buttonThemHinhAnhSach = findViewById(R.id.buttonThemHinhAnhSach);
        db = new MyDB(getApplicationContext());
    }
}
