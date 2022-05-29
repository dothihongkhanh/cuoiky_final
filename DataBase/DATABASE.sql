create database QUANLITHIETBICONGNGHE_KLN
go
use QUANLITHIETBICONGNGHE_KLN
go 
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
	trangThai nvarchar(30),
	matKhau varchar(50) not null
)
alter table NhanVien
drop column matKhau 
go 
 create table SanPham
 (
	maSP int not null primary key identity(1,1),
	tenSP nvarchar(50) not null,
	donGiaBan money not null,
	soLuongHienCon int not null

 )
 create table KhuyenMai
(
	maKM int not null primary key identity(1,1),
	tenCTKM nvarchar(50) not null,
	mucGiamGia int null,
	ngayBatDau date ,
	ngayKetThuc date,
	moTa nvarchar(50),
)
 go 
 create table HoaDon
 (
	maDH int not null primary key identity(1,1),
	ngayTaoDH date,
	diaChiGiaoHang nvarchar(80) not null,
	phuongThucThanhToan nvarchar(30) not null,
	thoiGianThanhToan date,
	thoiGianGiaoHang date,
	maKH int  not null,
	maNV int not null,
	maKM int not null,
	constraint FK_HDKH_KH foreign key (maKH) references KhachHang(maKH),
	constraint FK_HDNV_NV foreign key (maNV) references NhanVien(maNV),
	constraint FK_HDKM_KM foreign key (maKM) references KhuyenMai(maKM),
)
go 

create table ChiTietHoaDon(
	maDH int not null,
	maSP int not null,
	soLuongDat int ,
	 primary key( maSP,maDH),
	constraint FK_CTHD_MSP foreign key (maSP) references SanPham (maSP),
	constraint FK_CTHD_MDH foreign key (maDH) references HoaDon(maDH),
)
go
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
alter table KhuyenMai
	add constraint CK_KM_Date
	check (ngayBatDau<ngayKetThuc)
alter table HoaDon
	--tạo đơn đặt hàng nhỏ hơn ngày hiện tại
	add	constraint CK_DDHHD_nTDH
		check (ngayTaoDH < getdate()),	
	--ngày giao hàng nhỏ hơn ngày hiện tại 
		constraint CK_DDHHD_nGH
			check (thoiGianGiaoHang<getdate())
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
set dateformat dmy
--Bang NhanVien 
go
insert into NhanVien(tenNV,diaChi,SDT,vaiTro,ngaySinh,gioiTinh,email,trangThai)
	values
		(N'Nguyễn Thanh Vân',N'17 Đống Đa','0905123123',N'Nhân viên kho','16/05/1991',N'Nữ','thanhvan@gmail.com',N'Đang làm việc'),
		(N'Ngô Ánh Quỳnh',N'63 Lê Đại Hành','0917989586',N'Nhân viên bán hàng','28/04/1989',N'Nữ','anhquynh@gmail.com',N'Đang làm việc'),
		(N'Võ Hoài Nam',N'95 Trần Cao Vân','0913564278',N'Nhân viên bán hàng','26/04/2000',N'Nam','hoainam@gmail.com',N'Đang làm việc'),
		(N'Trần Thanh Huy',N'85 Nguyễn Tất Thành','0856324596',N'Nhân viên giữ xe','23/07/2000',N'Nam','thanhhuy@gmail.com',N'Đang làm việc'),
		(N'Nguyễn Hoài Anh',N'23 Lê Lợi','0589632147',N'Nhân viên bán hàng','07/12/1976',N'Nam','hoaianh@gmail.com',N'Đã nghỉ việc'),
		(N'Đặng Lê Như',N'56 Hải Phòng','0569832614',N'Nhân viên bán hàng','15/10/1996',N'Nữ','lenhu@gmail.com',N'Đang làm việc'),
		(N'Lê Hạ An',N'18 Ông Ích Khiêm ','0185239745',N'Nhân viên kho','28/09/2002',N'Nữ','haan@gmail.com',N'Đang làm việc'),
		(N'Nguyễn Anh Tuấn',N'26 Thanh Sơn','0888487524',N'Nhân viên giữ xe','08/08/1997',N'Nam','anhtuan@gmail.com',N'Đang làm việc'),
		(N'Trần Hoàng Mi',N'106 Ngô Quyền','0906325489',N'Nhân viên bán hàng','12/06/1970',N'Nữ','hoangmi@gmail.com',N'Đã nghỉ việc'),
		(N'Thái Ánh Linh',N'25 Lý Tự Trọng','0256347852',N'Nhân viên bán hàng','16/04/1988',N'Nữ','anhlinh@gmail.com',N'Đang làm việc')
		--select * from NhanVien
--Bang SanPham
insert into SanPham(tenSP,donGiaBan,soLuongHienCon) 
	values 
		(N'Samsung Galaxy S22 Ultra 5G',30990000,'30'),
		(N'iPhone 11',12490000,'40'),
		(N'OPPO Ren7 series',10490000,'35'),
		(N'iPhone 13 Pro',27490000,'20'),
		(N'iphone 12 Pro',26290000,'26'),
		(N'Bàn phím có dây Gaming Asus TUF K1',990000,'30'),
		(N'Chuột không dây Gaming Asus TUF M4 WL',1190000,'34'),
		(N'Chuột có dây Gaming Asus Keris',1250000,'20'),
		(N'Bàn phím có dây DareU EK87 ',649000,'30'),
		(N'Bàn phím cơ có dây Gaming Razer BlackWidow',2880000,'15'),
		(N'Chuột không dây Rapoo M20 Plus Đen',200000,'30'),
		(N'Cáp Type C- Lightning Apple MM0A3',501000,'60'),
		(N'Sạc Hydrus CS-TC027',60000,'40'),
		(N'Cáp Type C Xmobile MU09-1000X',75000,'40'),
		(N'Đế sạc không dây Mbest AC63F3',1750000,'25'),
		(N'Tai nghe Bluetooth AirPods 2 Apple MRXJ2',5590000,'40'),
		(N'Tai nghe Bluetooth AirPods 3 Apple MME73',5490000,'30'),
		(N'Tai nghe có dây Mozard DS510-WB',120000,'30'),
		(N'Tai nghe Bluetooth Chụp Tai Kanen K6',600000,'26'),
		(N'Tai nghe EP Gaming Asus Rog Cetra II Core',1290000,'20')
					--select * from SanPham
--Bang KhuyenMai
insert into KhuyenMai(tenCTKM, mucGiamGia, ngayBatDau,ngayKetThuc,moTa)
	values
		(N'Lễ 30/4',10, '25/04/2022', '05/05/2022',null),
		(N'Lễ Quốc Khánh 02/09',15, '25/08/2021', '05/09/2021',null),
		(N'Kỉ niệm 5 năm thành lập',20, '25/05/2022', '10/06/2022',null),
		(N'Giảm giá cuối tuần',5, '28/05/2022', '03/06/2022',null),
		(N'Noel',5, '20/11/2021', '30/12/2021',null)
		--select * from KhuyenMai 
-- chèn dữ liệu vào bảng Hóa đơn 
go 
insert into HoaDon (ngayTaoDH,diaChiGiaoHang,phuongThucThanhToan,thoiGianThanhToan,thoiGianGiaoHang,maKH,maNV,maKM)
values ('1/5/2022',N'Ông Ích Khiêm, Đà Nẵng',N'Tiền mặt','2/5/2022','2/5/2022',1,2,1),
		('2/5/2022',N'Ông Ích Khiêm, Đà Nẵng',N'Thẻ ngân hàng','2/5/2022','2/5/2022',5,3,1),
		('3/5/2022',N'48 Cao Thắng, Đà Nẵng',N'Tiền mặt','3/5/2022','3/5/2022',7,6,1),
		('3/5/2022',N'Đống Đa, Đà Nẵng',N'Thẻ ngân hàng','4/5/2022','4/5/2022',10,5,1),
		('4/5/2022',N'Lý Tự Trọng, Đà Nẵng',N'Tiền mặt','4/5/2022','4/5/2022',1,9,1),
		('4/5/2022',N'Ông Ích Khiêm, Đà Nẵng',N'Tiền mặt','5/5/2022','5/5/2022',5,10,1),
		('4/5/2022',N'Hoàng Diệu, Đà Nẵng',N'Tiền mặt','4/5/2022','5/5/2022',7,2,1),
		('28/5/2022',N'48 Cao Thắng, Đà Nẵng',N'Thẻ ngân hàng','28/5/2022','28/5/2022',10,3,4),
		('28/5/2022',N'Lê Duẩn, Đà Nẵng',N'Tiền mặt','28/5/2022','28/5/2022',5,6,4),
		('28/5/2022',N'Điện Biên Phủ, Đà Nẵng',N'Tiền mặt','28/5/2022','28/5/2022',1,5,4);
go 
insert into ChiTietHoaDon 
values	(3,2,2),
		(4,3,1),
		(5,3,2),
		(6,7,3),
		(7,8,1),
		(8,9,3),
		(8,15,1),
		(9,19,3),
		(10,4,1),
		(10,6,2);

	

					   			 		  			



