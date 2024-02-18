package br.dev.hc.TestAppium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  private static AndroidDriver driver;
  private static AppiumDriverLocalService service;

  @Before
  public static void startDriver() {
    AppiumServiceBuilder builder = new AppiumServiceBuilder();
    builder.usingAnyFreePort();

    service = AppiumDriverLocalService.buildService(builder);
    service.start();

    String ci = System.getenv("CI");
    UiAutomator2Options options = new UiAutomator2Options()
      .setApp("Chrome")
      .setPlatformName("Android")
      .setAutomationName("UiAutomator2")
      .setAutoGrantPermissions(true)
      .setClearSystemFiles(true)
      .setNoReset(true);

    if (ci != null && ci.equals("true")) {
      options.headless();
    }

    driver = new AndroidDriver(service.getUrl(), options);
  }

  @After
  public static void closeDriver(){
    if (driver != null) {
      driver.quit();
    }

    if (service != null) {
      service.stop();
    }
  }

  public static AndroidDriver getDriver(){
    return driver;
  }
}
