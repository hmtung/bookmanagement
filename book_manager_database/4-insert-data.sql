USE bookmanagement
GO

--create data role
INSERT INTO role_tbl(authority) VALUES ('ADMIN')
INSERT INTO role_tbl(authority) VALUES ('USER')
GO

--create data user
INSERT INTO user_tbl(username, password) VALUES ('ducpm','123456')
INSERT INTO user_tbl(username, password) VALUES ('tunghm','123456')
GO
--create data user_role
INSERT INTO user_role_tbl(user_id, role_id) VALUES(1,1)
INSERT INTO user_role_tbl(user_id, role_id) VALUES(2,2)
GO
--create data book-case
INSERT INTO book_case_tbl(book_case_name, user_id) VALUES ('demo1', 1)
INSERT INTO book_case_tbl(book_case_name, user_id) VALUES ('demo2', 2)