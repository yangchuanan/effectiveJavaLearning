package chapter6.item38;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 22:52
 * @Description Emulated extensible enum using an interface - Basic implementation (Page 176)
 * @Version 0.0.1
 */
public enum BasicOperation implements Operation {
    /**
     *
     */
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
