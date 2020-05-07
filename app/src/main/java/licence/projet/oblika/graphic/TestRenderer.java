package licence.projet.oblika.graphic;

import android.opengl.GLES30;

import licence.projet.oblika.Time;
import licence.projet.oblika.graphic.helper.Mesh;
import licence.projet.oblika.graphic.wrapper.Shader;
import licence.projet.oblika.graphic.wrapper.Texture;
import licence.projet.oblika.graphic.wrapper.VAO;
import licence.projet.oblika.graphic.wrapper.VBO;

public class TestRenderer implements Renderer {

    private Shader quadShader;
    private Shader pictureShader;
    private VAO quad;
    private VAO picture;

    private Texture bueno;

    public TestRenderer() {
        try {
            quadShader = new Shader("glsl_test_vert", "glsl_test_frag");
            pictureShader = new Shader("glsl_picture_test_vert", "glsl_picture_test_frag");
        } catch (Exception e) {
            e.printStackTrace();
        }

        quad = new VAO()
                .addVBO(new VBO(Mesh.gen2DQuad(1f, 1f), 2, 0))
                .prepare();

        picture = new VAO()
                .addVBO(new VBO(Mesh.gen2DQuad(0.8f, (9f/16f) * 0.8f), 2, 0))
                .addVBO(new VBO(Mesh.gen2DQuadUV(), 2, 1))
                .prepare();

        bueno = new Texture("bueno").setUnit(0);
    }

    @Override
    public void refresh(int width, int height) {
        GLES30.glViewport(0, 0, width, height);
        GLES30.glClearColor(0f, 0f, 0f, 1.0f);

        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glEnable(GLES30.GL_TEXTURE_2D);

        /*GLES30.glEnable(GLES30.GL_CULL_FACE);
        GLES30.glCullFace(GLES30.GL_CCW);*/
    }

    @Override
    public void render() {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT | GLES30.GL_DEPTH_BUFFER_BIT);

        quadShader.bind();
        quadShader.sendFloat(0, (float) (Math.sin(Time.now) * 0.5 + 0.5));
        quad.draw();

        pictureShader.bind();
        bueno.bind();
        picture.draw();
    }
}
