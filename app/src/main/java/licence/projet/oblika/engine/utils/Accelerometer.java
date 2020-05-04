package licence.projet.oblika.engine.utils;

import android.hardware.SensorListener;

public class Accelerometer implements SensorListener {
    float x, y, z;

    public void onSensorChanged(int sensor, float[] values) {

        x = values[0];

        y = values[1];

        z = values[2];

    }

    @Override
    public void onAccuracyChanged(int i, int i1) {

    }
}
