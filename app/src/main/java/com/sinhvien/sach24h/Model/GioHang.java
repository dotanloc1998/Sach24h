package com.sinhvien.sach24h.Model;

public class GioHang {
    private int id;
    private int maSach;
    private int soLuong;
    private String email;

    public GioHang() {
    }

    public GioHang(int id, int maSach, int soLuong, String email) {
        this.id = id;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.email = email;
    }

    public GioHang(int maSach, int soLuong, String email) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.email = email;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
