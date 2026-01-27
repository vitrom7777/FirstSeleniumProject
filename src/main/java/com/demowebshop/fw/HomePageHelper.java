package com.demowebshop.fw.tests;

import com.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent () {
        return isElementPresent(By.xpath("//title[text()='Demo Web Shop']"));

    }
}
