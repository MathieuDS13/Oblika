package licence.projet.oblika.model;

public interface Movable extends Position, HitBoxed{
    void moveRight();
    void moveLeft();
    void moveTop();
    void moveBot();
}
