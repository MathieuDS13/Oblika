package licence.projet.oblika.activities;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import licence.projet.oblika.Time;
import licence.projet.oblika.graphic.Renderer;
import licence.projet.oblika.graphic.TestRenderer;

public class GLEngine implements GLSurfaceView.Renderer {
    private Renderer testRenderer;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        testRenderer = new TestRenderer();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        testRenderer.refresh(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Time.update();

        testRenderer.render();
    }
}
