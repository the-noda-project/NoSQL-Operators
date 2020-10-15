package gr.ds.unipi.noda.api.core.constants;

public class Commons {
    public static final String BASE_PATH = Commons.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public static String commonPrefix(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }
        return a.substring(0, minLength);
    }
}
