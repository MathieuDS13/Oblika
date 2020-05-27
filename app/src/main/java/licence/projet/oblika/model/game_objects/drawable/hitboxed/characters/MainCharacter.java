package licence.projet.oblika.model.game_objects.drawable.hitboxed.characters;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.AudioHandler;
import licence.projet.oblika.engine.utils.TouchEventListener;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MainCharacter implements Character, GameObject {

    private RectangleHitBox hitBox;
    private Point2D actualPosition;
    private Point2D topLeft;
    private Point2D botRight;
    private String textureID;
    private float speed = 1.7f;
    private float height = 1.0f;
    private float width = 0.7f;
    private float slidingSpeed = -0.1f;
    private boolean isGrounded = true;

    public MainCharacter(Point2D actualPosition, String textureID) {
        this.topLeft = new Point2D(-width/2, height/2);
        this.botRight = new Point2D(width/2, -height/2);
        this.actualPosition = actualPosition;
        this.textureID = textureID;
        generateHitBox();
    }

    protected void generateHitBox(){
        hitBox = new RectangleHitBox(topLeft, botRight);
    }

    @Override
    public void setGrounded() {
        isGrounded = true;
    }

    @Override
    public Point2D getActualPosition() {
        return this.actualPosition;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public void update() {
        if (TouchEventListener.isRightSideTouched())
            actualPosition.setX(actualPosition.getX() + speed * Time.delta);

        if (TouchEventListener.isLeftSideTouched())
            actualPosition.setX(actualPosition.getX() - speed * Time.delta);


        slidingSpeed += -0.35f; //Gravity
        actualPosition.setY(actualPosition.getY() + slidingSpeed * Time.delta);

        if(isGrounded){
            slidingSpeed = 0;
        }

        if (TouchEventListener.isJumping() && isGrounded) {
            AudioHandler.playJumpSound();
            slidingSpeed = 8f;
        }

        isGrounded = false;
    }
}
