package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import licence.projet.oblika.R;
import licence.projet.oblika.model.DataBaseHandler;

import static android.support.constraint.Constraints.TAG;

public class LoginActivity extends Activity {

    private FirebaseAuth mAuth;
    Button buttonLogin, goToRegister;
    EditText edMail, edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        buttonLogin = findViewById(R.id.login);
        edMail = findViewById(R.id.email);
        edPass = findViewById(R.id.password);
        goToRegister = findViewById(R.id.goToRegister);


        buttonLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String email = edMail.getText().toString();
                String password = edPass.getText().toString();
                login(email, password);
            }
        });


        goToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(activity2Intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        //TODO si currentUser != null il faut alors il est log, il faut retourner sur la page principale
    }


    private boolean isInfoValid(String mail, String password) {
        return false;
    }

    private void login(String email, String password) {
        boolean infoIsValid = isInfoValid(email, password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            DataBaseHandler.setUser(user);
                            //Renvoie sur la page d'accueil
                            Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(activity2Intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //TODO mettre à jour la page si l'utilisateur n'arrive pas à se connecter
                        }

                        // ...
                    }
                });
    }
}
