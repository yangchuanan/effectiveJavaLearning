package chapter2.item2.hierarchicalbuilder;

import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;
import static chapter2.item2.hierarchicalbuilder.NyPizza.Size.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:05
 * @Description Using the hierarchical builder (Page 16)
 * @Version 0.0.1
 */
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        
        System.out.println(pizza);
        System.out.println(calzone);
    }
}
