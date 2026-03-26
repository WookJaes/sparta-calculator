package com.example.calculator1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            int num1;
            int num2;

            try {   // 0 이상의 정수만 입력받도록 예외 처리
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = sc.nextInt();

                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요!");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = sc.nextInt();

                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("숫자(정수)를 입력해주세요!");
                sc.nextLine(); // nextInt()로 읽어온 문자 제거
                continue;   // while 복귀
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            String input = sc.next();

            if (input.length() != 1) {
                System.out.println("연산 기호는 한 글자만 입력해주세요!");
                continue;
            }
            char op = input.charAt(0);  // 입력된 문자열 중 첫 번째 글자 (문자 1개)

            int result = 0;
            boolean flag = true;

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        flag = false;   // 잘못된 연산의 경우 결과값이 나오면 안된다.
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 연산 기호를 입력하세요. (+, -, *, /)");
                    flag = false;   // 잘못된 연산의 경우 결과값이 나오면 안된다.
            }

            if (flag) {
                System.out.println("계산 결과는 " + result + " 입니다.");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String str = sc.next();
            if (str.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        sc.close();

    }
}