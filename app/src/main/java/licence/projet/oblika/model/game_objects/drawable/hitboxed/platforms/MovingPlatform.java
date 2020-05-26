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
    public Point2D getActualPosition() {
        return actualPosition;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }

    @Override
    public void update() {
        if(isVertical){
            if(AccelerometerListener.getY() > 1.5 && actualPosition.getY() < botRight.getY() + range)
                this.actualPosition.setY(actualPosition.getY() + slidingSpeed * Time.delta);

            if(AccelerometerListener.getY() < -1.5 && actualPosition.getY() > topLeft.getY() - range)
                this.actualPosition.setY(actualPosition.getY() - slidingSpeed * Time.delta);

        } else {
            if(AccelerometerListener.getX() > 1.5 && actualPosition.getX() < botRight.getX() + range)
                this.actualPosition.setX(actualPosition.getX() + slidingSpeed * Time.delta);

            if(AccelerometerListener.getX() < -1.5 && actualPosition.getX() > topLeft.getX() - range)
                this.actualPosition.setX(actualPosition.getX() - slidingSpeed * Time.delta);
        }



/*
        if(isVertical){
            float yAcc = Math.abs(AccelerometerListener.getY()) > .2f ? AccelerometerListener.getY() * .5f : 0f;

            this.actualPosition.setY(actualPosition.getY() + yAcc * Time.delta);

            if(actualPosition.getY() > range) actualPosition.setY(range);
            else if(actualPosition.getY() < -range) actualPosition.setY(-range);

        } else {
            float xAcc = Math.abs(AccelerometerListener.getX()) > .2f ? AccelerometerListener.getX() * .5f : 0f;

            this.actualPosition.setX(actualPosition.getX() + xAcc * Time.delta);

            if(actualPosition.getX() > range) actualPosition.setX(range);
            else if(actualPosition.getX() < -range) actualPosition.setX(-range);
        }*/
    }
}
