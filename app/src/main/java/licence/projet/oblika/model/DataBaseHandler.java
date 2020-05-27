package licence.projet.oblika.model;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseHandler {

    private static String pseudo = "Guest";
    private static String mail = null;
    private static FirebaseUser user;
    private static FirebaseAuth mAuth;
    private static Context context;
    private static DatabaseReference mDatabase;

    public static void init(Context context) {
        DataBaseHandler.mAuth = FirebaseAuth.getInstance();
        DataBaseHandler.context = context;
        DataBaseHandler.mDatabase = FirebaseDatabase.getInstance().getReference();
        user = mAuth.getCurrentUser();
    }

    public static void createNewUser(String pseudo, String email) {
        User user = new User(pseudo, mail);
        mDatabase.child("users").child(user.getEmail()).setValue(user);
    }

    public static String getPseudo() {
        return pseudo;
    }

    public static void setPseudo(String pseudo) {

        DataBaseHandler.pseudo = pseudo;
    }

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        DataBaseHandler.mail = mail;
    }

    private boolean isInfoValid(String mail, String password) {
        return false;
    }

    public static void setUser(FirebaseUser user) {
        DataBaseHandler.user = user;
    }
}
