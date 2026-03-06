# 🔍 Selenium Locators – Complete Quality Reference Guide

> **Project:** Cura Health Service App – Selenium Automation  
> **Framework:** Selenium WebDriver + TestNG + Page Object Model (POM) + Allure Reports  
> **Language:** Java | **Build Tool:** Maven

---

## 📋 Table of Contents

1. [What Are Locators?](#what-are-locators)
2. [Types of Locators in Selenium](#types-of-locators-in-selenium)
3. [Locator Priority & Best Practices](#locator-priority--best-practices)
4. [Project Structure](#project-structure)
5. [Mini Project – Cura Health App](#mini-project--cura-health-app)
6. [Step-by-Step Implementation](#step-by-step-implementation)
7. [pom.xml Configuration (Allure + TestNG)](#pomxml-configuration)
8. [Page Object Model Classes](#page-object-model-classes)
9. [Test Class – Full Walkthrough](#test-class--full-walkthrough)
10. [Allure Report Generation](#allure-report-generation)
11. [Allure Report – Actual Results](#allure-report--actual-results)
12. [Common Mistakes & Fixes](#common-mistakes--fixes)
13. [Locator Cheat Sheet](#locator-cheat-sheet)

---

## 🧠 What Are Locators?

Locators are the **strategies Selenium uses to find web elements** on a web page.  
They act as the **address** of an HTML element — without them, Selenium cannot interact with any element.

```java
// Every interaction starts with finding an element
WebElement element = driver.findElement(By.id("login-btn"));
element.click();
```

---

## 🗂️ Types of Locators in Selenium

### 1. `By.id` – Most Preferred ✅
```java
driver.findElement(By.id("username")).sendKeys("admin");
```
- **Best when:** The element has a unique, stable `id` attribute.
- **Example HTML:** `<input id="username" type="text">`

---

### 2. `By.name`
```java
driver.findElement(By.name("password")).sendKeys("admin");
```
- **Best when:** `id` is absent but `name` attribute is unique.
- **Example HTML:** `<input name="password" type="password">`

---

### 3. `By.className`
```java
driver.findElement(By.className("btn-login")).click();
```
- **Best when:** A single, unique CSS class is present.
- ⚠️ **Avoid** when class has spaces (compound classes) — use CSS selector instead.

---

### 4. `By.tagName`
```java
List<WebElement> links = driver.findElements(By.tagName("a"));
```
- **Best when:** Retrieving all elements of a specific HTML tag.

---

### 5. `By.linkText` & `By.partialLinkText`
```java
// Exact match
driver.findElement(By.linkText("Make Appointment")).click();

// Partial match
driver.findElement(By.partialLinkText("Appointment")).click();
```
- **Best when:** Interacting with anchor (`<a>`) tags with visible, stable text.

---

### 6. `By.cssSelector` – Fast & Flexible ✅
```java
// By ID
driver.findElement(By.cssSelector("#login-btn")).click();

// By Class
driver.findElement(By.cssSelector(".btn-default")).click();

// By Attribute
driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");

// Child selector
driver.findElement(By.cssSelector("div.form-group > input")).sendKeys("value");

// Pseudo-class (nth-child)
driver.findElement(By.cssSelector("ul li:nth-child(2)")).click();
```

---

### 7. `By.xpath` – Most Powerful ✅
```java
// Absolute XPath (avoid — fragile)
driver.findElement(By.xpath("/html/body/div/form/input[1]"));

// Relative XPath (preferred)
driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");

// Text match
driver.findElement(By.xpath("//a[text()='Make Appointment']")).click();

// Contains — tolerates partial match
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
driver.findElement(By.xpath("//input[contains(@class,'btn')]")).click();

// Starts-with
driver.findElement(By.xpath("//input[starts-with(@id,'user')]")).sendKeys("admin");

// Axes — parent, sibling, following
driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));
driver.findElement(By.xpath("//div[@class='form-group'][1]//input"));

// AND / OR conditions
driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
driver.findElement(By.xpath("//input[@type='text' or @type='email']"));

// Index-based
driver.findElement(By.xpath("(//input[@type='text'])[1]"));
```

---

## 🏆 Locator Priority & Best Practices

| Priority | Locator        | Stability | Speed  | Notes                              |
|----------|----------------|-----------|--------|------------------------------------|
| 1st      | `id`           | ⭐⭐⭐⭐⭐    | ⚡⚡⚡⚡⚡ | Always prefer if unique & stable   |
| 2nd      | `name`         | ⭐⭐⭐⭐     | ⚡⚡⚡⚡  | Good fallback when no id           |
| 3rd      | `cssSelector`  | ⭐⭐⭐⭐     | ⚡⚡⚡⚡  | Faster than XPath; very versatile  |
| 4th      | `xpath`        | ⭐⭐⭐      | ⚡⚡⚡   | Most powerful; use relative paths  |
| 5th      | `linkText`     | ⭐⭐⭐      | ⚡⚡⚡   | Only for anchor tags               |
| 6th      | `className`    | ⭐⭐       | ⚡⚡⚡   | Avoid compound class names         |
| 7th      | `tagName`      | ⭐        | ⚡⚡    | Only for bulk element retrieval    |

---

## 📁 Project Structure

```
SeleniumATB15X_new/
│
├── src/
│   ├── main/java/org/example/
│   │   └── pages/
│   │       ├── HomePage.java          ← POM Page class
│   │       ├── LoginPage.java         ← POM Page class
│   │       └── AppointmentPage.java   ← POM Page class
│   │
│   └── test/java/org/example/
│       └── ex03_Locators/
│           └── TestSelenium18_Mini_Project3_Curaapp.java ← Test class
│
├── allure-results/                    ← Auto-generated by Allure
├── pom.xml                            ← Maven config with Allure + TestNG
└── locator.md                         ← This file
```

---

## 🏥 Mini Project – Cura Health App

**URL:** `https://katalon-demo-cura.herokuapp.com/`

### Test Objectives
| Step | Action | Verification |
|------|--------|-------------|
| 1 | Open Home Page | Verify "Make Appointment" button exists |
| 2 | Click button → Login Page | Verify URL contains `/login` |
| 3 | Enter credentials & Login | Username: `John Doe` / Password: `ThisIsNotAPassword` |
| 4 | Navigate to Appointment Page | Verify URL = `/profile.php#appointment` |
| 5 | Verify H2 heading | Text = `Make Appointment` |
| 6 | Generate Allure Report | Annotate test with `@Epic`, `@Story`, `@Description` |

---

## 🚀 Step-by-Step Implementation

### Step 1: `pom.xml` Configuration

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>SeleniumATB15X_new</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

    <dependencies>

        <!-- Selenium WebDriver -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.18.1</version>
        </dependency>

        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.9.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Allure TestNG Integration -->
        <!-- Source: https://mvnrepository.com/artifact/io.qameta.allure/allure-testng -->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.33.0</version>
            <scope>compile</scope>
        </dependency>

        <!-- WebDriverManager (auto-manages browser drivers) -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.7.0</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <!-- Surefire Plugin for TestNG -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>

            <!-- Allure Maven Plugin -->
            <plugin>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-maven</artifactId>
                <version>2.12.0</version>
            </plugin>
        </plugins>
    </build>

</project>
```

---

## 📄 Page Object Model Classes

### `HomePage.java`
```java
package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By makeAppointmentBtn = By.id("btn-make-appointment");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMakeAppointmentButton() {
        return driver.findElement(makeAppointmentBtn);
    }

    public void clickMakeAppointment() {
        driver.findElement(makeAppointmentBtn).click();
    }

    public boolean isMakeAppointmentBtnDisplayed() {
        return driver.findElement(makeAppointmentBtn).isDisplayed();
    }
}
```

### `LoginPage.java`
```java
package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginButton   = By.id("btn-login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
```

### `AppointmentPage.java`
```java
package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentPage {

    private WebDriver driver;

    // Locators
    private By h2Heading = By.cssSelector("h2.text-center");

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getH2Text() {
        return driver.findElement(h2Heading).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
```

---

## 🧪 Test Class – Full Walkthrough

### `TestSelenium18_Mini_Project3_Curaapp.java`
```java
package org.example.ex03_Locators;

import io.qameta.allure.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AppointmentPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Cura Health Service App")
@Feature("Patient Appointment Booking Flow")
public class TestSelenium18_Mini_Project3_Curaapp {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        homePage        = new HomePage(driver);
        loginPage       = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
    }

    @Test(priority = 1)
    @Story("Home Page Verification")
    @Description("Verify 'Make Appointment' button is displayed on Home Page")
    @Severity(SeverityLevel.NORMAL)
    public void verifyMakeAppointmentButtonVisible() {
        boolean isDisplayed = homePage.isMakeAppointmentBtnDisplayed();
        Assert.assertTrue(isDisplayed,
            "'Make Appointment' button should be displayed on the home page");
    }

    @Test(priority = 2)
    @Story("Navigation to Login Page")
    @Description("Click 'Make Appointment' button and verify navigation to Login page")
    @Severity(SeverityLevel.CRITICAL)
    public void navigateToLoginPage() {
        homePage.clickMakeAppointment();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"),
            "URL should contain 'login' after clicking Make Appointment");
    }

    @Test(priority = 3)
    @Story("Login Functionality")
    @Description("Enter valid credentials and verify navigation to Appointment page")
    @Severity(SeverityLevel.BLOCKER)
    public void loginAndVerifyAppointmentPage() {
        // Login
        loginPage.loginAs("John Doe", "ThisIsNotAPassword");

        // Verify URL
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/profile.php#appointment";
        String actualUrl   = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
            "URL mismatch after login");

        // Verify H2 heading
        String actualH2   = appointmentPage.getH2Text();
        String expectedH2 = "Make Appointment";
        Assert.assertEquals(actualH2, expectedH2,
            "H2 text mismatch on Appointment page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

---

## 📊 Allure Report Generation

### Run Tests
```bash
# Step 1: Run tests (generates allure-results/)
mvn clean test
```

### Launch Allure Report
```bash
# Step 2: Serve the report in browser
allure serve allure-results
```

### Generate Static Report
```bash
# Alternative: generate static HTML report
allure generate allure-results --clean -o allure-report
allure open allure-report
```

### Allure Annotations Explained

| Annotation | Purpose |
|---|---|
| `@Epic` | Top-level grouping (e.g., "Cura Health App") |
| `@Feature` | Feature grouping (e.g., "Booking Flow") |
| `@Story` | Individual user story |
| `@Description` | Detailed test description |
| `@Severity` | Marks test criticality: BLOCKER, CRITICAL, NORMAL, MINOR |
| `@Step` | Used in helper methods for step-level reporting |
| `@Attachment` | Attach screenshots, logs, or HTML to reports |

---

## ✅ Allure Report – Actual Results

> **Screenshot taken:** 3/5/2026 — Local execution
![Screenshot_5-3-2026_163842_127 0 0 1](https://github.com/user-attachments/assets/e350958d-2215-4389-9437-4ba3cae971a7)

| Metric | Result |
|--------|--------|
| Total Test Cases | **5** |
| Pass Rate | **100% ✅** |
| Suite | Default Suite (5/5 passed) |
| Features by Stories | 5 items |
| Execution Date | 3/5/2026 |

### 🔧 Enhancing Your Report (Next Steps)

**Add Environment Variables** — create `allure-results/environment.properties`:
```properties
Browser=Chrome
Environment=QA
App.URL=https://katalon-demo-cura.herokuapp.com/
Java.Version=11
Selenium.Version=4.18.1
```

**Add Executor Info** — create `allure-results/executor.json`:
```json
{
  "name": "Local Machine",
  "type": "local",
  "buildName": "Cura Health Suite - Build 1"
}
```

**Enable Trend Graph** — Run tests **twice or more** consecutively. Allure builds the trend chart automatically across runs.

**Enable Behaviors Tab** — Add `@Epic` and `@Feature` to your test class:
```java
@Epic("Cura Health Service App")
@Feature("Patient Appointment Booking Flow")
public class TestSelenium18_Mini_Project3_Curaapp { ... }
```

---

## ⚠️ Common Mistakes & Fixes

| Mistake | Why It's Wrong | Fix |
|---|---|---|
| `//div/span/input` | Absolute path — breaks on DOM changes | Use `//input[@id='username']` |
| `By.className("btn primary")` | Space in class name causes error | Use `By.cssSelector(".btn.primary")` |
| `By.xpath("//input[@type='Text']")` | Case-sensitive attribute match | Use lowercase: `@type='text'` |
| Not using `WebDriverWait` | `NoSuchElementException` on slow pages | Add explicit waits |
| Hardcoding `Thread.sleep()` | Flaky tests, slow execution | Use `ExpectedConditions` instead |
| Using absolute XPath | Breaks when page structure changes | Always use relative XPath |

---

## 📌 Locator Cheat Sheet

```java
// ID
By.id("submit-btn")

// Name
By.name("email")

// Class
By.className("nav-link")

// Tag
By.tagName("button")

// Link Text
By.linkText("Click Here")
By.partialLinkText("Click")

// CSS Selector
By.cssSelector("#id")
By.cssSelector(".class")
By.cssSelector("input[type='email']")
By.cssSelector("div > p.highlight")
By.cssSelector("input:nth-child(2)")

// XPath
By.xpath("//input[@id='email']")
By.xpath("//button[text()='Submit']")
By.xpath("//button[contains(@class,'btn')]")
By.xpath("//input[starts-with(@name,'user')]")
By.xpath("(//input[@type='text'])[2]")
By.xpath("//label[.='Email']/following-sibling::input")
By.xpath("//div[@id='form']//input[@type='submit']")
```

---

## 🔗 References

- [Selenium Official Docs](https://www.selenium.dev/documentation/)
- [Allure TestNG Docs](https://allurereport.org/docs/testng/)
- [Katalon Cura Demo App](https://katalon-demo-cura.herokuapp.com/)
- [MVN Repository – Allure TestNG](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng)
- [WebDriverManager Docs](https://bonigarcia.dev/webdrivermanager/)

---

*Maintained by QA Automation Engineer | Java | Selenium | TestNG | POM | Allure*
