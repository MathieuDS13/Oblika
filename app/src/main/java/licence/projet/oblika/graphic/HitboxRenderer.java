package licence.projet.oblika.graphic;

import android.opengl.GLES30;

import java.nio.FloatBuffer;

import licence.projet.oblika.Time;
import licence.projet.oblika.graphic.helper.Mesh;
import licence.projet.oblika.graphic.wrapper.Shader;
import licence.projet.oblika.graphic.wrapper.VAO;
import licence.projet.oblika.graphic.wrapper.VBO;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class HitboxRenderer {
    private Shader shader;

    private VAO rectVAO;
    private VBO rectVBO;
    private FloatBuffer rectBuffer;

    public HitboxRenderer() throws Exception {
        shader = new Shader("glsl_hitbox_vert", "glsl_hitbox_frag", "hitbox");

        rectBuffer = Mesh.gen2DQuad(1, 1);

        rectVBO = new VBO(rectBuffer, 2, 0, GLES30.GL_DYNAMIC_DRAW);
        rectVAO = new VAO()
                .addVBO(rectVBO)
                .addVBO(new VBO(Mesh.gen2DQuadUV(), 2, 1))
                .prepare();
    }

    public void prepare(float[] vpMatrix) {
        shader.bind();
        shader.sendMat4(0, vpMatrix);
        shader.sendFloat(1, (Time.now * 0.1f) % 1f);
    }

    public void render(RectangleHitBox hitBox) {
        Point2D topLeft = hitBox.getTopLeft();
        Point2D botRight = hitBox.getBotRight();

        Mesh.fill2DQuad(rectBuffer,
                (float) topLeft.getX(), (float) topLeft.getY(),
                (float) botRight.getX(), (float) topLeft.getY(),
                (float) topLeft.getX(), (float) botRight.getY(),
                (float) botRight.getX(), (float) botRight.getY()
        );

        rectVBO.setData(rectBuffer, 0);

        rectVAO.draw();
    }
}
