package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.sinhvien.sach24h.Model.DonHang;
import com.sinhvien.sach24h.Model.MyDB;

public class QuanLiDonHangActivity extends AppCompatActivity {
    private static MyDB db;
    ImageButton buttonBack;
    private static ListView listViewDonHang;
    private static Cursor donHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_don_hang);
        AnhXa();
        HienThi(getApplicationContext());
        listViewDonHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                donHang.moveToFirst();
                donHang.move(i);
                String maDonHang = donHang.getString(donHang.getColumnIndex("madonhang"));
                String trangThai = donHang.getString(donHang.getColumnIndex("trangthai"));
                String ngayGiao = donHang.getString(donHang.getColumnIndex("ngaygiao"));
                String ngayTao = donHang.getString(donHang.getColumnIndex("ngaytao"));
                String email = donHang.getString(donHang.getColumnIndex("email"));
                int tongTien = donHang.getInt(donHang.getColumnIndex("tongtien"));
                Intent intent = new Intent(getApplicationContext(), SuaDonHangActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("madonhang", maDonHang);
                bundle.putString("trangthai", trangThai);
                bundle.putString("ngaygiao", ngayGiao);
                bundle.putString("ngaytao", ngayTao);
                bundle.putString("email", email);
                bundle.putInt("tongtien", tongTien);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        listViewDonHang = findViewById(R.id.listViewDonHang);
        db = new MyDB(getApplicationContext());
    }

    public static void HienThi(Context context) {
        donHang = db.LayTatCaDonHang();
        String[] from = new String[]{"madonhang", "ngaygiao", "ngaytao", "email", "tongtien", "trangthai"};
        int[] to = new int[]{R.id.textViewMaDonHang, R.id.textViewNgayGiao, R.id.textViewNgayTao, R.id.textViewEmail, R.id.textViewTongTien, R.id.textViewTrangThai};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(context, R.layout.dong_don_hang_admin, donHang, from, to, 0);
        listViewDonHang.setAdapter(adapter);
    }
}
