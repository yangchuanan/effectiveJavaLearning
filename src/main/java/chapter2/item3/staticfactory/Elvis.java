package chapter2.item3.staticfactory;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:08
 * @Description 实现单例工厂模式
 * Singleton with static factory (Page 17)
 * @Version 0.0.1
 */
public class Elvis {
    // 静态字段初始化
    private static final Elvis INSTANCE = new Elvis();

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:09
     * @Description 构造函数私有化
     * @Version 0.0.1
     */
    private Elvis() {
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:10
     * @Description 静态工厂方法
     * @Version 0.0.1
     */
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        // 获取单例
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
