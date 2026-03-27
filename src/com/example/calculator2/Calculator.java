package com.example.calculator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private final List<Integer> memory = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {

        int result;

        switch (operator) {
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

        memory.add(result);
        return result; // 결과 반환 후 종료
    }

    public void removeResult() {
        if (memory.isEmpty()) {
            System.out.println("삭제할 결과가 없습니다.");
        } else {
            memory.remove(0);
        }
    }

    public List<Integer> getMemory() {
        return Collections.unmodifiableList(memory);   // 불변 객체
    }

    // 내부 데이터가 변경되어 캡슐화의 의미가 약해진다.
    // 특정 위치의 값만 변경
    public void setMemory(int index, int value) {
        memory.set(index, value);
    }
}