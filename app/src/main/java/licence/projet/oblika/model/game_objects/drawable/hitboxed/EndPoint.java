package licence.projet.oblika.model.game_objects.drawable.hitboxed;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class EndPoint implements GameObject, HitBoxed {

    HitBox hitBox;
    Point2D endPoint;
    String texture;

    public EndPoint(Point2D point, String texture) {
        this.endPoint = point;
        this.texture = texture;
        Point2D point2 = new Point2D(point.getX()+0.5f, point.getY() + 0.5f);
        this.hitBox = new RectangleHitBox(point,point2);
    }

    @Override
    public void update() {

    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public Point2D getPosition() {
        return endPoint;
    }

    @Override
    public String getTextureId() {
        return texture;
    }
}
