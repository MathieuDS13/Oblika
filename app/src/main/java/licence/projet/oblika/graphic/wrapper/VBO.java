package licence.projet.oblika.graphic.wrapper;

import android.opengl.GLES30;

import java.nio.FloatBuffer;

public class VBO extends BufferObject {

    private int attribLocation;
    private int nbOfElement;

    public VBO(FloatBuffer data, int nbOfElement, int attribLocation) {
        this(data, nbOfElement, attribLocation, GLES30.GL_STATIC_DRAW);
    }

    public VBO(FloatBuffer data, int nbOfElement, int attribLocation, int usage) {
        super(usage);

        this.attribLocation = attribLocation;
        this.nbOfElement = nbOfElement;
        this.dataLength = data.capacity() * 4;

        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, pointer);
        //data.position(0);
        data.rewind();
        GLES30.glBufferData(GLES30.GL_ARRAY_BUFFER, dataLength, data, usage);
    }

    public void setData(FloatBuffer data, int offset) {
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, pointer);
        //data.position(0);
        data.rewind();
        GLES30.glBufferSubData(GLES30.GL_ARRAY_BUFFER, offset * 4, dataLength, data);
    }

    public int getAttribLocation() {
        return attribLocation;
    }

    @Override
    public void bind() {
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, pointer);
        GLES30.glVertexAttribPointer(attribLocation, nbOfElement, GLES30.GL_FLOAT, false, 0, 0);
    }

    @Override
    public void unbind() {
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, 0);
    }

    @Override
    public int getDataLength() {
        return dataLength / nbOfElement;
    }
}
