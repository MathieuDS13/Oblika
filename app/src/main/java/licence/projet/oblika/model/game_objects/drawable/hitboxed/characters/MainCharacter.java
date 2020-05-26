package licence.projet.oblika.model.game_objects.drawable.hitboxed.characters;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.TouchEventListener;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MainCharacter implements Character, GameObject {

    private RectangleHitBox hitBox;
    private Point2D position;
    private String textureID;
    private float speed = 0.08f;
    private float height = 1.0f;
    private float width = 0.2f;
    private float gravity = 0.1f;
    private boolean isGrounded = true; //défini si le joueur est sur une plateforme

    public MainCharacter(RectangleHitBox hitBox, Point2D position, String textureID) {
        this.hitBox = hitBox;
        this.position = position;
        this.textureID = textureID;
    }

    @Override
    public Point2D getActualPosition() {
        return this.position;
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
            position.setX(position.getX() + speed * Time.delta);
        if (TouchEventListener.isLeftSideTouched())
            position.setX(position.getX() + speed * Time.delta);
        if (!isGrounded) {
            //Si le joueur est en l'air lui applique la gravité pour le faire redescendre
            position.setY(position.getY() - gravity * Time.delta);
        }
        if (TouchEventListener.isJumping() && isGrounded) {
            //TODO calculer la physique du saut OSKUR
        }
        //TODO ces putains de collisions je sais pas comment les calculer, physique de merde
    }
}
