package licence.projet.oblika.model.hitboxes;

import licence.projet.oblika.model.Point2D;

public class RectangleHitBox implements HitBox {
    private Point2D topLeft;
    private Point2D botRight;

    public RectangleHitBox(Point2D topLeft, Point2D botRight){
        this.topLeft = topLeft;
        this.botRight = botRight;
    }

    public Point2D getTopLeft() {
        return topLeft;
    }

    public Point2D getBotRight() {
        return botRight;
    }

    public boolean contains (Point2D point){
        if(topLeft.getX() <= point.getX() && topLeft.getY() <= point.getY()) {
            if (botRight.getX() >= point.getX() && botRight.getY() >= point.getY()) {
                return true;
            }
        }
         return false;
    }
}
