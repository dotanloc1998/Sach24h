package com.sinhvien.sach24h;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sinhvien.sach24h.Adapter.DonHangNguoiDungAdapter;
import com.sinhvien.sach24h.Model.DonHang;
import com.sinhvien.sach24h.Model.MyDB;

import java.util.Collections;
import java.util.List;

public class DonHangNguoiDungActivity extends AppCompatActivity {
    ListView listViewDonHangNguoiDung;
    List<DonHang> donHangs;
    DonHangNguoiDungAdapter adapter;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang_nguoi_dung);
        listViewDonHangNguoiDung = findViewById(R.id.listViewDonHangNguoiDung);
        HienThi();
        listViewDonHangNguoiDung.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DonHangNguoiDungActivity.this);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn muốn hủy đơn hàng này ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DonHang donHangHuy = donHangs.get(position);
                        if (!donHangHuy.getTrangThai().equals("Đã hủy")) {
                            donHangHuy.setTrangThai("Đã hủy");
                            db.CapNhatDonHang(donHangHuy);
                            HienThi();
                        }
                    }
                });
                builder.setNegativeButton("Giữ đơn hàng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });

        listViewDonHangNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moGiaoDienChiTiet = new Intent(getApplicationContext(), ChiTietDonHangActivity.class);
                Bundle bundle = new Bundle();
                String maDonHang = donHangs.get(i).getMaHoaDon();
                int tongTien = donHangs.get(i).getTongTien();
                bundle.putString("madonhang", maDonHang);
                bundle.putInt("tongtien",tongTien);
                moGiaoDienChiTiet.putExtras(bundle);
                startActivity(moGiaoDienChiTiet);
            }
        });

    }

    private void HienThi() {
        db = new MyDB(getApplicationContext());
        donHangs = db.LayTatCaDonHangCuaTaiKhoan(db.LayTaiKhoanDangDangNhap());
        Collections.reverse(donHangs);
        adapter = new DonHangNguoiDungAdapter(getApplicationContext(), donHangs);
        listViewDonHangNguoiDung.setAdapter(adapter);
    }
}
