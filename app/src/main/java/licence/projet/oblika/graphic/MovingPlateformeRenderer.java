package licence.projet.oblika.graphic;

import licence.projet.oblika.graphic.helper.Mesh;
import licence.projet.oblika.graphic.wrapper.Shader;
import licence.projet.oblika.graphic.wrapper.VAO;
import licence.projet.oblika.graphic.wrapper.VBO;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;
import licence.projet.oblika.model.hitboxes.HitBox;

public class MovingPlateformeRenderer {
    private Shader shader;

    private VAO rectVAO;
    private float[] pos;
    private float[] size;

    public MovingPlateformeRenderer() throws Exception {
        shader = new Shader("glsl_movingplateforme_vert", "glsl_movingplateforme_frag", "movingplateforme");

        rectVAO = new VAO()
                .addVBO(new VBO(Mesh.gen2DQuad(0.5f, 0.5f), 2, 0))
                .prepare();

        pos = new float[2];
        pos[0] = 0;
        pos[1] = 0;

        size = new float[2];
        size[0] = 0;
        size[1] = 0;
    }

    public void prepare(float[] vpMatrix) {
        shader.bind();
        shader.sendMat4(0, vpMatrix);
    }

    public void render(MovingPlatform movingPlatform) {
        final Point2D position = movingPlatform.getActualPosition();
        pos[0] = position.getX();
        pos[1] = position.getY();

        final HitBox hitBox = movingPlatform.getHitBox();
        final Point2D topLeft = hitBox.getTopLeft();
        final Point2D botRight = hitBox.getBotRight();

        size[0] = botRight.getX() - topLeft.getX();
        size[1] = topLeft.getY() - botRight.getY();

        shader.sendVec2(1, pos);
        shader.sendVec2(2, size);
        shader.sendFloat(3, 0);
        rectVAO.draw();





        final Point2D spawnPosition = movingPlatform.getSpawnPosition();
        pos[0] = spawnPosition.getX();
        pos[1] = spawnPosition.getY();


        if(movingPlatform.isVertical()) {
            size[0] = .1f;
            size[1] = movingPlatform.getRange() * 2f;
        } else {
            size[1] = .1f;
            size[0] = movingPlatform.getRange() * 2f;
        }

        shader.sendVec2(1, pos);
        shader.sendVec2(2, size);
        shader.sendFloat(3, 1);
        rectVAO.draw();
    }
}
