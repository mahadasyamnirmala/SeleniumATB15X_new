package org.example.selenium_miniprojects.Curapp_Healthcare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium18_Mini_Project3_Curaapp {
@Test
    public static void main(String[] args) throws InterruptedException {

        //step1:   // 1. Driver Managing
        WebDriver driver =new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
// step2:     //2.  Locators
        // Step1: Find the Make Appointment  and click on the button
                  //<a id="btn-make-appointment"
                     //href="./index.php#appointment"
                       //class="btn btn-dark btn-lg">Make Appointment</a>
        WebElement btn_appointment_submit = driver.findElement(By.linkText("Make Appointment"));
        btn_appointment_submit .click();

// or we can take partial text also
//WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("Make //Appointment"));
        // Make Appointment
        // App
        // Appoint
        // Make App ,Appointment………..
// a_tag_partial_match.click();
        WebElement username_input_box = driver.findElement(By.id("txt-username"));
        username_input_box.sendKeys("John Doe");


        WebElement pwd_input_box = driver.findElement(By.id("txt-password"));
        pwd_input_box.sendKeys("ThisIsNotAPassword");


        Thread.sleep(10000);
        WebElement login_btn=driver.findElement(By.id("btn-login"));
        login_btn.click();

        // 3. Assertions
      /* AR- driver.getCurrentUrl()
      ER- https://katalon-demo-cura.herokuapp.com/#appointment

      AR- h2_Text.getText()
      ER-Make Appointment
      */


       Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
//System.out.println(driver.getCurrentUrl());
    Thread.sleep(5000);

    WebElement h2_Text = driver.findElement(By.tagName("h2"));
   // System.out.println(h2_Text.getText());


    Assert.assertEquals(h2_Text.getText(),"Make Appointment");

        // 4. Quit
        driver.quit();
    }
}
