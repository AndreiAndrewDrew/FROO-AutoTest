package org.random.tests.js;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsTests {
  @Test
  public void jsTest() {

    System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://yahoo.com");

    JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;



    WebElement mailLink =
            (WebElement) jsExecuter.executeScript("return document.getElementById('ybar-navigation-item-mail')");
//    WebElement logo =
//            (WebElement) jsExecuter.executeScript("document.getElementByXpath('//img[@class=_yb_ks4fb _yb_14y8t _yb_1jmta]').setAttribute('class', 'display: none'); return document.getElementById('ybar-logo')");


    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.interrupted();
    }

   mailLink.click();
//    logo.click();

    driver.quit();


  }
}
