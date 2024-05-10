package com.moneytolia.step_definitions;

import com.moneytolia.utils.DriverManager;
import com.moneytolia.utils.Pages;

import org.openqa.selenium.WebDriver;

public abstract class BaseStep {

	protected final WebDriver DRIVER;

	protected static Pages PAGES;

	public BaseStep() {
		DRIVER = DriverManager.getWebDriver();
		PAGES = new Pages();

	}

}
