package com.sinhvien.sach24h.Model;

public class KhuyenMai {
    private int id;
    private String tenKhuyenMai;
    private String noiDung;
    private String duongDanHinhAnh;
    private double giaTriKhuyenMai;
    private String ngayBatDau;
    private String ngayKetThuc;

    public KhuyenMai(int id, String tenKhuyenMai, String noiDung, String duongDanHinhAnh, double giaTriKhuyenMai, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.tenKhuyenMai = tenKhuyenMai;
        this.noiDung = noiDung;
        this.duongDanHinhAnh = duongDanHinhAnh;
        this.giaTriKhuyenMai = giaTriKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public KhuyenMai(String tenKhuyenMai, String noiDung, String duongDanHinhAnh, double giaTriKhuyenMai, String ngayBatDau, String ngayKetThuc) {
        this.tenKhuyenMai = tenKhuyenMai;
        this.noiDung = noiDung;
        this.duongDanHinhAnh = duongDanHinhAnh;
        this.giaTriKhuyenMai = giaTriKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDuongDanHinhAnh() {
        return duongDanHinhAnh;
    }

    public void setDuongDanHinhAnh(String duongDanHinhAnh) {
        this.duongDanHinhAnh = duongDanHinhAnh;
    }

    public double getGiaTriKhuyenMai() {
        return giaTriKhuyenMai;
    }

    public void setGiaTriKhuyenMai(double giaTriKhuyenMai) {
        this.giaTriKhuyenMai = giaTriKhuyenMai;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
