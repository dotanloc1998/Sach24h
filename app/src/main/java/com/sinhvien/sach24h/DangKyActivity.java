package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.TaiKhoan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DangKyActivity extends AppCompatActivity {
    ImageButton buttonBack;
    Button buttonDangKy, buttonHuyBo;
    EditText editTextEmail, editTextHoTen, editTextMatKhau, editTextNhapLaiMatKhau, editTextDiaChi;
    TextView textViewNgaySinh;
    Spinner spinnerGioiTinh;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        AnhXa();
        ThemDuLieuChoSpinner();
        final Calendar calendar = Calendar.getInstance();
        CapNhatNgay(calendar);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(calendar.YEAR, year);
                calendar.set(calendar.MONTH, monthOfYear);
                calendar.set(calendar.DAY_OF_MONTH, dayOfMonth);
                CapNhatNgay(calendar);
            }
        };
        textViewNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(DangKyActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        buttonHuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String hoTen = editTextHoTen.getText().toString();
                String matKhau = editTextMatKhau.getText().toString();
                String nhapLaiMatKhau = editTextNhapLaiMatKhau.getText().toString();
                String diaChi = editTextDiaChi.getText().toString();
                String gioiTinh = spinnerGioiTinh.getSelectedItem().toString();
                String ngaySinh = textViewNgaySinh.getText().toString();
                if (email.isEmpty() || hoTen.isEmpty() || matKhau.isEmpty() || nhapLaiMatKhau.isEmpty() || diaChi.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.deTrong), Toast.LENGTH_SHORT).show();
                } else {
                    if (matKhau.equals(nhapLaiMatKhau)) {
                        if (!db.KiemTraNguoiDungTonTai(email)) {
                            TaiKhoan taiKhoanMoi = new TaiKhoan(email, hoTen, matKhau, ngaySinh, gioiTinh, diaChi);
                            db.ThemTaiKhoan(taiKhoanMoi);
                            Toast.makeText(getApplicationContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Người dùng đã tồn tại", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Mật khẩu nhập lại không trùng!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        buttonDangKy = findViewById(R.id.buttonDangKy);
        buttonHuyBo = findViewById(R.id.buttonHuyBo);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextMatKhau = findViewById(R.id.editTextMatKhau);
        editTextNhapLaiMatKhau = findViewById(R.id.editTextNhapLaiMatKhau);
        editTextDiaChi = findViewById(R.id.editTextDiaChi);
        textViewNgaySinh = findViewById(R.id.textViewNgaySinh);
        spinnerGioiTinh = findViewById(R.id.spinnerGioiTinh);
        db = new MyDB(getApplicationContext());
    }

    private void ThemDuLieuChoSpinner() {
        List<String> gioiTinh = new ArrayList<>();
        gioiTinh.add("Nam");
        gioiTinh.add("Nữ");
        ArrayAdapter adapterSL = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, gioiTinh);
        adapterSL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGioiTinh.setAdapter(adapterSL);
    }

    private void CapNhatNgay(Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat);
        textViewNgaySinh.setText(dateFormat.format(calendar.getTime()));
    }
}
