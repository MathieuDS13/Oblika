package licence.projet.oblika.model.game_objects.drawable.hitboxed;

import licence.projet.oblika.model.game_objects.drawable.Position;
import licence.projet.oblika.model.hitboxes.HitBox;

public interface HitBoxed extends Position {
    HitBox getHitBox();
}
