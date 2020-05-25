package licence.projet.oblika.engine;

import java.util.ArrayList;

import licence.projet.oblika.graphic.MasterRenderer;
import licence.projet.oblika.model.Camera;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class Game {
    private MasterRenderer renderer;

    private Camera camera;

    private ArrayList<MovingPlatform> testMovingPlatform;
    private ArrayList<RectangleHitBox> testHitBoxList;

    public Game() {
        renderer = new MasterRenderer();

        // camera = new ???();
        //TODO charger le niveau demandé

        testMovingPlatform = new ArrayList<>();
        testHitBoxList = new ArrayList<>();

        MovingPlatform testVertical = new MovingPlatform("none", new Point2D(-3, -1), true, 0.5f);
        MovingPlatform testHorizontal = new MovingPlatform("none", new Point2D(-1, 1), false, 0.5f);

        testMovingPlatform.add(testHorizontal);
        testMovingPlatform.add(testVertical);

        for(MovingPlatform movingPlatform : testMovingPlatform){
            testHitBoxList.add((RectangleHitBox) movingPlatform.getHitBox());
        }
    }

    public MasterRenderer getRenderer() {
        return renderer;
    }

    public void update() {
        for(MovingPlatform movingPlatform : testMovingPlatform){
            movingPlatform.update();
        }
        // calcule de la physique toussa toussa
    }

    public void draw() {
        renderer.prepare();

        // renderer.camera(camera);

        renderer.hitboxes(testHitBoxList);

        renderer.background();

        renderer.finish();
    }
}
