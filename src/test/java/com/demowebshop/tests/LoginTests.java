package com.demowebshop.tests;

import com.demowebshop.core.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginButton();

        app.getUser().fillLoginForm("test_v@gmail.com", "Qwerty12345@");

        app.getUser().clickOnLogin();

        app.getUser().isElementLogoutPresent();

    }

}
