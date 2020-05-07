package licence.projet.oblika.graphic.wrapper;

import android.opengl.GLES30;

public class FrameBuffer {
    private static int initialWidth;
    private static int initialHeight;

    private int pointer;
    private int depthRBPointer;

    private Texture texColor;

    public FrameBuffer(int width, int height) throws Exception {
        this(width, height, false);
    }

    public FrameBuffer(int width, int height, boolean depthTest) throws Exception {
        int[] p = new int[1];
        GLES30.glGenFramebuffers(1, p, 0);
        pointer = p[0];

        texColor = new Texture(width, height);

        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, pointer);
        GLES30.glFramebufferTexture2D(GLES30.GL_FRAMEBUFFER, GLES30.GL_COLOR_ATTACHMENT0, GLES30.GL_TEXTURE_2D, texColor.getPointer(), 0);

        if(depthTest) {
            GLES30.glGenRenderbuffers(1, p, 0);
            depthRBPointer = p[0];

            GLES30.glBindRenderbuffer(GLES30.GL_RENDERBUFFER, depthRBPointer);
            GLES30.glRenderbufferStorage(GLES30.GL_RENDERBUFFER, GLES30.GL_DEPTH_COMPONENT16, width, height);
            GLES30.glFramebufferRenderbuffer(GLES30.GL_FRAMEBUFFER, GLES30.GL_DEPTH_ATTACHMENT, GLES30.GL_RENDERBUFFER, depthRBPointer);
        } else {
            depthRBPointer = -1;
        }

        int status = GLES30.glCheckFramebufferStatus(GLES30.GL_FRAMEBUFFER);

        if(status != GLES30.GL_FRAMEBUFFER_COMPLETE) {
            System.out.println("FBORenderer -> Framebuffer incomplete. Status: " + status);
            throw new Exception("Error creating FBO");
        }
    }

    public static void setInitialSize(int width, int height) {
        initialWidth = width;
        initialHeight = height;
    }

    public void bind() {
        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, pointer);
        if(depthRBPointer != -1) GLES30.glBindRenderbuffer(GLES30.GL_RENDERBUFFER, depthRBPointer);
        GLES30.glViewport(0, 0, texColor.getWidth(), texColor.getHeight());
    }

    public void unbind() {
        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, 0);
        GLES30.glBindRenderbuffer(GLES30.GL_RENDERBUFFER, 0);
        GLES30.glViewport(0, 0, initialWidth, initialHeight);
    }
}
