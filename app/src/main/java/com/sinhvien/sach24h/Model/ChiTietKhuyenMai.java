package com.sinhvien.sach24h.Model;

public class ChiTietKhuyenMai {
    private int id;
    private int maKhuyenMai;
    private int maSach;

    public ChiTietKhuyenMai(int id, int maKhuyenMai, int maSach) {
        this.id = id;
        this.maKhuyenMai = maKhuyenMai;
        this.maSach = maSach;
    }

    public ChiTietKhuyenMai(int maKhuyenMai, int maSach) {
        this.maKhuyenMai = maKhuyenMai;
        this.maSach = maSach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
}
