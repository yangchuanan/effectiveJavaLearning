package chapter7.item45;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 18:03
 * @Description Refrain from using streams to process char values (Page 206)
 * @Version 0.0.1
 */
public class CharStream {
    public static void main(String[] args) {
        // Does not produce the expected result
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();

        // Fixes the problem
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}
