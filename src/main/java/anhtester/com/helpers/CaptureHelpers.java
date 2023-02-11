package anhtester.com.helpers;

import anhtester.com.constants.ConstantGlobal;
import anhtester.com.driver.DriverManager;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.AudioFormatKeys.EncodingKey;
import static org.monte.media.AudioFormatKeys.FrameRateKey;
import static org.monte.media.AudioFormatKeys.KeyFrameIntervalKey;
import static org.monte.media.AudioFormatKeys.MIME_AVI;
import static org.monte.media.AudioFormatKeys.MediaTypeKey;
import static org.monte.media.AudioFormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.*;

public class CaptureHelpers extends ScreenRecorder {

    // ------Record with Monte Media library---------
    public static ScreenRecorder screenRecorder;
    public String name;

    //Hàm xây dựng
    public CaptureHelpers(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    //Hàm này bắt buộc để ghi đè custom lại hàm trong thư viên viết sẵn
    @Override
    protected File createMovieFile(Format fileFormat) {

        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            try {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }

    // Hàm Start record video
    public static void startRecord(String methodName) {
        //Tạo thư mục để lưu file video vào
        File file = new File(ConstantGlobal.RECORD_VIDEO_PATH + File.separator + methodName + File.separator);
        if (!file.exists()) {
            file.mkdirs();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        try {
            screenRecorder = new CaptureHelpers(gc, captureSize, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI), new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60), new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)), null, file, methodName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        try {
            screenRecorder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Stop record video
    public static void stopRecord() {
        try {
            screenRecorder.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Take a screenshot
    public static void takeScreenshot(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        try {

            FileHandler.copy(source, new File("./screenshots/" + result.getName() + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot taken: " + result.getName());
    }

    //Take a screenshot
    public static void takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        try {

            FileHandler.copy(source, new File("./screenshots/" + name + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot taken: " + name);
    }
}
