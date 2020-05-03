package licence.projet.oblika.graphic.wrapper;

import android.opengl.GLES30;

public abstract class BufferObject {
    protected int pointer;
    protected int dataLength;
    protected int usage;

    public BufferObject() {
        this(GLES30.GL_STATIC_DRAW);
    }

    public BufferObject(int usage) {
        int[] pointerBuffer = new int[1];
        GLES30.glGenBuffers(1, pointerBuffer, 0);
        pointer = pointerBuffer[0];

        dataLength = -1;
        setUsage(usage);
    }

    public BufferObject setUsage(int usage) {
        this.usage = usage;
        return this;
    }

    public abstract void bind();

    public abstract void unbind();

    public void delete() {
        int[] b = {pointer};
        GLES30.glDeleteBuffers(1, b, 0);
    }

    public int getDataLength() {
        return dataLength;
    }
}
