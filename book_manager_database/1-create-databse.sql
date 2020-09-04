
--drop database
IF EXISTS(SELECT NAME FROM SYS.DATABASES WHERE NAME = 'bookmanagement')

DROP DATABASE bookmanagement

GO

--create dâtbase
CREATE DATABASE bookmanagement