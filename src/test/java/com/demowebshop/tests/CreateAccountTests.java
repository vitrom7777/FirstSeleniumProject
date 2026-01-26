package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterFormName("John", "Smith"); // ???
        // Why does it say that:
        // Value of parameter 'firstName' 'lastName' is always '"John"' "Smith"?

        fillLoginRegisterForm("Qwerty12345@");
        clickOnRegistrationButton();

        Assert.assertTrue(isContinueButtonPresent());

    }

    @Test
    public void existedUserRegisterNegativeTest() {

        clickOnLoginLink();

        fillLoginRegisterFormName("John", "Smith");

        fillLoginRegisterForm("Qwerty12345@");

        clickOnRegistrationButton();

        Assert.assertTrue(isElementEmailPresent());
    }

}
