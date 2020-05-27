package licence.projet.oblika.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import licence.projet.oblika.R;
import licence.projet.oblika.model.DataBaseHandler;

public class UtilisateurActivity extends Activity {

    Button deleteUser;
    TextView pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisateur);

        deleteUser = findViewById(R.id.deleteUser);
        pseudo = findViewById(R.id.pseudoView);

        update();

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler.deleteUser();
                update();
            }
        });
    }

    private void update() {
        pseudo.setText(DataBaseHandler.getPseudo());
    }
}
