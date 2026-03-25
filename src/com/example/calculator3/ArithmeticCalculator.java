package com.example.calculator3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticCalculator {

    private final List<Number> mem = new ArrayList<>(); // Integer, Double 타입 결과 저장 가능

    // 서로 다른 타입의 입력값을 처리하기 위해 제네릭 메서드 사용
    public <T extends Number, R extends Number> Number calculate(T num1, R num2, char op) {
        OperatorType operator = OperatorType.findByOp(op);

        Number result;

        if (num1 instanceof Integer && num2 instanceof Integer) {   // 입력값이 모두 정수인 경우 int 사용
            result = operator.operate(num1.intValue(), num2.intValue());
        } else {    // 실수가 입력되면 double 사용
            result = operator.operate(num1.doubleValue(), num2.doubleValue());
        }

        mem.add(result);
        return result; // 결과 반환 후 종료
    }

    public void removeResult() {
        if (mem.isEmpty()) {
            System.out.println("삭제할 결과가 없습니다.");
        } else {
            mem.remove(0);
        }
    }

    public List<Number> getMem() { // 캡슐화를 위해 불변 리스트로 반환
        return Collections.unmodifiableList(mem);
    }

    // 저장된 결과 중 입력값보다 큰 값만 조회
    public List<Number> findResult(Number num) {
        return mem.stream()
            .filter(result -> result.doubleValue() > num.doubleValue())
            .toList();  // 불변 리스트
    }
}