# sparta-calculator
JAVA 계산기 과제
<br/><br/>
## 프로젝트 소개
자바 학습을 통해 배운 내용을 적용한 계산기입니다.
<br/><br/>
## 주요 기능
- 정수 사칙연산(+, -, *, /)
- exit 입력 시 프로그램 종료
- 연산 결과 저장 및 조회
- 저장된 결과 수정 및 삭제 기능
- 실수(Double) 연산 지원
- enum을 활용한 연산자 관리
- stream, lambda를 활용한 데이터 처리
- 예외 처리 (0으로 나누기 등)
<br/>

## 파일 구조
```text
example
├─calculator1
│      App.java
│
├─calculator2
│      App.java
│      Calculator.java
│
└─calculator3
        App.java
        ArithmeticCalculator.java
        OperatorType.java
```
- `calculator1`: step 1. 기본 계산기 구현 - 클래스 분리 없이 구현한 계산기
- `calculator2`: step 2. 객체지향 적용 - 클래스 분리 구현, 연산 결과를 조회하고 변경할 수 있는 계산기
- `calculator3`: step 3. 자바 고급 기능 적용 - enum, stream, lambda를 사용한 계산기
<br/>

## 구현 환경
- Java 17
- IntelliJ IDEA
<br/>

## 주요 기능 실행 결과
**1. calculator1.App**

<img width="600" height="356" alt="image" src="https://github.com/user-attachments/assets/7c8b4ced-9fb9-407f-a5f7-e58bcb7b93a2" />
<br/><br/>

**2. calculator2.App**

<img width="600" height="487" alt="image" src="https://github.com/user-attachments/assets/dbcc555c-0cd4-4cbc-baf4-f498e75027ed" />
<br/><br/>

**3. calculator3.App**

<img width="600" height="756" alt="image" src="https://github.com/user-attachments/assets/6e06242e-f6cb-402b-98be-c6a2941c2cf9" />
