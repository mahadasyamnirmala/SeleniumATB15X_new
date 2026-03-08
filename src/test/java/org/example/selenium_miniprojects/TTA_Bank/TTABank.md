# 🏦 TTA Bank – Selenium Automation Project (XPath)

![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green?logo=selenium)
![Java](https://img.shields.io/badge/Language-Java-orange?logo=java)
![TestNG](https://img.shields.io/badge/Framework-TestNG-red)
![Allure](https://img.shields.io/badge/Reports-Allure-blue)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

---

## 📌 Project Overview

This project automates the end-to-end banking workflow of the **TTA Bank** web application using **Selenium WebDriver** with **XPath locators**. The goal is to validate core banking functionalities — including login, fund transfer, and dashboard balance verification — through automated test scenarios.

> 🔗 **Application URL:** [https://tta-bank-digital-973242068062.us-west1.run.app/](https://tta-bank-digital-973242068062.us-west1.run.app/)

---

## 🎯 Test Scenario

| Parameter        | Details                      |
|-----------------|------------------------------|
| Action          | Transfer **$5,000**          |
| Expected Result | Dashboard shows **$45,000.00** |
| Locator Strategy | XPath                       |
| Reporting Tool  | Allure Reports               |

---

## 🛠️ Tech Stack

| Tool / Technology  | Purpose                        |
|--------------------|-------------------------------|
| Java               | Programming Language           |
| Selenium WebDriver | Browser Automation             |
| TestNG             | Test Framework                 |
| XPath              | Element Locator Strategy       |
| Allure             | Test Reporting                 |
| Maven / Gradle     | Build & Dependency Management  |
| Chrome / Edge      | Browser                        |

---

## 📁 Project Structure

```
TTABank-Selenium/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── LoginPage.java
│   │           ├── DashboardPage.java
│   │           └── TransferPage.java
│   │
│   └── test/
│       └── java/
│           └── tests/
│               └── TTABankTest.java
│
├── allure-results/
├── pom.xml
└── README.md
```

---

## 🚀 Step-by-Step Automation Flow

### Step 1 – Launch the Application
- Open the browser and navigate to the TTA Bank URL.
- The browser loads the login page of TTA Bank.

### Step 2 – Login to the Application
- Locate the **Username** field using XPath and enter credentials.
- Locate the **Password** field using XPath and enter the password.
- Click the **Login** button.

```java
driver.findElement(By.xpath("//input[@name='username']")).sendKeys("your_username");
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("your_password");
driver.findElement(By.xpath("//button[@type='submit']")).click();
```

### Step 3 – Verify Dashboard
- After login, validate that the **Dashboard** page loads successfully.
- Capture the current account balance displayed on the dashboard.

```java
WebElement balance = driver.findElement(By.xpath("//div[contains(@class,'balance')]"));
System.out.println("Current Balance: " + balance.getText());
```

### Step 4 – Navigate to Fund Transfer
- Click on the **Transfer** or **Send Money** option in the navigation menu.
- Verify the Transfer page loads correctly.

```java
driver.findElement(By.xpath("//a[contains(text(),'Transfer')]")).click();
```

### Step 5 – Perform Fund Transfer ($5,000)
- Enter the **recipient account** details using XPath locators.
- Enter the **transfer amount** as `5000`.
- Click the **Submit / Transfer** button.

```java
driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("5000");
driver.findElement(By.xpath("//button[text()='Transfer']")).click();
```

### Step 6 – Verify Transfer Confirmation
- Validate that a **success message** or confirmation screen appears after the transfer.

### Step 7 – Return to Dashboard & Verify Balance
- Navigate back to the **Dashboard**.
- Verify the updated account balance shows **$45,000.00**.

```java
driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
WebElement updatedBalance = driver.findElement(By.xpath("//div[contains(@class,'balance')]"));
Assert.assertEquals(updatedBalance.getText(), "$45,000.00");
```
<img src="./Screenshots_TTA/show_dashboard_final.Jpg" alt="A centered screenshot">
---

## 📊 Test Execution Output

The following screenshots capture the complete test execution flow:

| Step | Screenshot |
|------|-----------|
| Login Page | ✅ Loaded successfully |
| Dashboard – Initial Balance | ✅ Captured |
| Transfer Page | ✅ Navigated |
| Amount Entry ($5,000) | ✅ Entered |
| Transfer Confirmation | ✅ Verified |
| Dashboard – Updated Balance ($45,000.00) | ✅ Verified |

---

## 📈 Allure Report

Allure Reports provide a detailed, visual summary of the test execution with pass/fail status, screenshots, and step-by-step breakdown.

### How to View Allure Report

**Step 1 – Run your tests** (Allure results are generated automatically in `allure-results/` folder)

```bash
mvn test
```

**Step 2 – Serve the Allure Report**

```bash
allure serve allure-results
```

**Step 3 – View in Browser**

Allure will automatically open a browser with the full interactive report including:
- ✅ Test pass/fail summary
- 📸 Attached screenshots per step
- 🕒 Execution time per test
- 🔍 Step-by-step breakdown

---

## ✅ Test Results Summary

| Test Case               | Status  |
|------------------------|---------|
| Launch Application      | ✅ PASS |
| Login with Valid Creds  | ✅ PASS |
| Verify Dashboard Load   | ✅ PASS |
| Navigate to Transfer    | ✅ PASS |
| Transfer $5,000         | ✅ PASS |
| Verify Confirmation     | ✅ PASS |
| Verify Balance $45,000  | ✅ PASS |

---

## 💡 Key Learnings

- ✔️ Using **XPath** effectively to locate dynamic web elements
- ✔️ Implementing **explicit waits** for asynchronous banking UI elements
- ✔️ Integrating **Allure Reports** for professional test reporting
- ✔️ Automating **end-to-end financial workflows** with Selenium
- ✔️ Applying **assertions** to validate real-time balance updates

---

## 🔧 How to Run This Project

### Prerequisites

- Java JDK 11+
- Maven
- Chrome Browser + ChromeDriver
- Allure CLI installed

### Run Steps

```bash
# 1. Clone the repository
git clone https://github.com/your-username/TTABank-Selenium.git

# 2. Navigate to project folder
cd TTABank-Selenium

# 3. Run tests
mvn test

# 4. Generate Allure Report
allure serve allure-results
```
<img src="./Screenshots_TTA/allure_report_final.JpG" alt="A centered screenshot">
---

## 🙌 Author

**Nirmala**
- 💼 [LinkedIn](https://www.linkedin.com/in/mahadasyamnirmala)
- 🐙 [GitHub](https://github.com/mahadasyamnirmala)

---

> ⭐ If you found this project helpful, feel free to **star** the repository!
