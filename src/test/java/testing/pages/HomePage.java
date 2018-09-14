package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  String homePageUrl = "http://www.amazon.es";

  By searchBox = By.id("twotabsearchtextbox");

  public HomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    driver.get(homePageUrl);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(searchBox));
  }

  public ResultsPage search(String text) {
    driver.findElement(searchBox).sendKeys(text);
    driver.findElement(searchBox).submit();
    return new ResultsPage(driver, wait);
  }
}
