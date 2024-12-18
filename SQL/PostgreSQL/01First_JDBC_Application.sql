Assuming You have installed DataBase Softwere (PostgreSQL, MySQL, etc)

--Create Database
	CREATE DATABASE ajdb19;
	
--Create Role
	CREATE ROLE username LOGIN SUPERUSER PASSWORD 'password';
	
--Connecting Database
	\c ajdb19;
	
--Creating Table
	CREATE TABLE student(
		rno int primary key,
		name varchar(20) not null,
		per float
	);
	
--Add Constraint To per Column
	ALTER TABLE student 
	ADD CONSTRAINT chk_percentage
	CHECK( per>=0 AND per<=100 );
	

--Insert Values
	INSERT INTO student VALUES(101, 'AAA', 67.8);
	INSERT INTO student VALUES(102, 'BBB', 35.8);
	INSERT INTO student VALUES(103, 'CCC', 95.88);
	
