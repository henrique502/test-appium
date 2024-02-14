package br.dev.hc.TestAppium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
  private static AndroidDriver driver;

  @Before
  public static void startDriver() throws MalformedURLException {
    String ci = System.getenv("CI");
    UiAutomator2Options options = new UiAutomator2Options()
      .setUdid("aaa")
      .setApp("/home/myapp.apk");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


    if (ci != null && ci.equals("true")) {

    }

  }

  @After
  public static void closeDriver(){
    driver.close();
  }

  public static WebDriver getDriver(){
    return driver;
  }

}
