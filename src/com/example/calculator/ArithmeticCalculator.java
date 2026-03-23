package com.example.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticCalculator {
    private List<Integer> mem = new ArrayList<>();

    public int calculate (int num1, int num2, char op) {
        OperatorType operator = OperatorType.findByOp(op);
        int result = operator.calculate(num1, num2);
        mem.add(result);
        return result; // 결과 반환 후 종료
    }

    public void removeResult() {
        if(mem.isEmpty()){
            System.out.println("삭제할 결과가 없습니다.");
        } else {
            mem.remove(0);
        }
    }

    public List<Integer> getMem() { // 캡슐화를 위해 불변 리스트로 반환
        return Collections.unmodifiableList(mem);
    }
}