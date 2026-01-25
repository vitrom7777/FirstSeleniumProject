package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

@Test
    public void loginRegisteredUserPositiveTest(){
// click on `Register` link
    //driver.findElement(By.cssSelector("[href='/register']")).click();
    click(By.cssSelector("[href='/login']"));

    // Enter First name: *
    //1.click
    //type(By.name("FirstName"), "John");

    //*
    // Enter Last name: *
    //1.click
    //type(By.name("LastName"), "Smith");

    // Enter email *
    //1.click
    type(By.name("Email"), "test_v@gmail.com");

    // password
    // Enter password *
    //1.click
    type(By.name("Password"), "Qwerty12345@");

    // password confirm
    //1.click
    //type(By.name("ConfirmPassword"), "Qwerty12345@");

    // click on Registration button  Log in
    //click(By.name("register-button"));
    click(By.xpath("//input[@class='button-1 login-button' and @value='Log in']"));


    // assert Log in is present
    //Assert.assertTrue(isElementPresent(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")));
    Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));

}

}
