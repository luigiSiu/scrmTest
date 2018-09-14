package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartConfirmPage extends BasePage {

  By cartButton = By.cssSelector("[class*='order-row'] [class*='button'] [href*='/cart/']");

  public AddCartConfirmPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(cartButton));
  }

  public boolean isElementAdded() {
    return driver.findElements(cartButton).size() != 0;
  }

  public CartPage accessCart() {
    driver.findElement(cartButton).click();
    return new CartPage(driver, wait);
  }
}
