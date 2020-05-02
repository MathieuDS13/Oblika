package licence.projet.oblika.graphic;

import android.opengl.GLES30;

import licence.projet.oblika.Time;
import licence.projet.oblika.graphic.helper.Mesh;
import licence.projet.oblika.graphic.wrapper.Shader;
import licence.projet.oblika.graphic.wrapper.VAO;
import licence.projet.oblika.graphic.wrapper.VBO;

public class TestRenderer implements Renderer {

    private Shader shader;
    private VAO quad;

    public TestRenderer() {
        try {
            shader = new Shader(
                "#version 300 es\n" +
                    "precision mediump float;\n" +
                    "\n" +
                    "layout(location = 0) in vec2 position;\n" +
                    "out vec2 uv;\n" +
                    "\n" +
                    "void main() {\n" +
                    "    uv = position * 0.5 + 0.5;\n" +
                    "    gl_Position = vec4(position, 0.99, 1.0);\n" +
                    "}",

                "#version 300 es\n" +
                    "precision mediump float;\n" +
                    "\n" +
                    "in vec2 uv;\n" +
                    "out vec4 FragColor;\n" +
                    "\n" +
                    "uniform float blue;\n" +
                    "\n" +
                    "void main() {\n" +
                    "    FragColor = vec4(uv, blue, 1.0);\n" +
                    "}");
        } catch (Exception e) {
            e.printStackTrace();
        }

        quad = new VAO()
                .addVBO(new VBO(Mesh.gen2DQuad(1f, 1f), 2, 0))
                .prepare();
    }

    @Override
    public void refresh(int width, int height) {
        GLES30.glViewport(0, 0, width, height);
        GLES30.glClearColor(0f, 0f, 0f, 1.0f);
    }

    @Override
    public void render() {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);

        shader.bind();
        shader.sendFloat(0, (float) (Math.sin(Time.now) * 0.5 + 0.5));
        quad.draw();
    }
}
