package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

public class selenium001 {
    public static void main(String[] args) {
        // this is the source code
        // Source here ->  (navigate to the Google.com)
        //  Converted -> JSON Wire protocol | HTTP Request | api request)
        //  Browser Driver | Server ( application running on a particular port)
        // Browser Driver -> Real Driver(

        // Selenium 3-
        // Download the driver binary
        // System.get ---  start the binary

        // Selenium 4
        // Selenium manager (application)
        // Selenium will automatically download the drivers and start)

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.quit();
    }
}
