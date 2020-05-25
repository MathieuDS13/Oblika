package licence.projet.oblika.graphic;

import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.graphic.helper.Mesh;
import licence.projet.oblika.graphic.wrapper.Shader;
import licence.projet.oblika.graphic.wrapper.VAO;
import licence.projet.oblika.graphic.wrapper.VBO;

public class BackgroundRenderer {
    private Shader shader;

    private VAO rectVAO;
    private float[] pos;

    public BackgroundRenderer() throws Exception {
        shader = new Shader("glsl_background_vert", "glsl_background_frag", "background");

        rectVAO = new VAO()
                .addVBO(new VBO(Mesh.gen2DQuad(1, 1), 2, 0))
                .prepare();

        pos = new float[2];
        pos[0] = 0;
        pos[1] = 0;
    }

    public void render() {
        float cibleX = -AccelerometerListener.getX() * 0.02f;
        float cibleY = -AccelerometerListener.getY() * 0.02f;

        if(cibleX < 0.05 && cibleX > -0.05) cibleX = 0;
        if(cibleY < 0.05 && cibleY > -0.05) cibleY = 0;

        double angle = Math.atan2(cibleY - pos[1], cibleX - pos[0]);
        double dist = Math.sqrt(Math.pow((cibleX-pos[0]), 2) +  Math.pow((cibleY-pos[1]), 2));

        pos[0] += Math.cos(angle) * dist * 0.02;
        pos[1] += Math.sin(angle) * dist * 0.02;

        shader.bind();
        shader.sendVec2(0, pos);
        rectVAO.draw();
    }
}
