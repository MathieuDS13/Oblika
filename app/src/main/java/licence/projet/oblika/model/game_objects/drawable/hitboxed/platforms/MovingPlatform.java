package licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MovingPlatform implements Platform, GameObject {

    private String textureID;
    private Point2D position;
    private Point2D startingPosition;
    private boolean isVertical;
    private HitBox hitBox;
    private float range;
    private float slidingSpeed = 0.07f;

    public MovingPlatform(String textureID, Point2D position, boolean isVertical, float range) {
        this.textureID = textureID;
        this.position = position;
        this.startingPosition = position;
        this.isVertical = isVertical;
        this.range = range;
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

    @Override
    public void update() {
        if(isVertical){
            if(AccelerometerListener.getX() > 1.5 && position.getX() < startingPosition.getX() + range) this.position.setX(position.getX() + slidingSpeed * Time.delta);
            if(AccelerometerListener.getX() < -1.5 && position.getX() > startingPosition.getX() - range) this.position.setX(position.getX() - slidingSpeed * Time.delta);

        } else {
            if(AccelerometerListener.getY() > 1.5 && position.getY() < startingPosition.getY() + range) this.position.setY(position.getY() + slidingSpeed * Time.delta);
            if(AccelerometerListener.getY() < -1.5 && position.getY() > startingPosition.getY() - range) this.position.setY(position.getY() - slidingSpeed * Time.delta);
        }
    }
}
