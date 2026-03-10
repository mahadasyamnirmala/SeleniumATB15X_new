package org.example.ex_05_Xpath_axes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestSelenium_Xpath_axes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
// to get a list of items
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='Mammal']/preceding-siblings::div"));
        elements.get(0).click();
// this example for list of items----not for execution program.just for syntax purpose.
    }
}
