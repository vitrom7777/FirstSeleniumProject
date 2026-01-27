package com.demowebshop.tests;

import com.demowebshop.core.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginButton();

        app.getUser().type(By.name("Email"), "test_v@gmail.com");
        app.getUser().type(By.name("Password"), "Qwerty12345@");

        app.getUser().clickOnLogInButton();

        app.getUser().isElementLogoutPresent();

    }

}
