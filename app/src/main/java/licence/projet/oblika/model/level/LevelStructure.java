package licence.projet.oblika.model.level;

import java.util.ArrayList;
import java.util.List;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.GameObject;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.EndPoint;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.Enemy;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.MainCharacter;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.FixedPlatform;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;

public class LevelStructure {

    String levelName;
    MainCharacter mainCharacter;
    Point2D start;
    EndPoint endPoint;
    List<MovingPlatform> movingPlatformList;
    List<FixedPlatform> fixedPlatformList;
    List<Enemy> enemyList;
    List<GameObject> gameObjects;


    public void LevelStructure() {
        this.levelName = "";
        this.fixedPlatformList = new ArrayList<>();
        this.movingPlatformList = new ArrayList<>();
        this.enemyList = new ArrayList<>();
        this.gameObjects = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
        gameObjects.add(enemy);
    }

    public void addMovingPlatformList(MovingPlatform platform) {
        movingPlatformList.add(platform);
        gameObjects.add(platform);
    }

    public void addFixedPlatformList(FixedPlatform platform) {
        fixedPlatformList.add(platform);
        gameObjects.add(platform);
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

    public EndPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point2D end) {
        this.endPoint = new EndPoint(end);
        gameObjects.add(endPoint);
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public List<MovingPlatform> getMovingPlatformList() {
        return movingPlatformList;
    }

    public List<FixedPlatform> getFixedPlatformList() {
        return fixedPlatformList;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public List<GameObject> getGameObjects(){
        return this.gameObjects;
    }
}
