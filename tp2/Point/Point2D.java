package tp2.Point;

// Question 7 : Point en 2 dimensions
public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double dot(Point2D other) {
        return this.x * other.getX() + this.y * other.getY();
    }

    public Point2D add(Point2D other) {
        return new Point2D(this.x + other.getX(), this.y + other.getY());
    }

    public double distance(Point2D other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    public double distanceManhattan(Point2D other) {
        return Math.abs(this.x - other.getX()) + Math.abs(this.y - other.getY());
    }

    public double norm() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}