package licence.projet.oblika.graphic;

import android.opengl.GLES30;

import java.util.List;

import licence.projet.oblika.graphic.helper.Matrix;
import licence.projet.oblika.model.Camera;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class MasterRenderer {
    public static float scale = 10f;

    private float[] viewMatrix;
    private float[] projectionMatrix;
    private float[] vpMatrix;

    private float viewportWidth;
    private float viewportHeight;
    private float ratio;

    private HitboxRenderer hitboxRenderer;
    private BackgroundRenderer backgroundRenderer;

    public MasterRenderer() {
        viewMatrix = Matrix.mat4GenIdentity();
        projectionMatrix = Matrix.mat4GenIdentity();
        vpMatrix = Matrix.mat4GenIdentity();

        try {
            hitboxRenderer = new HitboxRenderer();
            backgroundRenderer = new BackgroundRenderer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh(int width, int height) {
        GLES30.glViewport(0, 0, width, height);
        viewportWidth = (float) width;
        viewportHeight = (float) height;
        ratio = viewportWidth / viewportHeight;
        GLES30.glClearColor(0f, 0.3f, 0.8f, 1.0f);

        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glEnable(GLES30.GL_TEXTURE_2D);

        float xOffset = scale / 2f;
        float yOffset = scale / 2f / ratio;

        Matrix.mat4Ortho(projectionMatrix, -xOffset, xOffset, -yOffset, yOffset, 0, 1);
        Matrix.mat4Mult(vpMatrix, projectionMatrix, viewMatrix);
    }

    public void prepare() {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT | GLES30.GL_DEPTH_BUFFER_BIT);
    }

    public void camera(Camera camera) {
        Point2D position = camera.getPosition();
        viewMatrix[12] = -position.getX();
        viewMatrix[13] = -position.getY();

        Matrix.mat4Mult(vpMatrix, projectionMatrix, viewMatrix);
    }

    public void hitboxes(List<RectangleHitBox> hitboxes) {
        hitboxRenderer.prepare(vpMatrix);
        for(RectangleHitBox hitbox : hitboxes) {
            hitboxRenderer.render(hitbox);
        }
    }

    public void background() {
        backgroundRenderer.render();
    }

    public void finish() {

    }
}
