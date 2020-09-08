USE bookmanagement

--create table user
CREATE TABLE user_tbl
(
	 user_id INT IDENTITY(1,1) PRIMARY KEY,
	 username VARCHAR(50) NOT NULL UNIQUE,
	 password VARCHAR(50) NOT NULL
)
GO

--create table role
CREATE TABLE role_tbl
(
	role_id INT IDENTITY(1,1) PRIMARY KEY,
	authority VARCHAR(50) NOT NULL
);
GO

--create table user_role
CREATE TABLE user_role_tbl
(
	user_role_id INT IDENTITY(1,1) PRIMARY KEY,
	user_id INT NOT NULL,
	role_id INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user_tbl(user_id),
	FOREIGN KEY (role_id) REFERENCES role_tbl(role_id),
);
GO

--create table book
CREATE TABLE book_tbl
(
	book_id INT IDENTITY(1,1) PRIMARY KEY,
	book_title VARCHAR(50) NOT NULL,
	author VARCHAR(50) not null,
	brief VARCHAR(50),
	publisher VARCHAR(50),
	content VARCHAR(50),
	category VARCHAR(50),
)
GO

--create table book-case
CREATE TABLE book_case_tbl
(
	book_case_id INT IDENTITY(1,1) PRIMARY KEY,
	book_case_name VARCHAR(50) NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user_tbl(user_id),
)
GO

-- create table contain
CREATE TABLE contain
(
	book_case_id INT NOT NULL,
	book_id INT NOT NULL,
	create_date DATETIME NOT NULL
	CONSTRAINT PK_Contain PRIMARY KEY (book_case_id,book_id)
	FOREIGN KEY (book_case_id) REFERENCES book_case_tbl(book_case_id),
	FOREIGN KEY (book_id) REFERENCES book_tbl(book_id) ON DELETE CASCADE,
)

