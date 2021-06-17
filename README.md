
# GROUP E ROOM
![Group E Room-logo](https://user-images.githubusercontent.com/77327044/122395429-f0bcd400-cfb1-11eb-9fe2-a850eb313396.png)
------------
## 팀원 
김동준, 이혜성, 조혜리, 한정서

------------
## 수행기간
2021년 4월 26일 ~ 6월 15일

------------


## Contetns

1. [개요](#개요)
2. [설계의 주안점](#설계의-주안점)
3. [사용기술 및 개발환경](#사용기술-및-개발환경)
4. [프로젝트 기능 구현](#프로젝트-기능-구현)
5. [주요기능](#주요-기능)
6. [Document](#Document)

------------

## 개요
+ 많은 기업에서 그룹웨어 사용이 보편화 되어있지만 소기업 혹은 청년층이 주인 스타트업 기업에서 사용할 수 있는 가벼운 그룹웨어가 부재해 이에 필요성을 느꼈습니다.
따라서 우리의 목표는 업무에 꼭 필요한 기능만 추가하여 라이트하지만 업무 능률을 향상시킬 수 있는 그룹웨어를 구현하는 것입니다.
------------

## 설계의 주안점
- LG의 그룹웨어 프로그램 'U+윅스', '워크 플로우 전자결재 시스템' 과 같은 사이트를 참고하였습니다.
위와 같은 타사와 전체적인 기능은 비슷하지만, 'GroupEroom'은 소형 기업 및 전자 결재, 부서별 소통, 현황에 더욱 집중하여 업무의 능률 향상 효과를 기대할 수 있습니다.
또 한, 개인 다이어리를 쓰는 듯한 느낌을 줄 수 있도록 퍼스널 서비스도 추가하였으며, 접근성을 용이하기 위해 Web기반 플랫폼으로 설계의 주안점을 두었습니다.

------------
## 사용기술 및 개발환경
![화면 캡처 2021-06-17 203027](https://user-images.githubusercontent.com/77327044/122388508-e814cf80-cfaa-11eb-93e9-02763c73c58e.png)

Category | Detail
---- | ----
Laguage & Library | HTML5, JS, CSS, Java, JSP, jQuery, Ajax
API | OpenWeatherMap, FullCalendar, SummerNote
IDE | Eclpise
Server | Tomcat(v8.5)
Document | draw.io, ERDCloud, Figma
CI | Github
DataBase | Oracle 11g
FramWork | Spring, Bootstrap

------------
## 프로젝트 기능 구현


- 공통
    - 프로젝트 주제 선정 및 기획 
    - 플로우차트, 유스케이스 다이어그램 설계
    - DB & 클래스, 시퀸스 다이어그램 설계
    - 프로젝트 문서 작업
<br><br>

- 김동준
  - 로그인 
    - 초기비밀번호'1234' , 비밀번호 변경(중복체크)Ajax
  - 공지사항(CRUD)
     - 페이징,검색처리,조회수증가,썸머노트api,업로드파일등록
   - 인사관리
     - 사원등록(유효성검사(js),이메일중복체크(Ajax),주소api ,프로필사진등록(썸네일미리보기)등등
     - 사원목록(상세페이지,수정페이지 등 기타 CSS)
<br><br>

- 이혜성
  - 전자결재
    - <결재 작성>
      - SummerNote 사용
      - 문서 종류, 조직도를 활용한 결재선 2명 선택
<br>
   - <진행함>, <미결함>, <완료함>, <반려함>
     - 게시글 수정, 삭제, 조회, 페이징
     - 댓글 등록, 삭제
  
   - 회의실 예약
     - fullCalendar 사용
     - 일정 등록, 수정, 삭제

  - 채팅
     - Web Socket을 이용한 실시간 채팅 (M:N)

 <br><br>
   
- 조혜리
  

<br><br>  
   
- 한정서
  - 근태관리
     - 근무일 수 조회, 부여 연차(근무일 수 마다 차등부여) 조회
     - 연차(연차, 오후 ,오전, 경조사) 자동 신청/등록, 연차 취소(당일까지 가능), 
     <br>
  - 일정관리
   - <캘린더>
     - fullCalendar 사용
     - 클릭, 드래그-개인 일정 등록(메모, 색상 선택), 수정 ,삭제
   - <할 일>
     - 할 일 등록 (중요도 선택), 수정(+완료) , 삭제
     <br>
  - 동호회 게시판
      - SummerNote 사용
      - 게시글 등록, 수정, 삭제, 조회 , 검색, 페이징
      - 댓글 수정, 삭제, 등록 , 대댓글 작성가능
     <br>
  - 투표
      - 투표등록(결과공개/비공개, 익명/실명, 투표기간, 투표대상 선택가능), 투표 삭제
      - 투표 결과 조회( bar 차트)
  
<br><br>

------------
## 주요 기능
[기획보고서_그룹이룸_텔레토비_최종.pdf](https://github.com/Team-Teletubby/GroupEroom/files/6669828/_._._.pdf)


------------ 
## Document

### 1. ERD
![화면 캡처 2021-06-17 203626](https://user-images.githubusercontent.com/77327044/122389253-b6e8cf00-cfab-11eb-9224-658ec13c6fec.png)


------------ 
## 시연 영상




