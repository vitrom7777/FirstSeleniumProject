package com.demowebshop.core;

import com.demowebshop.fw.HomePageHelper;
import com.demowebshop.fw.ItemHelper;
import com.demowebshop.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;
    public WebDriverWait wait;

    UserHelper user;
    HomePageHelper homePage;
    ItemHelper item;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
if (browser.equalsIgnoreCase("chrome")) {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
} else if ( browser.equalsIgnoreCase("firefox")) {
    WebDriverManager.firefoxdriver().setup();
    driver= new FirefoxDriver();
} else if (browser.equalsIgnoreCase("edge")) {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
}


        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        homePage = new HomePageHelper(driver);
        item = new ItemHelper(driver);
    }

    public ItemHelper getItem() {
        return item;
    }

    public UserHelper getUser() {
        return user;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }

    }


}
