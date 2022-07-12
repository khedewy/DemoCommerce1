package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaptureScreenshoots {

     public static void takingScreenshoots(WebDriver driver, String screenshootName){


         Path desination = Paths.get("./Screenshoots",screenshootName+".png");

         try {
             Files.createDirectories(desination.getParent());
             FileOutputStream out = new FileOutputStream(desination.toString());
             out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
             out.close();
         } catch (IOException e) {
             System.out.println("taking screenshot ...");
         }


     }


}
