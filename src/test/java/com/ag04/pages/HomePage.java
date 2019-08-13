package com.ag04.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends LoadableComponent<HomePage> {

  private final WebDriver driver;
  private final URL url;

  @FindBy(name = "q")
  private WebElement searchBar;

  public HomePage(WebDriver driver) throws MalformedURLException {
    this.driver = driver;
    this.url = new URL("https://www.google.com");
  }

  public ResultsPage searchFor(String searchString) {
    searchBar.clear();
    searchBar.sendKeys(searchString);
    searchBar.submit();
    ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
    return resultsPage.get();
  }

  @Override
  protected void load() {
    driver.get(url.toString());
  }

  @Override
  protected void isLoaded() throws Error {
    assertThat(driver.getTitle(), containsString("Google"));
  }
}
