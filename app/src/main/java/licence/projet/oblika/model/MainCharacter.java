package licence.projet.oblika.model;

public class MainCharacter implements Character {

    private RectangleHitBox hitBox;
    private Point2D position;

    public MainCharacter(RectangleHitBox hitBox, Point2D position){
        this.hitBox = hitBox;
        this.position = position;
    }

    @Override
    public String getType() {
        return "MainCharacter";
    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveTop() {

    }

    @Override
    public void moveBot() {

    }

    @Override
    public Point2D getPosition(){
        return this.position;
    }

    @Override
    public void getTextureId() {

    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
}
