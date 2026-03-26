package com.example.calculator2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

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

            } catch (Exception e) {   // 예외 처리 (숫자를 입력하지 않는 경우)
                System.out.println("숫자를 입력해주세요!");
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

            try {
                int result = cal.calculate(num1, num2, op);
                System.out.println("계산 결과는 " + result + " 입니다.");
                System.out.println("연산 결과:" + cal.getMem()); // 연산 결과 조회 (getter)

                // 메서드 값 변경 (setter)
                System.out.print("저장된 결과를 변경하시겠습니까? (Y/y 입력 시 변경): ");
                String str = sc.next();

                if (str.equalsIgnoreCase("Y")) {
                    boolean flag = true;    // flag를 사용하여 로직 처리 (입력 값이 잘못되면 기록 삭제 부분으로 이동하도록 설계)
                    int index = 0;
                    int value = 0;

                    try {
                        System.out.print("인덱스(0부터 시작)를 입력하세요: ");   // 정수를 입력하지 않으면 변경 과정 종료
                        index = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("정수만 입력해야 합니다!");
                        sc.nextLine();
                        flag = false;
                    }

                    if (flag && (index < 0 || index >= cal.getMem().size())) {   // 범위를 초과하면 변경 과정 종료
                        System.out.println("범위를 초과했습니다!");
                        flag = false;
                    }

                    if (flag) {
                        try {
                            System.out.print("변경할 값을 입력하세요: ");     // 정수를 입력하지 않으면 변경 과정 종료
                            value = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("정수만 입력해야 합니다!");
                            sc.nextLine();
                            flag = false;
                        }
                    }

                    if (flag) {
                        cal.setMem(index, value);
                        System.out.println("변경된 값:" + cal.getMem());
                    }
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("첫 번째 계산 기록을 삭제 하시겠습니까? (Y/y 입력 시 삭제): ");
            String s = sc.next();
            if (s.equalsIgnoreCase("Y")) {
                cal.removeResult();
            }
            System.out.println("저장된 값:" + cal.getMem());

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