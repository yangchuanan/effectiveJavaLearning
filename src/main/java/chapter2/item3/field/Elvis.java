package chapter2.item3.field;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:12
 * @Description 静态字段实现单例，不提供静态工厂方法
 * Singleton with public final field  (Page 17)
 * @Version 0.0.1
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        // 获取单例
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}