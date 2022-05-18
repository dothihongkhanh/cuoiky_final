create database QUANLITHIETBICONGNGHE_KLN
go
use QUANLITHIETBICONGNGHE_KLN
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
	thoiGianBaoHanh date ,
	diaChiGiaoHang nvarchar(80) not null,
	phuongThucThanhToan nvarchar(30) not null,
	thoiGianGiaoHang date,
	maKH int  not null,
	maNV int not null,
	constraint FK_HDKH_KH foreign key (maKH) references KhachHang(maKH),
	constraint FK_HDNV_NV foreign key (maNV) references NhanVien(maNV),
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
)
create table ChiTietHoaDon(
	maDH int not null,
	maSP int not null,
	soLuongDat int ,
	 primary key( maSP,maDH),
	constraint FK_CTHD_MSP foreign key (maSP) references SanPham (maSP),
	constraint FK_CTHD_MDH foreign key (maDH) references HoaDon(maDH),
)
CREATE TABLE SanPhamKM
(
	maSP int not null ,
	constraint FK_SPKM_SP foreign key (maSP) references SanPham(maSP),
	maKM int not null ,
	constraint FK_SPKM_TTKM foreign key (maKM) references KhuyenMai(maKM),
	primary key (maSP, maKM),
	giaTriGiam int null
)
--TAO RANG BUOC
--Email: có chứa @, bắt đầu là chữ cái viết thường hoặc viết hoa (thuộc 1 trong 3 dịch vụ mail: Gmail hoặc Yahoo Mail hoặc ute.udn.vn mail); và phải là duy nhất
alter table NhanVien
	add constraint UQ_NV_Email unique(email),
		constraint CK_NV_Email check (email like '[A-Za-z]%@gmail.com'
									or email like'[A-Za-z]%@yahoo.com'
									or email like '[A-Za-z]%@ute.udn.vn')

--SDT là dãy các chữ số gồm 10 hoặc 11 chữ số, và phải đảm bảo duy nhất
alter table KhachHang 
	add constraint UQ_KH_SDT unique (SDT),
	constraint CK_KH_SDT
	check (SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
		or SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
alter table NhanVien 
	add constraint UQ_NV_SDT unique (SDT),
	constraint CK_NV_SDT
	check (SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
		or SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
--soLuongDat> 0
alter table ChiTietHoaDon 
	add constraint CK_CTHD_SLD
		check (soLuongDat > (0) )
--donGiaBan >0 va soLuongHienCon > 0
alter table SanPham
	add constraint CK_SP_DGB
		check (donGiaBan >(0)),
		constraint CK_SP_SLHC
		check (soLuongHienCon>(0))
