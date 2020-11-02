package com.sinhvien.sach24h.ViewModel;

public class ViewModelSuKien {
    private int idSuKien;
    private String hinhAnhSuKien;

    public ViewModelSuKien(int idSuKien, String hinhAnhSuKien) {
        this.idSuKien = idSuKien;
        this.hinhAnhSuKien = hinhAnhSuKien;
    }

    public int getIdSuKien() {
        return idSuKien;
    }

    public void setIdSuKien(int idSuKien) {
        this.idSuKien = idSuKien;
    }

    public String getHinhAnhSuKien() {
        return hinhAnhSuKien;
    }

    public void setHinhAnhSuKien(String hinhAnhSuKien) {
        this.hinhAnhSuKien = hinhAnhSuKien;
    }
}
