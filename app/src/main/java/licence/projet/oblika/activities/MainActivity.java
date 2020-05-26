package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import licence.projet.oblika.R;

public class  MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGameActivity = findViewById(R.id.buttonGameActivity);
        buttonGameActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(activity2Intent);
            }
        });

        Button buttonPrefActivity = findViewById(R.id.buttonPrefActivity);
        buttonPrefActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), PreferencesActivity.class);
                startActivity(activity2Intent);
            }
        });

        Button buttonLeaderBoardActivity = findViewById(R.id.buttonGameActivity3);
        buttonLeaderBoardActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), LeaderBoardActivity.class);
                startActivity(activity2Intent);
            }
        });
    }

}
