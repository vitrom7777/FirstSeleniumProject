package com.demowebshop.core;

import com.demowebshop.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {

    public WebDriver driver;
    public WebDriverWait wait;

    UserHelper user;
    com.demowebshop.fw.tests.HomePageHelper homePage;

    public void init() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new UserHelper(driver);
        homePage = new com.demowebshop.fw.tests.HomePageHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public com.demowebshop.fw.tests.HomePageHelper getHomePage() {
        return homePage;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }

    }


}
