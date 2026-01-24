package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends  TestBase{

    @Test
    public void newUserRegisterPositiveTest(){
        // click on `Register` link
        //driver.findElement(By.cssSelector("[href='/register']")).click();
        click(By.cssSelector("[href='/register']"));

        // Enter First name: *
        //1.click
        type(By.name("FirstName"), "John");

        //*
        // Enter Last name: *
        //1.click
        type(By.name("LastName"), "Smith");

        // Enter email *
        //1.click
        type(By.name("Email"), "test_v@gmail.com");

        // password
        // Enter password *
        //1.click
        type(By.name("Password"), "Qwerty12345@");

        // password confirm
        //1.click
        type(By.name("ConfirmPassword"), "Qwerty12345@");

        // click on Registration button  register-button
        click(By.name("register-button"));

        // assert Sign Out is present
        Assert.assertTrue(isElementPresent(By.xpath("//input[@class='button-1 register-continue-button' and @value='Continue']")));

    }

    @Test
    public void existedUserRegisterNegativeTest(){
        // click on `Register` link
        click(By.cssSelector("[href='/register']"));
        // Enter First name: *
        //1.click
        type(By.name("FirstName"), "John");

        //*
        // Enter Last name: *
        //1.click
        type(By.name("LastName"), "Smith");

        // Enter email *
        //1.click
        type(By.name("Email"), "test_v@gmail.com");

        // password
        // Enter password *
        //1.click
        type(By.name("Password"), "Qwerty12345@");

        // password confirm
        //1.click
        type(By.name("ConfirmPassword"), "Qwerty12345@");

        // click on Registration button  register-button
        click(By.name("register-button"));

        // assert ALERT
        //Assert.assertTrue(isElementPresent(By.xpath("//input[@class='button-1 register-continue-button' and @value='Continue']")));
Assert.assertTrue(isAlertPresent());
    }

}
