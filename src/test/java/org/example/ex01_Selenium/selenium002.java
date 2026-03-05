package org.example;

import org.openqa.selenium.firefox.FirefoxDriver;

public class selenium002 {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://sdet.live");
        driver.quit();
    }

}
