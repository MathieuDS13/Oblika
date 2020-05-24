package licence.projet.oblika.engine.controller;

import licence.projet.oblika.activities.GLView;
import licence.projet.oblika.engine.utils.TouchEventListener;
import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class InGameTouchEventController {
    float viewWidth;
    float viewHeight;
    Point2D touchEvent_pos;
    RectangleHitBox leftBox;
    RectangleHitBox rightBox;
    enum Direction{ LEFT, RIGHT, NONE};
    Direction direction;

    public InGameTouchEventController(GLView view) {
        this.viewWidth = view.getWidth();
        this.viewHeight = view.getHeight();
        initLeftBox();
        initRightBox();
    }

    public Direction update(){
        float touchEvent_x = TouchEventListener.getX();
        float touchEvent_y = TouchEventListener.getY();
        this.touchEvent_pos = new Point2D(touchEvent_x,touchEvent_y);
        this.direction = Direction.NONE;
        if(leftBox.contains(touchEvent_pos)) this.direction = Direction.LEFT;
        if(rightBox.contains(touchEvent_pos)) this.direction = Direction.RIGHT;
        return  direction;
    }

    public RectangleHitBox initLeftBox(){
        //TODO verifier les coordonnées par rapport la vue
        Point2D topLeft = new Point2D(0,0);
        Point2D botRight = new Point2D(viewWidth/2,viewHeight);
        this.leftBox = new RectangleHitBox(topLeft, botRight);
        return  leftBox;
    }

    public RectangleHitBox initRightBox(){
        Point2D topLeft = new Point2D(viewWidth/2,0);
        Point2D botRight = new Point2D(viewWidth,viewHeight);
        this.rightBox = new RectangleHitBox(topLeft, botRight);
        return  rightBox;
    }

    public Direction getDirection() {
        return direction;
    }
}
