package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ItemTests extends TestBase {
    //WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeMethod
    public void precondition() {
// click on `Register` link
        //driver.findElement(By.cssSelector("[href='/register']")).click();
        clickOnLoginButton();

        type(By.name("Email"), "test_v@gmail.com");

        type(By.name("Password"), "Qwerty12345@");

        // click on Registration button  Log in
        //click(By.name("register-button"));
        click(By.xpath("//input[@class='button-1 login-button' and @value='Log in']"));


        // assert Log in is present
        //Assert.assertTrue(isElementPresent(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")));
        isElementLogoutPresent();
    }

    @Test
    public void addItemToCartTest() {

//   1. кликнуть на кнопку второго товара Add to cart;
        WebElement addToCartButton2 =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@data-productid='31']//input[@value='Add to cart']")));
        addToCartButton2.click();
        //2.кликнуть на ссылку Shopping cart в хэдере;
        WebElement shopCartLink = driver.findElement(By.id("topcartlink"));
        shopCartLink.click();

// 3. проверить добавление товара в корзину по его названию(имени)
        driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']"));
        // String expectedName = "14.1-inch Laptop";

        // 4.Assert
        //Assert.assertTrue(driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']")).isDisplayed());
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='14.1-inch Laptop']")));
    }
}
