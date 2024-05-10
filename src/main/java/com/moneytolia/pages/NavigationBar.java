package com.moneytolia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage {

	@FindBy(xpath = "//a[@href='/']")
	private WebElement homeButton;

	@FindBy(xpath = "//a[@href='/products']")
	private WebElement productsButton;

	@FindBy(xpath = "//a[@href='/view cart']")
	private WebElement cartButton;

	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginSignUpButton;

	@FindBy(xpath = "//a[@href='/test cases']")
	private WebElement testCasesButton;

	@FindBy(css = "a img")
	private WebElement logo;

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getHomeButton() {
		return homeButton;
	}

	public WebElement getProductsButton() {
		return productsButton;
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public WebElement getLoginSignUpButton() {
		return loginSignUpButton;
	}

	public WebElement getTestCasesButton() {
		return testCasesButton;
	}

}
