package licence.projet.oblika.model.level;

import java.util.ArrayList;
import java.util.List;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.drawable.hitboxed.characters.MainCharacter;
import licence.projet.oblika.model.drawable.hitboxed.platforms.FixedPlatform;
import licence.projet.oblika.model.drawable.hitboxed.platforms.MovingPlatform;

public class LevelStructure {

    MainCharacter mainCharacter;
    Point2D start;
    Point2D end;
    List<MovingPlatform> movingPlatformList;
    List<FixedPlatform> fixedPlatformList;

    public void LevelStructure(){
        this.fixedPlatformList = new ArrayList<>();
        this.movingPlatformList = new ArrayList<>();
    }

    public void setMovingPlatformList(MovingPlatform platform){
        movingPlatformList.add(platform);
    }

    public void setFixedPlatformList(FixedPlatform platform){
        fixedPlatformList.add(platform);
    }

    public void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public Point2D getStart() {
        return start;
    }

    public void setStart(Point2D start) {
        this.start = start;
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }
}
