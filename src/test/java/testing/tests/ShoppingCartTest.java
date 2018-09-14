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
  public void testGoogleSearch() {
    HomePage homePage = new HomePage(driver, wait);

    ResultsPage resultsPage = homePage.search("Pantalla");
    ProductPage productPage = resultsPage.accessFirstResult();
    AddCartConfirmPage addCartConfirmPage = productPage.addToCart();

    Assert.assertTrue(addCartConfirmPage.isElementAdded(), "The item was not added to the cart.");

    CartPage cartPage = addCartConfirmPage.accessCart();
    Assert.assertTrue(cartPage.isItemAdded(), "The item is not in the cart.");
  }
}
