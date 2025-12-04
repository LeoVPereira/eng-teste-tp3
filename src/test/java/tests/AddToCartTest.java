package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {

        driver.get("https://demo.prestashop.com/#/en/front");

        HomePage home = new HomePage(driver);
        home.openFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.addToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isCheckoutVisible());
    }
}
