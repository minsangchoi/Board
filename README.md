# Board
전반적인 웹의 기본 소양이 되는 게시판 프로젝트입니다.
# 1. 프로젝트 소개
프로젝트를 시작하게 된 계기는 웹 프로그래밍의 기본 소양이라 할 수 있는 게시판을 직접 만들어보며 인강으로 관련 기술들을 학습한 이후 
배운 내용들을 복습하고자 시작하게 되었습니다.

# 2. 프로젝트 기능
프로젝트의 주요 기능은 다음과 같습니다.

* 게시판 - CRUD 기능, 조회수, 페이징 및 검색 처리 
* 댓글 - CRUD 기능
 
# 3. 주요 프레임워크 / 라이브러리
* Java 17
* SpringBoot 3.2.4
* JPA(Spring Data JPA)
* H2 DataBase
  
# 4. 구조 및 설계

* 테이블 설계 <br>
![ERD](https://github.com/user-attachments/assets/dd943aa8-f868-45c0-ab07-a47ad69d3617)
![테이블스펙](https://github.com/user-attachments/assets/71f9307d-539b-4ce8-acc1-e658b9f50510)

* API 설계 <br>
![API명세서](https://github.com/user-attachments/assets/1f2bf387-94c5-445b-bcc3-f71e3ebb8e81)

# 5. 실행화면
* 회원가입 <br>
![회원가입](https://github.com/user-attachments/assets/fdb03c70-bfd6-4dbe-b16d-3a5de2192f1b)

* 로그인 <br>
![로그인](https://github.com/user-attachments/assets/3bc7daa4-ec97-4350-abe5-6f99143f3357)

* 메인 <br>
![메인](https://github.com/user-attachments/assets/ae22f992-e53d-4c2b-9e6e-733cc6e38b8f)

* 댓글 <br>
![댓글](https://github.com/user-attachments/assets/ecda0e3c-46a1-4533-a850-75021a577d8c)

# 6. 후기
1. 프로젝트 보완사항 웹 프로그래밍의 기본적인 요소인 CRUD, 즉 Create, Read, Update, Delete 기능을 가진 게시판을 만드는 것이 이 프로젝트의 초기 목표였습니다. 템플릿 엔진으로는 타임리프를 선택했습니다. 타임리프는 서버 사이드에서 자바 코드를 이용해 데이터를 처리하고, HTML과 자연스럽게 통합되어 웹 페이지를 동적으로 생성하는 데 유용하기 떄문입니다. 

2. 이 프로젝트는 혼자서 독학하며 처음으로 만들어본 프로젝트였습니다. 공부한 내용을 실제로 적용해보는 설렘과 함께, 부족한 부분에 대한 아쉬움도 많이 느꼈습니다. 효율적인 설계를 위해 많은 고민을 하고, 여러 가지 문제를 해결하면서 많은 것을 배울 수 있었습니다. 이 로직은 이 단계에서 처리하는 것이 맞는가, 각 레이어간 데이터 전달은 어떤 방식이든 DTO로 하는 것이 맞는가 등 여러 가지 고민을 했습니다.  또한 내가 작성한 코드를 다른 사람에게 보여주고, 그들이 코드의 근거를 물어볼 때, 나의 생각을 자신 있게 말할 수 있을까 하는 생각을 많이 했습니다. 이로 인해, 하나를 구현할 때 이렇게 구현하는 것이 과연 최선인가, 더 나은 Best Practice는 없을까라는 의문을 가지고 스스로 고민하게 되었습니다.
기술적인 부분에서 더 공부하고 싶은 방향을 찾을 수 있었습니다. 이 프로젝트는 저에게 좋은 경험이었고, 저의 부족한 부분을 스스로 알 수 있는 좋은 계기가 되었습니다.
