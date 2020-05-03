package licence.projet.oblika.graphic.wrapper;

import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLUtils;

import licence.projet.oblika.graphic.helper.ResLoader;

public class Texture {

    private int pointer;
    private int unit;

    public Texture(String fileName) {
        final int[] textureHandle = new int[1];
        GLES30.glGenTextures(1, textureHandle, 0);
        pointer = textureHandle[0];

        Bitmap bitmap = ResLoader.bitmap(fileName);

        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, pointer);

        GLES30.glTexParameteri(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MIN_FILTER, GLES30.GL_NEAREST);
        GLES30.glTexParameteri(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MAG_FILTER, GLES30.GL_NEAREST);

        GLUtils.texImage2D(GLES30.GL_TEXTURE_2D, 0, bitmap, 0);

        bitmap.recycle();

        setUnit(0);
    }

    public Texture setUnit(int unit) {
        this.unit = unit;
        return this;
    }

    public void bind() {
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0 + unit);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, pointer);
    }

    public void delete() {
        int[] b = {pointer};
        GLES30.glDeleteTextures(1, b, 0);
    }
}
