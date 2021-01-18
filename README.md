## 마크다운(Markdown) 문법

### 1.1 # 으로 헤더 설정하기
 
# This is H1
## This is H2
### This is H3
#### This is H4
##### This is H5
###### This is H6
#### H1 ~ H6 까지 사용 가능.

### 1.2 블록 인용구 (Block quote) : >
~~~
> 으로 시작하는 텍스트.~~~
>>, >>> 처럼 사용하면 여러 층 사용
~~~
> This is block quote.
>> I can hightlight lines
>> And also do on multiple levels!

### 1.3 코드 (Code)
- 코드 블럭 (Code Block) : ''' 혹은 \~\~~으로 감싼 텍스트
- 혹은 줄의 맨 앞에 스페이스 4개가 삽입되었을 때.
- 인라인 코드 (Inline Code) : \`로 감싼 텍스트

```This is code block```

 
### https://gist.github.com/ihoneymon/652be052a0727ad59601

FOREIGN KEY (task_id) REFERENCES tasks (task_id) ON UPDATE RESTRICT ON DELETE CASCADE


음식점.  (배민)

1. 로그인, 회원가입
2. 음식점 리스트 쭈우우욱
3. 라디오 버튼으로 메뉴별 리스트 나타내기 
4. 콤보박스로 동네별 리스트 나타내기
5. 리스트에 메뉴이름과 가격.



idx, 음식점명, 취급음식, 주소 (INNER JOIN 동별 우암동, 사직동, 서원동), 가격



6. 로그인한 사람 주문리스트.
7. 관리자는 음식과 회원관리를 할 수 있게함.   
CREATE TABLE `javadb`.`delivery` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `kind` VARCHAR(45) NOT NULL,
  `menu` VARCHAR(45) NOT NULL,
  `addr` VARCHAR(100) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idx`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('우리중국집', '짜장면', '우암동', '123-4567', 15000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('뚱이치킨집', '양념치킨', '사직동', '123-5123', 14000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('디비피자집', '포테이토피자', '우암동', '123-4953', 5700);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('디비피자집', '고구마피자', '우암동', '123-4953', 5700);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('별이치킨집', '후라이드치킨', '우암동', '123-2123', 10000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('별이치킨집', '간장치킨', '우암동', '123-2123', 11000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('우리중국집', '짬뽕', '우암동', '123-4567', 15000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('메롱피자집', '고구마피자', '서원동', '123-4513', 10000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('콩이치킨집', '간장치킨', '서원동', '123-4943', 6000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('콩이치킨집', '후라이드치킨', '서원동', '123-4943', 6000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('대한중국집', '짜장면', '사직동', '123-0987', 12000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('맹구치킨집', '양념치킨', '사직동', '123-2223', 11000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('디디피자집', '고구마피자', '사직동', '123-4523', 11000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('한국치킨집', '간장치킨', '서운동', '123-3223', 11000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('한국치킨집', '후라이드치킨', '서운동', '123-3223', 11000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('디디피자집', '불고기피자', '사직동', '123-4523', 12000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('대한중국집', '짬뽕', '사직동', '123-0987', 13000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('우리중국집', '탕수육', '우암동', '123-4567', 1000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('미래중국집', '짜장면', '서원동', '123-2222', 9000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('별이치킨집', '양념치킨', '우암동', '123-2123', 11000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('디비피자집', '불고기피자', '우암동', '123-4953', 5700);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('디디피자집', '포테이토피자', '사직동', '123-4523', 12000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('과거중국집', '짜장면', '우암동', '123-1111', 10000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('대한중국집', '탕수육', '사직동', '123-0987', 13000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('메롱피자집', '포테이토피자', '서원동', '123-4513', 10000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('안녕중국집', '짬뽕', '사직동', '123-5566', 12000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('콩이치킨집', '양념치킨', '서원동', '123-4943', 6000);
INSERT INTO delivery(`kind`, `menu`, `addr`, `number`, `price`) VALUES ('안녕중국집', '탕수육', '사직동', '123-5566', 15000);

