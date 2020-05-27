package licence.projet.oblika.engine;

import java.util.List;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.LevelLoader;
import licence.projet.oblika.graphic.MasterRenderer;
import licence.projet.oblika.model.Camera;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.CollisionTester;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.EndPoint;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.MainCharacter;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.FixedPlatform;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;
import licence.projet.oblika.model.level.LevelStructure;


public class Game {
    private MasterRenderer renderer;

    private GameEndListener gameEndListener;
    private float currentEndCountdown = 0.2f;
    private boolean listenerHaveBeenCalled = false;

    private Camera camera;

    private List<MovingPlatform> movingPlatforms;
    private List<FixedPlatform> fixedPlateforms;

    private MainCharacter character;
    private Point2D spawnPoint;
    private EndPoint endPoint;

    public Game() {
        this("level1");
    }

    public Game(String levelName) {
        renderer = new MasterRenderer();
        LevelStructure level = LevelLoader.parseLevel(levelName);
        movingPlatforms = level.getMovingPlatformList();
        fixedPlateforms = level.getFixedPlatformList();
        spawnPoint = new Point2D(level.getStart().getX(), level.getStart().getY());
        endPoint = level.getEndPoint();

        // camera = new ???();

        character = new MainCharacter(level.getStart(), "none");
    }

    public MasterRenderer getRenderer() {
        return renderer;
    }

    public void setGameEndListener(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }

    public void update() {
        character.update();

        for(MovingPlatform movingPlatform : movingPlatforms){
            movingPlatform.update();
            CollisionTester.moveCharacter(character, movingPlatform);
        }

        for (FixedPlatform fixedPlatform : fixedPlateforms) {
            fixedPlatform.update();
            CollisionTester.moveCharacter(character, fixedPlatform);
        }

        if(CollisionTester.characterTouchEndPoint(character, endPoint)) {
            currentEndCountdown -= Time.delta;
            if(currentEndCountdown < 0 && !listenerHaveBeenCalled) {
                listenerHaveBeenCalled = true;
                gameEndListener.run();
            }
        }

        if(CollisionTester.characterOutOfBounds(character)) {
            character.getActualPosition().setX(spawnPoint.getX());
            character.getActualPosition().setY(spawnPoint.getY());
            System.out.println(spawnPoint.getX() +" | "+ spawnPoint.getY());
        }
        // calcule de la physique toussa toussa
    }

    public void draw() {
        renderer.prepare();

        // renderer.camera(camera);
        renderer.movingPlatforms(movingPlatforms);

        renderer.fixedPlatforms(fixedPlateforms);

        renderer.character(character);

        renderer.background();

        renderer.endPoint(endPoint);

        renderer.finish();
    }
}
