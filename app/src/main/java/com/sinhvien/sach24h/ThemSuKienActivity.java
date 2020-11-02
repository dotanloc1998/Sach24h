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

public class ThemSuKienActivity extends AppCompatActivity {
    EditText editTextTenSuKien, editTextNoiDung, editTextGiaTriKhuyenMai, editTextHinhKhuyenMai;
    TextView textViewNgayBatDau, textViewNgayKetThuc;
    Button buttonThemSuKien;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_su_kien);
        AnhXa();
        final Calendar calendarNgayBatDau = Calendar.getInstance();
        final Calendar calendarNgayKetThuc = Calendar.getInstance();
        CapNhatNgayBatDau(calendarNgayBatDau);
        CapNhatNgayKetThuc(calendarNgayKetThuc);

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
                new DatePickerDialog(ThemSuKienActivity.this, dateStart, calendarNgayBatDau.get(Calendar.YEAR), calendarNgayBatDau.get(Calendar.MONTH), calendarNgayBatDau.get(Calendar.DAY_OF_MONTH)).show();
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
                new DatePickerDialog(ThemSuKienActivity.this, dateEnd, calendarNgayKetThuc.get(Calendar.YEAR), calendarNgayKetThuc.get(Calendar.MONTH), calendarNgayKetThuc.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        buttonThemSuKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenSK = editTextTenSuKien.getText().toString();
                String noiDung = editTextNoiDung.getText().toString();
                String hinhSK = editTextHinhKhuyenMai.getText().toString();
                String giaTriString = editTextGiaTriKhuyenMai.getText().toString();
                String ngayBatDau = textViewNgayBatDau.getText().toString();
                String ngayKetThuc = textViewNgayKetThuc.getText().toString();
                if (tenSK.isEmpty() || noiDung.isEmpty() || hinhSK.isEmpty() || ngayBatDau.isEmpty() || ngayKetThuc.isEmpty() || giaTriString.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Không được để trống",Toast.LENGTH_SHORT).show();
                } else {
                    double giaTriDouble = Double.parseDouble(giaTriString);
                    KhuyenMai moi = new KhuyenMai(tenSK,noiDung,hinhSK,giaTriDouble,ngayBatDau,ngayKetThuc);
                    db.ThemSuKien(moi);
                    QuanLiSuKienActivity.HienThi(getApplicationContext());
                    finish();
                    Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        editTextTenSuKien = findViewById(R.id.editTextTenSuKien);
        editTextNoiDung = findViewById(R.id.editTextNoiDung);
        editTextGiaTriKhuyenMai = findViewById(R.id.editTextGiaTriKhuyenMai);
        editTextHinhKhuyenMai = findViewById(R.id.editTextHinhKhuyenMai);
        buttonThemSuKien = findViewById(R.id.buttonThemSuKien);
        textViewNgayBatDau = findViewById(R.id.textViewNgayBatDau);
        textViewNgayKetThuc = findViewById(R.id.textViewNgayKetThuc);
        db = new MyDB(getApplicationContext());
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
