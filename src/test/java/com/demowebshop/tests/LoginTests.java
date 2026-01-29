package com.demowebshop.tests;

import com.demowebshop.core.TestBase;
import com.demowebshop.data.UserData;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginButton();

        app.getUser().fillLoginForm(UserData.EMAIL, UserData.PASSWORD);

        app.getUser().clickOnLogin();

        app.getUser().isElementLogoutPresent();

    }

}
