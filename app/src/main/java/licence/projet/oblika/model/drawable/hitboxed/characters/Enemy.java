package licence.projet.oblika.model.drawable.hitboxed.characters;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.HitBox;

public class Enemy implements Character {

    private String textureID;
    private Point2D position;

    public Enemy(String textureID, Point2D position) {
        this.textureID = textureID;
        this.position = position;
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
    public HitBox getHitBox() {
        return null;
    }
}
