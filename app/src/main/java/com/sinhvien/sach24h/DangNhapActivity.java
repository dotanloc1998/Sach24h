package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.TaiKhoan;

public class DangNhapActivity extends AppCompatActivity {
    EditText editTextTaiKhoan;
    TextInputEditText editTextMatKhau;
    Button buttonDangNhap, buttonDangKy;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        AnhXa();
        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moGiaoDienDangKy = new Intent(getApplicationContext(), DangKyActivity.class);
                startActivity(moGiaoDienDangKy);
            }
        });
        buttonDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTaiKhoan.getText().toString().isEmpty() || editTextMatKhau.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.deTrong), Toast.LENGTH_SHORT).show();
                } else {
                    String email = editTextTaiKhoan.getText().toString();
                    String matKhau = editTextMatKhau.getText().toString();
                    if (!db.KiemTraNguoiDungTonTai(email)) {
                        Toast.makeText(getApplicationContext(), "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        TaiKhoan thongTinTK = db.LayTaiKhoan(email);
                        if (thongTinTK.getMatKhau().equals(matKhau)) {
                            db.ThemDangNhap(email);
                            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            finishAffinity();
                            Intent moLaiGiaoDien = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(moLaiGiaoDien);
                        } else {
                            Toast.makeText(getApplicationContext(), "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });
    }

    private void AnhXa() {
        editTextTaiKhoan = findViewById(R.id.editTextTaiKhoan);
        editTextMatKhau = findViewById(R.id.editTextMatKhau);
        buttonDangNhap = findViewById(R.id.buttonDangNhap);
        buttonDangKy = findViewById(R.id.buttonDangKy);
        db = new MyDB(getApplicationContext());
    }
}
