package com.sinhvien.sach24h.Model;

public class FeedBack {
    private int id;
    private String noiDung;
    private String maHoaDon;

    public FeedBack(int id, String noiDung, String maHoaDon) {
        this.id = id;
        this.noiDung = noiDung;
        this.maHoaDon = maHoaDon;
    }

    public FeedBack(String noiDung, String maHoaDon) {
        this.noiDung = noiDung;
        this.maHoaDon = maHoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
}
