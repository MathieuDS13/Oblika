package licence.projet.oblika.engine.utils;

import android.view.MotionEvent;
import android.view.View;

public class TouchEvent implements View.OnTouchListener {
    float x;
    float y;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();

        /*
        On attribut la valeur de x et y de l'envent lorsque l'action du toucher vient de commencer,
        vient de se terminer ou à commencer mais à bouger
         */
        if(action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_MOVE  ){

            x = motionEvent.getX();
            y = motionEvent.getY();
            return true;
        }
        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    
}
