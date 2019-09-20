package chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 20:50
 * @Description Wildcard type for parameter that serves as an T producer (page 141)
 * @Version 0.0.1
 */
public class Chooser<T> {
    private final List<T> choiceList;
    private final Random rnd = new Random();

    public Chooser(Collection<? extends T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        Chooser<Number> chooser = new Chooser<>(intList);
        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}
