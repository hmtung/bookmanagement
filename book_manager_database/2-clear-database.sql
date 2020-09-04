USE bookmanagement

-- drop table user role
IF  EXISTS(SELECT * FROM INFORMATION_SCHEMA.TABLES Where Table_Schema = 'dbo'  AND Table_Name ='user_role_tbl')
BEGIN
     DROP TABLE  user_role_tbl
END

GO

-- drop table contain
IF  EXISTS(SELECT * FROM INFORMATION_SCHEMA.TABLES Where Table_Schema = 'dbo'  AND Table_Name ='contain')
BEGIN
     DROP TABLE  contain
END

GO

-- drop table book
IF  EXISTS(SELECT * FROM INFORMATION_SCHEMA.TABLES Where Table_Schema = 'dbo'  AND Table_Name ='book_tbl')
BEGIN
     DROP TABLE  book_tbl
END

GO

-- drop table book case
IF  EXISTS(SELECT * FROM INFORMATION_SCHEMA.TABLES Where Table_Schema = 'dbo'  AND Table_Name ='book_case_tbl')
BEGIN
     DROP TABLE  book_case_tbl
END

GO

-- drop table user
IF  EXISTS(SELECT * FROM INFORMATION_SCHEMA.TABLES Where Table_Schema = 'dbo'  AND Table_Name ='user_tbl')
BEGIN
     DROP TABLE  user_tbl
END

GO

-- drop table role
IF  EXISTS(SELECT * FROM INFORMATION_SCHEMA.TABLES Where Table_Schema = 'dbo'  AND Table_Name ='role_tbl')
BEGIN
     DROP TABLE  role_tbl
END

GO
