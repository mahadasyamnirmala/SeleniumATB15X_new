# 🔐 OrangeHRM Login Automation using XPath + Allure Reports

**Tech Stack:** Java | Selenium WebDriver | XPath | Allure Reports | TestNG

---

## 📌 Project Overview

Automated the **OrangeHRM login flow** using XPath locators and generated **Allure HTML reports** to visualize test results.

- 🔗 **App URL:** [OrangeHRM](https://opensource-demo.orangehrmlive.com/)
- 📁 **Project Path:** `E:\SeleniumATB15X_new\src\test\java\org\example\ex04_Xpath\TestSelenium20_MiniProject.java`

---

## ✅ What I Did — Step by Step

### Step 1: Identify XPath Locators for Login Page Elements

Used browser **DevTools (Alt + F)** to inspect elements and verify uniqueness.

#### 🔹 Username Field
```html
<input class="oxd-input oxd-input--active" name="username" placeholder="Username" autofocus="">
```

| XPath | Usable? |
|-------|---------|
| `//input[@name="username"]` | ✅ Yes — Unique |
| `//input[@placeholder="Username"]` | ✅ Yes — Unique |
| `//input[@class="oxd-input oxd-input--active"]` | ⚠️ Returns 2 elements — 1st match, can use carefully |

**Best choice:** `//input[@name="username"]`

---

#### 🔹 Password Field
```html
<input class="oxd-input oxd-input--active" type="password" name="password" placeholder="Password">
```

| XPath | Usable? |
|-------|---------|
| `//input[@name="password"]` | ✅ Yes — Unique |
| `//input[@placeholder="Password"]` | ✅ Yes — Unique |
| `//input[@class="oxd-input oxd-input--active"]` | ❌ Returns 2 elements — 2nd match, avoid |
| `//input[@type="password"]` | ⚠️ Not unique enough |

**Best choice:** `//input[@name="password"]`

---

### Step 2: Write the Test Method

- Launched the browser automatically using WebDriver
- Navigated to the OrangeHRM login page
- Located **Username** field using XPath and entered credentials
- Located **Password** field using XPath and entered credentials
- Clicked the **Login** button

### Step 3: Verify Successful Login

- After login, verified that the next screen loaded correctly
- Confirmed the logged-in user by checking the **PIM (Personnel Information Management)** module is accessible

---

### Step 4: Generate Allure Reports

Run the following command in terminal after test execution:

```bash
allure serve allure-results
```

This launches a local Allure server and opens the HTML report in the browser.

---

## 📊 Allure Report Results

| Metric | Result |
|--------|--------|
| **Status** | ✅ 100% Passed |
| **Test Name** | `test_OHRM_login` |
| **Severity** | Critical |
| **Duration** | 11s 177ms |
| **Owner** | Nirmala |
| **Description** | Verify login is working |

### Report Highlights:
- **Status Chart** — 100% green (all passed) 🟢
- **Severity Chart** — 1 Critical, 5 Normal tests
- **Suite** — `SeleniumATB15X_new > org.example.ex04_Xpath.TestSelenium20_MiniProject`

---

## 🧠 Key Learnings

- How to inspect and verify **XPath uniqueness** using DevTools
- Difference between **absolute** and **relative XPath**
- How to choose the **most reliable XPath** when multiple matches exist
- Setting up and running **Allure Reports** for Selenium tests
- Structuring a clean **Selenium test class** in Java

---

## 🔧 Tools & Technologies

| Tool | Purpose |
|------|---------|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| XPath | Element locator strategy |
| TestNG | Test framework |
| Allure | Test reporting |
| Chrome DevTools | XPath verification |

---

> 💡 *This is part of my Selenium Automation Testing journey — Mini Project 3*
