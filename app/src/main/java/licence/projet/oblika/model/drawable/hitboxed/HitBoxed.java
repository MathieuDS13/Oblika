package licence.projet.oblika.model.drawable.hitboxed;

import licence.projet.oblika.model.drawable.Position;
import licence.projet.oblika.model.hitboxes.HitBox;

public interface HitBoxed extends Position {
    HitBox getHitBox();
}
