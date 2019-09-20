package chapter2.item2.hierarchicalbuilder;
import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 11:34
 * @Description 构造者模式用于继承层次 page 14
 * Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies,
 * not just builders
 * @Version 0.0.1
 */
public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        // 创建一个空的枚举类型集合
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }
    
    Pizza(Builder<?> builder) {
        // See Item 50
        toppings = builder.toppings.clone();
    }
}
