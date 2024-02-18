package br.dev.hc.TestAppium.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DialogPage {
  public static final By signInFreDismissButton = By.xpath("//android.widget.Button[@resource-id=\"com.android.chrome:id/signin_fre_dismiss_button\"]");
  public static final By negativeButton = By.xpath("//android.widget.Button[@resource-id=\"com.android.chrome:id/negative_button\"]");
}
