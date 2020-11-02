package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    ImageButton buttonBack;
    CardView cardViewQuanLiHang, cardViewQuanLiNguoiDung, cardViewQuanLiDonHang, cardViewQuanLiKhuyenMai, cardViewQuanLiThongKe, cardViewQuanLiVeChungToi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        AnhXa();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cardViewQuanLiHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quanLiSach = new Intent(getApplicationContext(), QuanLiSachActivity.class);
                startActivity(quanLiSach);
            }
        });

        cardViewQuanLiNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuanLiNguoiDungActivity.class);
                startActivity(intent);
            }
        });

        cardViewQuanLiDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuanLiDonHangActivity.class);
                startActivity(intent);
            }
        });

        cardViewQuanLiKhuyenMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuanLiSuKienActivity.class);
                startActivity(intent);
            }
        });
        cardViewQuanLiThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThongKeActivity.class);
                startActivity(intent);
            }
        });
        cardViewQuanLiVeChungToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntent(getApplicationContext()));
            }
        });
    }

    private void AnhXa() {
        buttonBack = findViewById(R.id.buttonBack);
        cardViewQuanLiHang = findViewById(R.id.cardViewQuanLiHang);
        cardViewQuanLiNguoiDung = findViewById(R.id.cardViewQuanLiNguoiDung);
        cardViewQuanLiKhuyenMai = findViewById(R.id.cardViewQuanLiKhuyenMai);
        cardViewQuanLiThongKe = findViewById(R.id.cardViewQuanLiThongKe);
        cardViewQuanLiVeChungToi = findViewById(R.id.cardViewQuanLiVeChungToi);
        cardViewQuanLiDonHang = findViewById(R.id.cardViewQuanLiDonHang);
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/khimacao"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/khimacao"));
        }
    }
}
