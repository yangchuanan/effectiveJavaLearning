package chapter7.item42;

import java.util.function.DoubleBinaryOperator;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/5 21:38
 * @Description Enum with function object fields & constant-specific behavior (Page 195)
 * 拥有对象与以及函数，并具有行为的枚举类型
 * @Version 0.0.1
 */
public enum Operation {
    /**
     *
     */
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    /**
     * Main method from Item 34 (Page 163)
     */
    public static void main(String[] args) {
        Operation operation = Operation.PLUS;
        double x = Double.parseDouble("2.0");
        double y = Double.parseDouble("5");
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}
