package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
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

    public void fillLoginRegisterFormName(String firstName, String lastName) {
        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
         }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLogInButton() {
        click(By.xpath("//input[@class='button-1 login-button' and @value='Log in']"));
    }
    public String newEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String email = "John" + i + "@gmail.com";
        return email;
    }

    public boolean isElementEmailPresent() {
        return isElementPresent(By.xpath("//li[contains(text(),'The specified email already exists')]"));
    }

    public void isElementLogoutPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}
