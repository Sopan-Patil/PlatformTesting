package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public static String takeScreenshot(String fileName, WebDriver  driver) {
		
		
		String destination = "";
		try {
			File file2 = new File(new File(".", ObjectHelper.screenshotsFolder + "//" + fileName + ".png").getAbsolutePath());
			String name = fileName;
			int i = 0;
			while (file2.exists()) {
				i++;
				name = fileName + "(" + i + ")";
				file2 = new File(new File(".", ObjectHelper.screenshotsFolder + "//" + name + ".png").getAbsolutePath());
			}

			fileName = name + ".png";
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 			FileUtils.copyFile(srcFile, new File(new File(".", ObjectHelper.screenshotsFolder + "\\" + fileName).getAbsolutePath()));
			destination = new File(".", ObjectHelper.screenshotsFolder + "\\" + fileName).getAbsolutePath();

		} catch (Exception e) {
			System.out.println("Screenshot error" + e);
		}
		return destination;
	}
	public static String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}