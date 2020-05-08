package licence.projet.oblika.activities;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import licence.projet.oblika.Time;
import licence.projet.oblika.engine.Game;

public class GLEngine implements GLSurfaceView.Renderer {
    private Game game;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        game = new Game();
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
