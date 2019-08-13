package com.ag04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleTestExample {
  private WebDriver driver;

  @BeforeClass
  public static void setupWebdriverBinary() {
    WebDriverManager.firefoxdriver().setup();
  }

  @Before
  public void setup() {
    driver = new FirefoxDriver();
  }

  @After
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void searchGoogleForAgency04() {
    driver.get("https://www.google.com");
    WebElement searchBar = driver.findElement(By.name("q"));
    searchBar.clear();
    searchBar.sendKeys("AG04");
    searchBar.submit();
    new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("/search"));
    assertThat(driver.getTitle(), containsString("AG04"));
  }

}
