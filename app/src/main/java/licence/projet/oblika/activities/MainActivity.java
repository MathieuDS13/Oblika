package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import licence.projet.oblika.R;
import licence.projet.oblika.model.DataBaseHandler;

public class MainActivity extends Activity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        DataBaseHandler.init(this);

        if (currentUser == null) {
            Intent activity2Intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(activity2Intent);
        }

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
