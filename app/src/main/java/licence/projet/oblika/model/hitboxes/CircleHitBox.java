package licence.projet.oblika.model.hitboxes;

import licence.projet.oblika.model.Point2D;

public class CircleHitBox implements HitBox {
    private Point2D center;
    private float radius;

    public CircleHitBox(Point2D center, float radius){
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
