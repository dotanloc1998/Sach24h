package com.sinhvien.sach24h.ViewModel;

public class ViewModelChiTietDonHang {
    private String tenSach;
    private String hinhAnhSach;
    private int soLuong;
    private int gia;
    private int giaThanhTien;

    public ViewModelChiTietDonHang(String tenSach, String hinhAnhSach, int soLuong, int gia) {
        this.tenSach = tenSach;
        this.hinhAnhSach = hinhAnhSach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getGiaThanhTien() {
        return giaThanhTien;
    }

    public void setGiaThanhTien(int giaThanhTien) {
        this.giaThanhTien = giaThanhTien;
    }

    public ViewModelChiTietDonHang(String tenSach, String hinhAnhSach, int soLuong, int gia, int giaThanhTien) {
        this.tenSach = tenSach;
        this.hinhAnhSach = hinhAnhSach;
        this.soLuong = soLuong;
        this.gia = gia;
        this.giaThanhTien = giaThanhTien;
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
