USE [master]
GO
/****** Object:  Database [DormManagement]    Script Date: 5/2/2015 9:30:37 PM ******/
CREATE DATABASE [DormManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DormManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DormManagement.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DormManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DormManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DormManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DormManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DormManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DormManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DormManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DormManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DormManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [DormManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DormManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DormManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DormManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DormManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DormManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DormManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DormManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DormManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DormManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DormManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DormManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DormManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DormManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DormManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DormManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DormManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DormManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [DormManagement] SET  MULTI_USER 
GO
ALTER DATABASE [DormManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DormManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DormManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DormManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DormManagement] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DormManagement', N'ON'
GO
USE [DormManagement]
GO
/****** Object:  Table [dbo].[ClosedItem]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[DamagedItem]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Department]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Dorm]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Family]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Hostel]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[LostItem]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Payment]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[PaymentType]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Room]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[Room_ID] [int] IDENTITY(1,1) NOT NULL,
	[RoomNo] [int] NOT NULL,
	[RoomType_ID] [int] NULL,
	[Dorm_ID] [int] NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[Room_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RoomType]    Script Date: 5/2/2015 9:30:37 PM ******/
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
/****** Object:  Table [dbo].[Student]    Script Date: 5/2/2015 9:30:37 PM ******/
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
	[Status] [nvarchar](10) NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[Student_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[ClosedItem]  WITH NOCHECK ADD  CONSTRAINT [FK_ClosedItem_LostItem] FOREIGN KEY([LostItem_ID])
REFERENCES [dbo].[LostItem] ([LostItem_ID])
GO
ALTER TABLE [dbo].[ClosedItem] CHECK CONSTRAINT [FK_ClosedItem_LostItem]
GO
ALTER TABLE [dbo].[ClosedItem]  WITH NOCHECK ADD  CONSTRAINT [FK_ClosedItem_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Student] ([Student_ID])
GO
ALTER TABLE [dbo].[ClosedItem] CHECK CONSTRAINT [FK_ClosedItem_Student]
GO
ALTER TABLE [dbo].[DamagedItem]  WITH NOCHECK ADD  CONSTRAINT [FK_DamagedItem_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[DamagedItem] CHECK CONSTRAINT [FK_DamagedItem_Dorm]
GO
ALTER TABLE [dbo].[Hostel]  WITH NOCHECK ADD  CONSTRAINT [FK_Hostel_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[Hostel] CHECK CONSTRAINT [FK_Hostel_Dorm]
GO
ALTER TABLE [dbo].[Hostel]  WITH NOCHECK ADD  CONSTRAINT [FK_Hostel_Room] FOREIGN KEY([Room_ID])
REFERENCES [dbo].[Room] ([Room_ID])
GO
ALTER TABLE [dbo].[Hostel] CHECK CONSTRAINT [FK_Hostel_Room]
GO
ALTER TABLE [dbo].[Hostel]  WITH NOCHECK ADD  CONSTRAINT [FK_Hostel_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Student] ([Student_ID])
GO
ALTER TABLE [dbo].[Hostel] CHECK CONSTRAINT [FK_Hostel_Student]
GO
ALTER TABLE [dbo].[LostItem]  WITH NOCHECK ADD  CONSTRAINT [FK_LostItem_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[LostItem] CHECK CONSTRAINT [FK_LostItem_Dorm]
GO
ALTER TABLE [dbo].[Payment]  WITH NOCHECK ADD  CONSTRAINT [FK_Payment_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Dorm]
GO
ALTER TABLE [dbo].[Payment]  WITH NOCHECK ADD  CONSTRAINT [FK_Payment_PaymentType] FOREIGN KEY([PaymentType_ID])
REFERENCES [dbo].[PaymentType] ([PaymentType_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_PaymentType]
GO
ALTER TABLE [dbo].[Payment]  WITH NOCHECK ADD  CONSTRAINT [FK_Payment_Room] FOREIGN KEY([Room_ID])
REFERENCES [dbo].[Room] ([Room_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Room]
GO
ALTER TABLE [dbo].[Payment]  WITH NOCHECK ADD  CONSTRAINT [FK_Payment_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Student] ([Student_ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Student]
GO
ALTER TABLE [dbo].[Room]  WITH NOCHECK ADD  CONSTRAINT [FK_Room_Dorm] FOREIGN KEY([Dorm_ID])
REFERENCES [dbo].[Dorm] ([Dorm_ID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Dorm]
GO
ALTER TABLE [dbo].[Room]  WITH NOCHECK ADD  CONSTRAINT [FK_Room_RoomType] FOREIGN KEY([RoomType_ID])
REFERENCES [dbo].[RoomType] ([RoomType_ID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_RoomType]
GO
ALTER TABLE [dbo].[Student]  WITH NOCHECK ADD  CONSTRAINT [FK_Student_Department] FOREIGN KEY([Department_ID])
REFERENCES [dbo].[Department] ([Department_ID])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Department]
GO
ALTER TABLE [dbo].[Student]  WITH NOCHECK ADD  CONSTRAINT [FK_Student_Family] FOREIGN KEY([Family_ID])
REFERENCES [dbo].[Family] ([Family_ID])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Family]
GO
/****** Object:  StoredProcedure [dbo].[Get_DamagedItems]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_DamagedItems]
	-- Add the parameters for the stored procedure here
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select DamagedItem_ID, ItemName, Status, Note, Date, DormName from DamagedItem dt
inner join Dorm drm on drm.Dorm_ID = dt.Dorm_ID
END



GO
/****** Object:  StoredProcedure [dbo].[Get_Dorm]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_Dorm]
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT DormName from Dorm
END



GO
/****** Object:  StoredProcedure [dbo].[Get_DormCapacity]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_DormCapacity]
	@DormName nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

select sum(TypeName) from Room r
inner join RoomType rt on rt.RoomType_ID= r.RoomType_ID
where Dorm_ID=(select Dorm_ID from Dorm where DormName=@DormName)
END

GO
/****** Object:  StoredProcedure [dbo].[Get_FemaleNumber]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_FemaleNumber]
	@DormName nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    select Count(s.StudentName) from Student s
	inner join Hostel h on h.Student_ID=s.Student_ID
	inner join Dorm d on d.Dorm_ID=h.Dorm_ID
	where h.Dorm_ID=(select Dorm_ID from Dorm where DormName=@DormName) and s.Gender='Female' and s.Status='Active'

END




GO
/****** Object:  StoredProcedure [dbo].[Get_LostInfo]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_LostInfo] 
	@itemid int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select ItemName, Note, DormName, Date, Status from LostItem lt, Dorm drm where drm.Dorm_ID = lt.Dorm_ID 
and lt.LostItem_ID = @itemid
END


GO
/****** Object:  StoredProcedure [dbo].[Get_LostItems]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_LostItems]
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select LostItem_ID, ItemName, Status, Note, Date, DormName from LostItem lt
inner join Dorm drm on drm.Dorm_ID =  lt.Dorm_ID
END





GO
/****** Object:  StoredProcedure [dbo].[Get_MaleNumber]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_MaleNumber]
	@DormName nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    select Count(s.StudentName) from Student s
	inner join Hostel h on h.Student_ID=s.Student_ID
	inner join Dorm d on d.Dorm_ID=h.Dorm_ID
	where h.Dorm_ID=(select Dorm_ID from Dorm where DormName=@DormName) and s.Gender='Male'and s.Status='Active'

END





GO
/****** Object:  StoredProcedure [dbo].[Get_PaymentHistory]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_PaymentHistory]
@Name nvarchar(50),
@Surname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

  select d.DormName,rt.TypeName, p.Type,pt.Disbursement,pt.PaidDate from Payment pt
inner join Student st on st.Student_ID=pt.Student_ID
inner join Dorm d on d.Dorm_ID=pt.Dorm_ID
inner join Room r on r.Room_ID=pt.Room_ID
inner join RoomType rt on rt.RoomType_ID=r.RoomType_ID
inner join PaymentType p on pt.PaymentType_ID=p.PaymentType_ID

where pt.Student_ID=(select Student_ID from Student where StudentName=@Name and StudentSurname=@Surname)
END

GO
/****** Object:  StoredProcedure [dbo].[Get_PaymentInfo]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_PaymentInfo]
	@StdName nvarchar(50),
	@StdSurname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select rt.Price,DATEDIFF(MM,h.StartDate,h.EndDate) as Diff,rt.Price * DATEDIFF(MM,h.StartDate,h.EndDate) as Multiple from RoomType rt 
	inner join Room r on r.RoomType_ID=rt.RoomType_ID
	inner join Hostel h on h.Room_ID=r.Room_ID
	inner join Dorm d on d.Dorm_ID=h.Dorm_ID
	
	where Hostel_ID=(select Hostel_ID from Hostel h inner join Student std on std.Student_ID=h.Student_ID
						where std.StudentName=@StdName and std.StudentSurname=@StdSurname)

END



GO
/****** Object:  StoredProcedure [dbo].[Get_RemainingDebt]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_RemainingDebt]
	-- Add the parameters for the stored procedure here
@Name nvarchar(50),
@Surname nvarchar(50)

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    select Top 1 RemainingDebt from Payment pt inner join Student st on st.Student_ID=pt.Student_ID
	where pt.Student_ID=(select Student_ID from Student where StudentName=@Name and StudentSurname=@Surname)
	order by Payment_ID DESC;
END

GO
/****** Object:  StoredProcedure [dbo].[Get_Room]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_Room]
	@DormName nvarchar(50),
	@TypeName int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT RoomNo from Room where Dorm_ID=(select Dorm_ID from Dorm where DormName=@DormName) 
	and RoomType_ID=(select RoomType_ID from RoomType where TypeName=@TypeName)
	
END



GO
/****** Object:  StoredProcedure [dbo].[Get_RoomPrice]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_RoomPrice]
	@Type int
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
    -- Insert statements for procedure here
	select rt.Price from RoomType rt 
	where rt.TypeName=@Type 
END

GO
/****** Object:  StoredProcedure [dbo].[Get_RoomType]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_RoomType] 
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT TypeName from RoomType
END



GO
/****** Object:  StoredProcedure [dbo].[Get_StudentBetweenStartEndDate]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentBetweenStartEndDate]
	@StartDate date,
	@EndDate date,
	@DormName nvarchar(50),
	@RoomNo int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    select Count(st.StudentName) from Student st
inner join Hostel h on h.Student_ID=st.Student_ID

where  (((@StartDate>=h.StartDate and @EndDate>=h.EndDate and h.EndDate>=@StartDate )
or(h.StartDate<=@EndDate and h.StartDate>=@StartDate and h.EndDate>=@EndDate) 
or(h.StartDate<=@EndDate and h.StartDate<=@StartDate and h.EndDate>=@EndDate)
or(h.StartDate<=@EndDate and h.StartDate>=@StartDate and h.EndDate<=@EndDate) )
and (h.Room_ID=(select Room_ID from Room r inner join Dorm d on d.Dorm_ID=r.Dorm_ID  where r.RoomNo=@RoomNo and d.DormName=@DormName))
and st.Status='Active')

END



GO
/****** Object:  StoredProcedure [dbo].[Get_StudentIDCountForPayment]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentIDCountForPayment] 
	-- Add the parameters for the stored procedure here
@Name nvarchar(50),
@Surname nvarchar(50)

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    select count(pt.Student_ID) from Payment pt inner join Student st on st.Student_ID=pt.Student_ID 
	where pt.Student_ID=(select st.Student_ID where st.StudentName=@Name and st.StudentSurname=@Surname)
END

GO
/****** Object:  StoredProcedure [dbo].[Get_StudentInfo]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentInfo] 
	-- Add the parameters for the stored procedure here
	@Name nvarchar(50),
	@Surname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select StudentName, StudentSurname, TC_ID, Gender, st.Phone, Mail, Birthdate, Name, Surname, 
fmy.Phone, University, DepName, Grade, DormName, TypeName, RoomNo, StartDate, EndDate     
from Student st  
inner join Department dpt on dpt.Department_ID = st.Department_ID
inner join Family fmy on fmy.Family_ID = st.Family_ID
inner join Hostel hs on  st.Student_ID = hs.Student_ID  
inner join Dorm dm on dm.Dorm_ID = hs.Dorm_ID
inner join Room rm on rm.Room_ID = hs.Room_ID
inner join RoomType rt on rt.RoomType_ID = rm.RoomType_ID
where StudentName = @Name and StudentSurname = @Surname
END



GO
/****** Object:  StoredProcedure [dbo].[Get_StudentNumberInDorm]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentNumberInDorm] 
	@DormName nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
select count(st.StudentName) from Hostel h
inner join Dorm d on d.Dorm_ID= h.Dorm_ID
inner join Student st on st.Student_ID=h.Student_ID
where h.Dorm_ID=(select Dorm_ID from Dorm where DormName=@DormName)
and st.Status='Active'
END

GO
/****** Object:  StoredProcedure [dbo].[Get_StudentsForDate]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentsForDate]
	-- Add the parameters for the stored procedure here
	@StartDate date,
	@EndDate date

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra res1ult sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
 select d.DormName, r.RoomNo,st.StudentName,st.StudentSurname, h.StartDate,h.EndDate, rt.TypeName from Student st
inner join Hostel h on h.Student_ID=st.Student_ID
inner join Dorm d on h.Dorm_ID=d.Dorm_ID
inner join Room r on r.Room_ID=h.Room_ID
inner join RoomType rt on rt.RoomType_ID = r.RoomType_ID
where  (((@StartDate>=h.StartDate and @EndDate>=h.EndDate and h.EndDate>=@StartDate )
or(h.StartDate<=@EndDate and h.StartDate>=@StartDate and h.EndDate>=@EndDate) 
or(h.StartDate<=@EndDate and h.StartDate<=@StartDate and h.EndDate>=@EndDate))
and st.Status='Active')


END


GO
/****** Object:  StoredProcedure [dbo].[Get_StudentsInDorm]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentsInDorm] 
	@dormname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select StudentName, StudentSurname from Student st
inner join Hostel ht on ht.Student_ID = st.Student_ID
inner join Dorm d on d.Dorm_ID = ht.Dorm_ID
inner join Room r on r.Room_ID = ht.Room_ID
inner join RoomType rt on rt.RoomType_ID = r.RoomType_ID
where DormName = @dormname and st.Status='Active'
END


GO
/****** Object:  StoredProcedure [dbo].[Get_StudentsinRoom]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Get_StudentsinRoom]
	-- Add the parameters for the stored procedure here
	@Dormname nvarchar(50),
	@roomno int

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	select st.StudentName,st.StudentSurname from Student st
inner join Hostel h on st.Student_ID=h.Student_ID
where Room_ID=(select Room_ID from Room where Dorm_ID=(select Dorm_ID from Dorm where DormName=@Dormname) 
and RoomNo=@roomno) and Status='Active'
END





GO
/****** Object:  StoredProcedure [dbo].[Insert_ClosedItem]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_ClosedItem]
	@stdname nvarchar(50),
	@stdsurname nvarchar(50),
	@lostid int,
	@closingdate date
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	insert into ClosedItem(Student_ID, LostItem_ID, Date) values ((select Student_ID from Student where StudentName = @stdname 
	and StudentSurname = @stdsurname), (select LostItem_ID from LostItem where LostItem_ID = @lostid), @closingdate)
END


GO
/****** Object:  StoredProcedure [dbo].[Insert_DamagedItem]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_DamagedItem]
	-- Add the parameters for the stored procedure here
	@itemname nvarchar(50),
	@note nvarchar(200),
	@date datetime,
	@status nvarchar(50),
	@dormname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO DamagedItem(ItemName, Note, Date, Status, Dorm_ID) VALUES (@itemname, @note, @date, @status, 
	(select Dorm_ID from Dorm where DormName = @dormname))
END






GO
/****** Object:  StoredProcedure [dbo].[Insert_Dorm]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_Dorm]
	@dormname nvarchar(50), 
	@location nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure her
	Insert into Dorm(DormName, Location) values (@dormname, @location)
END



GO
/****** Object:  StoredProcedure [dbo].[Insert_LostItem]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_LostItem]
	-- Add the parameters for the stored procedure here
	@itemname nvarchar(50),
	@note nvarchar(200),
	@date datetime,
	@status nvarchar(50),
	@dormname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO LostItem(ItemName, Note, Date, Status, Dorm_ID) VALUES (@itemname, @note, @date, @status, 
	(select Dorm_ID from Dorm where DormName = @dormname))
END





GO
/****** Object:  StoredProcedure [dbo].[Insert_Payment]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_Payment]
	-- Add the parameters for the stored procedure here
	@stdname nvarchar(50),
	@stdsurname nvarchar(50),
	@roomno int,
	@dormname nvarchar(50),
	@type nvarchar(50),
	@remainingdebt decimal (10,2),
	@disbursement decimal(10,2)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO Payment (Student_ID, Room_ID,Dorm_ID, PaymentType_ID, RemainingDebt,PaidDate, Disbursement) VALUES (
	(select Student_ID from Student where StudentName = @stdname and StudentSurname = @stdsurname),
	(select Room_ID from Room where RoomNo = @roomno and Dorm_ID=(select Dorm_ID from Dorm where DormName = @dormname)),
	(select Dorm_ID from Dorm where DormName = @dormname),
	(select PaymentType_ID from PaymentType where Type = @type), @remainingdebt,GETDATE(),@disbursement
	)
END


GO
/****** Object:  StoredProcedure [dbo].[Insert_Room]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_Room]
	
	@roomno int,
	@roomtype nvarchar(50),
	@DormName nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure her
	insert into Room(RoomNo, RoomType_ID,Dorm_ID) values 
(@roomno,(select RoomType_ID from RoomType where TypeName=@roomtype)
,(select Dorm_ID from Dorm where DormName=@DormName))
END



GO
/****** Object:  StoredProcedure [dbo].[Insert_RoomType]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_RoomType]
	@typename nvarchar(50), 
	@roomprice decimal(5,2)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure her
	Insert into RoomType(TypeName, Price) values (@typename, @roomprice)
END



GO
/****** Object:  StoredProcedure [dbo].[Insert_Student]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Insert_Student]
	-- Add the parameters for the stored procedure here
@uni nvarchar (50),
@deptname nvarchar (50),
@grade int,
@Name nvarchar(50),
@Surname nvarchar(50),
@Phone nvarchar(50),
@SName nvarchar(50),
@SSurname nvarchar(50),
@Mail nvarchar(50),
@SPhone nvarchar(50),
@Gender nvarchar(50),
@Birthdate datetime,
@TC int,
@DormName nvarchar(50),
@RoomNo int,
@StartDate datetime,
@EndDate datetime

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	insert into Department(University, DepName, Grade) Values (@uni, @deptname, @grade) 
	insert into Family(Name,Surname,Phone) Values (@Name,@Surname,@Phone)
		insert into Student(StudentName,StudentSurname,Mail,Phone,Gender,Birthdate,TC_ID,Family_ID,Department_ID,Status) 
		values(@SName,@SSurname,@Mail,@Phone,@Gender,@Birthdate,@TC,@@IDENTITY,@@IDENTITY,'Active')
	insert into Hostel(Student_ID,Dorm_ID,Room_ID,StartDate,EndDate) 
	values((select Student_ID from Student where StudentName=@SName and StudentSurname=@SSurname),
			(select Dorm_ID from Dorm where DormName=@DormName),
			(select Room_ID from Room r inner join Dorm d on d.Dorm_ID=r.Dorm_ID 
				where RoomNo=@RoomNo and DormName=@DormName)
			,@StartDate,@EndDate)


end



GO
/****** Object:  StoredProcedure [dbo].[Update_DamagedItemStatus]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Update_DamagedItemStatus] 
	@itemid int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	update DamagedItem set Status='Closed'  from DamagedItem where DamagedItem_ID = @itemid
END


GO
/****** Object:  StoredProcedure [dbo].[Update_Hostel]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Update_Hostel]
@StudentNameV nvarchar(50),
@StudentSurnameV nvarchar(50),
@StartDate date,
@EndDate date,
@DormName nvarchar(50),
@RoomType int,
@RoomNo int

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	update Hostel set StartDate=@StartDate,EndDate=@EndDate,Dorm_ID=(select Dorm_ID from Dorm where DormName=@DormName)
 ,Room_ID=(select Room_ID from Room r 
			inner join RoomType rt on rt.RoomType_ID=r.RoomType_ID 
			inner join Dorm d on d.Dorm_ID=r.Dorm_ID
			where r.RoomNo=@RoomNo and rt.TypeName=@RoomType and d.DormName=@DormName)

 where Student_ID=(select Student_ID from Student where StudentName=@StudentNameV and StudentSurname=@StudentSurnameV)
END



GO
/****** Object:  StoredProcedure [dbo].[Update_LostItemStatus]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Update_LostItemStatus] 
@lostid int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	update LostItem set Status = 'Closed' from LostItem where LostItem_ID = @lostid
END


GO
/****** Object:  StoredProcedure [dbo].[Update_StudentPersonalInfo]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- ALTER date: <ALTER Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Update_StudentPersonalInfo]
@StudentNameV nvarchar(50),
@StudentSurnameV nvarchar(50),
@StudentName nvarchar(50),
@StudentSurname nvarchar(50),
@Mail nvarchar(100),
@Phone nvarchar(15),
@Gender nvarchar(10),
@Birthdate date,
@TC nvarchar(12),
@FName nvarchar(50),
@FSurname nvarchar (50),
@FPhone nvarchar(15),
@DepName nvarchar(50),
@University nvarchar(50),
@Grade int	


AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

   update Student set StudentName=@StudentNameV, StudentSurname=@StudentSurnameV
   , Mail=@Mail,Phone=@Phone,Gender=@Gender,Birthdate=@Birthdate,TC_ID=@TC
   where StudentName=@StudentName and StudentSurname=@StudentSurname

   update Family set Name=@FName,Surname=@FSurname,Phone=@FPhone
  where Family_ID=(select Family_ID from Student where StudentName=@StudentNameV and StudentSurname=@StudentSurnameV)

  update Department set DepName=@DepName, University=@University,Grade=@Grade
  where Department_ID=(select Department_ID from Student where StudentName=@StudentNameV and StudentSurname=@StudentSurnameV)
  
  
END





GO
/****** Object:  StoredProcedure [dbo].[Update_StudentStatus]    Script Date: 5/2/2015 9:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[Update_StudentStatus] 
	@SName nvarchar(50),
	@SSurname nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

  Update Student set Status='Passive' where StudentName=@SName and StudentSurname=@SSurname
END

GO
USE [master]
GO
ALTER DATABASE [DormManagement] SET  READ_WRITE 
GO
