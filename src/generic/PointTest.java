package generic;

public class PointTest {

    public static <T, V> double makeRectangle(Point<T, V> p1, Point<V, T> p2) {
        double right = ((Number) p1.getX()).doubleValue();
        double left = ((Number) p2.getX()).doubleValue();
        double top = ((Number) p1.getY()).doubleValue();
        double bottom = ((Number) p2.getY()).doubleValue();

        double width = right - left;
        double height = top - bottom;

        return width * height;
    }

    public static void main(String[] args) {

        Point<Integer, Double> p2 = new Point<>(0, 0.00);
        Point<Double, Integer> p1 = new Point<>(12.5, 2);

        double rectSize = PointTest.makeRectangle(p1, p2);
        System.out.println(rectSize);
    }
}
