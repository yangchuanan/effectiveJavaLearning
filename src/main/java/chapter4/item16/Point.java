package chapter4.item16;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:24
 * @Description Encapsulation of data by accessor methods and mutators  (Page 78)
 * @Version 0.0.1
 */
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
}
