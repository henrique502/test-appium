package br.dev.hc.TestAppium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.InetAddress;

public class Hooks {
  private static AndroidDriver driver;
  private static AppiumDriverLocalService service;

  private static String getHostname() {
    String hostname = "Unknown";

    try {
      InetAddress addr;
      addr = InetAddress.getLocalHost();
      hostname = addr.getHostName();
    }
    catch (Exception ex) {
      System.out.println("Hostname can not be resolved");
    }

    return hostname;
  }

  @Before
  public static void startDriver() {
    service = AppiumDriverLocalService.buildDefaultService();
    service.start();

    final String id = "appium-" + getHostname();
    final String apk = System.getProperty("user.dir") + "/apks/app-debug.apk";

    String ci = System.getenv("CI");
    UiAutomator2Options options = new UiAutomator2Options()
      .setUdid(id)
      .setApp(apk);

    /*
    XCUITestOptions options = new XCUITestOptions()
      .setUdid('123456')
      .setApp("/home/myapp.ipa");
    IOSDriver driver = new IOSDriver(
      // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
      new URL("http://127.0.0.1:4723"), options
    );
    */

    driver = new AndroidDriver(service.getUrl(), options);


    if (ci != null && ci.equals("true")) {

    }

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
