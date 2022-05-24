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
	gioiTinh nvarchar(3)
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
	gioiTinh nvarchar(3),
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
	diaChiGiaoHang nvarchar(80) not null,
	phuongThucThanhToan nvarchar(30) not null,
	thoiGianThanhToan date,
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
--GioiTinh (Nam hoặc Nữ) – mặc định Nam.
alter table NhanVien
	add constraint CK_NV_GT
	check(gioiTinh = N'Nữ' or GioiTinh = N'Nam'),
	constraint DF_NV_GT default N'Nam' for gioiTinh

alter table KhachHang
	add constraint CK_KH_GT
	check(gioiTinh = N'Nữ' or GioiTinh = N'Nam'),
	constraint DF_KH_GT default N'Nam' for gioiTinh
--chèn dữ liệu vào database
----Bảng Khách Hàng
insert into KhachHang(tenKH,diaChi,SDT,gioiTinh)
	values
		(N'Nguyễn Văn An',N'Đà Nẵng','0123456789',default),
		(N'Lê Nhật Nam',N'Quảng Nam','0112345678',default),
		(N'Nguyễn Thị Ngọc Lan',N'Quảng Nam','0124578945',N'Nữ'),
		(N'Lê Văn Hùng',N'Huế','0233456789',default),
		(N'Phạm Lan Nhi',N'Đà Nẵng','01234456789',N'Nữ'),
		(N'Nguyễn Quốc Dũng',N'Quảng Trị','0123446789',default),
		(N'Lê Hữu Nam',N'Đà Nẵng','0123455789',default),
		(N'Nguyễn Long',N'Quảng Nam','0123456799',default),
		(N'Phạm Ngọc Mai',N'Quảng Nam','0123456689',N'Nữ'),
		(N'Lê Minh Đức',N'Đà Nẵng','0123456779',default)
		--select * from KhachHang
go
insert into SanPham(tenSP,donGiaBan,soLuongHienCon) 
			values (N'Samsung Galaxy S22 Ultra 5G','30.990.000đ','30'),
					(N'iPhone 11','12.490.000đ','40'),
					(N'OPPO Ren7 series','10.490.000đ','35'),
					(N'iPhone 13 Pro','27.490.000đ','20'),
					(N'iphone 12 Pro','26.290.000đ','26'),
					(N'Bàn phím có dây Gaming Asus TUF K1','990.000đ','30'),
					(N'Chuột không dây Gaming Asus TUF M4 WL','1.190.000đ','34'),
					(N'Chuột có dây Gaming Asus Keris','1.250.000đ','20'),
					(N'Bàn phím có dây DareU EK87 ','649.000đ','30'),
					(N'Bàn phím cơ có dây Gaming Razer BlackWidow','2.880.000đ','15'),
					(N'Chuột không dây Rapoo M20 Plus Đen','200.000đ','30'),
					(N'Cáp Type C- Lightning Apple MM0A3','501.000đ','60'),
					(N'Sạc Hydrus CS-TC027','60.000đ','40'),
					(N'Cáp Type C Xmobile MU09-1000X','75.000đ','40'),
					(N'Đế sạc không dây Mbest AC63F3','1750.000đ','25'),
					(N'Tai nghe Bluetooth AirPods 2 Wireless charge Apple MRXJ2','5.590.000đ','40'),
					(N'Tai nghe Bluetooth AirPods 3 Apple MME73','5.490.000đ','30'),
					(N'Tai nghe có dây Mozard DS510-WB','120.000đ','30'),
					(N'Tai nghe Bluetooth Chụp Tai Kanen K6','600.000đ','26'),
					(N'Tai nghe EP Gaming Asus Rog Cetra II Core','1.290.000đ','20')
