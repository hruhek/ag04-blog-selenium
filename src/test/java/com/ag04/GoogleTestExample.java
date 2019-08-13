package com.ag04;

import com.ag04.pages.HomePage;
import com.ag04.pages.ResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleTestExample {
  private WebDriver driver;
  private HomePage homePage;
  private ResultsPage resultsPage;

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
    homePage = PageFactory.initElements(driver, HomePage.class);
    resultsPage = homePage.get().searchFor("AG04");
    assertThat(driver.getTitle(), containsString("AG04"));
    assertThat(resultsPage.getResults().get(0).getText(), containsString("AG04 - Experts in enterprise software development"));
  }

}
