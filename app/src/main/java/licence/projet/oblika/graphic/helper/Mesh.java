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
}
