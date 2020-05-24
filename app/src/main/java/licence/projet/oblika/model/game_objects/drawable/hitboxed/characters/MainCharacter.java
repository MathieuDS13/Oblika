package licence.projet.oblika.model.game_objects.drawable.hitboxed.characters;

import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MainCharacter implements Character, GameObject {

    private RectangleHitBox hitBox;
    private Point2D position;
    private String textureID;

    public MainCharacter(RectangleHitBox hitBox, Point2D position, String textureID) {
        this.hitBox = hitBox;
        this.position = position;
        this.textureID = textureID;
    }

    @Override
    public Point2D getPosition(){
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
    public void update(){

    }
}
