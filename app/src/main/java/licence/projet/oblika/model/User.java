package licence.projet.oblika.model;

public class User {

    private String pseudo;
    private String email;

    private double bestTime = -1;

    private int progress = -1;

    public User() {
    }

    public User(String pseudo, String email) {
        this.pseudo = pseudo;
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
