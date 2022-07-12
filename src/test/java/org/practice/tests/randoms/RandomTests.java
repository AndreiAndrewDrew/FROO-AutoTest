package org.practice.tests.randoms;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTests {

  static WebDriver driver;

  @Test
  void randomNumbersAreNotRepeatedTest() {

    System.setProperty("webdriver.chrome.driver", "libs/chrome/chromedriver.exe");
    driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://ro.piliapp.com/random/number/");

    driver.findElement(By.id("count")).sendKeys((CharSequence) Keys.CONTROL,
            (CharSequence) "a");
    driver.findElement(By.id("count")).sendKeys(Keys.DELETE);
    driver.findElement(By.id("count")).sendKeys("1");

    driver.findElement(By.id("gen")).click();

    String firstRandomNumber = driver.findElement(By.id("results-textarea")).getText();
    System.out.println("Primul numar generat= " + firstRandomNumber);

    assertTrue(firstRandomNumber != null);

  }

  @AfterAll
  static void afterAll() {
    driver.quit();
  }
}
