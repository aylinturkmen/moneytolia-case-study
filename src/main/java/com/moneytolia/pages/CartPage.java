package com.moneytolia.pages;

import com.moneytolia.data.ProductData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

	@FindBy(css = ".cart_description a")
	private List<WebElement> productNames;

	@FindBy(css = ".cart_price p")
	private List<WebElement> productPrices;

	@FindBy(css = ".cart_quantity button")
	private List<WebElement> productQuantityButtons;

	@FindBy(css = ".cart_total_price")
	private List<WebElement> productTotalPrices;

	@FindBy(css = "tbody tr")
	private List<WebElement> productContainers;

	public List<WebElement> getProductContainers() {
		return productContainers;
	}

	public List<WebElement> getProductNames() {
		return productNames;
	}

	public List<WebElement> getProductPrices() {
		return productPrices;
	}

	public List<WebElement> getProductQuantityButtons() {
		return productQuantityButtons;
	}

	public List<WebElement> getProductTotalPrices() {
		return productTotalPrices;
	}

	public String getProductName(int index) {
		return productNames.get(index).getText();
	}

	public double getProductPrice(int index) {
		String price = productPrices.get(index).getText().split(" ")[1].trim();
		return Double.parseDouble(price);
	}

	public int getProductQuantity(int index) {
		String quantity = productQuantityButtons.get(index).getText();
		return Integer.parseInt(quantity);
	}

	public double getProductTotalPrice(int index) {
		String price = productTotalPrices.get(index).getText().split(" ")[1].trim();
		return Double.parseDouble(price);
	}

	public List<ProductData> getProductsInTheCart() {
		List<ProductData> products = new ArrayList<>();
		for (int i = 0; i < productContainers.size(); i++) {
			ProductData productData = new ProductData();
			productData.setProductName(getProductName(i));
			productData.setProductPrice(getProductPrice(i));
			productData.setProductQuantity(getProductQuantity(i));
			products.add(productData);
		}
		return products;
	}

}
