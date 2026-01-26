package com.demowebshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//title[text()='Demo Web Shop']"));

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public String newEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String email = "John" + i + "@gmail.com";
        return email;
    }

    public boolean isContinueButtonPresent() {
        return isElementPresent(By.xpath("//input[@class='button-1 register-continue-button' and @value='Continue']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void fillLoginRegisterForm(String password) {
        type(By.name("Email"), newEmail());
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), password);
    }

    protected void fillLoginRegisterFormName(String firstName, String lastName) {
        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
        // ???
        // Why does it say that:
        // Value of parameter 'firstName' 'lastName' is always "John" "Smith"?

    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isElementEmailPresent() {
        return isElementPresent(By.xpath("//li[contains(text(),'The specified email already exists')]"));
    }

    public void isElementLogoutPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }
//    public boolean isAlertPresent() {
//        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(21))
//                .until(ExpectedConditions.alertIsPresent());
//        if (alert == null) {
//            return false;
//        } else {
//            return true;
//        }
//   }
}
