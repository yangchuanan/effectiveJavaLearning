package chapter6.item34;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:30
 * @Description Takes earth-weight and prints table of weights on all planets (Page 160)
 * @Version 0.0.1
 */
public class WeightTable {
   public static void main(String[] args) {
      double earthWeight = Double.parseDouble("10");
      double mass = earthWeight / Planet.EARTH.surfaceGravity();
      for (Planet p : Planet.values()) {
         System.out.printf("Weight on %s is %f%n",
                 p, p.surfaceWeight(mass));
      }
   }
}
