package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.sinhvien.sach24h.Adapter.BinhLuanAdapter;
import com.sinhvien.sach24h.Adapter.HinhAnhSachAdapter;
import com.sinhvien.sach24h.Model.BinhLuan;
import com.sinhvien.sach24h.Model.GioHang;
import com.sinhvien.sach24h.Model.HinhAnhSach;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.Sach;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    RecyclerView listHinhAnhSP;
    ListView listViewBinhLuan;
    public static ImageView imageViewHinhSanPham;
    Spinner spinnerSL;
    Button buttonMua, buttonGuiDanhGia;
    TextView textViewTenSanPham, textViewGiaSanPham, textViewTheLoai, textViewTacGia, textViewTrongLuong, textViewKichThuoc, textViewSoTrang, textViewMoTa;
    EditText editTextBinhLuan;
    RatingBar ratingBarDanhGia;
    int idSPChon;
    HinhAnhSachAdapter anhSachAdapter;
    BinhLuanAdapter binhLuanAdapter;
    List<HinhAnhSach> hinhAnhSaches;
    List<BinhLuan> binhLuans;
    MyDB db;
    BinhLuan binhLuanNguoiDung;
    View main_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        AnhXa();
        ThemDuLieuChoSpinner();
        Sach sach = db.TraVeSachBangId(idSPChon);
        textViewTenSanPham.setText("Tên sản phẩm: " + sach.getTenSach());
        textViewGiaSanPham.setText("Giá sản phẩm: " + sach.getGia() + "$");
        String theLoai = db.TraVeTenTheLoai(sach.getMaTheLoai());
        textViewTheLoai.setText("Thể loại: " + theLoai);
        textViewTacGia.setText("Tác giả: " + sach.getTacGia());
        textViewTrongLuong.setText("Trọng lượng: " + sach.getTrongLuong());
        textViewKichThuoc.setText("Kích thước: " + sach.getKichThuoc());
        textViewSoTrang.setText("Số trang: " + sach.getSoTrang());
        textViewMoTa.setText(sach.getMoTa());
        GanHinhDaiDien(getApplicationContext(), hinhAnhSaches.get(0).getDuongDanHinhAnh());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        listHinhAnhSP.setLayoutManager(layoutManager);
        listHinhAnhSP.setAdapter(anhSachAdapter);
        CapNhatBinhLuan();

        buttonGuiDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.LayTaiKhoanDangDangNhap().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng đăng nhập để đánh giá", Toast.LENGTH_SHORT).show();
                } else {
                    if (binhLuanNguoiDung == null) {
                        if (ratingBarDanhGia.getRating() < 0.5) {
                            Toast.makeText(getApplicationContext(), "Vui lòng bình chọn số điểm", Toast.LENGTH_SHORT).show();
                        } else {
                            String noiDung = editTextBinhLuan.getText().toString();
                            double soDiem = ratingBarDanhGia.getRating();
                            binhLuanNguoiDung = new BinhLuan(noiDung, soDiem, idSPChon, db.LayTaiKhoanDangDangNhap());
                            db.ThemBinhLuan(binhLuanNguoiDung);
                            Toast.makeText(getApplicationContext(), "Cám ơn bạn đã đánh giá", Toast.LENGTH_SHORT).show();
                            CapNhatBinhLuan();
                        }

                    } else {
                        if (ratingBarDanhGia.getRating() < 0.5) {
                            Toast.makeText(getApplicationContext(), "Vui lòng bình chọn số điểm", Toast.LENGTH_SHORT).show();
                        } else {
                            String noiDung = editTextBinhLuan.getText().toString();
                            double soDiem = ratingBarDanhGia.getRating();
                            binhLuanNguoiDung = new BinhLuan(noiDung, soDiem, idSPChon, db.LayTaiKhoanDangDangNhap());
                            db.CapNhatBinhLuan(binhLuanNguoiDung);
                            Toast.makeText(getApplicationContext(), "Đã cập nhật đánh giá của bạn", Toast.LENGTH_SHORT).show();
                            CapNhatBinhLuan();
                        }

                    }
                }

            }
        });

        buttonMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuong = Integer.parseInt(spinnerSL.getSelectedItem().toString());
                GioHang gioHangMoi = new GioHang(idSPChon, soLuong, db.LayTaiKhoanDangDangNhap());
                int kq = db.ThemGioHang(gioHangMoi);
                if (kq == 1) {
                    Snackbar snackbar = Snackbar
                            .make(main_content, "Thêm vào giỏ hàng thành công", Snackbar.LENGTH_LONG)
                            .setAction("Đến xem", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent moGioHang = new Intent(getApplicationContext(), CartActivity.class);
                                    finish();
                                    startActivity(moGioHang);
                                }
                            });
                    snackbar.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Vượt quá số lượng qui định", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        Bundle thongTin = getIntent().getExtras();
        idSPChon = thongTin.getInt("masanpham");
        listHinhAnhSP = findViewById(R.id.listHinhAnhSP);
        main_content = findViewById(R.id.main_content);
        listViewBinhLuan = findViewById(R.id.listViewBinhLuan);
        imageViewHinhSanPham = findViewById(R.id.imageViewHinhSanPham);
        spinnerSL = findViewById(R.id.spinnerSL);
        buttonMua = findViewById(R.id.buttonMua);
        buttonGuiDanhGia = findViewById(R.id.buttonGuiDanhGia);
        editTextBinhLuan = findViewById(R.id.editTextBinhLuan);
        ratingBarDanhGia = findViewById(R.id.ratingBarDanhGia);
        textViewTenSanPham = findViewById(R.id.textViewTenSanPham);
        textViewGiaSanPham = findViewById(R.id.textViewGiaSanPham);
        textViewTheLoai = findViewById(R.id.textViewTheLoai);
        textViewTacGia = findViewById(R.id.textViewTacGia);
        textViewTrongLuong = findViewById(R.id.textViewTrongLuong);
        textViewKichThuoc = findViewById(R.id.textViewKichThuoc);
        textViewSoTrang = findViewById(R.id.textViewSoTrang);
        textViewMoTa = findViewById(R.id.textViewMoTa);
        db = new MyDB(getApplicationContext());
        hinhAnhSaches = db.LayHinhAnhCuaSach(idSPChon);
        anhSachAdapter = new HinhAnhSachAdapter(getApplicationContext(), hinhAnhSaches);
        binhLuanNguoiDung = db.TraVeBinhLuanCuaNguoiDung(idSPChon, db.LayTaiKhoanDangDangNhap());
    }

    private void ThemDuLieuChoSpinner() {
        List<String> soLuong = new ArrayList<>();
        soLuong.add("1");
        soLuong.add("2");
        soLuong.add("3");
        soLuong.add("4");
        soLuong.add("5");
        soLuong.add("6");
        soLuong.add("7");
        soLuong.add("8");
        soLuong.add("9");
        soLuong.add("10");
        ArrayAdapter adapterSL = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, soLuong);
        adapterSL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSL.setAdapter(adapterSL);
    }

    public static void GanHinhDaiDien(Context context, String duongDanHinhAnh) {

        Picasso.with(context).load(duongDanHinhAnh)
                .placeholder(R.drawable.logo)
                .error(R.drawable.errorimg)
                .into(imageViewHinhSanPham);

    }

    public void CapNhatBinhLuan() {
        binhLuans = db.LayBinhLuanCuaSach(idSPChon);
        binhLuanAdapter = new BinhLuanAdapter(getApplicationContext(), binhLuans);
        listViewBinhLuan.setAdapter(binhLuanAdapter);
        if (!(binhLuanNguoiDung == null)) {
            editTextBinhLuan.setText(binhLuanNguoiDung.getNoiDung());
            ratingBarDanhGia.setRating((float) binhLuanNguoiDung.getSoDiem());
        }
    }
}
