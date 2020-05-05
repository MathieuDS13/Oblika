package licence.projet.oblika.model;

public class CircleHitBox implements HitBox{
    private Point2D center;
    private double radius;

    public CircleHitBox(Point2D center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public Point2D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}
