package licence.projet.oblika.model.drawable.hitboxed.platforms;

import licence.projet.oblika.model.Point2D;

public class PlatformFactory {

    private String verticalPlatformTextureID;
    private String horizontalPlatformTextureID;
    private String fixedPlatformTextureID;

    public PlatformFactory(String verticalPlatformTextureID, String horizontalPlatformTextureID, String fixedPlatformTextureID) {
        this.verticalPlatformTextureID = verticalPlatformTextureID;
        this.horizontalPlatformTextureID = horizontalPlatformTextureID;
        this.fixedPlatformTextureID = fixedPlatformTextureID;
    }

    public MovingPlatform CreateVerticalMovingPlatform(Point2D position){
        return new MovingPlatform(verticalPlatformTextureID, position, true);
    }

    public MovingPlatform CreateHorizontalMovingPlatform(Point2D position){
        return new MovingPlatform(horizontalPlatformTextureID, position, false);
    }

    public FixedPlatform CreateFixedPlatform(Point2D position){
        return new FixedPlatform(fixedPlatformTextureID, position);
    }
}
