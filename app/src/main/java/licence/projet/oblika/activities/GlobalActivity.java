package licence.projet.oblika.activities;

import android.app.Activity;
import android.os.Bundle;

import licence.projet.oblika.R;

public class GlobalActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO ca marche pas ici non plus
        setContentView(R.layout.activity_global);
    }
}
