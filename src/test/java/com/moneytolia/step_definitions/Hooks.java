package com.moneytolia.step_definitions;

import com.moneytolia.utils.BrowserUtils;
import com.moneytolia.utils.ConfigurationManager;
import com.moneytolia.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(Hooks.class);

	public static Scenario scenario;

	@Before
	public void setup(Scenario scenario) {

		LOGGER.info("Test Scenario : " + scenario.getName());
		LOGGER.info("Browser type ----> " + ConfigurationManager.getProperty("browser"));

		DRIVER.get(ConfigurationManager.getProperty("baseURL"));
		BrowserUtils.waitFor(1);

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getWebDriver();
			byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			BrowserUtils.getScreenshot(scenario.getName());
			scenario.attach(image, "image/png", scenario.getName());
			LOGGER.error("Test scenario is failed " + scenario.getName());
		}
		else {
			LOGGER.info("Test scenario is passed");
		}
		DriverManager.closeDriver();
	}

}