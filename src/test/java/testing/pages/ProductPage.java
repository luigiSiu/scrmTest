package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

  By addToCart = By.id("submit.add-to-cart");

  public ProductPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(addToCart));
  }

  public AddCartConfirmPage addToCart() {
    driver.findElement(addToCart).click();
    return new AddCartConfirmPage(driver, wait);
  }
}
