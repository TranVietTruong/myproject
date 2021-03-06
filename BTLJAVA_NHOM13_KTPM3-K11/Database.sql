USE [master]
GO
/****** Object:  Database [ComMic]    Script Date: 4/11/2019 10:05:24 PM ******/
CREATE DATABASE [ComMic]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ComMic', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\ComMic.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ComMic_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\ComMic_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ComMic] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ComMic].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ComMic] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ComMic] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ComMic] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ComMic] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ComMic] SET ARITHABORT OFF 
GO
ALTER DATABASE [ComMic] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ComMic] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [ComMic] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ComMic] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ComMic] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ComMic] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ComMic] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ComMic] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ComMic] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ComMic] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ComMic] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ComMic] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ComMic] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ComMic] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ComMic] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ComMic] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ComMic] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ComMic] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ComMic] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ComMic] SET  MULTI_USER 
GO
ALTER DATABASE [ComMic] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ComMic] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ComMic] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ComMic] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [ComMic]
GO
/****** Object:  StoredProcedure [dbo].[spud_input_quantity]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spud_input_quantity]
@id int,
@inputquantity int
as
DECLARE @qty int
select @qty = quantity from Commic where id = @id
update Commic set Commic.quantity = @qty + @inputquantity where id = @id
GO
/****** Object:  StoredProcedure [dbo].[spud_update_quantity]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spud_update_quantity]
@id int,
@quantity int
as
DECLARE @qty int
select @qty = quantity from Commic where id = @id
update Commic set Commic.quantity = @qty - @quantity where id = @id
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_customer] [nvarchar](255) NOT NULL,
	[name_employee] [nvarchar](255) NOT NULL,
	[date_order] [datetime] NULL,
	[note] [text] NULL,
	[total_money] [int] NULL,
	[promotion] [int] NULL,
	[is_delete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Catagory]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catagory](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_catagory] [nvarchar](255) NOT NULL,
	[is_delete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Commic]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Commic](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_commic] [nvarchar](255) NOT NULL,
	[id_catagory] [int] NULL,
	[id_publisher] [int] NULL,
	[quantity] [int] NULL,
	[price] [int] NULL,
	[is_delete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Coupon]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Coupon](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_suppiler] [nvarchar](255) NOT NULL,
	[date_order] [datetime] NULL,
	[note] [text] NULL,
	[total_money] [int] NULL,
	[is_delete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DetailBill]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailBill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_bill] [int] NULL,
	[id_commic] [int] NULL,
	[quantity_oder] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DetailCoupon]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailCoupon](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_coupon] [int] NULL,
	[id_commic] [int] NULL,
	[quantity_order] [int] NULL,
	[import_price] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Employee]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_employee] [nvarchar](255) NOT NULL,
	[name_user] [nvarchar](255) NOT NULL,
	[pass_word] [varchar](255) NOT NULL,
	[level_employee] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Publisher]    Script Date: 4/11/2019 10:05:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publisher](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_publisher] [nvarchar](255) NOT NULL,
	[is_delete] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (15, N'Nguyễn Văn A', N'Trần Viết Trưởng', CAST(0x0000AA2600000000 AS DateTime), N'hello', 12000, 5000, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (16, N'Nguyễn Thị B', N'Trần Viết Trưởng', CAST(0x0000AA2600000000 AS DateTime), N'kakakak', 130000, 39000, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (17, N'Trần Thị B', N'Trần Viết Trưởng', CAST(0x0000AA2600000000 AS DateTime), N'', 80500, 5000, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (18, N'Bùi Như Lạc', N'Trần Viết Trưởng', CAST(0x0000AA2600000000 AS DateTime), N'', 602000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (19, N'Trần Thị Trâm', N'Trần Viết Trưởng', CAST(0x0000AA2700000000 AS DateTime), N'khách hàng d?u tiên', 62000, 0, 1)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (20, N'Nguyễn Quang Duy', N'Trần Viết Trưởng', CAST(0x0000AA2700000000 AS DateTime), N'không có gì', 40000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (21, N'test', N'Trần Viết Trưởng', CAST(0x0000AA2700000000 AS DateTime), N'', 5000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (22, N'Trần Quang Thanh', N'Trần Viết Trưởng', CAST(0x0000AA2700000000 AS DateTime), N'', 196500, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (23, N'Khách hàng đầu tiên', N'Trần Viết Trưởng', CAST(0x0000AA2800000000 AS DateTime), N'', 80000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (24, N'Nguyễn Văn Hoàng', N'Trần Viết Trưởng', CAST(0x0000AA2800000000 AS DateTime), N'', 37500, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (25, N'Phạm Hà Trang', N'Trần Viết Trưởng', CAST(0x0000AA2900000000 AS DateTime), N'', 71500, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (26, N'Trần Quang Khải', N'Trần Viết Trưởng', CAST(0x0000AA2B00000000 AS DateTime), N'', 251000, 50200, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (27, N'Nguyễn Khang Duy', N'Trần Viết Trưởng', CAST(0x0000AA2B00000000 AS DateTime), N'khách hàng cu?i cùng', 92500, 10000, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (28, N'AAAAAAAAAAAA', N'Trần Viết Trưởng', CAST(0x0000AA2B00000000 AS DateTime), N'', 99000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (29, N'Hoàng Tuấn Anh', N'Trần Viết Trưởng', CAST(0x0000AA2B00000000 AS DateTime), N'', 69500, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (30, N'Hứa Văn Ninh', N'Trần Viết Trưởng', CAST(0x0000AA2B00000000 AS DateTime), N'dây là ghi chú c?a tôi', 85000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (31, N'Trần Huy Hùng', N'Trần Viết Trưởng', CAST(0x0000AA2C00000000 AS DateTime), N'', 93000, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (32, N'Bùi Quang Linh', N'Trần Viết Trưởng', CAST(0x0000AA2C00000000 AS DateTime), N'', 71500, 0, 0)
INSERT [dbo].[Bill] ([id], [name_customer], [name_employee], [date_order], [note], [total_money], [promotion], [is_delete]) VALUES (33, N'lalalalalalalal', N'Trần Viết Trưởng', CAST(0x0000AA2C00000000 AS DateTime), N'', 105000, 0, 0)
SET IDENTITY_INSERT [dbo].[Bill] OFF
SET IDENTITY_INSERT [dbo].[Catagory] ON 

INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (1, N'Truyện Trinh Thám', 0)
INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (2, N'Truyện Phiêu Lưu', 0)
INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (3, N'Truyện Cổ Tích', 0)
INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (4, N'Truyện Cười', 1)
INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (5, N'Truyện Ngụ Ngôn', 1)
INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (6, N'aaaaaaaaaa', 1)
INSERT [dbo].[Catagory] ([id], [name_catagory], [is_delete]) VALUES (7, N'Truyện Cười', 0)
SET IDENTITY_INSERT [dbo].[Catagory] OFF
SET IDENTITY_INSERT [dbo].[Commic] ON 

INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (1, N'Conan', 1, 1, 81, 5000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (2, N'Doremon', 2, 1, 84, 7000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (3, N'Hoàng tử ếch', 3, 1, 85, 4500, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (4, N'Con kiến đen', 3, 2, 88, 6000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (5, N'Vua trò chơi', 2, 2, 86, 5000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (6, N'7 viên ngọc rồng', 2, 2, 83, 5000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (7, N'Hazuki', 3, 3, 78, 5500, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (8, N'Omega', 3, 3, 83, 50000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (18, N'Sasuke', 2, 2, 87, 9000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (19, N'Nàng tiên cá', 3, 2, 75, 3500, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (28, N'Lọ lem', 3, 3, 73, 4500, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (30, N'test', 1, 2, 0, 50000, 1)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (31, N'test', 2, 3, 0, 5000, 1)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (32, N'Hoàng tử và công chúa ', 7, 6, 83, 4000, 0)
INSERT [dbo].[Commic] ([id], [name_commic], [id_catagory], [id_publisher], [quantity], [price], [is_delete]) VALUES (33, N'Tấm Cám', 3, 5, 87, 4000, 0)
SET IDENTITY_INSERT [dbo].[Commic] OFF
SET IDENTITY_INSERT [dbo].[Coupon] ON 

INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (2, N'Long Hà', CAST(0x0000AA2B00000000 AS DateTime), N'', 50000, 0)
INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (3, N'Hòa Trung', CAST(0x0000AA2B00000000 AS DateTime), N'', 75000, 0)
INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (4, N'Test', CAST(0x0000AA2B00000000 AS DateTime), N'', 10000, 0)
INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (5, N'Hải Phong', CAST(0x0000AA2B00000000 AS DateTime), N'không có gì', 340000, 0)
INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (6, N'Hải Phong', CAST(0x0000AA2C00000000 AS DateTime), N'hôm nay là ngày 11/04/2019', 230000, 0)
INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (7, N'Hưng Hà', CAST(0x0000AA2C00000000 AS DateTime), N'', 50000, 0)
INSERT [dbo].[Coupon] ([id], [name_suppiler], [date_order], [note], [total_money], [is_delete]) VALUES (8, N'Kim đồng', CAST(0x0000AA2C00000000 AS DateTime), N'', 200000, 0)
SET IDENTITY_INSERT [dbo].[Coupon] OFF
SET IDENTITY_INSERT [dbo].[DetailBill] ON 

INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (9, 15, 1, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (10, 15, 2, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (11, 16, 2, 10)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (12, 16, 4, 10)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (13, 17, 3, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (14, 17, 7, 6)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (15, 17, 5, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (16, 18, 6, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (17, 18, 8, 10)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (18, 18, 2, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (19, 18, 3, 10)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (20, 18, 1, 9)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (21, 19, 6, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (22, 19, 7, 4)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (23, 19, 5, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (24, 20, 6, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (25, 20, 5, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (26, 20, 1, 2)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (27, 21, 6, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (28, 22, 7, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (29, 22, 8, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (30, 22, 4, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (31, 23, 6, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (32, 23, 2, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (33, 23, 5, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (34, 23, 1, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (35, 24, 3, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (36, 24, 1, 2)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (37, 24, 6, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (38, 25, 2, 2)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (39, 25, 5, 4)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (40, 25, 6, 2)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (41, 25, 7, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (42, 26, 8, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (43, 26, 4, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (44, 26, 2, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (45, 26, 1, 4)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (46, 26, 5, 6)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (47, 27, 18, 6)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (48, 27, 32, 7)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (49, 27, 19, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (50, 28, 3, 10)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (51, 28, 18, 6)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (52, 29, 3, 4)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (53, 29, 5, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (54, 29, 7, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (55, 29, 1, 4)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (56, 30, 5, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (57, 30, 4, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (58, 30, 2, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (59, 30, 19, 6)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (60, 31, 33, 10)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (61, 31, 4, 8)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (62, 31, 5, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (63, 32, 33, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (64, 32, 1, 3)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (65, 32, 28, 6)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (66, 32, 19, 5)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (67, 33, 1, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (68, 33, 2, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (69, 33, 3, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (70, 33, 4, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (71, 33, 5, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (72, 33, 6, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (73, 33, 7, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (74, 33, 8, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (75, 33, 18, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (76, 33, 19, 1)
INSERT [dbo].[DetailBill] ([id], [id_bill], [id_commic], [quantity_oder]) VALUES (77, 33, 28, 1)
SET IDENTITY_INSERT [dbo].[DetailBill] OFF
SET IDENTITY_INSERT [dbo].[DetailCoupon] ON 

INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (1, 2, 19, 50, 1000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (2, 3, 28, 30, 1000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (3, 3, 32, 30, 1500)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (4, 4, 28, 10, 1000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (5, 5, 1, 10, 1000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (6, 5, 2, 10, 2000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (7, 5, 3, 20, 3000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (8, 5, 32, 50, 5000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (9, 6, 19, 40, 2000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (10, 6, 28, 40, 3000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (11, 6, 5, 20, 1500)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (12, 7, 32, 10, 1000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (13, 7, 4, 20, 2000)
INSERT [dbo].[DetailCoupon] ([id], [id_coupon], [id_commic], [quantity_order], [import_price]) VALUES (14, 8, 33, 100, 2000)
SET IDENTITY_INSERT [dbo].[DetailCoupon] OFF
SET IDENTITY_INSERT [dbo].[Employee] ON 

INSERT [dbo].[Employee] ([id], [name_employee], [name_user], [pass_word], [level_employee]) VALUES (1, N'Trần Viết Trưởng', N'admin', N'123', 3)
SET IDENTITY_INSERT [dbo].[Employee] OFF
SET IDENTITY_INSERT [dbo].[Publisher] ON 

INSERT [dbo].[Publisher] ([id], [name_publisher], [is_delete]) VALUES (1, N'Kim Đồng', 0)
INSERT [dbo].[Publisher] ([id], [name_publisher], [is_delete]) VALUES (2, N'Bãi Bằng', 0)
INSERT [dbo].[Publisher] ([id], [name_publisher], [is_delete]) VALUES (3, N'Hồng Hải', 0)
INSERT [dbo].[Publisher] ([id], [name_publisher], [is_delete]) VALUES (4, N'TEST', 1)
INSERT [dbo].[Publisher] ([id], [name_publisher], [is_delete]) VALUES (5, N'Hồng Hà', 0)
INSERT [dbo].[Publisher] ([id], [name_publisher], [is_delete]) VALUES (6, N'không tên', 1)
SET IDENTITY_INSERT [dbo].[Publisher] OFF
ALTER TABLE [dbo].[Commic]  WITH CHECK ADD  CONSTRAINT [fk_id_catagory] FOREIGN KEY([id_catagory])
REFERENCES [dbo].[Catagory] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Commic] CHECK CONSTRAINT [fk_id_catagory]
GO
ALTER TABLE [dbo].[Commic]  WITH CHECK ADD  CONSTRAINT [fk_id_publisher] FOREIGN KEY([id_publisher])
REFERENCES [dbo].[Publisher] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Commic] CHECK CONSTRAINT [fk_id_publisher]
GO
ALTER TABLE [dbo].[DetailBill]  WITH CHECK ADD  CONSTRAINT [fk_id_bill] FOREIGN KEY([id_bill])
REFERENCES [dbo].[Bill] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DetailBill] CHECK CONSTRAINT [fk_id_bill]
GO
ALTER TABLE [dbo].[DetailBill]  WITH CHECK ADD  CONSTRAINT [FK_id_Commic] FOREIGN KEY([id_commic])
REFERENCES [dbo].[Commic] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DetailBill] CHECK CONSTRAINT [FK_id_Commic]
GO
ALTER TABLE [dbo].[DetailCoupon]  WITH CHECK ADD  CONSTRAINT [FK_id_Commic_Coupon] FOREIGN KEY([id_commic])
REFERENCES [dbo].[Commic] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DetailCoupon] CHECK CONSTRAINT [FK_id_Commic_Coupon]
GO
ALTER TABLE [dbo].[DetailCoupon]  WITH CHECK ADD  CONSTRAINT [fk_id_coupon] FOREIGN KEY([id_coupon])
REFERENCES [dbo].[Coupon] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DetailCoupon] CHECK CONSTRAINT [fk_id_coupon]
GO
USE [master]
GO
ALTER DATABASE [ComMic] SET  READ_WRITE 
GO
