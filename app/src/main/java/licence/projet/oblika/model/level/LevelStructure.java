package licence.projet.oblika.model.level;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.drawable.hitboxed.characters.Enemy;
import licence.projet.oblika.model.drawable.hitboxed.characters.MainCharacter;
import licence.projet.oblika.model.drawable.hitboxed.platforms.FixedPlatform;
import licence.projet.oblika.model.drawable.hitboxed.platforms.MovingPlatform;

public class LevelStructure {

    String levelName;
    MainCharacter mainCharacter;
    Point2D start;
    Point2D end;
    List<MovingPlatform> movingPlatformList;
    List<FixedPlatform> fixedPlatformList;
    List<Enemy> enemyList;

    public void LevelStructure() {
        this.levelName = "";
        this.fixedPlatformList = new ArrayList<>();
        this.movingPlatformList = new ArrayList<>();
        this.enemyList = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
    }

    public void addMovingPlatformList(MovingPlatform platform) {
        movingPlatformList.add(platform);
    }

    public void addFixedPlatformList(FixedPlatform platform) {
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

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
