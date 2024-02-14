package br.dev.hc.TestAppium.utils;

public class Retry {

  // Try to execute the function until maxRetry attempts
  public  static void run(int maxRetry, Runnable fn) {
    int count = 0;
    while (true) {
      try {
        //This makes the block inside {} to be executed where retry is called
        fn.run();
        break;
      } catch (Exception ex) {
        count+=1;
        if (count >= maxRetry) {
          throw ex;
        }
      }
    }
  }
  // This function is calling the run function passing different parameters
  // in Java we can create functions with the same name and they will be identified by their signature
  public static void run(Runnable fn) {
    run(3, fn);
  }
}
