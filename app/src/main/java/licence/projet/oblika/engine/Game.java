package licence.projet.oblika.engine;

import java.util.List;

import licence.projet.oblika.engine.utils.LevelLoader;
import licence.projet.oblika.graphic.MasterRenderer;
import licence.projet.oblika.model.Camera;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.CollisionTester;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.MainCharacter;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.FixedPlatform;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;
import licence.projet.oblika.model.level.LevelStructure;


public class Game {
    private MasterRenderer renderer;

    private Camera camera;

    private List<MovingPlatform> movingPlatforms;
    private List<FixedPlatform> fixedPlateforms;

    MainCharacter character;

    public Game() {
        renderer = new MasterRenderer();
        LevelStructure level = LevelLoader.parseLevel("level1");
        movingPlatforms = level.getMovingPlatformList();
        fixedPlateforms = level.getFixedPlatformList();

        // camera = new ???();

        character = new MainCharacter(new RectangleHitBox(new  Point2D(-0.5f, 0.5f), new Point2D(0.5f, -0.5f)), new Point2D(0, 0), "none");
    }

    public MasterRenderer getRenderer() {
        return renderer;
    }

    public void update() {
        for(MovingPlatform movingPlatform : movingPlatforms){
            movingPlatform.update();
            CollisionTester.moveCharacter(character, movingPlatform);
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

        renderer.finish();
    }
}
