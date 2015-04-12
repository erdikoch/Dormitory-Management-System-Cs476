USE [DormManagement]
GO
/****** Object:  StoredProcedure [dbo].[Get_PaymentInfo]    Script Date: 4/12/2015 1:27:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
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
