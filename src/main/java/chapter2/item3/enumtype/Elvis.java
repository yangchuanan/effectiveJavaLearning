package chapter2.item3.enumtype;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:15
 * @Description 使用枚举实现单例模式
 * Enum singleton - the preferred approach (Page 18)
 * @Version 0.0.1
 */
public enum Elvis {
    // 单例
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }


    public static void main(String[] args) {
        // 获取单例
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
