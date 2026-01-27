package com.demowebshop.tests;

import com.demowebshop.core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        app.getUser().clickOnLoginButton();
        fillLoginForm("test_v@gmail.com", "Qwerty12345@");
        clickOnLogin();
    }

    public void clickOnLogin() {
        app.getUser().clickOnLogInButton();
    }

    public void fillLoginForm(String email, String password) {
        app.getUser().type(By.name("Email"), email);
        app.getUser().type(By.name("Password"), password);
    }

    @Test
    public void addItemToCartTest() {

        String name = itemName("3");
        clickOnItemInList("3");
        clickOnShoppingCartLink();
        Assert.assertTrue(verifyByName(name));
    }

    public String itemName(String itemNameNumber) {
        return app.driver.findElement(By.cssSelector(".item-box:nth-child(" + itemNameNumber + ") h2>a")).getText();
    }

    public void clickOnShoppingCartLink() {
        app.getUser().click(By.id("topcartlink"));
    }

    public void clickOnItemInList(String itemNumber) {
        app.getUser().click(By.cssSelector(".item-box:nth-child(" + itemNumber + ") .buttons"));
    }

    public boolean verifyByName(String text) {
        List<WebElement> contacts = app.driver.findElements(By.cssSelector(".product-name"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

//    @AfterMethod
//    public void postCondition(){
//    removeItemFromCart();
//// click on  ShoppingCart
 }
