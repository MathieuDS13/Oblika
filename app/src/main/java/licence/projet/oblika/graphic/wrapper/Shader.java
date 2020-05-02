package licence.projet.oblika.graphic.wrapper;

import android.opengl.GLES30;

public class Shader {
    private String name;

    private int vertexShader;
    private int fragmentShader;
    private int program;

    public Shader(String vs, String fs) throws Exception {
        this(vs, fs, "Shader");
    }

    public Shader(String vs, String fs, String name) throws Exception {
        this.name = name;

        vertexShader = createShader(GLES30.GL_VERTEX_SHADER, /*ResLoader.text(vs)*/ vs);
        if(vertexShader == 0) throw new Exception("Erreur creation VS");

        fragmentShader = createShader(GLES30.GL_FRAGMENT_SHADER, /*ResLoader.text(fs)*/ fs);
        if(fragmentShader == 0) throw new Exception("Erreur creation FS");

        createProgramme();
    }

    private int createShader(int type, String text) throws Exception {
        int shader = GLES30.glCreateShader(type);

        GLES30.glShaderSource(shader, text);
        GLES30.glCompileShader(shader);

        int[] compileStatus = new int[1];
        GLES30.glGetShaderiv(shader, GLES30.GL_COMPILE_STATUS, compileStatus, 0);
        if (compileStatus[0] != GLES30.GL_TRUE) {
            System.out.println(name + " -> erreur de compilation "+ (type == GLES30.GL_VERTEX_SHADER ? "vertex" : "fragment") +" shader!");
            String error = GLES30.glGetShaderInfoLog(shader);
            System.out.println(error);
            throw new Exception(error);
        }

        return shader;
    }

    private void createProgramme() throws Exception {
        int program = GLES30.glCreateProgram();
        GLES30.glAttachShader(program, this.vertexShader);
        GLES30.glAttachShader(program, this.fragmentShader);
        GLES30.glLinkProgram(program);

        int[] linkStatus = new int[1];
        GLES30.glGetProgramiv(program, GLES30.GL_LINK_STATUS, linkStatus, 0);
        if (linkStatus[0] != GLES30.GL_TRUE) {
            System.out.println(this.name + " -> Impossible de lier le programme");
            String error = GLES30.glGetProgramInfoLog(program);
            delete();
            throw new Exception(error);
        }

        GLES30.glValidateProgram(program);

        int[] validateStatus = new int[1];
        GLES30.glGetProgramiv(program, GLES30.GL_VALIDATE_STATUS, validateStatus, 0);

        if (validateStatus[0] != GLES30.GL_TRUE) {
            GLES30.glGetProgramInfoLog(program);
            System.out.println(name + " -> erreur de validation du programme");
            String error = GLES30.glGetProgramInfoLog(program);
            delete();
            throw new Exception(error);
        }

        this.program = program;
    }

    private void delShad(int s){
        GLES30.glDetachShader(program, s);
        GLES30.glDeleteShader(s);
    }

    public void delete() {
        delShad(vertexShader);
        delShad(fragmentShader);

        GLES30.glDeleteProgram(program);
    }

    public void bind() {
        GLES30.glUseProgram(program);
    }

    public void sendFloat(int index, float f) {
        GLES30.glUniform1f(index, f);
    }

    public void sendMat4(int index, float[] mat) {
        GLES30.glUniformMatrix4fv(index, 1,false, mat, 0);
    }
}

