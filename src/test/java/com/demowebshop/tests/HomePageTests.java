package com.demowebshop.tests;
import com.demowebshop.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests {

    public static class homePageTests extends TestBase {

        @Test
        public void isHomeComponentPresentTests() {
            // System.out.println("Present "+ isHomeComponentPresent()); //true!
            //driver.findElement(By.xpath("//title[text()='Demo Web Shop']"));
            Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
        }
    }
}



