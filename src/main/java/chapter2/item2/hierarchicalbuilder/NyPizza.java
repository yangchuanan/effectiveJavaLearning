package chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 13:58
 * @Description Subclass with hierarchical builder (Page 15)
 * @Version 0.0.1
 */
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        /**
         * @Author Chuanan YANG
         * @DateTime 2019/8/25 14:02
         * @Description 构造函数
         * @Params [size]
         * @Version 0.0.1
         */
        public Builder(Size size) {
            // 验证size非空
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() { return this; }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return "New York Pizza with " + toppings;
    }
}
