package com.sinhvien.sach24h.Model;

public class ChiTietDonHang {
    private int id;
    private String maDonHang;
    private int soLuong;
    private int maSach;

    public ChiTietDonHang(int id, String maDonHang, int soLuong, int maSach) {
        this.id = id;
        this.maDonHang = maDonHang;
        this.soLuong = soLuong;
        this.maSach = maSach;
    }

    public ChiTietDonHang(String maDonHang, int soLuong, int maSach) {
        this.maDonHang = maDonHang;
        this.soLuong = soLuong;
        this.maSach = maSach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
}
