--================================
-- 관리자 (system) 계정
--================================
-- jake 계정 생성
create user jake
identified by jake
default tablespace users;

grant connect, resource to jake;


--================================
-- jake 계정
--================================
create table member (
		member_id varchar2(15),                          --PK
		password varchar2(300) not null,              --필수
		member_name varchar2(30) not null,        --필수
		member_role char(1) default 'U' not null,    --필수
		gender char(1),
		birthday date,
		email varchar2(100),
		phone char(11) not null,                           --필수
		address varchar2(200),
		hobby varchar2(100),
		enroll_date date default sysdate,
		constraint pk_member_id primary key(member_id),
		constraint ck_gender check(gender in ('M', 'F')),
		constraint ck_member_role check(member_role in ('U', 'A'))
);

desc member;

insert into member values (
'kimpembe', '1234', '김뱀배', 'U', 'M', to_date('19950813','yyyymmdd'),
'kimpembe@naver.com', '01012341234', '서울시 동작구', '운동,등산', default);

insert into member values (
'ummepe', '1234', '황희찬', 'U', 'M', to_date('19950126','yyyymmdd'),
'ummepe@naver.com', '01012341234', '강원도 춘천시', '운동,등산,게임', default);

update member
set birthday = to_date('19960126','yyyymmdd')
where member_name = '황희찬';

insert into member values (
    'admin', '1234', '관리자', 'A', 'M', to_date('19901225','yyyymmdd'),
    'admin@naver.com', '01056785678', '서울시 관악구', '여행,독서', default);

select * from member;
commit;













