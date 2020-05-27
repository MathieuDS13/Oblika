package licence.projet.oblika.graphic;

import licence.projet.oblika.graphic.helper.Mesh;
import licence.projet.oblika.graphic.wrapper.Shader;
import licence.projet.oblika.graphic.wrapper.Texture;
import licence.projet.oblika.graphic.wrapper.VAO;
import licence.projet.oblika.graphic.wrapper.VBO;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.Character;
import licence.projet.oblika.model.hitboxes.HitBox;

public class CharacterRenderer {
    private Shader shader;
    private Texture bueno;

    private VAO rectVAO;
    private float[] pos;
    private float[] size;

    public CharacterRenderer() throws Exception {
        shader = new Shader("glsl_character_vert", "glsl_character_frag", "character");

        bueno = new Texture("buenosmole");

        rectVAO = new VAO()
                .addVBO(new VBO(Mesh.gen2DQuad(0.5f, 0.5f), 2, 0))
                .addVBO(new VBO(Mesh.gen2DQuadUV(), 2, 1))
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

    public void render(Character character) {
        final Point2D position = character.getActualPosition();
        pos[0] = position.getX();
        pos[1] = position.getY();

        final HitBox hitBox = character.getHitBox();
        final Point2D topLeft = hitBox.getTopLeft();
        final Point2D botRight = hitBox.getBotRight();

        size[0] = botRight.getX() - topLeft.getX();
        size[1] = topLeft.getY() - botRight.getY();

        shader.sendVec2(1, pos);
        shader.sendVec2(2, size);
        shader.sendFloat(3, 0);
        bueno.bind();
        rectVAO.draw();
    }
}
