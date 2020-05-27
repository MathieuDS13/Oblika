package licence.projet.oblika.model.game_objects.drawable.hitboxed;

import licence.projet.oblika.model.Point2D;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.characters.Character;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.Platform;
import licence.projet.oblika.model.hitboxes.HitBox;
import licence.projet.oblika.model.hitboxes.RectangleHitBox;

public class CollisionTester {
    private static RectangleHitBox ch = new RectangleHitBox(new Point2D(-5, 0), new Point2D(0, -5));
    private static RectangleHitBox ph = new RectangleHitBox(new Point2D(-5, 0), new Point2D(0, -5));

    public static void moveCharacter(Character character , Platform platform) {
        HitBox charHitBox = character.getHitBox();

        ch.getTopLeft().setX(charHitBox.getTopLeft().getX() + character.getActualPosition().getX());
        ch.getTopLeft().setY(charHitBox.getTopLeft().getY() + character.getActualPosition().getY());

        ch.getBotRight().setX(charHitBox.getBotRight().getX() + character.getActualPosition().getX());
        ch.getBotRight().setY(charHitBox.getBotRight().getY() + character.getActualPosition().getY());


        HitBox platformHitBox = platform.getHitBox();
        ph.getTopLeft().setX(platformHitBox.getTopLeft().getX() + platform.getActualPosition().getX());
        ph.getTopLeft().setY(platformHitBox.getTopLeft().getY() + platform.getActualPosition().getY());

        ph.getBotRight().setX(platformHitBox.getBotRight().getX() + platform.getActualPosition().getX());
        ph.getBotRight().setY(platformHitBox.getBotRight().getY() + platform.getActualPosition().getY());

        if(!
                (
                        (ch.getBotRight().getX() < ph.getTopLeft().getX()) || (ch.getTopLeft().getX() > ph.getBotRight().getX()) ||
                        (ch.getBotRight().getY() > ph.getTopLeft().getY()) || (ch.getTopLeft().getY() < ph.getBotRight().getY())
                )
        ) {
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
}
