package br.dev.hc.TestAppium.cucumber;

import br.dev.hc.TestAppium.utils.Hooks;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoSteps {

  @Given("The app is open")
  public void theAppIsOpen() {
    WebElement el = Hooks.getDriver().findElement(new By.ByXPath("//Button"));
    el.click();
    Hooks.getDriver().getPageSource();
  }

  @When("The app is open press the button")
  public void theAppIsOpenPressTheButton() {

  }

  @Then("The app is open and the button is pressed")
  public void theAppIsOpenAndTheButtonIsPressed() {
  }
}
