package com.moneytolia.utils;

import com.moneytolia.pages.CartPage;
import com.moneytolia.pages.HomePage;
import com.moneytolia.pages.NavigationBar;
import com.moneytolia.pages.ProductsPage;

public class Pages {

	private HomePage homePage;

	private NavigationBar navigationBar;

	private ProductsPage productsPage;

	private CartPage cartPage;

	public Pages() {
		homePage = new HomePage();
		productsPage = new ProductsPage();
		navigationBar = new NavigationBar();
		cartPage = new CartPage();
	}

	public HomePage homePage() {
		return homePage;
	}

	public NavigationBar navigationBar() {
		return navigationBar;
	}

	public ProductsPage productsPage() {
		return productsPage;
	}

	public CartPage cartPage() {
		return cartPage;
	}

}
