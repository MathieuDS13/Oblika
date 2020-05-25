package licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MovingPlatform implements Platform, GameObject {

    private String textureID;
    private Point2D position;
    private Point2D startingPosition;
    private boolean isVertical;
    private HitBox hitBox;
    private float range;
    private float slidingSpeed = 1f;

    public MovingPlatform(String textureID, Point2D position, boolean isVertical, float range) {
        this.textureID = textureID;
        this.position = position;
        this.startingPosition = new Point2D(position.getX(), position.getY());
        this.isVertical = isVertical;
        this.range = range;
        generateHitBox();
    }

    public boolean isVertical() {
        return isVertical;
    }

    private void generateHitBox() {
        Point2D topLeft = new Point2D(position.getX(), position.getY() + 0.5f);
        Point2D botRight = new Point2D(position.getX() + 1.5f, position.getY());
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
        if (isVertical) {
            if (AccelerometerListener.getY() > 1.5 && position.getY() < startingPosition.getY() + range)
                this.position.setY(position.getY() + slidingSpeed * Time.delta);
            if (AccelerometerListener.getY() < -1.5 && position.getY() > startingPosition.getY() - range)
                this.position.setY(position.getY() - slidingSpeed * Time.delta);
            hitBox.getTopLeft().setY(position.getY());
            hitBox.getBotRight().setY(position.getY() + 0.5f);

        } else {
            if (AccelerometerListener.getX() > 1.5 && position.getX() < startingPosition.getX() + range)
                this.position.setX(position.getX() + slidingSpeed * Time.delta);
            if (AccelerometerListener.getX() < -1.5 && position.getX() > startingPosition.getX() - range)
                this.position.setX(position.getX() - slidingSpeed * Time.delta);
            hitBox.getTopLeft().setX(position.getX());
            hitBox.getBotRight().setX(position.getX() + 1.5f);
        }
    }
}
