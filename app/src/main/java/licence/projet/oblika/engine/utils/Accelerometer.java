package licence.projet.oblika.engine.utils;

public class Accelerometer {
    float x, y, z;

    public void onSensorChanged(int sensor, float[] values) {

        x = values[0];

        y = values[1];

        z = values[2];

    }
}
