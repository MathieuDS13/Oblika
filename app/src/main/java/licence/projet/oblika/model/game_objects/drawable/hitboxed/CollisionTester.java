package licence.projet.oblika.model.game_objects.drawable.hitboxed;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.Character;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.Platform;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class CollisionTester {
    private static RectangleHitBox ch = new RectangleHitBox(new Point2D(-5, 0), new Point2D(0, -5));
    private static RectangleHitBox ph = new RectangleHitBox(new Point2D(-5, 0), new Point2D(0, -5));

    private static void fillBuffers(HitBoxed c, HitBoxed p) {
        HitBox charHitBox = c.getHitBox();
        ch.getTopLeft().setX(charHitBox.getTopLeft().getX() + c.getActualPosition().getX());
        ch.getTopLeft().setY(charHitBox.getTopLeft().getY() + c.getActualPosition().getY());

        ch.getBotRight().setX(charHitBox.getBotRight().getX() + c.getActualPosition().getX());
        ch.getBotRight().setY(charHitBox.getBotRight().getY() + c.getActualPosition().getY());

        HitBox platformHitBox = p.getHitBox();
        ph.getTopLeft().setX(platformHitBox.getTopLeft().getX() + p.getActualPosition().getX());
        ph.getTopLeft().setY(platformHitBox.getTopLeft().getY() + p.getActualPosition().getY());

        ph.getBotRight().setX(platformHitBox.getBotRight().getX() + p.getActualPosition().getX());
        ph.getBotRight().setY(platformHitBox.getBotRight().getY() + p.getActualPosition().getY());
    }


    public static boolean buffersOverlap() {
        return !(
                        (ch.getBotRight().getX() < ph.getTopLeft().getX()) || (ch.getTopLeft().getX() > ph.getBotRight().getX()) ||
                        (ch.getBotRight().getY() > ph.getTopLeft().getY()) || (ch.getTopLeft().getY() < ph.getBotRight().getY())
                );
    }


    public static void moveCharacter(Character character , Platform platform) {
        fillBuffers(character, platform);

        if(buffersOverlap()) {
            final float dxg = ph.getBotRight().getX() - ch.getTopLeft().getX();
            final float dxd = ch.getBotRight().getX() - ph.getTopLeft().getX();

            final float dyg = ph.getTopLeft().getY() - ch.getBotRight().getY();
            final float dyd = ch.getTopLeft().getY() - ph.getBotRight().getY();

            final float minx = Math.min(Math.abs(dxg), Math.abs(dxd));
            final float miny = Math.min(Math.abs(dyg), Math.abs(dyd));

            if(Math.min(minx, miny) == minx) {
                if(minx == Math.abs(dxg) && dxg > 0) {
                    character.getActualPosition().setX(character.getActualPosition().getX() + dxg);
                }
                else if(minx == Math.abs(dxd) && dxd > 0) {
                    character.getActualPosition().setX(character.getActualPosition().getX() - dxd);
                }

            } else {
                if(miny == Math.abs(dyg) && dyg > 0) {
                    character.getActualPosition().setY(character.getActualPosition().getY() + dyg);
                    character.setGrounded();
                }
                else if(miny == Math.abs(dyd) && dyd > 0) {
                    character.getActualPosition().setY(character.getActualPosition().getY() - dyd);
                }
            }
        }
    }

    public static boolean characterTouchEndPoint(Character character, EndPoint endPoint) {
        fillBuffers(character, endPoint);
        return buffersOverlap();
    }

    public static boolean characterOutOfBounds(Character character) {
        return character.getActualPosition().getY() < -10f;
    }
}
