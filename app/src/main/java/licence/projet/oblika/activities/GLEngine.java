package licence.projet.oblika.activities;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.Game;
import licence.projet.oblika.engine.GameEndListener;

public class GLEngine implements GLSurfaceView.Renderer {
    private Game game;
    private String levelName;

    private GameEndListener gameEndListener;

    public GLEngine(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Time.init();

        game = new Game(levelName);
        game.setGameEndListener(gameEndListener);
    }

    public void onGameEnd(GameEndListener listener) {
        gameEndListener = listener;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        game.getRenderer().refresh(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Time.update();
        game.update();
        game.draw();
    }
}
