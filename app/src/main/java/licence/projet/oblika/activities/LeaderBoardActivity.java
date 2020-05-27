package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import licence.projet.oblika.R;

public class LeaderBoardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        Button buttonAmisdActivity = findViewById(R.id.amis);
        buttonAmisdActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), AmisActivity.class);
                startActivity(activity2Intent);
            }
        });

        Button buttonGlobaldActivity = findViewById(R.id.global);
        buttonGlobaldActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), GlobalActivity.class);
                startActivity(activity2Intent);
            }
        });
    }
}
