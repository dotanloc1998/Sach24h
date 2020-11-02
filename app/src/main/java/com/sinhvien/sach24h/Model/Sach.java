package com.sinhvien.sach24h.Model;

public class Sach {
    private int id;
    private int soLuong;
    private String tenSach;
    private int gia;
    private String tacGia;
    private String namSuatBan;
    private String trongLuong;
    private String kichThuoc;
    private String moTa;
    private String soTrang;
    private String ngonNgu;
    private String nhaCungCap;
    private String loaiBia;
    private String trangThai;
    private int maTheLoai;
    private int maNhaXuatBan;
    private int soLuongBanDau;
    private int soLuotView;

    public Sach() {
    }

    public Sach(int id, int soLuong, String tenSach, int gia, String tacGia, String namSuatBan, String trongLuong, String kichThuoc, String moTa, String soTrang, String ngonNgu, String nhaCungCap, String loaiBia, String trangThai, int maTheLoai, int maNhaXuatBan, int soLuongBanDau, int soLuotView) {
        this.id = id;
        this.soLuong = soLuong;
        this.tenSach = tenSach;
        this.gia = gia;
        this.tacGia = tacGia;
        this.namSuatBan = namSuatBan;
        this.trongLuong = trongLuong;
        this.kichThuoc = kichThuoc;
        this.moTa = moTa;
        this.soTrang = soTrang;
        this.ngonNgu = ngonNgu;
        this.nhaCungCap = nhaCungCap;
        this.loaiBia = loaiBia;
        this.trangThai = trangThai;
        this.maTheLoai = maTheLoai;
        this.maNhaXuatBan = maNhaXuatBan;
        this.soLuongBanDau = soLuongBanDau;
        this.soLuotView = soLuotView;
    }

    public Sach(int soLuong, String tenSach, int gia, String tacGia, String namSuatBan, String trongLuong, String kichThuoc, String moTa, String soTrang, String ngonNgu, String nhaCungCap, String loaiBia, String trangThai, int maTheLoai, int maNhaXuatBan, int soLuongBanDau, int soLuotView) {
        this.soLuong = soLuong;
        this.tenSach = tenSach;
        this.gia = gia;
        this.tacGia = tacGia;
        this.namSuatBan = namSuatBan;
        this.trongLuong = trongLuong;
        this.kichThuoc = kichThuoc;
        this.moTa = moTa;
        this.soTrang = soTrang;
        this.ngonNgu = ngonNgu;
        this.nhaCungCap = nhaCungCap;
        this.loaiBia = loaiBia;
        this.trangThai = trangThai;
        this.maTheLoai = maTheLoai;
        this.maNhaXuatBan = maNhaXuatBan;
        this.soLuongBanDau = soLuongBanDau;
        this.soLuotView = soLuotView;
    }

    public Sach(String tenSach, int gia, String tacGia, String namSuatBan, String trongLuong, String kichThuoc, String moTa, String soTrang, String ngonNgu, String nhaCungCap, String loaiBia, String trangThai, int maTheLoai, int maNhaXuatBan, int soLuongBanDau, int soLuotView) {
        this.tenSach = tenSach;
        this.gia = gia;
        this.tacGia = tacGia;
        this.namSuatBan = namSuatBan;
        this.trongLuong = trongLuong;
        this.kichThuoc = kichThuoc;
        this.moTa = moTa;
        this.soTrang = soTrang;
        this.ngonNgu = ngonNgu;
        this.nhaCungCap = nhaCungCap;
        this.loaiBia = loaiBia;
        this.trangThai = trangThai;
        this.maTheLoai = maTheLoai;
        this.maNhaXuatBan = maNhaXuatBan;
        this.soLuongBanDau = soLuongBanDau;
        this.soLuotView = soLuotView;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNamSuatBan() {
        return namSuatBan;
    }

    public void setNamSuatBan(String namSuatBan) {
        this.namSuatBan = namSuatBan;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getLoaiBia() {
        return loaiBia;
    }

    public void setLoaiBia(String loaiBia) {
        this.loaiBia = loaiBia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public int getMaNhaXuatBan() {
        return maNhaXuatBan;
    }

    public void setMaNhaXuatBan(int maNhaXuatBan) {
        this.maNhaXuatBan = maNhaXuatBan;
    }

    public int getSoLuongBanDau() {
        return soLuongBanDau;
    }

    public void setSoLuongBanDau(int soLuongBanDau) {
        this.soLuongBanDau = soLuongBanDau;
    }

    public int getSoLuotView() {
        return soLuotView;
    }

    public void setSoLuotView(int soLuotView) {
        this.soLuotView = soLuotView;
    }
}
