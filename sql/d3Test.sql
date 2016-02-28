create database if not exists d3Test;
use d3Test;

drop table if exists d3;
create table d3(
	id int not null primary key auto_increment,
	test1 int,
	test2 int,
	test3 int
	);
insert into d3(test1,test2)values(200,300);
insert into d3(test1,test2,test3)values(200,300,400);