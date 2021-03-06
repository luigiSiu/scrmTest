package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

  By proceedToCheckout = By.name("proceedToCheckout");
  By productTitle = By
      .cssSelector("#activeCartViewForm div.sc-list-item-content span [class*='product-title']");

  public CartPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
  }

  public boolean isItemAdded(String itemName) {
    return driver.findElement(productTitle).getText().contains(itemName);
  }

  public boolean checkoutVerifiability() {
    return driver.findElements(proceedToCheckout).size() != 0;
  }
}
