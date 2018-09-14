package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  public WebDriver driver;
  public WebDriverWait wait;

  public BasePage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }
}
