create database QUANLITHIETBICONGNGHE_K
go
use QUANLITHIETBICONGNGHE_K
GO 
create table KhachHang
(
	maKH int  primary key not null identity(1,1),
	tenKH nvarchar(50) not null,
	diaChi nvarchar(80) not null,
	SDT varchar(11) not null,
	gioiTinh bit null
)
go 
create table NhanVien
(
	maNV int not null primary key identity(1,1),
	tenNV nvarchar(50) not null ,
	vaiTro nvarchar(50) not null,
	diaChi nvarchar(80) ,
	SDT varchar(11) not null,
	ngaySinh date ,
	gioiTinh bit ,
	email varchar(50),
	trangThai nvarchar(30)
)
go 
 create table SanPham
 (
	maSP int not null primary key identity(1,1),
	tenSP nvarchar(50) not null,
	donGiaBan money not null,
	soLuongHienCon int not null

 )
 go 
 create table HoaDon
 (
	maDH int not null primary key identity(1,1),
	tenSP nvarchar(50) not null,
	soLuongDat int not null,
	thoiGianBaoHanh date ,
	diaChiGiaoHang nvarchar(80) not null,
	phuongThucThanhToan nvarchar(30) not null,
	thoiGianGiaoHang date,
	thanhTien money,
	maKH int  not null,
	maNV int not null,
	maSP int not null,
	constraint FK_HDKH_KH foreign key (maKH) references KhachHang(maKH),
	constraint FK_HDNV_NV foreign key (maNV) references NhanVien(maNV),
	constraint FK_HDSP_SP foreign key (maSP) references SanPham(maSP)
)
go 
create table KhuyenMai
(
	maKM int not null primary key identity(1,1),
	tenCTKM nvarchar(50) not null,
	mucGiamGia int not null,
	ngayBatDau date ,
	ngayKetThuc date,
	moTa nvarchar(50),
	maSP int not null,
	constraint FK_KMSP_SP foreign key (maSP) references SanPham(maSP)
)
