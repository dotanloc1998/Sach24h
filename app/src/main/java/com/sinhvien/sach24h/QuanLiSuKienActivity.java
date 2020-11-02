package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class QuanLiSuKienActivity extends AppCompatActivity {
    ImageButton buttonBack;
    Button buttonThemSuKien;
    private static ListView listViewSuKien;
    private static MyDB db;
    private static Cursor suKien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_su_kien);
        AnhXa();
        HienThi(getApplicationContext());
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listViewSuKien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                suKien.moveToFirst();
                suKien.move(i);
                int idSK = suKien.getInt(suKien.getColumnIndex("_id"));
                double giaTri = suKien.getDouble(suKien.getColumnIndex("giatrikhuyenmai"));
                String tenKM = suKien.getString(suKien.getColumnIndex("tenkhuyenmai"));
                String ngayBatDau = suKien.getString(suKien.getColumnIndex("ngaybatdau"));
                String noiDung = suKien.getString(suKien.getColumnIndex("noidung"));
                String hinhAnh = suKien.getString(suKien.getColumnIndex("duongdanhinhanh"));
                String ngayKetThuc = suKien.getString(suKien.getColumnIndex("ngayketthuc"));
                Bundle bundle = new Bundle();
                bundle.putInt("id", idSK);
                bundle.putDouble("giatri", giaTri);
                bundle.putString("tenkhuyenmai", tenKM);
                bundle.putString("ngaybatdau", ngayBatDau);
                bundle.putString("ngayketthuc", ngayKetThuc);
                bundle.putString("noidung", noiDung);
                bundle.putString("hinhanh", hinhAnh);
                Intent intent = new Intent(getApplicationContext(), SuaSuKienActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        buttonThemSuKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThemSuKienActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        buttonThemSuKien = findViewById(R.id.buttonThemSuKien);
        listViewSuKien = findViewById(R.id.listViewSuKien);
        db = new MyDB(getApplicationContext());
    }

    public static void HienThi(Context context) {
        suKien = db.LayTatCaSuKien();
        String[] from = new String[]{"_id", "tenkhuyenmai", "giatrikhuyenmai", "ngaybatdau", "ngayketthuc"};
        int[] to = new int[]{R.id.textViewMaSuKien, R.id.textViewtTenSuKien, R.id.textViewGiaTriKhuyenMai, R.id.textViewNgayBatDau, R.id.textViewNgayKetThuc};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(context, R.layout.dong_su_kien_admin, suKien, from, to, 0);
        listViewSuKien.setAdapter(adapter);
    }
}
