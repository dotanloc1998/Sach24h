package com.sinhvien.sach24h;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.sinhvien.sach24h.Adapter.SanPhamAdapter;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.Sach;
import com.sinhvien.sach24h.ViewModel.ViewModelSach;

import java.util.List;


public class SearchFragment extends Fragment {
    SearchView khungTimKiem;
    ListView listViewSanPhamKiemDuoc;
    MyDB db;
    List<ViewModelSach> sach;
    SanPhamAdapter sanPhamAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        AnhXa(view);

        khungTimKiem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!s.equals("")){
                    sach = db.LaySachTheoTimKiem(s);
                    sanPhamAdapter = new SanPhamAdapter(getContext(),sach);
                    listViewSanPhamKiemDuoc.setAdapter(sanPhamAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (!s.equals("")){
                    sach = db.LaySachTheoTimKiem(s);
                    sanPhamAdapter = new SanPhamAdapter(getContext(),sach);
                    listViewSanPhamKiemDuoc.setAdapter(sanPhamAdapter);
                }
                return false;
            }
        });
        listViewSanPhamKiemDuoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int idSach = (int) listViewSanPhamKiemDuoc.getItemIdAtPosition(i);
                HomeFragment.ClickVaoSanPham(getContext(),idSach);
            }
        });
        return view;
    }
    private void AnhXa(View view){
        khungTimKiem = view.findViewById(R.id.khungTimKiem);
        listViewSanPhamKiemDuoc = view.findViewById(R.id.listViewSanPhamKiemDuoc);
        db = new MyDB(getContext());
    }
}
