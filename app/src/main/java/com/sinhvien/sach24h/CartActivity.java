package com.sinhvien.sach24h;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.sinhvien.sach24h.Adapter.GioHangAdapter;
import com.sinhvien.sach24h.Model.GioHang;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.ViewModel.ViewModelGioHang;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ImageButton buttonBack;
    View main_content;
    ListView listViewGioHang;
    public static TextView textViewTongTien;
    Button buttonThanhToan, buttonMuaTiep;
    public static List<ViewModelGioHang> gioHangs;
    MyDB db;
    public static int tongTien;
    GioHang hangDaXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        AnhXa();
        HienThi();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonMuaTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moGiaoDienXacNhan = new Intent(getApplicationContext(), XacNhanGiaoHangActivity.class);
                startActivity(moGiaoDienXacNhan);
            }
        });
        listViewGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn muốn xóa sản phẩm này ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ViewModelGioHang gioHang = gioHangs.get(position);
                        GioHang sanPhamCanXoa = db.LaySanPhamTrongGioHang(gioHang.getIdSach(), db.LayTaiKhoanDangDangNhap());
                        db.XoaGioHang(sanPhamCanXoa);
                        tongTien = 0;
                        HienThi();
                        hangDaXoa = sanPhamCanXoa;
                        Snackbar snackbar = Snackbar
                                .make(main_content, "Xóa sản phẩm thành công", Snackbar.LENGTH_LONG)
                                .setAction("Khôi phục", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        db.ThemGioHang(hangDaXoa);
                                        tongTien = 0;
                                        HienThi();
                                    }
                                });
                        snackbar.show();
                    }
                });
                builder.setNegativeButton("Giữ hàng", new DialogInterface.OnClickListener() {
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


    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        main_content = findViewById(R.id.main_content);
        listViewGioHang = findViewById(R.id.listViewGioHang);
        textViewTongTien = findViewById(R.id.textViewTongTien);
        buttonThanhToan = findViewById(R.id.buttonThanhToan);
        buttonMuaTiep = findViewById(R.id.buttonMuaTiep);
        gioHangs = new ArrayList<>();
        db = new MyDB(getApplicationContext());
        tongTien = 0;
        hangDaXoa = new GioHang();
    }

    private void HienThi() {
        gioHangs = db.LayGioHangCuaNguoiDung(db.LayTaiKhoanDangDangNhap());
        for (ViewModelGioHang item : gioHangs) {
            tongTien += item.getGia() * item.getSoLuong();
        }
        textViewTongTien.setText(getString(R.string.tongTien) + " " + tongTien + " $");
        listViewGioHang.setAdapter(new GioHangAdapter(getApplicationContext(), gioHangs));
    }
}
