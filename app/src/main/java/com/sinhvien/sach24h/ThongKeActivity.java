package com.sinhvien.sach24h;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.sinhvien.sach24h.Model.MyDB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThongKeActivity extends AppCompatActivity {
    BarChart barChartThuNhapTungThang;
    PieChart pieChartcacLoaiDonHang;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        AnhXa();
        XuLiPieChart();
        XuLiBarChart();
    }

    private void AnhXa() {
        barChartThuNhapTungThang = findViewById(R.id.barChartThuNhapTungThang);
        pieChartcacLoaiDonHang = findViewById(R.id.pieChartcacLoaiDonHang);
        db = new MyDB(getApplicationContext());
    }

    private void XuLiPieChart() {
        Cursor thongTinDonHang = db.LayTatCaDonHang();
        int tongChuaGiao = 0;
        int tongDaGiao = 0;
        int tongDaHuy = 0;
        int tongTraLaiTien = 0;
        if (thongTinDonHang.getCount() > 0) {
            do {
                String trangThai = thongTinDonHang.getString(thongTinDonHang.getColumnIndex("trangthai"));
                switch (trangThai) {
                    case "Chưa giao":
                        tongChuaGiao++;
                        break;
                    case "Đã giao":
                        tongDaGiao++;
                        break;
                    case "Đã hủy":
                        tongDaHuy++;
                        break;
                    case "Trả lại tiền":
                        tongTraLaiTien++;
                        break;
                    default:

                }
            } while (thongTinDonHang.moveToNext());
        }

        pieChartcacLoaiDonHang.setRotationEnabled(true);
        pieChartcacLoaiDonHang.setCenterText("Các loại hóa đơn");
        pieChartcacLoaiDonHang.setCenterTextSize(20);
        pieChartcacLoaiDonHang.animateXY(2000, 2000);

        List<PieEntry> entries = new ArrayList<>();
        if (tongChuaGiao > 0)
            entries.add(new PieEntry((float) tongChuaGiao, "Chưa giao"));
        if (tongDaGiao > 0)
            entries.add(new PieEntry((float) tongDaGiao, "Đã giao"));
        if (tongDaHuy > 0)
            entries.add(new PieEntry((float) tongDaHuy, "Đã hủy"));
        if (tongTraLaiTien > 0)
            entries.add(new PieEntry((float) tongTraLaiTien, "Trả lại tiền"));

        PieDataSet set = new PieDataSet(entries, "");
        set.setColors(ColorTemplate.COLORFUL_COLORS);
        set.setValueTextSize(20);

        PieData data = new PieData(set);
        pieChartcacLoaiDonHang.setData(data);
        pieChartcacLoaiDonHang.invalidate();
    }

    private void XuLiBarChart() {
        Calendar calendar = Calendar.getInstance();
        int[] tongTienTrongNam = db.TraVeMangTienMoiThang(calendar.get(Calendar.YEAR));
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, tongTienTrongNam[0]));
        entries.add(new BarEntry(1f, tongTienTrongNam[1]));
        entries.add(new BarEntry(2f, tongTienTrongNam[2]));
        entries.add(new BarEntry(3f, tongTienTrongNam[3]));
        entries.add(new BarEntry(4f, tongTienTrongNam[4]));
        entries.add(new BarEntry(5f, tongTienTrongNam[5]));
        entries.add(new BarEntry(6f, tongTienTrongNam[6]));
        entries.add(new BarEntry(7f, tongTienTrongNam[7]));
        entries.add(new BarEntry(8f, tongTienTrongNam[8]));
        entries.add(new BarEntry(9f, tongTienTrongNam[9]));
        entries.add(new BarEntry(10f, tongTienTrongNam[10]));
        entries.add(new BarEntry(11f, tongTienTrongNam[11]));
        BarDataSet barDataSet = new BarDataSet(entries, "Tiền thu được");

        barDataSet.setBarBorderWidth(0.9f);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        XAxis xAxis = barChartThuNhapTungThang.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun" , "Jul" , "Aug" , "Sep" , "Oct", "Nov" , "Dec"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(months);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        barChartThuNhapTungThang.setData(barData);
        barChartThuNhapTungThang.setFitBars(true);
        barChartThuNhapTungThang.animateXY(5000, 5000);
        barChartThuNhapTungThang.invalidate();
    }
}
