package licence.projet.oblika.graphic;

import android.opengl.GLES30;

import java.util.List;

import licence.projet.oblika.model.hitboxes.HitBox;

public class MasterRenderer {
    private float[] cameraMatrix;
    private float ratio;

    public MasterRenderer() {

    }

    public void refresh(int width, int height) {
        GLES30.glViewport(0, 0, width, height);
        ratio = ((float) width) / ((float) height);
        GLES30.glClearColor(0f, 0f, 0f, 1.0f);

        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glEnable(GLES30.GL_TEXTURE_2D);
    }

    public void prepare() {

    }

    public void camera() {

    }

    public void hitboxes(List<HitBox> hitBoxes) {

    }

    public void finish() {

    }
}
