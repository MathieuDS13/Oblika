package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import licence.projet.oblika.R;

public class PreferencesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        Button buttonSoundActivity = findViewById(R.id.buttonSound);
        buttonSoundActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), SoundActivity.class);
                startActivity(activity2Intent);
            }
        });

        Button buttonUtilisateurActivity = findViewById(R.id.buttonUtilisateur);
        buttonUtilisateurActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), UtilisateurActivity.class);
                startActivity(activity2Intent);
            }
        });

        Button buttonLeaderBoardActivity = findViewById(R.id.buttonGameActivity3);
        buttonLeaderBoardActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), UtilisateurActivity.class);
                startActivity(activity2Intent);
            }
        });
    }
}
