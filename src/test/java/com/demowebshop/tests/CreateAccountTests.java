package com.demowebshop.tests;

import com.demowebshop.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterFormName("John", "Smith");
        app.getUser().fillLoginRegisterForm("Qwerty12345@");
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isContinueButtonPresent());

    }

    @Test
    public void existedUserRegisterNegativeTest() {

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterFormName("John", "Smith");

        app.getUser().fillLoginRegisterForm("Qwerty12345@");

        app.getUser().clickOnRegistrationButton();

        Assert.assertFalse(app.getUser().isElementEmailPresent());
    }

}