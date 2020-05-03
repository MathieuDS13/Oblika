package licence.projet.oblika.graphic.wrapper;

import android.opengl.GLES30;

import java.nio.ShortBuffer;

public class IBO extends BufferObject {
    public IBO(ShortBuffer data) {
        this(data, GLES30.GL_STATIC_DRAW);
    }

    public IBO(ShortBuffer data, int usage) {
        super(usage);

        dataLength = data.capacity();

        GLES30.glBindBuffer(GLES30.GL_ELEMENT_ARRAY_BUFFER, pointer);
        data.position(0);
        GLES30.glBufferData(GLES30.GL_ELEMENT_ARRAY_BUFFER, dataLength * 2, data, usage);
    }

    public void setData(ShortBuffer data, int offset) {
        GLES30.glBindBuffer(GLES30.GL_ELEMENT_ARRAY_BUFFER, pointer);
        GLES30.glBufferSubData(GLES30.GL_ELEMENT_ARRAY_BUFFER, offset * 2, dataLength * 2, data);
    }

    public void bind() {
        GLES30.glBindBuffer(GLES30.GL_ELEMENT_ARRAY_BUFFER, pointer);
    }

    @Override
    public void unbind() {
        GLES30.glBindBuffer(GLES30.GL_ELEMENT_ARRAY_BUFFER, 0);
    }
}
