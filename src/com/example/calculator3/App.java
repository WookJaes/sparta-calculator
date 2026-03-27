package com.example.calculator3;

import java.util.List;
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
            } catch (NumberFormatException e) {   // 예외 처리 (숫자를 입력하지 않는 경우)
                System.out.println("숫자를 입력해주세요!");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            String input = sc.next();

            if (input.length() != 1) {
                System.out.println("연산 기호는 한 글자만 입력해주세요!");
                continue;
            }
            char operator = input.charAt(0);  // 입력된 문자열 중 첫 번째 글자 (문자 1개)

            try {
                Number result = cal.calculate(num1, num2, operator);
                System.out.println("계산 결과는 " + result + " 입니다.");
                System.out.println("저장된 값:" + cal.getMemory()); // 연산 결과 조회 (getter)
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            while (true) {
                System.out.print("기준값을 입력해주세요: ");

                try {
                    Number num = parseNumber(sc.next());
                    List<Number> result = cal.findResult(num);

                    if (result.isEmpty()) {
                        System.out.println("기준값보다 큰 결과값이 없습니다!");
                    } else {
                        System.out.println("기준값보다 큰 결과값은 " + result + " 입니다.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자(정수 또는 실수)를 입력하세요!");
                }
            }

            System.out.print("첫 번째 계산 기록을 삭제 하시겠습니까? (Y/y 입력 시 삭제): ");
            String s = sc.next();
            if ("Y".equalsIgnoreCase(s)) {   // NPE 방지를 위해 상수.equalsIgnoreCase(변수) 형태 사용
                cal.removeResult();
            }
            System.out.println("저장된 값:" + cal.getMemory());

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String str = sc.next();
            if ("exit".equals(str)) {   // NPE 방지를 위해 상수.equals(변수) 형태 사용
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