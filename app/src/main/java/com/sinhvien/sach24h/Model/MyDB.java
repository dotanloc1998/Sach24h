package com.sinhvien.sach24h.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.sinhvien.sach24h.ViewModel.ViewModelChiTietDonHang;
import com.sinhvien.sach24h.ViewModel.ViewModelGioHang;
import com.sinhvien.sach24h.ViewModel.ViewModelSach;
import com.sinhvien.sach24h.ViewModel.ViewModelSuKien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "quanlycuahang";
    private static final String KEY_ID = "_id";
    Context context;

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //Các bảng
    //Bảng đăng nhập
    private static final String TABLE_DANGNHAP = "TDangNhap";


    //Bảng bình luận
    private static final String TABLE_BINHlUAN = "TBinhLuan";
    private static final String KEY_NOIDUNG = "noidung";
    private static final String KEY_SODIEM = "sodiem";
    private static final String KEY_MASACH = "masach";
    private static final String KEY_EMAIL = "email";

    //Bảng chi tiết đơn hàng
    private static final String TABLE_CHITIETDONHANG = "TChiTietDonHang";
    private static final String KEY_MADONHANG = "madonhang";
    private static final String KEY_SOLUONG = "soluong";

    //Bảng chi tiết khuyến mãi
    private static final String TABLE_CHITIETKHUYENMAI = "TChiTietKhuyenMai";
    private static final String KEY_MAKHUYENMAI = "makhuyenmai";

    //Bảng đơn hàng
    private static final String TABLE_DONHANG = "TDonHang";
    private static final String KEY_NGAYGIAO = "ngaygiao";
    private static final String KEY_TRANGTHAI = "trangthai";
    private static final String KEY_NGAYTAO = "ngaytao";
    private static final String KEY_TONGTIEN = "tongtien";
    private static final String KEY_LOAITHANHTOAN = "loaithanhtoan";

    //Bảng feedback
    private static final String TABLE_FEEDBACK = "TFeedback";

    //Bảng giỏ hàng
    private static final String TABLE_GIOHANG = "TGioHang";

    //Bảng hình ảnh sách
    private static final String TABLE_HINHANHSACH = "THinhAnhSach";
    private static final String KEY_DUONGDANHINHANH = "duongdanhinhanh";

    //Bảng khuyến mãi
    private static final String TABLE_KHUYENMAI = "TKhuyenMai";
    private static final String KEY_TENKHUYENMAI = "tenkhuyenmai";
    private static final String KEY_GIATRIKHUYENMAI = "giatrikhuyenmai";
    private static final String KEY_NGAYBATDAU = "ngaybatdau";
    private static final String KEY_NGAYKETTHUC = "ngayketthuc";

    //Bảng lịch sử giá
    private static final String TABLE_LICHSUGIA = "TLichSuGia";
    private static final String KEY_NGAYSUA = "ngaysua";
    private static final String KEY_GIACU = "giacu";

    //Bảng nhà xuất bản
    private static final String TABLE_NHAXUATBAN = "TNhaXuatBan";
    private static final String KEY_TENNHAXUATBAN = "tennhaxuatban";

    //Bảng sách
    private static final String TABLE_SACH = "TSach";
    private static final String KEY_TENSACH = "tensach";
    private static final String KEY_GIA = "gia";
    private static final String KEY_TACGIA = "tacgia";
    private static final String KEY_NAMXUATBAN = "namxuatban";
    private static final String KEY_TRONGLUONG = "trongluong";
    private static final String KEY_KICHTHUOC = "kichthuoc";
    private static final String KEY_MOTA = "mota";
    private static final String KEY_SOTRANG = "sotrang";
    private static final String KEY_NGONNGU = "ngonngu";
    private static final String KEY_NHACUNGCAP = "nhacungcap";
    private static final String KEY_LOAIBIA = "loaibia";
    private static final String KEY_MATHElOAI = "matheloai";
    private static final String KEY_MANHAXUATBAN = "manhaxuatban";
    private static final String KEY_SOLUONGBANDAU = "soluongbandau";
    private static final String KEY_LUOTVIEW = "luotview";

    //Bảng tài khoản
    private static final String TABLE_TAIKHOAN = "TTaiKhoan";
    private static final String KEY_HOTEN = "hoten";
    private static final String KEY_MATKHAU = "matkhau";
    private static final String KEY_NGAYSINH = "ngaysinh";
    private static final String KEY_GIOITINH = "gioitinh";
    private static final String KEY_DIACHI = "diachi";

    //Bảng thể loại
    private static final String TABLE_THELOAI = "TTheLoai";
    private static final String KEY_TENTHELOAI = "tentheloai";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String taoBangDangNhap = "CREATE TABLE " + TABLE_DANGNHAP
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EMAIL + " TEXT" + ")";
        String taoBangBinhLuan = "CREATE TABLE " + TABLE_BINHlUAN
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NOIDUNG + " TEXT," + KEY_SODIEM + " REAL," + KEY_MASACH + " INTEGER," + KEY_EMAIL + " TEXT" + ")";
        String taoBangChiTietDonHang = "CREATE TABLE " + TABLE_CHITIETDONHANG
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MADONHANG + " TEXT," + KEY_SOLUONG + " INTEGER," + KEY_MASACH + " INTEGER" + ")";
        String taoBangChiTietKhuyenMai = "CREATE TABLE " + TABLE_CHITIETKHUYENMAI
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MAKHUYENMAI + " INTEGER," + KEY_MASACH + " INTEGER" + ")";
        String taoBangDonHang = "CREATE TABLE " + TABLE_DONHANG
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MADONHANG + " TEXT," + KEY_NGAYGIAO + " TEXT," + KEY_TRANGTHAI + " TEXT," + KEY_EMAIL + " TEXT," + KEY_NGAYTAO + " TEXT," + KEY_TONGTIEN + " INTEGER," + KEY_LOAITHANHTOAN + " TEXT" + ")";
        String taoBangFeedback = "CREATE TABLE " + TABLE_FEEDBACK
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NOIDUNG + " TEXT," + KEY_MADONHANG + " TEXT" + ")";
        String taoBangGioHang = "CREATE TABLE " + TABLE_GIOHANG
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MASACH + " INTEGER," + KEY_SOLUONG + " INTEGER," + KEY_EMAIL + " TEXT" + ")";
        String taoBangHinhAnhSach = "CREATE TABLE " + TABLE_HINHANHSACH
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MASACH + " INTEGER," + KEY_DUONGDANHINHANH + " TEXT" + ")";
        String taoBangKhuyenMai = "CREATE TABLE " + TABLE_KHUYENMAI
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TENKHUYENMAI + " TEXT," + KEY_NOIDUNG + " TEXT," + KEY_DUONGDANHINHANH + " TEXT," + KEY_GIATRIKHUYENMAI + " REAL," + KEY_NGAYBATDAU + " TEXT," + KEY_NGAYKETTHUC + " TEXT" + ")";
        String taoBangLichSuGia = "CREATE TABLE " + TABLE_LICHSUGIA
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NGAYSUA + " TEXT," + KEY_MASACH + " INTEGER," + KEY_GIACU + " INTEGER" + ")";
        String taoBangNhaXuatBan = "CREATE TABLE " + TABLE_NHAXUATBAN
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TENNHAXUATBAN + " TEXT," + KEY_TRANGTHAI + " TEXT" + ")";
        String taoBangSach = "CREATE TABLE " + TABLE_SACH
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_SOLUONG + " INTEGER," + KEY_TENSACH + " TEXT," + KEY_GIA + " INTEGER," + KEY_TACGIA + " TEXT," + KEY_NAMXUATBAN + " TEXT," + KEY_TRONGLUONG + " TEXT," + KEY_KICHTHUOC + " TEXT," + KEY_MOTA + " TEXT," + KEY_SOTRANG + " TEXT," + KEY_NGONNGU + " TEXT," + KEY_NHACUNGCAP + " TEXT," + KEY_LOAIBIA + " TEXT," + KEY_TRANGTHAI + " TEXT," + KEY_MATHElOAI + " INTEGER," + KEY_MANHAXUATBAN + " INTEGER," + KEY_SOLUONGBANDAU + " INTEGER," + KEY_LUOTVIEW + " INTEGER" + ")";
        String taoBangTaiKhoan = "CREATE TABLE " + TABLE_TAIKHOAN
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EMAIL + " TEXT," + KEY_HOTEN + " TEXT," + KEY_MATKHAU + " TEXT," + KEY_NGAYSINH + " TEXT," + KEY_GIOITINH + " TEXT," + KEY_DIACHI + " TEXT" + ")";
        String taoBangTheLoai = "CREATE TABLE " + TABLE_THELOAI
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TENTHELOAI + " TEXT," + KEY_TRANGTHAI + " TEXT," + KEY_DUONGDANHINHANH + " TEXT" + ")";

        sqLiteDatabase.execSQL(taoBangDangNhap);
        sqLiteDatabase.execSQL(taoBangBinhLuan);
        sqLiteDatabase.execSQL(taoBangChiTietDonHang);
        sqLiteDatabase.execSQL(taoBangChiTietKhuyenMai);
        sqLiteDatabase.execSQL(taoBangDonHang);
        sqLiteDatabase.execSQL(taoBangFeedback);
        sqLiteDatabase.execSQL(taoBangGioHang);
        sqLiteDatabase.execSQL(taoBangHinhAnhSach);
        sqLiteDatabase.execSQL(taoBangKhuyenMai);
        sqLiteDatabase.execSQL(taoBangLichSuGia);
        sqLiteDatabase.execSQL(taoBangNhaXuatBan);
        sqLiteDatabase.execSQL(taoBangSach);
        sqLiteDatabase.execSQL(taoBangTaiKhoan);
        sqLiteDatabase.execSQL(taoBangTheLoai);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Các hàm sẽ sử dụng
    public String LayTaiKhoanDangDangNhap() {
        SQLiteDatabase db = getWritableDatabase();
        String taiKhoan = "";
        Cursor taiKhoanDangDangNhap = db.query
                (TABLE_DANGNHAP, null, null, null, null, null, null);
        if (taiKhoanDangDangNhap.getCount() > 0) {
            taiKhoanDangDangNhap.moveToFirst();
            taiKhoan = taiKhoanDangDangNhap.getString(taiKhoanDangDangNhap.getColumnIndex(KEY_EMAIL));
        }
        return taiKhoan;
    }

    public List<TheLoai> LayTatCaLoaiSach() {
        SQLiteDatabase db = getWritableDatabase();
        List<TheLoai> theloaiSach = new ArrayList<>();
        Cursor loaiSach = db.query(TABLE_THELOAI, null, null, null, null, null, null);
        if (loaiSach.getCount() > 0) {
            loaiSach.moveToFirst();
            do {
                int id = loaiSach.getInt(loaiSach.getColumnIndex(KEY_ID));
                String tenTheLoai = loaiSach.getString(loaiSach.getColumnIndex(KEY_TENTHELOAI));
                String trangThai = loaiSach.getString(loaiSach.getColumnIndex(KEY_TRANGTHAI));
                String duongDanHinhAnh = loaiSach.getString(loaiSach.getColumnIndex(KEY_DUONGDANHINHANH));
                theloaiSach.add(new TheLoai(id, tenTheLoai, trangThai, duongDanHinhAnh));
            } while (loaiSach.moveToNext());
        }
        return theloaiSach;
    }

    public void ThemTheLoai(TheLoai theLoai) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TENTHELOAI, theLoai.getTenTheLoai());
        values.put(KEY_TRANGTHAI, theLoai.getTrangThai());
        values.put(KEY_DUONGDANHINHANH, theLoai.getDuongDanHinhAnh());
        db.insert(TABLE_THELOAI, null, values);
        db.close();
    }

    public void ThemSach(Sach sach) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putSach(sach);
        db.insert(TABLE_SACH, null, values);
        db.close();
    }

    public void SuaSach(Sach sach) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putSach(sach);
        db.update(TABLE_SACH, values, KEY_ID + " = " + "'" + sach.getId() + "'", null);
        db.close();
    }

    public void ThemNhaXuatBan(NhaXuatBan nhaXuatBan) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TENNHAXUATBAN, nhaXuatBan.getTenNhaXuatBan());
        values.put(KEY_TRANGTHAI, nhaXuatBan.getTrangThai());
        db.insert(TABLE_NHAXUATBAN, null, values);
        db.close();
    }

    public void ThemHinhAnhSach(HinhAnhSach hinhAnhSach) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MASACH, hinhAnhSach.getMaSach());
        values.put(KEY_DUONGDANHINHANH, hinhAnhSach.getDuongDanHinhAnh());
        db.insert(TABLE_HINHANHSACH, null, values);
        db.close();
    }

    public List<ViewModelSach> LaySachTheoTheLoai(int maTheLoai) {
        SQLiteDatabase db = getWritableDatabase();
        List<ViewModelSach> sachTheoTheLoai = new ArrayList<>();
        Cursor sach = db.query(TABLE_SACH, null, KEY_MATHElOAI + " = ? AND " + KEY_TRANGTHAI + " = ?", new String[]{maTheLoai + "", "HD"}, null, null, null);
        if (sach.getCount() > 0) {
            sach.moveToFirst();
            do {
                int id = sach.getInt(sach.getColumnIndex(KEY_ID));
                String tenSach = sach.getString(sach.getColumnIndex(KEY_TENSACH));
                int gia = sach.getInt(sach.getColumnIndex(KEY_GIA));
                String moTa = sach.getString(sach.getColumnIndex(KEY_MOTA));
                String duongDanHinhAnh = LayHinhAnhDaiDienCuaSach(id);
                sachTheoTheLoai.add(new ViewModelSach(id, tenSach, gia, moTa, duongDanHinhAnh));
            } while (sach.moveToNext());
        }
        return sachTheoTheLoai;
    }

    public List<ViewModelSach> LaySachHot() {
        SQLiteDatabase db = getWritableDatabase();
        List<ViewModelSach> sachHot = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_SACH + " WHERE " + KEY_TRANGTHAI + " = 'HD' " + " ORDER BY " + KEY_LUOTVIEW + " DESC " + "LIMIT 10";
        Cursor sach = db.rawQuery(query, null);
        if (sach.getCount() > 0) {
            sach.moveToFirst();
            do {
                int id = sach.getInt(sach.getColumnIndex(KEY_ID));
                String tenSach = sach.getString(sach.getColumnIndex(KEY_TENSACH));
                int gia = sach.getInt(sach.getColumnIndex(KEY_GIA));
                String moTa = sach.getString(sach.getColumnIndex(KEY_MOTA));
                String duongDanHinhAnh = LayHinhAnhDaiDienCuaSach(id);
                sachHot.add(new ViewModelSach(id, tenSach, gia, moTa, duongDanHinhAnh));
            } while (sach.moveToNext());
        }
        return sachHot;
    }

    public List<ViewModelSach> LaySachTheoTimKiem(String chuoiNhap) {
        SQLiteDatabase db = getWritableDatabase();
        List<ViewModelSach> sachTimKiem = new ArrayList<>();
        String chuoiNhapVietThuong = chuoiNhap.toLowerCase();
        int idNhaXuatBan = TraVeIdCuaNhaXuatBan(chuoiNhap);
        String query = "SELECT * FROM " + TABLE_SACH + " WHERE " + KEY_TRANGTHAI + " = 'HD' AND" + " LOWER(" + KEY_TENSACH + ")" + " LIKE " + "'%" + chuoiNhapVietThuong + "%'" + " OR "
                + " LOWER(" + KEY_TACGIA + ")" + " LIKE " + "'%" + chuoiNhapVietThuong + "%'" + " OR " + KEY_MANHAXUATBAN + " = " + idNhaXuatBan + " LIMIT 10";
        Cursor sach = db.rawQuery(query, null);
        if (sach.getCount() > 0) {
            sach.moveToFirst();
            do {
                int id = sach.getInt(sach.getColumnIndex(KEY_ID));
                String tenSach = sach.getString(sach.getColumnIndex(KEY_TENSACH));
                int gia = sach.getInt(sach.getColumnIndex(KEY_GIA));
                String moTa = sach.getString(sach.getColumnIndex(KEY_MOTA));
                String duongDanHinhAnh = LayHinhAnhDaiDienCuaSach(id);
                sachTimKiem.add(new ViewModelSach(id, tenSach, gia, moTa, duongDanHinhAnh));
            } while (sach.moveToNext());
        }
        return sachTimKiem;
    }

    public int TraVeIdCuaNhaXuatBan(String tenNhaXuatBan) {
        SQLiteDatabase db = getWritableDatabase();
        String tenVietThuong = tenNhaXuatBan.toLowerCase();
        String query = "SELECT * FROM " + TABLE_NHAXUATBAN + " WHERE " + " LOWER(" + KEY_TENNHAXUATBAN + ")" + " LIKE " + "'%" + tenVietThuong + "%'";
        Cursor nxb = db.rawQuery(query, null);
        NhaXuatBan timThay = new NhaXuatBan(-1, "", "");
        if (nxb.getCount() > 0) {
            nxb.moveToFirst();
            int id = nxb.getInt(nxb.getColumnIndex(KEY_ID));
            String tenNXB = nxb.getString(nxb.getColumnIndex(KEY_TENNHAXUATBAN));
            String trangThai = nxb.getString(nxb.getColumnIndex(KEY_TRANGTHAI));
            timThay = new NhaXuatBan(id, tenNXB, trangThai);
        }
        return timThay.getId();
    }

    public String LayHinhAnhDaiDienCuaSach(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String duongDanHinhAnh = "";
        Cursor hinhAnhSach = db.query(TABLE_HINHANHSACH, null, KEY_MASACH + " = ?", new String[]{id + ""}, null, null, null);
        if (hinhAnhSach.getCount() > 0) {
            hinhAnhSach.moveToFirst();
            duongDanHinhAnh = hinhAnhSach.getString(hinhAnhSach.getColumnIndex(KEY_DUONGDANHINHANH));
        }
        return duongDanHinhAnh;
    }

    public List<HinhAnhSach> LayHinhAnhCuaSach(int id) {
        SQLiteDatabase db = getWritableDatabase();
        List<HinhAnhSach> hinhAnhSaches = new ArrayList<>();
        Cursor hinhAnhSach = db.query(TABLE_HINHANHSACH, null, KEY_MASACH + " = ?", new String[]{id + ""}, null, null, null);
        if (hinhAnhSach.getCount() > 0) {
            hinhAnhSach.moveToFirst();
            do {
                int idHinhAnh = hinhAnhSach.getInt(hinhAnhSach.getColumnIndex(KEY_ID));
                String duongDan = hinhAnhSach.getString(hinhAnhSach.getColumnIndex(KEY_DUONGDANHINHANH));
                hinhAnhSaches.add(new HinhAnhSach(idHinhAnh, id, duongDan));
            } while (hinhAnhSach.moveToNext());
        }
        return hinhAnhSaches;
    }

    public List<BinhLuan> LayBinhLuanCuaSach(int idSach) {
        SQLiteDatabase db = getWritableDatabase();
        List<BinhLuan> binhLuans = new ArrayList<>();
        Cursor binhLuanSach = db.query(TABLE_BINHlUAN, null, KEY_MASACH + " = ?", new String[]{idSach + ""}, null, null, null);
        if (binhLuanSach.getCount() > 0) {
            binhLuanSach.moveToFirst();
            do {
                String emailNguoiDung = binhLuanSach.getString(binhLuanSach.getColumnIndex(KEY_EMAIL));
                String tenNguoiDung = TraVeTenNguoiDung(emailNguoiDung);
                int id = binhLuanSach.getInt(binhLuanSach.getColumnIndex(KEY_ID));
                String noiDung = binhLuanSach.getString(binhLuanSach.getColumnIndex(KEY_NOIDUNG));
                double soDiem = binhLuanSach.getDouble(binhLuanSach.getColumnIndex(KEY_SODIEM));
                binhLuans.add(new BinhLuan(id, noiDung, soDiem, idSach, tenNguoiDung));
            } while (binhLuanSach.moveToNext());

        }
        return binhLuans;
    }

    public String TraVeTenNguoiDung(String emailNguoiDung) {
        SQLiteDatabase db = getWritableDatabase();
        String tenNguoiDung = "";
        Cursor timNguoiDung = db.query(TABLE_TAIKHOAN, null, KEY_EMAIL + " = ?", new String[]{emailNguoiDung}, null, null, null);
        if (timNguoiDung.getCount() > 0) {
            timNguoiDung.moveToFirst();
            tenNguoiDung = timNguoiDung.getString(timNguoiDung.getColumnIndex(KEY_HOTEN));
        }
        return tenNguoiDung;
    }

    public Sach TraVeSachBangId(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Sach sach = new Sach();
        Cursor timSach = db.query(TABLE_SACH, null, KEY_ID + " = ?", new String[]{id + ""}, null, null, null, null);
        if (timSach.getCount() > 0) {
            timSach.moveToFirst();
            int soLuong = timSach.getInt(timSach.getColumnIndex(KEY_SOLUONG));
            String tenSach = timSach.getString(timSach.getColumnIndex(KEY_TENSACH));
            int gia = timSach.getInt(timSach.getColumnIndex(KEY_GIA));
            String tacGia = timSach.getString(timSach.getColumnIndex(KEY_TACGIA));
            String namSuatBan = timSach.getString(timSach.getColumnIndex(KEY_NAMXUATBAN));
            String trongLuong = timSach.getString(timSach.getColumnIndex(KEY_TRONGLUONG));
            String kichThuoc = timSach.getString(timSach.getColumnIndex(KEY_KICHTHUOC));
            String moTa = timSach.getString(timSach.getColumnIndex(KEY_MOTA));
            String soTrang = timSach.getString(timSach.getColumnIndex(KEY_SOTRANG));
            String ngonNgu = timSach.getString(timSach.getColumnIndex(KEY_NGONNGU));
            String nhaCungCap = timSach.getString(timSach.getColumnIndex(KEY_NHACUNGCAP));
            String loaiBia = timSach.getString(timSach.getColumnIndex(KEY_LOAIBIA));
            String trangThai = timSach.getString(timSach.getColumnIndex(KEY_TRANGTHAI));
            int maTheLoai = timSach.getInt(timSach.getColumnIndex(KEY_MATHElOAI));
            int maNhaXuatBan = timSach.getInt(timSach.getColumnIndex(KEY_MANHAXUATBAN));
            int soLuongBanDau = timSach.getInt(timSach.getColumnIndex(KEY_SOLUONGBANDAU));
            int soLuotView = timSach.getInt(timSach.getColumnIndex(KEY_LUOTVIEW));
            sach = new Sach(id, soLuong, tenSach, gia, tacGia, namSuatBan, trongLuong, kichThuoc, moTa, soTrang, ngonNgu, nhaCungCap, loaiBia, trangThai, maTheLoai, maNhaXuatBan, soLuongBanDau, soLuotView);
        }
        return sach;
    }

    public String TraVeTenTheLoai(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String tenTheLoai = "";
        Cursor timTheLoai = db.query(TABLE_THELOAI, null, KEY_ID + " = ?", new String[]{id + ""}, null, null, null);
        if (timTheLoai.getCount() > 0) {
            timTheLoai.moveToFirst();
            tenTheLoai = timTheLoai.getString(timTheLoai.getColumnIndex(KEY_TENTHELOAI));
        }
        return tenTheLoai;
    }

    public void CapNhatLuotViewSach(int idSach) {
        Sach sachCanCapNhatView = TraVeSachBangId(idSach);
        int luotViewSachMoi = sachCanCapNhatView.getSoLuotView() + 1;
        sachCanCapNhatView.setSoLuotView(luotViewSachMoi);
        SuaSach(sachCanCapNhatView);
    }

    public boolean KiemTraNguoiDungTonTai(String email) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor timNguoiDung = db.query(TABLE_TAIKHOAN, null, KEY_EMAIL + " = ?", new String[]{email}, null, null, null);
        if (timNguoiDung.getCount() > 0) {
            return true;
        }
        return false;
    }

    public void ThemDangNhap(String email) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, email);
        db.insert(TABLE_DANGNHAP, null, values);
        db.close();
    }

    private ContentValues putSach(Sach sach) {
        ContentValues values = new ContentValues();
        values.put(KEY_SOLUONG, sach.getSoLuong());
        values.put(KEY_TENSACH, sach.getTenSach());
        values.put(KEY_GIA, sach.getGia());
        values.put(KEY_TACGIA, sach.getTacGia());
        values.put(KEY_NAMXUATBAN, sach.getNamSuatBan());
        values.put(KEY_TRONGLUONG, sach.getTrongLuong());
        values.put(KEY_KICHTHUOC, sach.getKichThuoc());
        values.put(KEY_MOTA, sach.getMoTa());
        values.put(KEY_SOTRANG, sach.getSoTrang());
        values.put(KEY_NGONNGU, sach.getNgonNgu());
        values.put(KEY_NHACUNGCAP, sach.getNhaCungCap());
        values.put(KEY_LOAIBIA, sach.getLoaiBia());
        values.put(KEY_TRANGTHAI, sach.getTrangThai());
        values.put(KEY_MATHElOAI, sach.getMaTheLoai());
        values.put(KEY_MANHAXUATBAN, sach.getMaNhaXuatBan());
        values.put(KEY_SOLUONGBANDAU, sach.getSoLuongBanDau());
        values.put(KEY_LUOTVIEW, sach.getSoLuotView());
        return values;
    }

    private ContentValues putTaiKhoan(TaiKhoan taiKhoan) {
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, taiKhoan.getEmail());
        values.put(KEY_HOTEN, taiKhoan.getHoTen());
        values.put(KEY_MATKHAU, taiKhoan.getMatKhau());
        values.put(KEY_NGAYSINH, taiKhoan.getNgaySinh());
        values.put(KEY_GIOITINH, taiKhoan.getGioiTinh());
        values.put(KEY_DIACHI, taiKhoan.getDiaChi());
        return values;
    }

    private ContentValues putBinhLuan(BinhLuan binhLuan) {
        ContentValues values = new ContentValues();
        values.put(KEY_NOIDUNG, binhLuan.getNoiDung());
        values.put(KEY_SODIEM, binhLuan.getSoDiem());
        values.put(KEY_MASACH, binhLuan.getMaSach());
        values.put(KEY_EMAIL, binhLuan.getEmail());
        return values;
    }

    public void ThemTaiKhoan(TaiKhoan taiKhoan) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putTaiKhoan(taiKhoan);
        db.insert(TABLE_TAIKHOAN, null, values);
        db.close();
    }

    public void SuaTaiKhoan(TaiKhoan taiKhoan) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putTaiKhoan(taiKhoan);
        db.update(TABLE_TAIKHOAN, values, KEY_EMAIL + " = " + "'" + taiKhoan.getEmail() + "'", null);
        db.close();
    }

    public TaiKhoan LayTaiKhoan(String email) {
        SQLiteDatabase db = getWritableDatabase();
        TaiKhoan taiKhoan = null;
        Cursor timTK = db.query(TABLE_TAIKHOAN, null, KEY_EMAIL + " = ?", new String[]{email}, null, null, null);
        if (timTK.getCount() > 0) {
            timTK.moveToFirst();
            String hoTen = timTK.getString(timTK.getColumnIndex(KEY_HOTEN));
            String matKhau = timTK.getString(timTK.getColumnIndex(KEY_MATKHAU));
            String ngaySinh = timTK.getString(timTK.getColumnIndex(KEY_NGAYSINH));
            String gioiTinh = timTK.getString(timTK.getColumnIndex(KEY_GIOITINH));
            String diaChi = timTK.getString(timTK.getColumnIndex(KEY_DIACHI));
            taiKhoan = new TaiKhoan(email, hoTen, matKhau, ngaySinh, gioiTinh, diaChi);
        }
        return taiKhoan;
    }

    public void DangXuat(String email) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_DANGNHAP, KEY_EMAIL + " = " + "'" + email + "'", null);
        db.close();
    }

    public BinhLuan TraVeBinhLuanCuaNguoiDung(int idSach, String email) {
        SQLiteDatabase db = getWritableDatabase();
        BinhLuan binhLuan = null;
        Cursor timBinhLuan = db.query(TABLE_BINHlUAN, null, KEY_MASACH + " = ? AND " + KEY_EMAIL + " = ?", new String[]{idSach + "", email}, null, null, null);
        if (timBinhLuan.getCount() > 0) {
            timBinhLuan.moveToFirst();
            int id = timBinhLuan.getInt(timBinhLuan.getColumnIndex(KEY_ID));
            String noiDung = timBinhLuan.getString(timBinhLuan.getColumnIndex(KEY_NOIDUNG));
            double soDiem = timBinhLuan.getDouble(timBinhLuan.getColumnIndex(KEY_SODIEM));
            binhLuan = new BinhLuan(id, noiDung, soDiem, idSach, email);
            return binhLuan;
        }
        return binhLuan;
    }

    public void ThemBinhLuan(BinhLuan binhLuan) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putBinhLuan(binhLuan);
        db.insert(TABLE_BINHlUAN, null, values);
        db.close();
    }

    public void CapNhatBinhLuan(BinhLuan binhLuan) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putBinhLuan(binhLuan);
        db.update(TABLE_BINHlUAN, values, KEY_EMAIL + " = " + "'" + binhLuan.getEmail() + "'" + " AND " + KEY_MASACH + " = " + "'" + binhLuan.getMaSach() + "'", null);
        db.close();
    }

    public ViewModelSach LayViewModelSachBangMaSach(int idSach) {
        SQLiteDatabase db = getWritableDatabase();
        ViewModelSach canTim = null;
        Cursor timSach = db.query(TABLE_SACH, null, KEY_ID + " = ?", new String[]{idSach + ""}, null, null, null);
        if (timSach.getCount() > 0) {
            timSach.moveToFirst();
            int id = timSach.getInt(timSach.getColumnIndex(KEY_ID));
            String tenSach = timSach.getString(timSach.getColumnIndex(KEY_TENSACH));
            int gia = timSach.getInt(timSach.getColumnIndex(KEY_GIA));
            String moTa = timSach.getString(timSach.getColumnIndex(KEY_MOTA));
            String duongDanHinhAnh = LayHinhAnhDaiDienCuaSach(id);
            canTim = new ViewModelSach(id, tenSach, gia, moTa, duongDanHinhAnh);
        }
        return canTim;
    }

    public List<ViewModelGioHang> LayGioHangCuaNguoiDung(String email) {
        SQLiteDatabase db = getWritableDatabase();
        List<ViewModelGioHang> gioHangs = new ArrayList<>();
        Cursor timGioHang = db.query(TABLE_GIOHANG, null, KEY_EMAIL + " = ?", new String[]{email}, null, null, null);
        if (timGioHang.getCount() > 0) {
            timGioHang.moveToFirst();
            do {
                int idSach = timGioHang.getInt(timGioHang.getColumnIndex(KEY_MASACH));
                ViewModelSach thongTinSach = LayViewModelSachBangMaSach(idSach);
                String tenSach = thongTinSach.getTenSach();
                String hinhAnhSach = thongTinSach.getDuongDanHinhAnh();
                int soLuong = timGioHang.getInt(timGioHang.getColumnIndex(KEY_SOLUONG));
                int gia = thongTinSach.getGia();
                gioHangs.add(new ViewModelGioHang(idSach, tenSach, hinhAnhSach, soLuong, gia));
            } while (timGioHang.moveToNext());
        }
        return gioHangs;
    }

    public void XoaGioHangKhiThanhToan(String maTaiKhoan) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_GIOHANG, KEY_EMAIL + " = " + "'" + maTaiKhoan + "'", null);
        db.close();
    }

    public void CapNhatGioHang(GioHang gioHang) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SOLUONG, gioHang.getSoLuong());
        db.update(TABLE_GIOHANG, values, KEY_MASACH + " = " + "'" + gioHang.getMaSach() + "'" + " AND " + KEY_EMAIL + " = " + "'" + gioHang.getEmail() + "'", null);
        db.close();
    }

    public int ThemGioHang(GioHang gioHang) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        Cursor gioHangCuaTaiKhoan = db.query(TABLE_GIOHANG, null, KEY_MASACH + " = ? AND " + KEY_EMAIL + " = ?", new String[]{gioHang.getMaSach() + "", gioHang.getEmail()}, null, null, null);
        if (gioHangCuaTaiKhoan.getCount() == 0) {
            values.put(KEY_MASACH, gioHang.getMaSach());
            values.put(KEY_SOLUONG, gioHang.getSoLuong());
            values.put(KEY_EMAIL, gioHang.getEmail());
            db.insert(TABLE_GIOHANG, null, values);
            return 1;
        } else {
            gioHangCuaTaiKhoan.moveToFirst();
            int soLuongSanPham = gioHangCuaTaiKhoan.getInt(gioHangCuaTaiKhoan.getColumnIndex(KEY_SOLUONG));
            gioHang.setSoLuong(soLuongSanPham + gioHang.getSoLuong());
            CapNhatGioHang(gioHang);
            return 1;
        }
    }

    public void XoaGioHang(GioHang gioHangCanXoa) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_GIOHANG, KEY_ID + " = " + "'" + gioHangCanXoa.getId() + "'", null);
        db.close();
    }

    public GioHang LaySanPhamTrongGioHang(int maSP, String tenDangNhap) {
        SQLiteDatabase db = getWritableDatabase();
        GioHang hangCanTim = new GioHang();
        Cursor gioHangCuaTaiKhoan = db.query(TABLE_GIOHANG, null, KEY_MASACH + " = ? AND " + KEY_EMAIL + " = ?", new String[]{maSP + "", tenDangNhap}, null, null, null);
        if (gioHangCuaTaiKhoan.getCount() > 0) {
            gioHangCuaTaiKhoan.moveToFirst();
            hangCanTim.setMaSach(gioHangCuaTaiKhoan.getInt(gioHangCuaTaiKhoan.getColumnIndex(KEY_MASACH)));
            hangCanTim.setSoLuong(gioHangCuaTaiKhoan.getInt(gioHangCuaTaiKhoan.getColumnIndex(KEY_SOLUONG)));
            hangCanTim.setId(gioHangCuaTaiKhoan.getInt(gioHangCuaTaiKhoan.getColumnIndex(KEY_ID)));
            hangCanTim.setEmail(gioHangCuaTaiKhoan.getString(gioHangCuaTaiKhoan.getColumnIndex(KEY_EMAIL)));
        }
        return hangCanTim;
    }

    public void ThemDonHang(DonHang donHang) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putDonHang(donHang);
        db.insert(TABLE_DONHANG, null, values);
        db.close();
    }

    public void ThemChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MADONHANG, chiTietDonHang.getMaDonHang());
        values.put(KEY_MASACH, chiTietDonHang.getMaSach());
        values.put(KEY_SOLUONG, chiTietDonHang.getSoLuong());
        db.insert(TABLE_CHITIETDONHANG, null, values);
        db.close();
    }

    public ContentValues putDonHang(DonHang donHang) {
        ContentValues values = new ContentValues();
        values.put(KEY_MADONHANG, donHang.getMaHoaDon());
        values.put(KEY_NGAYGIAO, donHang.getNgayGiao());
        values.put(KEY_TRANGTHAI, donHang.getTrangThai());
        values.put(KEY_EMAIL, donHang.getEmail());
        values.put(KEY_NGAYTAO, donHang.getNgayTao());
        values.put(KEY_LOAITHANHTOAN, donHang.getLoaiThanhToan());
        values.put(KEY_TONGTIEN, donHang.getTongTien());
        return values;
    }

    public List<DonHang> LayTatCaDonHangCuaTaiKhoan(String email) {
        SQLiteDatabase db = getWritableDatabase();
        List<DonHang> donHangs = new ArrayList<>();
        Cursor timDonHang = db.query(TABLE_DONHANG, null, KEY_EMAIL + " = ?", new String[]{email}, null, null, null);
        if (timDonHang.getCount() > 0) {
            timDonHang.moveToFirst();
            do {
                String maHoaDon = timDonHang.getString(timDonHang.getColumnIndex(KEY_MADONHANG));
                String ngayGiao = timDonHang.getString(timDonHang.getColumnIndex(KEY_NGAYGIAO));
                String trangThai = timDonHang.getString(timDonHang.getColumnIndex(KEY_TRANGTHAI));
                String ngayTao = timDonHang.getString(timDonHang.getColumnIndex(KEY_NGAYTAO));
                String loaiThanhToan = timDonHang.getString(timDonHang.getColumnIndex(KEY_LOAITHANHTOAN));
                int tongTien = timDonHang.getInt(timDonHang.getColumnIndex(KEY_TONGTIEN));
                donHangs.add(new DonHang(maHoaDon, ngayGiao, trangThai, email, ngayTao, loaiThanhToan, tongTien));
            } while (timDonHang.moveToNext());
        }
        return donHangs;
    }

    public List<ViewModelChiTietDonHang> LayChiTietDonHang(String maDonHang) {
        SQLiteDatabase db = getWritableDatabase();
        List<ViewModelChiTietDonHang> chiTietDonHangs = new ArrayList<>();
        Cursor timChiTiet = db.query(TABLE_CHITIETDONHANG, null, KEY_MADONHANG + " = ?", new String[]{maDonHang}, null, null, null);
        if (timChiTiet.getCount() > 0) {
            timChiTiet.moveToFirst();
            do {
                int idSach = timChiTiet.getInt(timChiTiet.getColumnIndex(KEY_MASACH));
                ViewModelSach sach = LayViewModelSachBangMaSach(idSach);
                String tenSach = sach.getTenSach();
                String hinhAnhSach = sach.getDuongDanHinhAnh();
                int soLuong = timChiTiet.getInt(timChiTiet.getColumnIndex(KEY_SOLUONG));
                int gia = sach.getGia();
                int giaThanhTien = gia * soLuong;
                chiTietDonHangs.add(new ViewModelChiTietDonHang(tenSach, hinhAnhSach, soLuong, gia, giaThanhTien));
            } while (timChiTiet.moveToNext());
        }
        return chiTietDonHangs;
    }

    public FeedBack LayFeedBackDonHang(String maDonHang) {
        SQLiteDatabase db = getWritableDatabase();
        FeedBack feedBack = null;
        Cursor timFeedBack = db.query(TABLE_FEEDBACK, null, KEY_MADONHANG + " = ?", new String[]{maDonHang}, null, null, null);
        if (timFeedBack.getCount() > 0) {
            timFeedBack.moveToFirst();
            int id = timFeedBack.getInt(timFeedBack.getColumnIndex(KEY_ID));
            String noiDung = timFeedBack.getString(timFeedBack.getColumnIndex(KEY_NOIDUNG));
            feedBack = new FeedBack(id, noiDung, maDonHang);
        }
        return feedBack;
    }

    public void ThemFeedBack(FeedBack feedBack) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putFeedBack(feedBack);
        db.insert(TABLE_FEEDBACK, null, values);
        db.close();
    }

    public void CapNhatFeedBack(FeedBack feedBack) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putFeedBack(feedBack);
        db.update(TABLE_FEEDBACK, values, KEY_MADONHANG + " = " + "'" + feedBack.getMaHoaDon() + "'", null);
        db.close();
    }

    public ContentValues putFeedBack(FeedBack feedBack) {
        ContentValues values = new ContentValues();
        values.put(KEY_MADONHANG, feedBack.getMaHoaDon());
        values.put(KEY_NOIDUNG, feedBack.getNoiDung());
        return values;
    }

    public void CapNhatDonHang(DonHang donHang) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putDonHang(donHang);
        db.update(TABLE_DONHANG, values, KEY_MADONHANG + " = " + "'" + donHang.getMaHoaDon() + "'", null);
        db.close();
    }

    public void CapNhatDonHang(String maDonHang, String trangThai) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TRANGTHAI, trangThai);
        db.update(TABLE_DONHANG, values, KEY_MADONHANG + " = " + "'" + maDonHang + "'", null);
        db.close();
    }

    public Cursor LayTatCaSach() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor sachs = db.query(TABLE_SACH, null, null, null, null, null, null);
        if (sachs.getCount() > 0) {
            sachs.moveToFirst();
        }
        return sachs;
    }

    public List<String> TraVeTatCaMaSach() {
        SQLiteDatabase db = getWritableDatabase();
        List<String> maSach = new ArrayList<>();
        Cursor sach = db.query(TABLE_SACH, null, null, null, null, null, null);
        if (sach.getCount() > 0) {
            sach.moveToFirst();
            do {
                String ma = sach.getInt(sach.getColumnIndex(KEY_ID)) + "";
                maSach.add(ma);
            } while (sach.moveToNext());
        }
        return maSach;
    }

    public List<String> TraVeCacMaLoaiSach() {
        SQLiteDatabase db = getWritableDatabase();
        List<String> maLoai = new ArrayList<>();
        Cursor loaiSach = db.query(TABLE_THELOAI, null, null, null, null, null, null);
        if (loaiSach.getCount() > 0) {
            loaiSach.moveToFirst();
            do {
                String maLoaiSach = loaiSach.getInt(loaiSach.getColumnIndex(KEY_ID)) + "";
                maLoai.add(maLoaiSach);
            } while (loaiSach.moveToNext());
        }
        return maLoai;
    }

    public List<String> TraVeCacMaNXB() {
        SQLiteDatabase db = getWritableDatabase();
        List<String> maNXB = new ArrayList<>();
        Cursor nxb = db.query(TABLE_NHAXUATBAN, null, null, null, null, null, null);
        if (nxb.getCount() > 0) {
            nxb.moveToFirst();
            do {
                String maXuatBan = nxb.getInt(nxb.getColumnIndex(KEY_ID)) + "";
                maNXB.add(maXuatBan);
            } while (nxb.moveToNext());
        }
        return maNXB;
    }

    public Cursor LayTatCaNguoiDung() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor nguoiDungs = db.query(TABLE_TAIKHOAN, null, null, null, null, null, null);
        if (nguoiDungs.getCount() > 0) {
            nguoiDungs.moveToFirst();
        }
        return nguoiDungs;
    }

    public Cursor LayTatCaDonHang() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor donHang = db.query(TABLE_DONHANG, null, null, null, null, null, null);
        if (donHang.getCount() > 0) {
            donHang.moveToFirst();
        }
        return donHang;
    }

    public void ThemSuKien(KhuyenMai khuyenMai) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putSuKien(khuyenMai);
        db.insert(TABLE_KHUYENMAI, null, values);
        db.close();
    }

    public void SuaSuKien(KhuyenMai khuyenMai) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putSuKien(khuyenMai);
        db.update(TABLE_KHUYENMAI, values, KEY_ID + " = " + "'" + khuyenMai.getId() + "'", null);
        db.close();
    }

    public ContentValues putSuKien(KhuyenMai khuyenMai) {
        ContentValues values = new ContentValues();
        values.put(KEY_TENKHUYENMAI, khuyenMai.getTenKhuyenMai());
        values.put(KEY_NOIDUNG, khuyenMai.getNoiDung());
        values.put(KEY_DUONGDANHINHANH, khuyenMai.getDuongDanHinhAnh());
        values.put(KEY_GIATRIKHUYENMAI, khuyenMai.getGiaTriKhuyenMai());
        values.put(KEY_NGAYBATDAU, khuyenMai.getNgayBatDau());
        values.put(KEY_NGAYKETTHUC, khuyenMai.getNgayKetThuc());
        return values;
    }

    public List<ViewModelSuKien> LaySuKien() {
        SQLiteDatabase db = getWritableDatabase();
        List<ViewModelSuKien> suKiens = new ArrayList<>();
        Cursor timSK = db.query(TABLE_KHUYENMAI, null, null, null, null, null, null);
        if (timSK.getCount() > 0) {
            timSK.moveToFirst();
            do {
                int idSK = timSK.getInt(timSK.getColumnIndex(KEY_ID));
                String duongDan = timSK.getString(timSK.getColumnIndex(KEY_DUONGDANHINHANH));
                suKiens.add(new ViewModelSuKien(idSK, duongDan));
            } while (timSK.moveToNext());
        }
        return suKiens;
    }

    public Cursor LayTatCaSuKien() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor timSK = db.query(TABLE_KHUYENMAI, null, null, null, null, null, null);
        if (timSK.getCount() > 0) {
            timSK.moveToFirst();
        }
        return timSK;
    }

    public KhuyenMai LayKhuyenMai(int idKM) {
        SQLiteDatabase db = getWritableDatabase();
        KhuyenMai khuyenMai = null;
        Cursor timSK = db.query(TABLE_KHUYENMAI, null, KEY_ID + " = ?", new String[]{idKM + ""}, null, null, null);
        if (timSK.getCount() > 0) {
            timSK.moveToFirst();
            String tenKM = timSK.getString(timSK.getColumnIndex(KEY_TENKHUYENMAI));
            String noiDung = timSK.getString(timSK.getColumnIndex(KEY_NOIDUNG));
            String duongDanHinhAnh = timSK.getString(timSK.getColumnIndex(KEY_DUONGDANHINHANH));
            double giaTriKhuyenMai = timSK.getDouble(timSK.getColumnIndex(KEY_GIATRIKHUYENMAI));
            String ngayBatDau = timSK.getString(timSK.getColumnIndex(KEY_NGAYBATDAU));
            String ngayKetThuc = timSK.getString(timSK.getColumnIndex(KEY_NGAYKETTHUC));
            khuyenMai = new KhuyenMai(tenKM, noiDung, duongDanHinhAnh, giaTriKhuyenMai, ngayBatDau, ngayKetThuc);
        }
        return khuyenMai;
    }

    public Date ChuyenThanhDate(String ngayNhap) {
        try {
            Date ngayGuiDate = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhap);
            return ngayGuiDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int[] TraVeMangTienMoiThang(int nam) {
        int[] tienMoiThang = new int[12];
        SQLiteDatabase db = getWritableDatabase();
        for (int i = 0; i < tienMoiThang.length; i++) {
            String query = "SELECT * FROM " + TABLE_DONHANG + " WHERE " + KEY_NGAYTAO + " LIKE " + "'%/" + i + 1 + "/" + nam + "%'";
            Cursor hoaDon = db.rawQuery(query, null);
            if (hoaDon.getCount() > 0) {
                hoaDon.moveToFirst();
                do {
                    int soTien = hoaDon.getInt(hoaDon.getColumnIndex(KEY_TONGTIEN));
                    tienMoiThang[i] += soTien;
                } while (hoaDon.moveToNext());
            }
        }
        return tienMoiThang;
    }
}