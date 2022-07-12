package org.practice.tests.waits;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTablesTests {
  @Test
  public void implicitlyWaitTest() {
    System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);

    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    driver.get("https://datatables.net/examples/server_side/row_details.html");
    driver.manage().window().maximize();

    WebElement tableExamples = driver.findElement(By.id("example"));

    List<WebElement> tableRows =
            tableExamples.findElements(By.cssSelector("tbody > tr "));

    assertEquals(tableRows.size(), 10);


    Select select = new Select(driver.findElement(By.name("example_length")));
    select.selectByValue("25");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      Thread.interrupted();
    }

    tableRows = tableExamples.findElements(By.cssSelector("tbody > tr "));
    assertEquals(tableRows.size(), 25);

  }
}
