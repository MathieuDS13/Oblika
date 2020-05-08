package licence.projet.oblika.engine;

import java.util.ArrayList;

import licence.projet.oblika.Time;
import licence.projet.oblika.graphic.MasterRenderer;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class Game {
    private MasterRenderer renderer;

    private ArrayList<RectangleHitBox> testHitBoxList;

    public Game() {
        renderer = new MasterRenderer();

        testHitBoxList = new ArrayList();
        testHitBoxList.add(new RectangleHitBox(new Point2D(0, 1), new Point2D(1, 0)));
    }

    public MasterRenderer getRenderer() {
        return renderer;
    }

    public void update() {
        // calcule de la physique toussa toussa
    }

    public void draw() {
        renderer.prepare();

        // renderer.camera(...); pour la future camera

        renderer.hitboxes(testHitBoxList);

        renderer.finish();
    }
}
