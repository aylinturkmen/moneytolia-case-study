package com.moneytolia.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BrowserUtils {

	public static void waitFor(double timeout) {
		try {
			Thread.sleep((long) timeout * 1000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	public static String getTitle() {
		return DriverManager.getWebDriver().getTitle();
	}

	public static String getScreenshot(String name) {
		// Adding date and time to the screenshot name to make it unique
		name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
		String path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getWebDriver();
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void hoverOver(WebElement element) {
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.moveToElement(element).perform();
	}

	public static void dismissAds() {
		try {
			DriverManager.getWebDriver().findElement(By.id("dismiss-button")).click();
		}
		catch (Exception e) {
			System.out.println("No ads to dismiss");
		}
	}

}
