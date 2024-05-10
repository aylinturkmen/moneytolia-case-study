package com.moneytolia.pages;

import com.moneytolia.utils.BrowserUtils;
import com.moneytolia.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

	protected WebDriver driver;

	protected WebDriverWait wait;

	public Actions actions;

	public BasePage() {
		driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(id = "onetrust-reject-all-handler")
	private WebElement rejectCookiesButton;

	public void rejectCookies() {
		try {
			rejectCookiesButton.click();
		}
		catch (Exception e) {
			BrowserUtils.waitFor(2);
			rejectCookiesButton.click();
		}
	}

}
