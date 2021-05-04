create database ASSJV4
go
use ASSJV4;
go
create table users
(
    id nvarchar(100) not null primary key,
    password nvarchar(100) not null,
    email nvarchar(100) not null,
    fullName nvarchar(100) not null,
	admin bit,
    deleteUser bit
);

create table Video
(
	id nvarchar(100) primary key,
    title nvarchar(200) not null,
    poster nvarchar(200),
    views int,
    description nvarchar(300),
    active bit,
    deleteVideo bit
);

create table Favorite
(
	id int identity primary key,
    userID nvarchar(100),
    videoID nvarchar(100),
    likeDate datetime,
    constraint FK_Favorite_User foreign key(userID) references users(id),
    constraint FK_Favorite_Video foreign key(videoID) references Video(id)
);

create table Share
(
	id int identity primary key,
    userID nvarchar(100),
    videoID nvarchar(100),
    emails nvarchar(100),
    shareDate datetime,
    constraint FK_Share_User foreign key(userID) references users(id),
    constraint FK_Share_Video foreign key(videoID) references Video(id)
);

insert into Users
values('username1', '123', 'khainqph11867@fpt.edu.vn', 'username1', 0, 0),
		('username2', '123', 'username2@gmail.com', 'username2', 0, 0),
		('username3', '123', 'username3@gmail.com', 'username3', 0, 0),
		('admin1', '123', 'admin1@gmail.com', 'username1', 1, 0),
		('admin2', '123', 'admin2@gmail.com', 'username1', 1, 0),
        ('admin3', '123', 'admin3@gmail.com', 'username1', 1, 0);


