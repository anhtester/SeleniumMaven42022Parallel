package anhtester.com.constants;

import anhtester.com.helpers.PropertiesHelpers;

public class ConstantGlobal {
    static {
        PropertiesHelpers.loadAllFiles();
    }

    public final static String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public final static boolean HEADLESS = Boolean.parseBoolean(PropertiesHelpers.getValue("HEADLESS"));
    public final static String URL = PropertiesHelpers.getValue("URL");
    public final static String USERNAME = PropertiesHelpers.getValue("USERNAME");
    public final static String PASSWORD = PropertiesHelpers.getValue("PASSWORD");
    public final static long STEP_TIME = Long.parseLong(PropertiesHelpers.getValue("STEP_TIME"));
    public final static long EXPLICIT_TIMEOUT = Long.parseLong(PropertiesHelpers.getValue("EXPLICIT_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertiesHelpers.getValue("PAGE_LOAD_TIMEOUT"));
    public final static String ENV = PropertiesHelpers.getValue("ENV");
    public final static String SCREENSHOT_FAIL = PropertiesHelpers.getValue("SCREENSHOT_FAIL");
    public final static String SCREENSHOT_PASS = PropertiesHelpers.getValue("SCREENSHOT_PASS");
    public final static String SCREENSHOT_STEP = PropertiesHelpers.getValue("SCREENSHOT_STEP");
    public final static String RECORD_VIDEO = PropertiesHelpers.getValue("RECORD_VIDEO");
    public final static String RECORD_VIDEO_PATH = PropertiesHelpers.getValue("RECORD_VIDEO_PATH");
    public final static String EXTENT_REPORT_PATH = PropertiesHelpers.getValue("EXTENT_REPORT_PATH");
    public final static String AUTHOR = PropertiesHelpers.getValue("AUTHOR");

}
