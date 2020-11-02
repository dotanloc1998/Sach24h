package com.sinhvien.sach24h.Model;

public class BinhLuan {
    private int id;
    private String noiDung;
    private double soDiem;
    private int maSach;
    private String email;

    public BinhLuan(int id, String noiDung, double soDiem, int maSach, String email) {
        this.id = id;
        this.noiDung = noiDung;
        this.soDiem = soDiem;
        this.maSach = maSach;
        this.email = email;
    }

    public BinhLuan(String noiDung, double soDiem, int maSach, String email) {
        this.noiDung = noiDung;
        this.soDiem = soDiem;
        this.maSach = maSach;
        this.email = email;
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

    public double getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(double soDiem) {
        this.soDiem = soDiem;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
