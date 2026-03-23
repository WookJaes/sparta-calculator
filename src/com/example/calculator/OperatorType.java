package com.example.calculator;

public enum OperatorType {
    PLUS('+'){
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS('-'){
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*'){
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/'){
        @Override
        public int calculate(int num1, int num2) {
            if (num2 == 0){
                throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    private final char op;

    public abstract int calculate(int num1, int num2);

    // enum 클래스는 자체적으로 객체를 만들어서 사용함
    OperatorType(char op) {
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    public static OperatorType findByOp(char op){
        return switch (op) {    // switch 표현식으로 변경
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
        };
    }
}