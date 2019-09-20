package chapter4.item18;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:29
 * @Description Broken - Inappropriate use of inheritance! (Page 87)
 * @Version 0.0.1
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        // 打印的数字为6 父类的addAll 方法会调用add方法
        System.out.println(s.getAddCount());
    }
}
