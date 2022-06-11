create database mmpdb; -- member management program
use mmpdb;

create table membertbl( -- 회원 테이블
	m_Num int not null auto_increment primary key,
    m_Name varchar(10) not null,
    m_Phone varchar(20) not null,
    m_Home varchar(20) not null
);

create table programtbl( -- 프로그램 테이블
	p_Code varchar(10) primary key,
    p_Name varchar(20) not null,
    p_Week varchar(20) not null,
    p_Time varchar(10) not null,
    p_MaxMem int not null
);

create table registrationtbl( -- 등록 테이블
	r_Num int not null auto_increment primary key,
    m_Num int not null,
    p_Code varchar(10) not null,
	foreign key (m_Num) references membertbl(m_Num),
    foreign key (p_Code) references programtbl(p_Code)
);

-- 테이블 보기
select * from membertbl;
select * from programtbl;
select * from registrationtbl;

-- 테이블 키 보기
show keys from membertbl;
show keys from programtbl;
show keys from registrationtbl;

-- 임시 데이터 삽입
-- 멤버 테이블
insert into membertbl values ( null, '윤현우', '01011112222', 'A101');
insert into membertbl values ( null, '이연호', '01033334444', 'B501');
insert into membertbl values ( null, '이동준', '01044445555', 'A101');

-- 프로그램 테이블
insert into programtbl values ('H01', '헬스', '월,수,금','오전','12');
insert into programtbl values ('H02', '헬스', '월,수,금','오후','12');
insert into programtbl values ('Y01', '요가', '화,목,토','오전','12');

-- 등록 테이블
insert into registrationtbl values ( null, 1, 'H01');
insert into registrationtbl values ( null, 2, 'H02');
insert into registrationtbl values ( null, 3, 'Y01');


-- 등록 화면
select r_Num as '등록번호', m.m_Name as '회원명',
		p.p_Code as '수업코드', p.p_Name as '프로그램명', p.p_Week as '요일',
		p.p_Time as '시간', p.p_Maxmem as '최대인원'
        from registrationtbl r
        inner join membertbl m
        on r.m_Num = m.m_Num
        inner join programtbl p
        on r.p_Code = p.p_Code
        order by r_Num;
        
-- view 생성
create view v_r_tbl 
as
select r_Num as '등록번호', m.m_Name as '회원명',
		p.p_Code as '수업코드', p.p_Name as '프로그램명', p.p_Week as '요일',
		p.p_Time as '시간', p.p_Maxmem as '최대인원'
        from registrationtbl r
        inner join membertbl m
        on r.m_Num = m.m_Num
        inner join programtbl p
        on r.p_Code = p.p_Code
        order by r_Num;
        
select * from v_r_tbl;