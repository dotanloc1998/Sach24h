package com.sinhvien.sach24h.Model;

public class HinhAnhSach {
    private int id;
    private int maSach;
    private String duongDanHinhAnh;

    public HinhAnhSach(int id, int maSach, String duongDanHinhAnh) {
        this.id = id;
        this.maSach = maSach;
        this.duongDanHinhAnh = duongDanHinhAnh;
    }

    public HinhAnhSach(int maSach, String duongDanHinhAnh) {
        this.maSach = maSach;
        this.duongDanHinhAnh = duongDanHinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getDuongDanHinhAnh() {
        return duongDanHinhAnh;
    }

    public void setDuongDanHinhAnh(String duongDanHinhAnh) {
        this.duongDanHinhAnh = duongDanHinhAnh;
    }
}
