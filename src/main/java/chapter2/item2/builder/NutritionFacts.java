package chapter2.item2.builder;

import lombok.ToString;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/24 22:11
 * @Description 建造者模式
 * @Version 0.0.1
 */
@ToString
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/24 22:16
     * @Description 定义静态内部类
     * @Version 0.0.1
     */
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/24 22:16
     * @Description 定义私有构造函数
     * @Params [builder]
     * @Return
     * @Version 0.0.1
     */
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println("args = [" + cocaCola + "]");
    }
}