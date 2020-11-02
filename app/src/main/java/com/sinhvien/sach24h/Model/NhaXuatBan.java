package com.sinhvien.sach24h.Model;

public class NhaXuatBan {
    private int id;
    private String tenNhaXuatBan;
    private String trangThai;

    public NhaXuatBan(int id, String tenNhaXuatBan, String trangThai) {
        this.id = id;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.trangThai = trangThai;
    }

    public NhaXuatBan(String tenNhaXuatBan, String trangThai) {
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
