CREATE TABLE account (
		acc_no int primary key,
		name varchar(20),
		balance float
);


insert into account values(101,'AAA',10000);
insert into account values(102,'BBB',7000);

select * from account;

