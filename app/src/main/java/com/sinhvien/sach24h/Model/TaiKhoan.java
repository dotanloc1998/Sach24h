package com.sinhvien.sach24h.Model;

public class TaiKhoan {
    private int id;
    private String email;
    private String hoTen;
    private String matKhau;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;

    public TaiKhoan() {
    }

    public TaiKhoan(int id, String email, String hoTen, String matKhau, String ngaySinh, String gioiTinh, String diaChi) {
        this.id = id;
        this.email = email;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public TaiKhoan(String email, String hoTen, String matKhau, String ngaySinh, String gioiTinh, String diaChi) {
        this.email = email;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
