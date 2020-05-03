package licence.projet.oblika;

public class Time {
    public static float now;
    public static float last;
    public static float delta;

    public static long l_now;
    public static long l_last;
    public static long l_delta;

    private static long start;

    public static void init() {
        Time.start = System.nanoTime();

        Time.l_now = Time.start;
        Time.l_delta = 0;
        Time.l_last = Time.l_now;

        Time.now = (Time.l_now / 1e9f);
        Time.delta = 0;
        Time.last = Time.now;
    }

    public static void update() {
        Time.l_now = System.nanoTime() - Time.start;
        Time.l_delta = Time.l_now - Time.l_last;
        Time.l_last = Time.l_now;

        Time.now = Time.l_now / 1e9f;
        Time.delta = Time.now - Time.last;
        Time.last = Time.now;
    }
}
