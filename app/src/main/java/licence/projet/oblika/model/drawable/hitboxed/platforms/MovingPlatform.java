package licence.projet.oblika.model.drawable.hitboxed.platforms;

import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MovingPlatform implements Platform {

    private String textureID;
    private Point2D position;
    private boolean isVertical;
    private HitBox hitBox;

    public MovingPlatform(String textureID, Point2D position, boolean isVertical) {
        this.textureID = textureID;
        this.position = position;
        this.isVertical = isVertical;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public void update(float x, float y){
        if(isVertical) position.setY(position.getY() + y);
        else position.setX(position.getX() + x);
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
