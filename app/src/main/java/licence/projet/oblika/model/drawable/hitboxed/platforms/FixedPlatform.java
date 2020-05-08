package licence.projet.oblika.model.drawable.hitboxed.platforms;

import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class FixedPlatform implements Platform {

    private String textureID;
    private Point2D position;
    private HitBox hitBox;

    public FixedPlatform(String textureID, Point2D position) {
        this.textureID = textureID;
        this.position = position;
        generateHitBox();
    }

    private void generateHitBox(){
        Point2D topLeft = new Point2D(position.getX(), position.getY() + 10);
        Point2D botRight = new Point2D(position.getX() + 30, position.getY());
        hitBox = new RectangleHitBox(topLeft, botRight);
    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }
}
