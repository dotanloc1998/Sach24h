package com.sinhvien.sach24h.Model;

public class TheLoai {
    private int id;
    private String tenTheLoai;
    private String trangThai;
    private String duongDanHinhAnh;

    public TheLoai(int id, String tenTheLoai, String trangThai, String duongDanHinhAnh) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
        this.duongDanHinhAnh = duongDanHinhAnh;
    }

    public TheLoai(String tenTheLoai, String trangThai, String duongDanHinhAnh) {
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
        this.duongDanHinhAnh = duongDanHinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDuongDanHinhAnh() {
        return duongDanHinhAnh;
    }

    public void setDuongDanHinhAnh(String duongDanHinhAnh) {
        this.duongDanHinhAnh = duongDanHinhAnh;
    }
}
