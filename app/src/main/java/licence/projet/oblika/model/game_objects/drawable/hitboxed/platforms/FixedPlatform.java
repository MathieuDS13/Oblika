package licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class FixedPlatform implements Platform, GameObject {

    private String textureID;
    private Point2D position;
    private HitBox hitBox;
    private float height;
    private float width;

    public FixedPlatform(String textureID, Point2D position, float height, float width){
        //TODO modifie le constructeur et la classe
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
    public Point2D getActualPosition() {
        return position;
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
