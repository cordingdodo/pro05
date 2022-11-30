#project 05
spring boot + gradle + java8 + mySql + bootstrap(Admin_LTE)

주제 : nike 홈페이지/쇼핑몰 구현
주제 선정 이유 : 평소 좋아하던 브랜드 나이키로 쇼핑몰 구현을 해보았다
개발 언어:spring boot + gradle + java8 + mySql + bootstrap(Admin_LTE)

구현 주제
1. 상품 관리
2. 게시판 관리
3. 로그인 관리
4. 배송 관리

DB 설계
mysql 사용자 : root | pw : a1234

<상품 관리>
1. 상품 테이블
create table product(
  proNo int primary key auto_increament, --auto 상품 번호
  cateNO int not null, --카테고리 번호
  proName varchar(50) not null, --상품 이름
  proSpec varchar(1000) not null, --상품 상세 정보
  oriPic int not null, --원가
  disCountRate double, --할인율
  proPic varchar(300), --제품 사진
  proPic2 varchar(300), --제품 사진2
  ); 

2. 결제 테이블
create table payment(
  salePayNo int primary key auto_increament, --auto 번호
  paymethod varchar(30) not null, --결제 수단
  paycom varchar(50) not null, --결제 대행사
  cardNum varchar(50) not null, --결제 카드 번호
  payAmount int not null --총 결제 금액
  );
  
  
3. 배송 테이블 
create table parsel(
  parselNo int primary key auto_increament, --auto 번호
  parselAddr varchar(500), --배송 주소
  cusTel varchar(20), --고객 번호
  parselCompany varchar(50), --배송 회사
  parselTel varchar(30), --배송기사 번호
  parselState int default 0 --배송 상태
  );
  

4. 판매 테이블
create table sales(
  saleNo int primary key auto_increament, --auto 번호
  cusId varchar(50) not null, --고객 아이디
  proNo int not null, --상품 번호
  amount int nout null, --판매 수량
  saleDate date default now() not null, --판매일
  pareselNo int, --배송 코드
  salePayNo int, --결제 번호
  parseState int default 0, --배송 상태
  parselCompany varchar(50) --배송 회사
  );
  

<게시판 관리>
1. 게시판 테이블
create table notice(
  seq int primary key, auto_increament, --auto 번호
  title varchar(30) not null, --제목
  content varchar(1000) not null, -내용
  author varchar(20) not null, --글쓴이
  regdate date default now(), --글 작성일
  visited int --조회수
  );

2. QNA
create table qna(
  qNo int primary key, auto_increament, --auto 번호
  qtitle varchar(50) not null, --제목
  qcontent varchar(1000) not null, -내용
  qauthor varchar(20) not null, --글쓴이
  qregdate date default now(), --글 작성일
  qvisited int, --조회수
  qnum int not null --질문0 / 답변1
  qscreate int not null -- 공개0 / 비공개1

<로그인 관리>
1. 멤버 테이블
create table member(
  id varchar(30) primary key,
  pw varchar(30) not null,
  tel varchar(30) not null,
  addr varchar(100) not null,
  visited int,
  rank varchar(10)
  );
  
