package br.dev.hc.TestAppium.cucumber;

import br.dev.hc.TestAppium.pages.DialogPage;
import br.dev.hc.TestAppium.pages.SearchPage;
import br.dev.hc.TestAppium.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoSteps {
  @When("Dismiss sing in page")
  public void dismissSingInPage() {
    Hooks.getDriver().findElement(DialogPage.signInFreDismissButton).click();
  }

  @When("Dismiss notification dialog")
  public void dismissNotificationDialog() {
    Hooks.getDriver().findElement(DialogPage.negativeButton).click();
  }

  @Then("Search for {string} and touch enter")
  public void searchForTermAndTouchEnter(String term) {
    WebElement searchInput = Hooks.getDriver().findElement(SearchPage.searchInput);
    searchInput.sendKeys(term);
    searchInput.submit();
  }
}
