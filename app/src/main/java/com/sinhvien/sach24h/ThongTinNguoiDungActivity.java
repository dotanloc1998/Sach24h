package com.sinhvien.sach24h;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.google.android.material.textfield.TextInputEditText;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.TaiKhoan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ThongTinNguoiDungActivity extends AppCompatActivity {
    ImageButton buttonBack;
    TextView textViewEmail, textViewNgaySinh;
    EditText editTextHoTen, editTextDiaChi;
    TextInputEditText editTextMatKhau;
    Spinner spinnerGioiTinh;
    Button buttonCapNhat, buttonXemDonHang, buttonDangXuat;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_nguoi_dung);
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
                new DatePickerDialog(ThongTinNguoiDungActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        TaiKhoan thongTinTaiKhoan = db.LayTaiKhoan(db.LayTaiKhoanDangDangNhap());
        textViewEmail.setText("Email của bạn: "+thongTinTaiKhoan.getEmail());
        textViewNgaySinh.setText(thongTinTaiKhoan.getNgaySinh());
        editTextDiaChi.setText(thongTinTaiKhoan.getDiaChi());
        editTextHoTen.setText(thongTinTaiKhoan.getHoTen());
        editTextMatKhau.setText(thongTinTaiKhoan.getMatKhau());

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HienThiThongBao("Bạn có muốn đăng xuất không ?");
            }
        });

        buttonCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = db.LayTaiKhoanDangDangNhap();
                String hoTen = editTextHoTen.getText().toString();
                String matKhau = editTextMatKhau.getText().toString();
                String diaChi = editTextDiaChi.getText().toString();
                String gioiTinh = spinnerGioiTinh.getSelectedItem().toString();
                String ngaySinh = textViewNgaySinh.getText().toString();
                if (email.isEmpty() || hoTen.isEmpty() || matKhau.isEmpty() || diaChi.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.deTrong), Toast.LENGTH_SHORT).show();
                } else {
                    TaiKhoan taiKhoanMoi = new TaiKhoan(email, hoTen, matKhau, ngaySinh, gioiTinh, diaChi);
                    db.SuaTaiKhoan(taiKhoanMoi);
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonXemDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent xemDonHang = new Intent(getApplicationContext(),DonHangNguoiDungActivity.class);
                startActivity(xemDonHang);
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewNgaySinh = findViewById(R.id.textViewNgaySinh);
        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextDiaChi = findViewById(R.id.editTextDiaChi);
        editTextMatKhau = findViewById(R.id.editTextMatKhau);
        spinnerGioiTinh = findViewById(R.id.spinnerGioiTinh);
        buttonCapNhat = findViewById(R.id.buttonCapNhat);
        buttonXemDonHang = findViewById(R.id.buttonXemDonHang);
        buttonDangXuat = findViewById(R.id.buttonDangXuat);
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

    private void HienThiThongBao(String thongBao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinNguoiDungActivity.this);
        builder.setTitle("Thông báo!");
        builder.setMessage(thongBao);
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.DangXuat(db.LayTaiKhoanDangDangNhap());
                Intent moGiaoDienChinh = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(moGiaoDienChinh);
                finishAffinity();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
