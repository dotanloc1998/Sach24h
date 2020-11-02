package com.sinhvien.sach24h.Model;

public class DonHang {
    private int id;
    private String maHoaDon;
    private String ngayGiao;
    private String trangThai;
    private String email;
    private String ngayTao;
    private String loaiThanhToan;
    private int tongTien;

    public DonHang(String maHoaDon, String ngayGiao, String trangThai, String email, String ngayTao, String loaiThanhToan, int tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
        this.email = email;
        this.ngayTao = ngayTao;
        this.loaiThanhToan = loaiThanhToan;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public DonHang(int id, String ngayGiao, String trangThai, String email, String ngayTao, String loaiThanhToan, int tongTien) {
        this.id = id;
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
        this.email = email;
        this.ngayTao = ngayTao;
        this.loaiThanhToan = loaiThanhToan;
        this.tongTien = tongTien;
    }

    public DonHang(String ngayGiao, String trangThai, String email, String ngayTao, String loaiThanhToan, int tongTien) {
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
        this.email = email;
        this.ngayTao = ngayTao;
        this.loaiThanhToan = loaiThanhToan;
        this.tongTien = tongTien;
    }

    public String getLoaiThanhToan() {
        return loaiThanhToan;
    }

    public void setLoaiThanhToan(String loaiThanhToan) {
        this.loaiThanhToan = loaiThanhToan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
