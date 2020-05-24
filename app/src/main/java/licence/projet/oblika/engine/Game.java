package licence.projet.oblika.engine;

import android.text.method.Touch;

import java.util.ArrayList;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.engine.utils.TouchEventListener;
import licence.projet.oblika.graphic.MasterRenderer;
import licence.projet.oblika.model.Camera;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class Game {
    private MasterRenderer renderer;

    private Camera camera;

    private ArrayList<RectangleHitBox> testHitBoxList;

    public Game() {
        renderer = new MasterRenderer();

        // camera = new ???();

        testHitBoxList = new ArrayList();
        testHitBoxList.add(new RectangleHitBox(new Point2D(0, 1), new Point2D(1, 0)));
    }

    public MasterRenderer getRenderer() {
        return renderer;
    }

    public void update() {
        // calcule de la physique toussa toussa
        System.out.println("R " + TouchEventListener.isRightSideTouched() + " L " + TouchEventListener.isLeftSideTouched());
    }

    public void draw() {
        renderer.prepare();

        // renderer.camera(camera);

        renderer.hitboxes(testHitBoxList);

        renderer.finish();
    }
}
