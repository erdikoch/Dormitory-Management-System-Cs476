USE [DormManagement]
GO
/****** Object:  Table [dbo].[ClosedItem]    Script Date: 5/4/2015 1:08:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClosedItem](
	[ClosedItem_ID] [int] IDENTITY(1,1) NOT NULL,
	[LostItem_ID] [int] NOT NULL,
	[Student_ID] [int] NOT NULL,
	[Date] [datetime] NOT NULL,
 CONSTRAINT [PK_ClosedItem] PRIMARY KEY CLUSTERED 
(
	[ClosedItem_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DamagedItem]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DamagedItem](
	[DamagedItem_ID] [int] NOT NULL,
	[Note] [nvarchar](200) NOT NULL,
	[Date] [datetime] NOT NULL,
	[Status] [nvarchar](50) NOT NULL,
	[Dorm_ID] [int] IDENTITY(1,1) NOT NULL,
	[Room_ID] [int] NOT NULL,
	[ItemName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DamagedItem] PRIMARY KEY CLUSTERED 
(
	[DamagedItem_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Department]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[Department_ID] [int] IDENTITY(1,1) NOT NULL,
	[DepName] [nvarchar](50) NULL,
	[University] [nvarchar](100) NULL,
	[Grade] [int] NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[Department_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Dorm]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dorm](
	[Dorm_ID] [int] IDENTITY(1,1) NOT NULL,
	[DormName] [nvarchar](50) NOT NULL,
	[Location] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Dorm] PRIMARY KEY CLUSTERED 
(
	[Dorm_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Family]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Family](
	[Family_ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Surname] [nvarchar](50) NOT NULL,
	[Phone] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK_Family] PRIMARY KEY CLUSTERED 
(
	[Family_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Hostel]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hostel](
	[Hostel_ID] [int] IDENTITY(1,1) NOT NULL,
	[Student_ID] [int] NOT NULL,
	[Dorm_ID] [int] NOT NULL,
	[Room_ID] [int] NOT NULL,
	[StartDate] [date] NOT NULL,
	[EndDate] [date] NOT NULL,
 CONSTRAINT [PK_Hostel] PRIMARY KEY CLUSTERED 
(
	[Hostel_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LostItem]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LostItem](
	[LostItem_ID] [int] IDENTITY(1,1) NOT NULL,
	[ItemName] [nvarchar](50) NOT NULL,
	[Date] [datetime] NOT NULL,
	[Status] [nvarchar](50) NOT NULL,
	[Dorm_ID] [int] NOT NULL,
	[Note] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_LostItem] PRIMARY KEY CLUSTERED 
(
	[LostItem_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Payment]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[Payment_ID] [int] IDENTITY(1,1) NOT NULL,
	[Student_ID] [int] NOT NULL,
	[Room_ID] [int] NOT NULL,
	[RemainingDebt] [decimal](10, 2) NOT NULL,
	[PaymentType_ID] [int] NOT NULL,
	[Dorm_ID] [int] NULL,
	[Disbursement] [decimal](10, 2) NOT NULL,
	[PaidDate] [datetime] NOT NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[Payment_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaymentType]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentType](
	[PaymentType_ID] [int] IDENTITY(1,1) NOT NULL,
	[Type] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_PaymentType] PRIMARY KEY CLUSTERED 
(
	[PaymentType_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Room]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[Room_ID] [int] IDENTITY(1,1) NOT NULL,
	[RoomNo] [int] NOT NULL,
	[RoomType_ID] [int] NULL,
	[Dorm_ID] [int] NULL,
	[Status] [nvarchar](10) NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[Room_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RoomType]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoomType](
	[RoomType_ID] [int] IDENTITY(1,1) NOT NULL,
	[TypeName] [int] NOT NULL,
	[Price] [decimal](10, 2) NOT NULL,
 CONSTRAINT [PK_RoomType] PRIMARY KEY CLUSTERED 
(
	[RoomType_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Student]    Script Date: 5/4/2015 1:08:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[Student_ID] [int] IDENTITY(1,1) NOT NULL,
	[StudentName] [nvarchar](50) NOT NULL,
	[StudentSurname] [nvarchar](50) NOT NULL,
	[Mail] [nvarchar](100) NULL,
	[Phone] [nvarchar](15) NOT NULL,
	[Department_ID] [int] NOT NULL,
	[Family_ID] [int] NOT NULL,
	[Gender] [nvarchar](10) NULL,
	[Birthdate] [date] NULL,
	[TC_ID] [nvarchar](12) NULL,
	[Status] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[Student_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[ClosedItem]  WITH CHECK ADD  CONSTRAINT [FK_ClosedItem_LostItem] FOREIGN KEY([LostItem_ID])
REFERENCES [dbo].[LostItem] ([LostItem_ID])
GO
ALTER TABLE [dbo].[ClosedItem] CHECK CONSTRAINT [FK_ClosedItem_LostItem]
GO
ALTER TABLE [dbo].[ClosedItem]  WITH CHECK ADD  CONSTRAINT [FK_ClosedItem_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Student] ([Student_ID])
GO
ALTER TABLE [dbo].[ClosedItem] CHECK CONSTRAINT [FK_ClosedItem_Student]
GO
ALTER TABLE [dbo].[DamagedItem]  WITH CHECK ADD  CONSTRAINT [FK_DamagedItem_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[DamagedItem] CHECK CONSTRAINT [FK_DamagedItem_Dorm]
GO
ALTER TABLE [dbo].[Hostel]  WITH CHECK ADD  CONSTRAINT [FK_Hostel_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[Hostel] CHECK CONSTRAINT [FK_Hostel_Dorm]
GO
ALTER TABLE [dbo].[Hostel]  WITH CHECK ADD  CONSTRAINT [FK_Hostel_Room] FOREIGN KEY([Room_ID])
REFERENCES [dbo].[Room] ([Room_ID])
GO
ALTER TABLE [dbo].[Hostel] CHECK CONSTRAINT [FK_Hostel_Room]
GO
ALTER TABLE [dbo].[Hostel]  WITH CHECK ADD  CONSTRAINT [FK_Hostel_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Student] ([Student_ID])
GO
ALTER TABLE [dbo].[Hostel] CHECK CONSTRAINT [FK_Hostel_Student]
GO
ALTER TABLE [dbo].[LostItem]  WITH CHECK ADD  CONSTRAINT [FK_LostItem_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[LostItem] CHECK CONSTRAINT [FK_LostItem_Dorm]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Dorm]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_PaymentType] FOREIGN KEY([PaymentType_ID])
REFERENCES [dbo].[PaymentType] ([PaymentType_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_PaymentType]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Room] FOREIGN KEY([Room_ID])
REFERENCES [dbo].[Room] ([Room_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Room]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Student] ([Student_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Student]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Dorm]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_RoomType] FOREIGN KEY([RoomType_ID])
REFERENCES [dbo].[RoomType] ([RoomType_ID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_RoomType]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Department] FOREIGN KEY([Department_ID])
REFERENCES [dbo].[Department] ([Department_ID])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Department]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Family] FOREIGN KEY([Family_ID])
REFERENCES [dbo].[Family] ([Family_ID])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Family]
GO
