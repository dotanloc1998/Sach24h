package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.Sach;

import java.util.List;

public class ThemSachActivity extends AppCompatActivity {
    ImageButton buttonBack;
    Button buttonThemSach;
    EditText editTextTenSach, editTextSoLuongSach, editTextGiaSach, editTextTacGia, editTextNamSuatBan, editTextTrongLuong, editTextKichThuoc, editTextMoTaSach, editTextSoTrang, editTextNgonNgu, editTextNhaCungCap;
    Spinner spinnerLoaiSach, spinnerNhaXuatBan;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        AnhXa();
        ThemDuLieuChoSpinner();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenSach = editTextTenSach.getText().toString();
                String tacGia = editTextTacGia.getText().toString();
                String namXuatBan = editTextNamSuatBan.getText().toString();
                String trongLuong = editTextTrongLuong.getText().toString();
                String kichThuoc = editTextKichThuoc.getText().toString();
                String moTaSach = editTextMoTaSach.getText().toString();
                String soTrang = editTextSoTrang.getText().toString();
                String ngonNgu = editTextNgonNgu.getText().toString();
                String nhaCungCap = editTextNhaCungCap.getText().toString();
                int loaiSach = Integer.parseInt(spinnerLoaiSach.getSelectedItem().toString());
                int nhaXuatBan = Integer.parseInt(spinnerNhaXuatBan.getSelectedItem().toString());
                if (tenSach.isEmpty() || tacGia.isEmpty() || namXuatBan.isEmpty() || trongLuong.isEmpty() || kichThuoc.isEmpty() || moTaSach.isEmpty() || soTrang.isEmpty() || ngonNgu.isEmpty() || nhaCungCap.isEmpty() || editTextSoLuongSach.getText().toString().isEmpty() || editTextGiaSach.getText().toString().isEmpty()) {
                 Toast.makeText(getApplicationContext(),"Không được để trống",Toast.LENGTH_SHORT).show();
                }
                else {
                    int soLuongBanDau = Integer.parseInt(editTextSoLuongSach.getText().toString());
                    int giaSach = Integer.parseInt(editTextGiaSach.getText().toString());
                    Sach sachMoi = new Sach(tenSach, giaSach, tacGia, namXuatBan, trongLuong, kichThuoc, moTaSach, soTrang, ngonNgu, nhaCungCap, "", "HD", loaiSach, nhaXuatBan, soLuongBanDau, 0);
                    db.ThemSach(sachMoi);
                    finish();
                    Toast.makeText(getApplicationContext(), "Thêm sách thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        buttonThemSach = findViewById(R.id.buttonThemSach);
        editTextTenSach = findViewById(R.id.editTextTenSach);
        editTextSoLuongSach = findViewById(R.id.editTextSoLuongSach);
        editTextGiaSach = findViewById(R.id.editTextGiaSach);
        editTextTacGia = findViewById(R.id.editTextTacGia);
        editTextNamSuatBan = findViewById(R.id.editTextNamSuatBan);
        editTextTrongLuong = findViewById(R.id.editTextTrongLuong);
        editTextKichThuoc = findViewById(R.id.editTextKichThuoc);
        editTextMoTaSach = findViewById(R.id.editTextMoTaSach);
        editTextSoTrang = findViewById(R.id.editTextSoTrang);
        editTextNgonNgu = findViewById(R.id.editTextNgonNgu);
        editTextNhaCungCap = findViewById(R.id.editTextNhaCungCap);
        spinnerLoaiSach = findViewById(R.id.spinnerLoaiSach);
        spinnerNhaXuatBan = findViewById(R.id.spinnerNhaXuatBan);
        db = new MyDB(getApplicationContext());
    }

    private void ThemDuLieuChoSpinner() {
        List<String> maLoaiSach = db.TraVeCacMaLoaiSach();
        List<String> maNXB = db.TraVeCacMaNXB();

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, maLoaiSach);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoaiSach.setAdapter(adapter);

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, maNXB);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNhaXuatBan.setAdapter(adapter);
    }
}
