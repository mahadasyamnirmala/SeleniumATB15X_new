package org.example.selenium_miniprojects.TTA_Bank;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium22_MiniProject_05 {

    @Owner("Nirmala")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify TTA Bank Workflow is working")
    @Test
    public void test_tta_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
      Thread.sleep(10000);
      // signup
      WebElement sign_up = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
      sign_up.click();
        // name
      WebElement username= driver.findElement(By.xpath("//input[@placeholder='John Doe']"));
      username.sendKeys("Nirmala");
        // email
        WebElement input_email = driver.findElement(By.xpath("//input[@placeholder='you@example.com']"));
        input_email.sendKeys("nirmala@example.com");
        // pwd
        WebElement input_password = driver.findElement(By.xpath("//input[@type='password']"));
        input_password.sendKeys("nimi@1234");
      Thread.sleep(10000);
        // create account
        WebElement create_Account= driver.findElement(By.xpath("//button[text()='Create Account']"));
        create_Account.click();

       // check Assertion
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tta-bank-digital-973242068062.us-west1.run.app/";
        Assert.assertEquals(actualURL, expectedURL);
        Thread.sleep(10000);

        WebElement transfer= driver.findElement(By.xpath("//button[contains(text(),'Transfer Funds')]"));
        transfer.click();
        Thread.sleep(10000);
        WebElement transfer_amt = driver.findElement(By.xpath("//input[@type='number']"));
        transfer_amt.sendKeys("5000");
        Thread.sleep(10000);
        WebElement btn_Continue = driver.findElement(By.xpath("//button[text()='Continue']"));
        btn_Continue.click();
        Thread.sleep(10000);
        WebElement btn_Confirm = driver.findElement(By.xpath("//button[text()='Confirm Transfer']"));
        btn_Confirm.click();
        Thread.sleep(10000);
        WebElement dashBoard= driver.findElement(By.xpath("//button[contains(text(),'Dashboard')]"));
        dashBoard.click();
        WebElement actualAmt_balance = driver.findElement(By.xpath("//h3[contains(text(),'$')]"));
        String actualAmt= actualAmt_balance.getText();
        String expectedAmt= "$45,000.00";
        Assert.assertEquals(actualAmt,expectedAmt);
      Thread.sleep(10000);
        driver.close();


    }
}
