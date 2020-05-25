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

    private float distance (Point2D point){
        return(float) Math.sqrt(Math.pow(point.getX() - center.getX(),2)+ Math.pow(point.getY() - center.getY(),2));
    }

    @Override
    public boolean contains(Point2D point) {
        if(distance(point) <= radius) return true;
        return false;
    }

    @Override
    public Point2D getTopLeft() {
        return null;
    }

    @Override
    public Point2D getBotRight() {
        return null;
    }
}
