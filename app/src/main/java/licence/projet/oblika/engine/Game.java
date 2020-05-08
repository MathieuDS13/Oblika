package licence.projet.oblika.engine;

import licence.projet.oblika.Time;
import licence.projet.oblika.graphic.MasterRenderer;

public class Game {
    private MasterRenderer renderer;

    public Game() {
        renderer = new MasterRenderer();
    }

    public MasterRenderer getRenderer() {
        return renderer;
    }

    public void update() {
        // calcule de la physique toussa toussa
    }

    public void draw() {
        renderer.prepare();
        // renderer.camera(...);
        // renderer.hitboxes(...);
        renderer.finish();
    }
}
