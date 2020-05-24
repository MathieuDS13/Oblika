package licence.projet.oblika.engine.utils;

import android.view.MotionEvent;
import android.view.View;

public class TouchEventListener implements View.OnTouchListener {
    private static float x = -1;
    private static float y = -1;
    private static boolean rightSideTouched = false;
    private static boolean leftSideTouched = false;
    private static boolean jump = false;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();

        /*
        On attribut la valeur de x et y de l'envent lorsque l'action du toucher vient de commencer,
        vient de se terminer ou à commencer mais à bouger
         */
        if(action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE ){

            x = motionEvent.getX();
            y = motionEvent.getY();
            leftSideTouched = x < view.getWidth()/2;
            rightSideTouched = x > view.getWidth() /2;
            return true;
        }
        if( action == MotionEvent.ACTION_POINTER_DOWN) jump = true;
        if (action == MotionEvent.ACTION_POINTER_UP) jump = false;
        if(action == MotionEvent.ACTION_UP ) {
            x = -1;
            y = -1;
            rightSideTouched = false;
            leftSideTouched = false;
        }
        return false;
    }

    public static float getX() {
        return x;
    }

    public static float getY() {
        return y;
    }

    public static boolean isRightSideTouched(){
        return rightSideTouched;
    }

    public static boolean isLeftSideTouched(){
        return leftSideTouched;
    }

    
}
