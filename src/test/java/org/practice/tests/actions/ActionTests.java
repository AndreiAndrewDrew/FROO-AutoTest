package org.practice.tests.actions;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionTests {

  @Test
  public void dragAndDropTest(){
    System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/test/drag_drop.html");

    WebElement bankBlock = driver.findElement(By.cssSelector("#credit2 a"));
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
            .visibilityOf(bankBlock));

    WebElement accountSideBlock = driver.findElement(By.cssSelector("#bank li"));

    Actions actions = new Actions(driver);
    actions.dragAndDrop(bankBlock,accountSideBlock).pause(10000).perform();

    WebElement debitTable = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("bal3")));

    assertTrue(debitTable.isDisplayed());

    driver.quit();

  }
}
