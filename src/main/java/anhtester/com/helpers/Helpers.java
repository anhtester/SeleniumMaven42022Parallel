package anhtester.com.helpers;

import java.io.File;

public class Helpers {

    public static String getCurrentDir() {
        //File.separator = ký tự phân cách thư mục máy tính
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

}
