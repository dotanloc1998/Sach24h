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

public class SuaSachActivity extends AppCompatActivity {
    ImageButton buttonBack;
    Button buttonSuaSach;
    EditText editTextTenSach, editTextSoLuongSach, editTextGiaSach, editTextTacGia, editTextNamSuatBan, editTextTrongLuong, editTextKichThuoc, editTextMoTaSach, editTextSoTrang, editTextNgonNgu, editTextNhaCungCap;
    Spinner spinnerLoaiSach, spinnerNhaXuatBan;
    MyDB db;
    Sach sachChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_sach);
        AnhXa();
        ThemDuLieuChoSpinner();
        GanDuLieu();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonSuaSach.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    int soLuongBanDau = Integer.parseInt(editTextSoLuongSach.getText().toString());
                    int giaSach = Integer.parseInt(editTextGiaSach.getText().toString());
                    sachChon.setTenSach(tenSach);
                    sachChon.setGia(giaSach);
                    sachChon.setTacGia(tacGia);
                    sachChon.setNamSuatBan(namXuatBan);
                    sachChon.setTrongLuong(trongLuong);
                    sachChon.setKichThuoc(kichThuoc);
                    sachChon.setMoTa(moTaSach);
                    sachChon.setSoTrang(soTrang);
                    sachChon.setNgonNgu(ngonNgu);
                    sachChon.setNhaCungCap(nhaCungCap);
                    sachChon.setMaTheLoai(loaiSach);
                    sachChon.setMaNhaXuatBan(nhaXuatBan);
                    sachChon.setSoLuongBanDau(soLuongBanDau);
                    db.SuaSach(sachChon);
                    finish();
                    Toast.makeText(getApplicationContext(), "Sửa sách thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        buttonSuaSach = findViewById(R.id.buttonSuaSach);
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
        Bundle thongTin = getIntent().getExtras();
        int idSach = thongTin.getInt("masach");
        sachChon = db.TraVeSachBangId(idSach);
    }

    private void ThemDuLieuChoSpinner() {
        int viTri = 0;
        List<String> maLoaiSach = db.TraVeCacMaLoaiSach();
        List<String> maNXB = db.TraVeCacMaNXB();

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, maLoaiSach);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoaiSach.setAdapter(adapter);
        viTri = adapter.getPosition(sachChon.getMaTheLoai() + "");
        spinnerLoaiSach.setSelection(viTri);


        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, maNXB);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNhaXuatBan.setAdapter(adapter);
        viTri = adapter.getPosition(sachChon.getMaNhaXuatBan() + "");
        spinnerNhaXuatBan.setSelection(viTri);
    }

    private void GanDuLieu() {
        editTextTenSach.setText(sachChon.getTenSach());
        editTextSoLuongSach.setText(sachChon.getSoLuongBanDau() + "");
        editTextGiaSach.setText(sachChon.getGia() + "");
        editTextTacGia.setText(sachChon.getTacGia());
        editTextNamSuatBan.setText(sachChon.getNamSuatBan());
        editTextTrongLuong.setText(sachChon.getTrongLuong());
        editTextKichThuoc.setText(sachChon.getKichThuoc());
        editTextMoTaSach.setText(sachChon.getMoTa());
        editTextSoTrang.setText(sachChon.getSoTrang());
        editTextNgonNgu.setText(sachChon.getNgonNgu());
        editTextNhaCungCap.setText(sachChon.getNhaCungCap());
    }
}
