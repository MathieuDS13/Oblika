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
    private Point2D spawnPosition;
    private boolean isVertical;
    private HitBox hitBox;
    private float range;
    private float slidingSpeed = 0f;

    public MovingPlatform(String textureID, Point2D actualPosition, boolean isVertical, float range, float height, float width) {
        this.textureID = textureID;

        this.topLeft = new Point2D(-width / 2, height / 2);
        this.botRight = new Point2D(width / 2, -height / 2);

        this.spawnPosition = new Point2D(actualPosition.getX(), actualPosition.getY());
        this.actualPosition = actualPosition;

        this.isVertical = isVertical;
        this.range = range;

        generateHitBox();
    }

    public boolean isVertical() {
        return isVertical;
    }

    private void generateHitBox() {
        hitBox = new RectangleHitBox(topLeft, botRight);
    }

    public Point2D getSpawnPosition() {
        return spawnPosition;
    }

    public float getRange() {
        return range;
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
        if (isVertical) {
            float yAcc = Math.abs(AccelerometerListener.getY()) > .2f ? AccelerometerListener.getY() * .5f : 0f;
            slidingSpeed += yAcc;
            this.actualPosition.setY(actualPosition.getY() + slidingSpeed / 50 * Time.delta);

            if (actualPosition.getY() > spawnPosition.getY() + range) {
                actualPosition.setY(spawnPosition.getY() + range);
                slidingSpeed = 0;
            } else if (actualPosition.getY() < spawnPosition.getY() - range) {
                actualPosition.setY(spawnPosition.getY() - range);
                slidingSpeed = 0;
            }

        } else {
            float xAcc = Math.abs(AccelerometerListener.getX()) > .2f ? AccelerometerListener.getX() * .5f : 0f;
            slidingSpeed += xAcc;
            this.actualPosition.setX(actualPosition.getX() + slidingSpeed / 50 * Time.delta);

            if (actualPosition.getX() > spawnPosition.getX() + range) {
                actualPosition.setX(spawnPosition.getX() + range);
                slidingSpeed = 0;
            } else if (actualPosition.getX() < spawnPosition.getX() - range) {
                actualPosition.setX(spawnPosition.getX() - range);
                slidingSpeed = 0;
            }
        }
    }
}
