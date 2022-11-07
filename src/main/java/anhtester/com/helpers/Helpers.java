package anhtester.com.helpers;

import java.io.File;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class Helpers {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String makeSlug(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        String noWhiteSpace = WHITESPACE.matcher(input).replaceAll("_");
        String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String getCurrentDir() {
        //File.separator = ký tự phân cách thư mục máy tính
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

}
