package com.sinhvien.sach24h;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.sinhvien.sach24h.Adapter.LoaiSanPhamAdapter;
import com.sinhvien.sach24h.Adapter.SanPhamAdapter;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.TheLoai;
import com.sinhvien.sach24h.ViewModel.ViewModelSach;

import java.util.List;


public class HomeFragment extends Fragment {
    ViewFlipper viewFlipperQuangCao;
    RecyclerView recyclerViewTheLoai;
    ListView listViewSanPhamHot;
    LoaiSanPhamAdapter loaiSanPhamAdapter;
    List<TheLoai> theLoais;
    List<ViewModelSach> saches;
    SanPhamAdapter sanPhamAdapter;
    private static MyDB myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        AnhXa(view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTheLoai.setLayoutManager(layoutManager);
        recyclerViewTheLoai.setAdapter(loaiSanPhamAdapter);
        listViewSanPhamHot.setAdapter(sanPhamAdapter);
        listViewSanPhamHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int idSach = (int) listViewSanPhamHot.getItemIdAtPosition(i);
                ClickVaoSanPham(getContext(), idSach);
            }
        });
        return view;
    }

    private void AnhXa(View view) {
        viewFlipperQuangCao = view.findViewById(R.id.viewFlipperQuangCao);
        //Đặt 2s sẽ chuyển hình
        viewFlipperQuangCao.setFlipInterval(2000);
        //Bắt đầu chuyển
        viewFlipperQuangCao.startFlipping();
        recyclerViewTheLoai = view.findViewById(R.id.recyclerViewTheLoai);
        listViewSanPhamHot = view.findViewById(R.id.listViewSanPhamHot);
        myDB = new MyDB(getContext());
        theLoais = myDB.LayTatCaLoaiSach();
        loaiSanPhamAdapter = new LoaiSanPhamAdapter(getContext(), theLoais);
        saches = myDB.LaySachHot();
        sanPhamAdapter = new SanPhamAdapter(getContext(), saches);
    }

    public static void ClickVaoSanPham(Context context, int idSanPham) {
        Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("masanpham", idSanPham);
        intent.putExtras(bundle);
        myDB.CapNhatLuotViewSach(idSanPham);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
