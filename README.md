# sparta-calculator
JAVA 계산기 과제

## 프로젝트 소개
자바 학습을 통해 배운 내용을 적용한 계산기입니다.

## 주요 기능
- 정수 사칙연산(+, -, *, /)
- exit 입력 시 프로그램 종료
- 연산 결과 저장 및 조회
- 저장된 결과 수정 및 삭제 기능
- 실수(Double) 연산 지원
- enum을 활용한 연산자 관리
- Stream, Lambda를 활용한 데이터 처리
- 예외 처리 (0으로 나누기 등)

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
- `calculator1`: step 1. 기본 계산기 구현 - 클래스 사용 없이 구현하는 계산기
- `calculator2`: step 2. 객체지향 적용 - 클래스 분리 및 연산 결과를 조회, 변경할 수 있는 계산기
- `calculator3`: step 3. 자바 고급 기능 적용 - Enum, Stream, Lambda를 적용한 계산기

## 구현 환경
- Java 17
- IntelliJ IDEA
