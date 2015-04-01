USE [DormManagement]
GO
/****** Object:  StoredProcedure [dbo].[Get_DormCapacity]    Script Date: 4/1/2015 2:26:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
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
