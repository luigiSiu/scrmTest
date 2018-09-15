package testing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.pages.AddCartConfirmPage;
import testing.pages.CartPage;
import testing.pages.HomePage;
import testing.pages.ProductPage;
import testing.pages.ResultsPage;

public class ShoppingCartTest extends BaseTest {

  @Test
  public void testAmazonShoppingCart() {
    HomePage homePage = new HomePage(driver, wait);

    ResultsPage resultsPage = homePage.search("Pantalla");
    ProductPage productPage = resultsPage.accessFirstResult();

    String productTitle = productPage.getProductName();
    AddCartConfirmPage addCartConfirmPage = productPage.addToCart();

    Assert
        .assertTrue(addCartConfirmPage.isElementAdded(), "The product was not added to the cart.");

    CartPage cartPage = addCartConfirmPage.accessCart();
    Assert.assertTrue(cartPage.isItemAdded(productTitle), "The item is not in the cart.");
    Assert.assertTrue(cartPage.checkoutVerifiability(),
        "There is no option to proceed with the cart.");
  }
}
