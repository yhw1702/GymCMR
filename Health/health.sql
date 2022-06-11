use health;
-- 회원 테이블
select * from member;
drop table if exists member;
create table member(
	memberNum int auto_increment not null primary key,
    name varchar(6) not null,
    phoneNum varchar(20) not null,
    apartNum varchar(10) not null
);
insert into member(name,phoneNum,apartNum) values ('홍길동', '01012341234','A101');
delete from member where name in (select name from member where name = '홍길동');
update member set apartNum = 'A101' where name = '홍길동';

-- 프로그램 테이블
select * from Program;
create table Program(
	programCode varchar(5) not null primary key,
    programName varchar(20) not null,
    day varchar(10) not null,
    time varchar(10) not null,
    MaxPeople int not null
);
insert into Program values('A01','요가','월수금','오전',15);
insert into Program values('A02','요가','화목토','오후',15);
insert into Program values('B01','헬스','월수금','오전',10);
insert into Program values('B02','헬스','화목토','오후',10);

-- 등록 테이블
select * from Registeration;
create table Registeration(
	registNum int auto_increment primary key,
    programName varchar(20) not null,
    day varchar(10) not null,
    time varchar(10) not null,
    MaxPeople int not null
);