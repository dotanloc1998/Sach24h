package com.sinhvien.sach24h;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.sinhvien.sach24h.Model.ChiTietDonHang;
import com.sinhvien.sach24h.Model.DonHang;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.TaiKhoan;
import com.sinhvien.sach24h.ViewModel.ViewModelGioHang;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class XacNhanGiaoHangActivity extends AppCompatActivity {
    EditText editTextHoTen, editTextDiaChi, editTextEmail;
    TextView textViewTongTien;
    Button buttonXacNhan, buttonQuayLai;
    MyDB db;
    TaiKhoan thongTin;

    PayPalConfiguration m_Configuration;
    String paymentClientId = "AednqLylSYvAQXLABhWnXUO8CCdJ66L7AT6cnYnE0RTHT2EpmSWIl3XF_dECK2EzRt29tSC6Tc8n5Xnn";
    Intent service;
    int paypalRequestCode = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_giao_hang);
        AnhXa();
        buttonQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (thongTin != null) {
            editTextDiaChi.setText(thongTin.getDiaChi());
            editTextEmail.setText(thongTin.getEmail());
            editTextHoTen.setText(thongTin.getHoTen());
        }
        textViewTongTien.setText(getString(R.string.tongTien) + " " + CartActivity.tongTien + " $");
        buttonXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextEmail.getText().toString().isEmpty() || editTextDiaChi.getText().toString().isEmpty() || editTextHoTen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
                } else {
                    int soTienNhap = CartActivity.tongTien;
                    PayPalPayment payment = new PayPalPayment(new BigDecimal(soTienNhap), "USD", "Thanh toán cho đơn hàng của: " + editTextEmail.getText().toString(), PayPalPayment.PAYMENT_INTENT_SALE);
                    Intent moGiaoDienPaypal = new Intent(getApplicationContext(), PaymentActivity.class);
                    moGiaoDienPaypal.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_Configuration);
                    moGiaoDienPaypal.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
                    startActivityForResult(moGiaoDienPaypal, paypalRequestCode);
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
                        RandomString gen = new RandomString(8);
                        String maDonHang = gen.nextString();
                        Date homNay = new Date();
                        String myFormat = "dd/MM/yyyy";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat);
                        String ngayTao = dateFormat.format(homNay);
                        Calendar giao = Calendar.getInstance();
                        giao.add(Calendar.DAY_OF_MONTH, 7);
                        String ngayGiao = dateFormat.format(giao.getTime());
                        DonHang donHang = new DonHang(maDonHang, ngayGiao, "Chưa giao", db.LayTaiKhoanDangDangNhap(), ngayTao, "Paypal", CartActivity.tongTien);
                        db.ThemDonHang(donHang);
                        for (ViewModelGioHang item : CartActivity.gioHangs) {
                            db.ThemChiTietDonHang(new ChiTietDonHang(maDonHang, item.getSoLuong(), item.getIdSach()));
                        }
                        db.XoaGioHangKhiThanhToan(db.LayTaiKhoanDangDangNhap());
                        Intent moGiaoDien = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(moGiaoDien);
                        finishAffinity();
                        Toast.makeText(getApplicationContext(), "Giao dịch thành công", Toast.LENGTH_SHORT).show();
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
        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextDiaChi = findViewById(R.id.editTextDiaChi);
        editTextEmail = findViewById(R.id.editTextEmail);
        textViewTongTien = findViewById(R.id.textViewTongTien);
        buttonXacNhan = findViewById(R.id.buttonXacNhan);
        buttonQuayLai = findViewById(R.id.buttonQuayLai);
        db = new MyDB(getApplicationContext());
        thongTin = db.LayTaiKhoan(db.LayTaiKhoanDangDangNhap());

        m_Configuration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(paymentClientId);
        service = new Intent(getApplicationContext(), PayPalService.class);
        service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_Configuration);
        startService(service);
    }


}
