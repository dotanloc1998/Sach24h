package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.sach24h.Model.KhuyenMai;
import com.sinhvien.sach24h.Model.MyDB;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SuaSuKienActivity extends AppCompatActivity {
    EditText editTextTenSuKien, editTextNoiDung, editTextGiaTriKhuyenMai, editTextHinhKhuyenMai;
    TextView textViewNgayBatDau, textViewNgayKetThuc;
    Button buttonSuaSuKien;
    MyDB db;
    int idSK;
    double giaTri;
    String tenKM, ngayBatDau, noiDung, hinhAnh, ngayKetThuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_su_kien);
        AnhXa();
        final Calendar calendarNgayBatDau = Calendar.getInstance();
        final Calendar calendarNgayKetThuc = Calendar.getInstance();
        textViewNgayBatDau.setText(ngayBatDau);
        textViewNgayKetThuc.setText(ngayKetThuc);
        editTextTenSuKien.setText(tenKM);
        editTextNoiDung.setText(noiDung);
        editTextGiaTriKhuyenMai.setText(giaTri + "");
        editTextHinhKhuyenMai.setText(hinhAnh);

        final DatePickerDialog.OnDateSetListener dateStart = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendarNgayBatDau.set(calendarNgayBatDau.YEAR, year);
                calendarNgayBatDau.set(calendarNgayBatDau.MONTH, monthOfYear);
                calendarNgayBatDau.set(calendarNgayBatDau.DAY_OF_MONTH, dayOfMonth);
                CapNhatNgayBatDau(calendarNgayBatDau);
            }
        };
        textViewNgayBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SuaSuKienActivity.this, dateStart, calendarNgayBatDau.get(Calendar.YEAR), calendarNgayBatDau.get(Calendar.MONTH), calendarNgayBatDau.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final DatePickerDialog.OnDateSetListener dateEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendarNgayKetThuc.set(calendarNgayKetThuc.YEAR, year);
                calendarNgayKetThuc.set(calendarNgayKetThuc.MONTH, monthOfYear);
                calendarNgayKetThuc.set(calendarNgayKetThuc.DAY_OF_MONTH, dayOfMonth);
                CapNhatNgayKetThuc(calendarNgayKetThuc);
            }
        };

        textViewNgayKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SuaSuKienActivity.this, dateEnd, calendarNgayKetThuc.get(Calendar.YEAR), calendarNgayKetThuc.get(Calendar.MONTH), calendarNgayKetThuc.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        buttonSuaSuKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenKM = editTextTenSuKien.getText().toString();
                noiDung = editTextNoiDung.getText().toString();
                hinhAnh = editTextHinhKhuyenMai.getText().toString();
                String giaTriString = editTextGiaTriKhuyenMai.getText().toString();
                ngayBatDau = textViewNgayBatDau.getText().toString();
                ngayKetThuc = textViewNgayKetThuc.getText().toString();
                if (tenKM.isEmpty() || noiDung.isEmpty() || hinhAnh.isEmpty() || ngayBatDau.isEmpty() || ngayKetThuc.isEmpty() || giaTriString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    KhuyenMai suaKM = new KhuyenMai(idSK, tenKM, noiDung, hinhAnh, giaTri, ngayBatDau, ngayKetThuc);
                    db.SuaSuKien(suaKM);
                    QuanLiSuKienActivity.HienThi(getApplicationContext());
                    finish();
                    Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        editTextTenSuKien = findViewById(R.id.editTextTenSuKien);
        editTextNoiDung = findViewById(R.id.editTextNoiDung);
        editTextGiaTriKhuyenMai = findViewById(R.id.editTextGiaTriKhuyenMai);
        editTextHinhKhuyenMai = findViewById(R.id.editTextHinhKhuyenMai);
        buttonSuaSuKien = findViewById(R.id.buttonSuaSuKien);
        textViewNgayBatDau = findViewById(R.id.textViewNgayBatDau);
        textViewNgayKetThuc = findViewById(R.id.textViewNgayKetThuc);
        db = new MyDB(getApplicationContext());
        Bundle thongTin = getIntent().getExtras();
        idSK = thongTin.getInt("id");
        giaTri = thongTin.getDouble("giatri");
        tenKM = thongTin.getString("tenkhuyenmai");
        ngayBatDau = thongTin.getString("ngaybatdau");
        ngayKetThuc = thongTin.getString("ngayketthuc");
        noiDung = thongTin.getString("noidung");
        hinhAnh = thongTin.getString("hinhanh");
    }

    private void CapNhatNgayBatDau(Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat);
        textViewNgayBatDau.setText(dateFormat.format(calendar.getTime()));
    }

    private void CapNhatNgayKetThuc(Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat);
        textViewNgayKetThuc.setText(dateFormat.format(calendar.getTime()));
    }
}
