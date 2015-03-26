-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
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
