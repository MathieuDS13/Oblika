package licence.projet.oblika.graphic.helper;

import java.nio.FloatBuffer;

public class Mesh {
    public static FloatBuffer gen2DQuad(float xOffset, float yOffset) {
        FloatBuffer b = FloatBuffer.allocate(12); // 6 * 2 = 12

        b.put(xOffset); b.put(yOffset);
        b.put(-xOffset); b.put(yOffset);
        b.put(-xOffset); b.put(-yOffset);

        b.put(xOffset); b.put(yOffset);
        b.put(-xOffset); b.put(-yOffset);
        b.put(xOffset); b.put(-yOffset);

        return b;
    }

    public static FloatBuffer gen2DQuad2(float xOffset, float yOffset) {
        FloatBuffer b = FloatBuffer.allocate(12); // 6 * 2 = 12

        b.put(xOffset + xOffset + 100); b.put(yOffset + yOffset + 100);
        b.put(-xOffset + xOffset + 100); b.put(yOffset + yOffset + 100);
        b.put(-xOffset + xOffset + 100); b.put(-yOffset + yOffset + 100);

        b.put(xOffset + xOffset + 100); b.put(yOffset + yOffset + 100);
        b.put(-xOffset + xOffset + 100); b.put(-yOffset + yOffset + 100);
        b.put(xOffset + xOffset + 100); b.put(-yOffset + yOffset + 100);

        return b;
    }

    /*
    * 1------2
    * |      |
    * |      |
    * 3------4
    * */
    public static void fill2DQuad(FloatBuffer b, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
        b.rewind();

        b.put(x2); b.put(y2);
        b.put(x1); b.put(y1);
        b.put(x3); b.put(y3);

        b.put(x2); b.put(y2);
        b.put(x3); b.put(y3);
        b.put(x4); b.put(y4);
    }

    public static FloatBuffer gen2DQuadUV() {
        FloatBuffer b = FloatBuffer.allocate(12);

        b.put(1f); b.put(0f);
        b.put(0f); b.put(0f);
        b.put(0f); b.put(1f);

        b.put(1f); b.put(0f);
        b.put(0f); b.put(1f);
        b.put(1f); b.put(1f);

        return b;
    }
}
