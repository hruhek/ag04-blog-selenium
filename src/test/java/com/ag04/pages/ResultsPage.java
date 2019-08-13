package com.ag04.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ResultsPage extends LoadableComponent<ResultsPage> {

  private final WebDriver driver;
  private final URL url;

  @FindBy(css = "div[data-hveid] div.r")
  private List<WebElement> results;

  public ResultsPage(WebDriver driver) throws MalformedURLException {
    this.driver = driver;
    url = new URL("https://www.google.com/search");
  }

  public List<WebElement> getResults() {
    return results;
  }

  @Override
  protected void load() {
    // This page cannot be loaded manually, browser is redirected from search page.
  }

  @Override
  protected void isLoaded() throws Error {
    new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains(url.getPath()));
  }
}
