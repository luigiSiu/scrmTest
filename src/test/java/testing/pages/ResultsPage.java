package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage extends BasePage {

  By firstResult = By.cssSelector("#result_0 img");

  public ResultsPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(firstResult));
  }

  public ProductPage accessFirstResult() {
    driver.findElement(firstResult).click();
    return new ProductPage(driver, wait);
  }
}
