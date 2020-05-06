package licence.projet.oblika.model.drawable.hitboxed.platforms;

import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.Point2D;

public class MovingPlatform implements Platform {

    private String textureID;
    private Point2D position;
    private boolean isVertical;

    public MovingPlatform(String textureID, Point2D position, boolean isVertical) {
        this.textureID = textureID;
        this.position = position;
        this.isVertical = isVertical;
    }

    public boolean isVertical(){ return isVertical;}

    @Override
    public HitBox getHitBox() {
        return null;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public String getTextureId() {
        return textureID;
    }
}
