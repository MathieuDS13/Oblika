package licence.projet.oblika.model.drawable.hitboxed.platforms;

import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;

public class FixedPlatform implements Platform {

    private String textureID;
    private Point2D position;

    public FixedPlatform(String textureID, Point2D position) {
        this.textureID = textureID;
        this.position = position;
    }

    @Override
    public HitBox getHitBox() {
        return null;
    }

    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }
}
