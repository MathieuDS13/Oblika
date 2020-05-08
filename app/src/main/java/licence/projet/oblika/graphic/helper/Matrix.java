package licence.projet.oblika.graphic.helper;

public class Matrix {
    public static void printMat4(float[] mat) {
        for(int i = 0; i < 16; ++i) {
            if(i % 4 == 0) System.out.println();
            System.out.print(mat[i]+ ", ");
        }
        System.out.println();
    }

    public static float[] mat4GenIdentity() {
        float[] m = new float[16];
        m[0] =  1; m[1] =  0; m[2] =  0; m[3] =  0;
        m[4] =  0; m[5] =  1; m[6] =  0; m[7] =  0;
        m[8] =  0; m[9] =  0; m[10] = 1; m[11] = 0;
        m[12] = 0; m[13] = 0; m[14] = 0; m[15] = 1;

        return m;
    }

    public static void mat4Ortho(float[] out, float left, float right, float bottom, float top, float near, float far) {
        float lr = 1f / (left - right);
        float bt = 1f / (bottom - top);
        float nf = 1f / (near - far);
        out[0] = -2 * lr;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = -2 * bt;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = 2 * nf;
        out[11] = 0;
        out[12] = (left + right) * lr;
        out[13] = (top + bottom) * bt;
        out[14] = (far + near) * nf;
        out[15] = 1;
    }

    public static void mat4Mult(float[] out, float[] a, float[] b) {
        float a00 = a[0],
                a01 = a[1],
                a02 = a[2],
                a03 = a[3];
        float a10 = a[4],
                a11 = a[5],
                a12 = a[6],
                a13 = a[7];
        float a20 = a[8],
                a21 = a[9],
                a22 = a[10],
                a23 = a[11];
        float a30 = a[12],
                a31 = a[13],
                a32 = a[14],
                a33 = a[15];
        // Cache only the current line of the second matrix
        float b0 = b[0],
                b1 = b[1],
                b2 = b[2],
                b3 = b[3];
        out[0] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[1] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[2] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[3] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        b0 = b[4];
        b1 = b[5];
        b2 = b[6];
        b3 = b[7];
        out[4] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[5] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[6] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[7] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        b0 = b[8];
        b1 = b[9];
        b2 = b[10];
        b3 = b[11];
        out[8] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[9] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[10] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[11] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        b0 = b[12];
        b1 = b[13];
        b2 = b[14];
        b3 = b[15];
        out[12] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[13] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[14] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[15] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
    }
}
