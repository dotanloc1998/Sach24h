package com.sinhvien.sach24h.Model;

public class LichSuGia {
    private int id;
    private String NgaySua;
    private int maSach;
    private int giaCu;

    public LichSuGia(int id, String ngaySua, int maSach, int giaCu) {
        this.id = id;
        NgaySua = ngaySua;
        this.maSach = maSach;
        this.giaCu = giaCu;
    }

    public LichSuGia(String ngaySua, int maSach, int giaCu) {
        NgaySua = ngaySua;
        this.maSach = maSach;
        this.giaCu = giaCu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(String ngaySua) {
        NgaySua = ngaySua;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getGiaCu() {
        return giaCu;
    }

    public void setGiaCu(int giaCu) {
        this.giaCu = giaCu;
    }
}
