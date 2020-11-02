package com.sinhvien.sach24h;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.sinhvien.sach24h.Model.HinhAnhSach;
import com.sinhvien.sach24h.Model.MyDB;

import java.io.IOException;
import java.util.List;

public class ThemHinhAnhSachActivity extends AppCompatActivity {
    EditText editDuongDanHinhAnh;
    Spinner spinnerSach;
    Button buttonThemHinhAnhSach;
    ImageButton nutChonHinh;
    MyDB db;
    ImageView hinhAnhPreview;
    final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hinh_anh_sach);
        AnhXa();
        ThemDuLieuChoSpinner();
        buttonThemHinhAnhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idSach = Integer.parseInt(spinnerSach.getSelectedItem().toString());
                String duongDanHinh = editDuongDanHinhAnh.getText().toString();
                if (duongDanHinh.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    HinhAnhSach anhSach = new HinhAnhSach(idSach, duongDanHinh);
                    db.ThemHinhAnhSach(anhSach);
                    finish();
                    Toast.makeText(getApplicationContext(), "Thêm hình ảnh thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nutChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
    }

    private void AnhXa() {
        editDuongDanHinhAnh = findViewById(R.id.editDuongDanHinhAnh);
        spinnerSach = findViewById(R.id.spinnerSach);
        buttonThemHinhAnhSach = findViewById(R.id.buttonThemHinhAnhSach);
        hinhAnhPreview = findViewById(R.id.hinhAnhPreview);
        nutChonHinh = findViewById(R.id.nutChonHinh);
        db = new MyDB(getApplicationContext());
    }

    private void ThemDuLieuChoSpinner() {
        List<String> maSach = db.TraVeTatCaMaSach();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, maSach);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSach.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == PICK_IMAGE) {
                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        hinhAnhPreview.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String duongDan = selectedImageUri.toString();
                    editDuongDanHinhAnh.setText(duongDan);
                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
