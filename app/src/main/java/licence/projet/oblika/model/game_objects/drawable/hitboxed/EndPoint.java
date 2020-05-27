package licence.projet.oblika.model.game_objects.drawable.hitboxed;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class EndPoint implements GameObject, HitBoxed {

    private final float width = 0.6f;
    private final float height = 1f;

    HitBox hitBox;
    Point2D endPoint;
    String texture;

    public EndPoint(Point2D point, String texture) {
        this.endPoint = point;
        this.texture = texture;
        this.hitBox = new RectangleHitBox(new Point2D(-width / 2, height / 2), new Point2D(width / 2, -height / 2));
    }

    @Override
    public void update() {

    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public Point2D getActualPosition() {
        return endPoint;
    }

    @Override
    public String getTextureId() {
        return texture;
    }
}
