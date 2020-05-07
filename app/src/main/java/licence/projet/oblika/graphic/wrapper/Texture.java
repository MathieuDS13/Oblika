package licence.projet.oblika.graphic.wrapper;

import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLUtils;

import licence.projet.oblika.graphic.helper.ResLoader;

public class Texture {

    private int pointer;
    private int unit;
    private int width;
    private int height;

    public Texture(String fileName) {
        genTex();

        Bitmap bitmap = ResLoader.bitmap(fileName);
        applyParams();
        GLUtils.texImage2D(GLES30.GL_TEXTURE_2D, 0, bitmap, 0);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        bitmap.recycle();
    }

    public Texture(int width, int height) {
        genTex();
        applyParams();
        GLES30.glTexImage2D(GLES30.GL_TEXTURE_2D, 0, GLES30.GL_RGBA4, width, height, 0, GLES30.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, null);
        this.width = width;
        this.height = height;
    }

    private void genTex() {
        final int[] textureHandle = new int[1];
        GLES30.glGenTextures(1, textureHandle, 0);
        pointer = textureHandle[0];
    }

    private void applyParams() {
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, pointer);

        GLES30.glTexParameteri(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MIN_FILTER, GLES30.GL_NEAREST);
        GLES30.glTexParameteri(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MAG_FILTER, GLES30.GL_NEAREST);
    }

    public Texture setUnit(int unit) {
        this.unit = unit;
        return this;
    }

    int getPointer() {
        return pointer;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
