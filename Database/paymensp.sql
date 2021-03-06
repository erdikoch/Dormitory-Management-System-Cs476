USE [DormManagement]
GO
/****** Object:  StoredProcedure [dbo].[Get_PaymentHistory]    Script Date: 5/2/2015 7:55:58 PM ******/
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
/****** Object:  StoredProcedure [dbo].[Get_RemainingDebt]    Script Date: 5/2/2015 7:55:58 PM ******/
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
/****** Object:  StoredProcedure [dbo].[Get_StudentIDCountForPayment]    Script Date: 5/2/2015 7:55:58 PM ******/
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
/****** Object:  StoredProcedure [dbo].[Insert_Payment]    Script Date: 5/2/2015 7:55:58 PM ******/
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
