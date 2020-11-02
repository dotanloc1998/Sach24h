package com.sinhvien.sach24h.ViewModel;

public class ViewModelGioHang {
    private int idSach;
    private String tenSach;
    private String hinhAnhSach;
    private int soLuong;
    private int gia;

    public ViewModelGioHang(String tenSach, String hinhAnhSach, int soLuong, int gia) {
        this.tenSach = tenSach;
        this.hinhAnhSach = hinhAnhSach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public ViewModelGioHang(int idSach, String tenSach, String hinhAnhSach, int soLuong, int gia) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.hinhAnhSach = hinhAnhSach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getHinhAnhSach() {
        return hinhAnhSach;
    }

    public void setHinhAnhSach(String hinhAnhSach) {
        this.hinhAnhSach = hinhAnhSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
