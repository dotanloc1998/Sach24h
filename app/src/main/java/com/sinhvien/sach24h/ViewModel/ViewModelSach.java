package com.sinhvien.sach24h.ViewModel;

public class ViewModelSach {
    private int id;
    private String tenSach;
    private int gia;
    private String moTa;
    private String duongDanHinhAnh;

    public ViewModelSach(int id, String tenSach, int gia, String moTa, String duongDanHinhAnh) {
        this.id = id;
        this.tenSach = tenSach;
        this.gia = gia;
        this.moTa = moTa;
        this.duongDanHinhAnh = duongDanHinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDuongDanHinhAnh() {
        return duongDanHinhAnh;
    }

    public void setDuongDanHinhAnh(String duongDanHinhAnh) {
        this.duongDanHinhAnh = duongDanHinhAnh;
    }
}
