create database mmpdb;
use mmpdb;

create table membertbl( -- 회원 테이블
	m_Num int not null auto_increment primary key,
    m_Name varchar(10) not null,
    m_Phone varchar(20) not null,
    m_dong varchar(10) not null,
    m_ho varchar(10) not null
);

create table programtbl( -- 프로그램 테이블
	p_Code int not null auto_increment primary key,
    p_Name varchar(20) not null,
    p_Week varchar(20) not null,
    p_Time varchar(10) not null,
    p_MaxMem int not null
);

create table registtbl( -- 등록 테이블
	r_Num int not null auto_increment primary key,
	r_Name varchar(20) not null,
    r_Program varchar(20) not null,
    r_Week varchar(20) not null,
    r_Time varchar(20) not null,
    r_Maxmem int not null
);

-- 테이블 보기
select * from membertbl;
select * from programtbl;
select * from registtbl;