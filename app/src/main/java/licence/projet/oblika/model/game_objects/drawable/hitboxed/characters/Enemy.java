package licence.projet.oblika.model.game_objects.drawable.hitboxed.characters;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.hitboxes.HitBox;

public class Enemy implements Character, GameObject {

    private String textureID;
    private Point2D position;

    public Enemy(String textureID, Point2D position) {
        this.textureID = textureID;
        this.position = position;
    }

    @Override
    public Point2D getActualPosition() {
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

    @Override
    public void update() {
        //TODO faire l'IA des ennemis enfin s'ils ont un cerveau
    }
}
