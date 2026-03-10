package org.example.selenium_miniprojects.Ohrm_HRM;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_22_Mini_Ohrm_webtable {
    @Owner("Nirmala")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify login is working and check the employeeList table")
    @Test
    public void test_OHRM_login_web_table() throws InterruptedException {
        // step1: open the url
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        Thread.sleep(3000);
        // step2: enter the username , password and click on Login button
        WebElement user_name=driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//button"));
//        WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

        user_name.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();
        // step3: go to the view employee list page
        Thread.sleep(3000);

        List<WebElement> Rows = driver.findElements(By.xpath("//div[@role='table']/div[@class='oxd-table-body']/div[@class='oxd-table-card']"));

        //div[@class='oxd-table-card'][1]/div/div[@role='cell'][6]

        String first_part = "//div[@class='oxd-table-card'][";
        String second_part = "]/div/div[@role='cell'][";
        String third_part = "]";

        Integer row = driver.findElements(By.xpath("//div[@class='oxd-table-card']")).size();
        //    System.out.println(row);

        Integer column = driver.findElements(By.xpath("//div[@class='oxd-table-card'][2]/div/div[@role='cell']")).size();
        //  System.out.println(column);

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                // System.out.println(dynamic_xpath);

                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                //System.out.println(data);
                if(data.contains("Terminated"))
                {
                    String emp_name_path = dynamic_xpath + "/preceding-sibling::div[3]";
                    String emp_name = driver.findElement(By.xpath(emp_name_path)).getText();

                    System.out.println("Terminated Employee: " + emp_name);
                }
            }

        }


        WebElement delete = driver.findElement(By.xpath("(//button/i[@class='oxd-icon bi-trash'])[2]"));
        delete.click();

        // Thread.sleep(5000);


        // step6: close the driver
       //driver.quit();

    }

}
