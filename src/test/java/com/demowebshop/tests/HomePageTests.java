package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTests() {
        // System.out.println("Present "+ isHomeComponentPresent()); //true!
        //driver.findElement(By.xpath("//title[text()='Demo Web Shop']"));
        Assert.assertTrue(isHomeComponentPresent());
    }

}

