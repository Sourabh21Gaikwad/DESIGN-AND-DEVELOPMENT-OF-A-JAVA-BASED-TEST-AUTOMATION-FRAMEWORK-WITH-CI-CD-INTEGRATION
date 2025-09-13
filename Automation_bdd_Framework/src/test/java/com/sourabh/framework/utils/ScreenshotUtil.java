package com.sourabh.framework.utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String methodName) {
        String timestamp = String.valueOf(new Date().getTime());
        String screenshotPath = "screenshots/" + methodName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destFile.getAbsolutePath();
    }
}

