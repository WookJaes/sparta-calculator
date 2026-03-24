package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator cal = new ArithmeticCalculator();

        while (true) {

            Number num1;
            Number num2;

            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = parseNumber(sc.next());

                if (num1.doubleValue() < 0) { // int 타입은 소수점이 사라지기 때문에 double 타입 사용
                    System.out.println("0 이상의 숫자를 입력해주세요!");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = parseNumber(sc.next());

                if (num2.doubleValue() < 0) {
                    System.out.println("0 이상의 숫자를 입력해주세요!");
                    continue;
                }
            } catch (Exception e) {   // 예외 처리 (숫자를 입력하지 않는 경우)
                System.out.println("숫자를 입력해주세요!");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);  // 입력된 문자열 중 첫 번째 글자(문자 1개)

            try {
                Number result = cal.calculate(num1, num2, op);
                System.out.println("계산 결과는 " + result + " 입니다.");
                System.out.println("저장된 값 :" + cal.getMem()); // 연산 결과 조회 (getter)
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("첫 번째 계산 기록을 삭제 하시겠습니까? (Y/y 입력 시 삭제): ");
            String s = sc.next();
            if (s.equalsIgnoreCase("Y")) {
                cal.removeResult();
            }
            System.out.println("저장된 값 :" + cal.getMem());

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String str = sc.next();
            if (str.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        sc.close();

    }

    private static Number parseNumber(String input) {   // 입력값 파싱
        if (input.contains(("."))) {
            return Double.parseDouble(input);   // double형 변환
        }
        return Integer.parseInt(input); // int형 변환
    }
}