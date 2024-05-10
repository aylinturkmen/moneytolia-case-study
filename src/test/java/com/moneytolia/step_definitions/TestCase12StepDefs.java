package com.moneytolia.step_definitions;

import com.moneytolia.data.ProductData;
import com.moneytolia.pages.NavigationBar;
import com.moneytolia.utils.BrowserUtils;
import com.moneytolia.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestCase12StepDefs extends BaseStep {

	private static List<ProductData> products = new ArrayList<>();

	@Given("I am on the home page of {string}")
	public void i_am_on_home_page(String url) {
		Assert.assertEquals(DriverManager.getWebDriver().getCurrentUrl(), url);
		Assert.assertTrue(PAGES.navigationBar().getLogo().isDisplayed());
	}

	@When("I click the Products button")
	public void i_click_button() {
		try {
			PAGES.navigationBar().getProductsButton().click();
		}
		catch (Exception e) {
			BrowserUtils.waitFor(2);
			BrowserUtils.dismissAds();
			PAGES.navigationBar().getProductsButton().click();
		}

	}

	@When("I hover over the {int} product")
	public void i_hover_over_product(int productIndex) {

		ProductData productData;
		try {
			BrowserUtils.waitFor(2);
			PAGES.productsPage().hoverOverProduct(productIndex);
			productData = PAGES.productsPage().getProductData(productIndex);
		}
		catch (Exception e) {
			BrowserUtils.waitFor(2);
			PAGES.productsPage().hoverOverProduct(productIndex);
			BrowserUtils.dismissAds();
			productData = PAGES.productsPage().getProductData(productIndex);
		}

		if (products.contains(productData)) {
			products.get(products.indexOf(productData))
				.setProductQuantity(products.get(products.indexOf(productData)).getProductQuantity() + 1);
		}
		else {
			products.add(productData);
		}
	}

	@Then("I verify that both products are added to the cart")
	public void i_verify_both_products_added() {
		Assert.assertEquals(products.size(), PAGES.cartPage().getProductContainers().size());
		for (int i = 0; i < products.size(); i++) {
			Assert.assertEquals(products.get(i).getProductName(),
					PAGES.cartPage().getProductsInTheCart().get(i).getProductName());
		}

	}

	@Then("I verify their prices, quantities, and total price")
	public void i_verify_prices_quantities_and_total_price() {
		for (int i = 0; i < products.size(); i++) {
			Assert.assertEquals(products.get(i).getProductPrice(),
					PAGES.cartPage().getProductsInTheCart().get(i).getProductPrice(), 0.01);
			Assert.assertEquals(products.get(i).getProductQuantity(),
					PAGES.cartPage().getProductsInTheCart().get(i).getProductQuantity(), 0.01);
			Assert.assertEquals(products.get(i).getProductTotalPrice(),
					PAGES.cartPage().getProductsInTheCart().get(i).getProductTotalPrice(), 0.01);
		}

	}

	@And("I click Add to Cart button {int}")
	public void i_click_Add_to_cart_button(int index) {
		PAGES.productsPage().clickAddToCartButton(index);

	}

	@And("I click View Cart button")
	public void i_click_view_cart_button() {
		PAGES.productsPage().clickViewCartButton();

	}

	@And("I click Continue Shopping button")
	public void i_click_continue_shopping_button() {
		PAGES.productsPage().clickContinueShoppingButton();

	}

}
