package com.moneytolia.pages;

import com.moneytolia.data.ProductData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

	@FindBy(css = "div[class='single-products']")
	private List<WebElement> products;

	@FindBy(css = "div[class='overlay-content'] a[class$='btn btn-default add-to-cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(css = ".modal-content button")
	private WebElement continueShoppingButton;

	@FindBy(css = ".modal-content a")
	private WebElement viewCartButton;

	@FindBy(css = ".overlay-content h2")
	private List<WebElement> productPrices;

	@FindBy(css = ".overlay-content p")
	private List<WebElement> productNames;

	public List<WebElement> getProductPrices() {
		return productPrices;
	}

	public List<WebElement> getProductNames() {
		return productNames;
	}

	public String getProductName(int index) {
		return productNames.get(index).getText();
	}

	public ProductData getProductData(int index) {
		ProductData productData = new ProductData();
		productData.setProductName(getProductName(index));
		productData.setProductPrice(getProductPrice(index));
		productData.setProductQuantity(1);
		return productData;
	}

	public double getProductPrice(int index) {
		System.out.println(productPrices.get(index).getText());
		hoverOverProduct(index);
		String price = productPrices.get(index).getText().split(" ")[1].trim();
		return Double.parseDouble(price);
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public List<WebElement> getAddToCartButtons() {
		return addToCartButtons;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getViewCartButton() {
		return viewCartButton;
	}

	public void clickAddToCartButton(int index) {
		addToCartButtons.get(index).click();
	}

	public void clickContinueShoppingButton() {
		continueShoppingButton.click();
	}

	public void clickViewCartButton() {
		viewCartButton.click();
	}

	public void clickProduct(int index) {
		products.get(index).click();
	}

	public void hoverOverProduct(int index) {
		actions.moveToElement(products.get(index)).perform();
	}

}
