package chapter6.item35;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:49
 * @Description Enum with integer data stored in an instance field (Page 168)
 * 用实例域代替序数，将值保存在实例域中
 * @Version 0.0.1
 */
public enum Ensemble {
    /**
     *
     */
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;
    Ensemble(int size) { this.numberOfMusicians = size; }
    public int numberOfMusicians() { return numberOfMusicians; }
}