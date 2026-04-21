package lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;
    private String name;

    // 7.6.2 b): Instanță unică și contor
    private static PasswordMaker instance;
    private static int callingCounts = 0;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        // 7.6.2 b): Initializare instanță în bloc static
        instance = new PasswordMaker("SingletonUser");
    }

    // 7.6.2 a): Constructor privat
    private PasswordMaker(String name) {
        this.name = name;
    }

    // 7.6.2 a) + c): Metodă getInstance cu contor
    public static PasswordMaker getInstance() {
        callingCounts++;
        return instance;
    }

    public static int getCallingCounts() {
        return callingCounts;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}