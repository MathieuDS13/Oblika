package licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MovingPlatform implements Platform, GameObject {

    private String textureID;
    private Point2D topLeft;
    private Point2D botRight;
    private Point2D actualPosition;
    private boolean isVertical;
    private HitBox hitBox;
    private float range;
    private float slidingSpeed = 1f;

    public MovingPlatform(String textureID, Point2D actualPosition, boolean isVertical, float range, float height, float width) {
        this.textureID = textureID;

        this.topLeft = new Point2D(-width/2, height/2);
        this.botRight = new Point2D(width/2, -height/2);

        this.actualPosition = actualPosition;

        this.isVertical = isVertical;
        this.range = range;

        generateHitBox();
    }

    public boolean isVertical() {
        return isVertical;
    }

    private void generateHitBox(){
        hitBox = new RectangleHitBox(topLeft, botRight);
    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public Point2D getTopLeft() {
        return topLeft;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }

    @Override
    public void update() {
        if(isVertical){
            if(AccelerometerListener.getY() > 1.5 && topLeft.getY() < actualPosition.getY() + range)
                this.topLeft.setY(topLeft.getY() + slidingSpeed * Time.delta);

            if(AccelerometerListener.getY() < -1.5 && topLeft.getY() > actualPosition.getY() - range)
                this.topLeft.setY(topLeft.getY() - slidingSpeed * Time.delta);

        } else {
            if(AccelerometerListener.getX() > 1.5 && topLeft.getX() < actualPosition.getX() + range)
                this.topLeft.setX(topLeft.getX() + slidingSpeed * Time.delta);

            if(AccelerometerListener.getX() < -1.5 && topLeft.getX() > actualPosition.getX() - range)
                this.topLeft.setX(topLeft.getX() - slidingSpeed * Time.delta);
        }
    }
}
