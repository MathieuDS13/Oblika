package licence.projet.oblika.graphic.wrapper;

import android.opengl.GLES30;

import java.util.ArrayList;

interface DrawState {
    void draw(int mode, int dataLength);
}

class ArrayDrawState implements DrawState {
    @Override
    public void draw(int mode, int dataLength) {
        GLES30.glDrawArrays(mode, 0, dataLength);
    }
}

class ElementDrawState implements DrawState {
    @Override
    public void draw(int mode, int nbIndex) {
        GLES30.glDrawElements(mode, nbIndex, GLES30.GL_UNSIGNED_SHORT, 0);
    }
}

public class VAO {
    private static final DrawState ADState = new ArrayDrawState();
    private static final DrawState EDState = new ElementDrawState();

    private int pointer;
    protected int mode;
    private int length;
    private IBO ibo;
    private ArrayList<VBO> vbos;
    private DrawState drawState;

    public VAO(){
        this(GLES30.GL_TRIANGLES);
    }

    public VAO(int mode) {
        int[] ref = new int[1];
        GLES30.glGenVertexArrays(1, ref, 0);
        pointer = ref[0];
        setMode(mode);
        length = -1;
        vbos = new ArrayList();
    }

    public VAO setMode(int mode) {
        this.mode = mode;
        return this;
    }

    public VAO setIBO(IBO ibo) {
        this.ibo = ibo;
        length = ibo.getDataLength();
        return this;
    }

    public VAO addVBO(VBO vbo) {
        if(ibo == null) length = vbo.getDataLength();
        vbos.add(vbo);
        return this;
    }

    public VAO prepare() {
        bind();
        if(ibo != null) ibo.bind();
        for(VBO vbo : vbos) {
            vbo.bind();
            GLES30.glEnableVertexAttribArray(vbo.getAttribLocation());
        }
        unbind();

        if(ibo == null) drawState = ADState;
        else drawState = EDState;

        return this;
    }

    public void bind() {
        GLES30.glBindVertexArray(pointer);
    }

    public void unbind() {
        GLES30.glBindVertexArray(0);
    }

    public void draw() {
        bind();
        drawState.draw(mode, length);
    }

    public void delete() {
        int[] ref = new int[]{pointer};
        GLES30.glDeleteVertexArrays(1, ref, 0);

        if(ibo != null) ibo.delete();
        for(VBO vbo : vbos) vbo.delete();
    }
}
