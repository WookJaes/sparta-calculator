package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<Integer> list = new ArrayList<>();

    public int calculate (int num1, int num2, char op){

        int result = 0;

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
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
        }

        list.add(result);
        return result; // 결과 반환 후 종료
    }
}