
------------------------ Creating tables ------------------------ 

DROP TABLE IF EXISTS WORKINGSTATUS;
CREATE TABLE WORKINGSTATUS(
	id serial primary key not null, 
	name character(50)
);

DROP TABLE IF EXISTS WORKINGTIME;
CREATE TABLE WORKINGTIME(
	id serial primary key not null, 
	startHour int, 
	endHour int
);


DROP TABLE IF EXISTS FOOD;
CREATE TABLE FOOD(
	id serial primary key not null, 
	"name" text, 
	price float default 0,
	note text
);

DROP TABLE IF EXISTS FTABLE;
CREATE TABLE FTABLE(
	id serial primary key not null, 
	"name" text 
);


DROP TABLE IF EXISTS TYPESTAFF;
CREATE TABLE TYPESTAFF(
	id serial primary key not null, 
	name character(50)
);


DROP TABLE IF EXISTS STAFF;
CREATE TABLE STAFF(
	id serial primary key not null, 
	fullName text,
	address text, 
	acc_name text,
	email text,
	password text,
	sex boolean default true,
	birthday date, 
	id_type int not null references TYPESTAFF(id) 
);

DROP TABLE IF EXISTS REGISTERSTATUS;
CREATE TABLE REGISTERSTATUS(
	id serial primary key not null, 
	name character(50)
);

DROP TABLE IF EXISTS REGISTERLEAVE;
CREATE TABLE REGISTERLEAVE(
	id serial primary key,
	id_staff int references STAFF(id), 
	id_leaveWorkingTime int references WORKINGTIME(id), 
	leaveDate Date not null, 
	status int references REGISTERSTATUS(id)
);

DROP TABLE IF EXISTS DETAILWORKING;
CREATE TABLE DETAILWORKING(
	id_staff int references STAFF(id), 
	id_workingTime int references WORKINGTIME(id), 
	workingDate Date not null, 
	id_registerLeave int references REGISTERLEAVE(id)
);

DROP TABLE IF EXISTS DETAILORDER;
CREATE TABLE DETAILORDER(
	id serial primary key not null, 
	id_table int not null references FTABLE(id), 
	id_food int not null references FOOD(id), 
	id_staff int not null references STAFF(id), 
	numberOfCustomer int, 
	startDate Date not null	
);


------------------------ insert data ------------------------
 /* 1.  STAFFTYPE data */  
INSERT INTO TYPESTAFF (name) VALUES ('chủ quán');
INSERT INTO TYPESTAFF (name) VALUES ('quản lý');
INSERT INTO TYPESTAFF (name) VALUES ('nhân viên phục vụ');
INSERT INTO TYPESTAFF (name) VALUES ('đầu bếp');

INSERT INTO STAFF (fullName,address,acc_name,password,email,sex,id_type) VALUES ('Nguyễn Văn A','Tân Bình','boss','12345678','nva@gmail.com',true,1);
INSERT INTO STAFF (fullName,address,acc_name,password,email,sex,id_type) VALUES ('Nguyễn Văn B','Gò Vấp','manager','12345678','manager@gmail.com',false,2);
INSERT INTO STAFF (fullName,address,acc_name,password,email,sex,id_type) VALUES ('Nguyễn Văn C','Quận 5','normalstaff','12345678','normalstaff@gmail.com',true,3);
INSERT INTO STAFF (fullName,address,acc_name,password,email,sex,id_type) VALUES ('Nguyễn Văn D','Quận 10','chiefstaff','12345678','chiefstaff@gmail.com',false,4);