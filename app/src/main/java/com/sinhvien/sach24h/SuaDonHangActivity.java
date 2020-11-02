package com.sinhvien.sach24h;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.sinhvien.sach24h.Adapter.ChiTietDonHangAdapter;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.ViewModel.ViewModelChiTietDonHang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SuaDonHangActivity extends AppCompatActivity {
    TextView textViewNgayGiao, textViewEmail, textViewNgayTao;
    Spinner spinnerTrangThai;
    Button buttonSuaDonHang;
    ListView listViewChiTietDonHang;
    MyDB db;
    String maDonHang, trangThai, ngayGiao, ngayTao, email, trangThaiChon;
    int tongTien;

    PayPalConfiguration m_Configuration;
    String paymentClientId = "AednqLylSYvAQXLABhWnXUO8CCdJ66L7AT6cnYnE0RTHT2EpmSWIl3XF_dECK2EzRt29tSC6Tc8n5Xnn";
    Intent service;
    int paypalRequestCode = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_don_hang);
        AnhXa();
        TruyenDuLieu();

        buttonSuaDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trangThaiChon = spinnerTrangThai.getSelectedItem().toString();
                if (trangThaiChon.equals("Trả lại tiền")) {
                    PayPalPayment payment = new PayPalPayment(new BigDecimal(tongTien), "USD", "Trả lại tiền cho khách", PayPalPayment.PAYMENT_INTENT_SALE);
                    Intent moGiaoDienPaypal = new Intent(getApplicationContext(), PaymentActivity.class);
                    moGiaoDienPaypal.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_Configuration);
                    moGiaoDienPaypal.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
                    startActivityForResult(moGiaoDienPaypal, paypalRequestCode);
                } else {
                    db.CapNhatDonHang(maDonHang, trangThaiChon);
                    QuanLiDonHangActivity.HienThi(getApplicationContext());
                    finish();
                    Toast.makeText(getApplicationContext(), "Sửa đơn hàng thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == paypalRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    String state = confirmation.getProofOfPayment().getState();
                    if (state.equals("approved")) {
                        db.CapNhatDonHang(maDonHang, trangThaiChon);
                        QuanLiDonHangActivity.HienThi(getApplicationContext());
                        finish();
                        Toast.makeText(getApplicationContext(), "Sửa đơn hàng thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Có lỗi đã xảy ra", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Confirmation is null", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void AnhXa() {
        textViewNgayGiao = findViewById(R.id.textViewNgayGiao);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewNgayTao = findViewById(R.id.textViewNgayTao);
        spinnerTrangThai = findViewById(R.id.spinnerTrangThai);
        buttonSuaDonHang = findViewById(R.id.buttonSuaDonHang);
        listViewChiTietDonHang = findViewById(R.id.listViewChiTietDonHang);
        db = new MyDB(getApplicationContext());
        Bundle thongTin = getIntent().getExtras();
        maDonHang = thongTin.getString("madonhang");
        trangThai = thongTin.getString("trangthai");
        ngayGiao = thongTin.getString("ngaygiao");
        ngayTao = thongTin.getString("ngaytao");
        email = thongTin.getString("email");
        tongTien = thongTin.getInt("tongtien");
        if (trangThai.equals("TLT")) {
            buttonSuaDonHang.setEnabled(false);
        }

        m_Configuration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(paymentClientId);
        service = new Intent(getApplicationContext(), PayPalService.class);
        service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_Configuration);
        startService(service);
    }

    private void TruyenDuLieu() {
        textViewNgayGiao.setText(ngayGiao);
        if (email.equals("")) {
            textViewEmail.setText("Khách không đăng ký");
        } else {
            textViewEmail.setText(email);
        }

        textViewNgayTao.setText(ngayTao);

        List<String> cacTrangThai = new ArrayList<>();
        cacTrangThai.add("Chưa giao");
        cacTrangThai.add("Đã giao");
        cacTrangThai.add("Đã hủy");
        cacTrangThai.add("Trả lại tiền");
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, cacTrangThai);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrangThai.setAdapter(adapter);
        int viTri = adapter.getPosition(trangThai);
        spinnerTrangThai.setSelection(viTri);

        List<ViewModelChiTietDonHang> donHangs = db.LayChiTietDonHang(maDonHang);
        ChiTietDonHangAdapter chiTietDonHangAdapter = new ChiTietDonHangAdapter(getApplicationContext(), donHangs);
        listViewChiTietDonHang.setAdapter(chiTietDonHangAdapter);
    }
}
