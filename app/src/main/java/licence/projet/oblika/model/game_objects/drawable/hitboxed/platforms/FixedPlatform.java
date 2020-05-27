package licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms;

import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class FixedPlatform implements Platform, GameObject {

    private String textureID;
    private Point2D topLeft;
    private Point2D botRight;
    private Point2D actualPosition;
    private HitBox hitBox;
    private float range;

    public FixedPlatform(String textureID, Point2D actualPosition, float height, float width) {
        this.textureID = textureID;

        this.topLeft = new Point2D(-width/2, height/2);
        this.botRight = new Point2D(width/2, -height/2);

        this.actualPosition = actualPosition;

        this.range = range;
        generateHitBox();
    }

    private void generateHitBox(){
        hitBox = new RectangleHitBox(topLeft, botRight);
    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public Point2D getActualPosition() {
        return actualPosition;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }

    @Override
    public void update() {
        //Do nothing
    }
}
