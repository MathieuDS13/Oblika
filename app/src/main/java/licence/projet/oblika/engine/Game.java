package licence.projet.oblika.engine;

import java.util.ArrayList;

import licence.projet.oblika.graphic.MasterRenderer;
import licence.projet.oblika.model.Camera;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.CollisionTester;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.MainCharacter;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class Game {
    private MasterRenderer renderer;

    private Camera camera;

    private ArrayList<MovingPlatform> movingPlatforms;

    MainCharacter character;

    public Game() {
        renderer = new MasterRenderer();

        // camera = new ???();
        //TODO charger le niveau demandé

        movingPlatforms = new ArrayList<>();

        MovingPlatform testVertical = new MovingPlatform("none", new Point2D(-2f, -1f), true, 1.5f, 0.5f, 2f);
        MovingPlatform testHorizontal = new MovingPlatform("none", new Point2D(2.5f, 0f), false, 3f, 0.5f, 2f);

        movingPlatforms.add(testHorizontal);
        movingPlatforms.add(testVertical);

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

        //renderer.fixedPlatforms(...);

        renderer.character(character);

        renderer.background();

        renderer.finish();
    }
}
