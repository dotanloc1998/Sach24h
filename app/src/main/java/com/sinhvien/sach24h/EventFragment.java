package com.sinhvien.sach24h;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sinhvien.sach24h.Adapter.SuKienAdapter;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.ViewModel.ViewModelSuKien;

import java.util.List;


public class EventFragment extends Fragment {
    ListView listViewSuKien;
    List<ViewModelSuKien> suKiens;
    MyDB db;
    SuKienAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        AnhXa(view);
        listViewSuKien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("makhuyenmai", suKiens.get(i).getIdSuKien());
                Intent intent = new Intent(getContext(), KhuyenMaiActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    private void AnhXa(View view) {
        listViewSuKien = view.findViewById(R.id.listViewSuKien);
        db = new MyDB(getContext());
        suKiens = db.LaySuKien();
        adapter = new SuKienAdapter(getContext(), suKiens);
        listViewSuKien.setAdapter(adapter);
    }
}
