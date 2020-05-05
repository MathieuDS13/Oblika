package licence.projet.oblika.model;

public class RectangleHitBox implements HitBox{
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
}
