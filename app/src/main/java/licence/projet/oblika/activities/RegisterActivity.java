package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class RegisterActivity extends Activity {

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(activity2Intent);
        }

        Button register = findViewById(R.id.registerButton);
        Button goToLogin = findViewById(R.id.goToLogin);
        final EditText edEmail = findViewById(R.id.registerEmail);
        final EditText edPass = findViewById(R.id.registerPass);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String email = edEmail.getText().toString().trim();
                    String password = edPass.getText().toString().trim();
                    if (isInfoValid(email, password)) {
                        signUp(email, password);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Invalid info.",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(RegisterActivity.this, "Invalid info.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(activity2Intent);
            }
        });
    }

    private void signUp(String email, String password) {
        boolean validInfo = false;
        final EditText edPseudo = findViewById(R.id.edPseudo);

        validInfo = isInfoValid(email, password);

        if (validInfo) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                String pseudo = edPseudo.getText().toString();
                                DataBaseHandler.register(user, pseudo);
                                DataBaseHandler.login(user);
                                Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(activity2Intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(RegisterActivity.this, "Invalid info.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isInfoValid(String mail, String password) {
        return (mail != null && password != null);
    }

}
