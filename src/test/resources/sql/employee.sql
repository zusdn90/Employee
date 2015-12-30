select * from dept;

select * from emp;

drop table member;
--
--	Member table
--	DDL(Data Definition Language)
create table member (
	id 	int, 
	email varchar(255) not null,
	name varchar(255) not null,
	password varchar(255) not null,
	register_date date not null,
	constraint pk_member_id primary key (id)	
);
--
--	Member CRUD (Create, Read, Update, Delete)
-- 	DML(Data Manipulation Language)
--	Create

drop sequence member_id_generator
create sequence member_id_generator

--system table
select * from user_tables

select * from user_sequences

insert into member 
(id,email,name,password,register_date) 
values (member_id_generator.nextval,'xxx@hybrid.com','홍길동','1234','2015/12/21')

--	Read
select * from member;

--	Update
update member
	set name='홍순이',
		password='9876'
	where id = 5;

--	Delete
delete from member
	where id = 1;

--
-- city
--	
drop table city;

create table city (
  id 			numeric(11),
  name 			char(50) 	not null ,
  countrycode 	char(3)  	not null,
  district 		char(30) 	not null,
  population 	numeric(11) not null,
  constraint city_pk_id primary key 	(id)
);

select * from city;
drop sequence city_id_generator;
create sequence city_id_generator	start with 4090;
select city_id_generator.nextVal from dual;


insert into city
(
	name,
	countrycode,
	district,
	population)
values
(
	'seoul',
	'KOR',
	'Asia',
	99998)

--
-- inner join
-- left outer join
-- right outer join
--	
select 
      	d.deptno as dept_deptno,
      	d.dname as dept_dname,
      	d.loc as dept_loc,
      	e.empno as emp_empno,
      	e.ename as emp_ename,
      	e.job as emp_job
  from  emp e inner join dept d
   	on 	e.deptno = d.deptno
   
select 
      	d.deptno as dept_deptno,
      	d.dname as dept_dname,
      	d.loc as dept_loc,
      	e.empno as emp_empno,
     	e.ename as emp_ename,
      	e.job as emp_job 
 from 	emp e left outer join dept d
   on 	e.deptno = d.deptno
   
 select * from dept;
 select * from emp;
 
 select * from dept d inner join emp e
 	on d.deptno = e.deptno
 	where d.deptno = 81;
    
 select count(*) from city
 select * from CITY
 
 select *
   from city
  order by countrycode asc, name asc 
  
  
  select outer.*
    from ( select rownum r, inner.*
    		 from ( select *
    		 		  from city 
    		 		  order by countrycode asc, name asc
    		 	   )inner	
    	  ) outer
  	where outer.r >= 21
 	and	outer.r <= 30
  	
 
 delete from city
 /*
  *	Country 
  */
 create table country (
  	code 				char(3), 
    name 				char(52),
  	continent			char(50),
    regio 				char(26), 
    surfacearea 		numeric(10,2),
    indepyear 			numeric(6),
    population 			numeric(11),
    lifeexpectancy 		numeric(3,1),
    gnp 				numeric(10,2),
    gnpold 				numeric(10,2),
    localname 			char(45),
    governmentform 		char(45),
    headofstate 		char(60),
    capital 			numeric(11),
    code2 				char(2),
    constraint pk_country_code primary key (code)
) 

select * from country
