package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public String itemName(String itemNameNumber) {
        return driver.findElement(By.cssSelector(".item-box:nth-child(" + itemNameNumber + ") h2>a")).getText();
    }

    public void clickOnShoppingCartLink() {
        click(By.id("topcartlink"));
    }

    public void clickOnItemInList(String itemNumber) {
        click(By.cssSelector(".item-box:nth-child(" + itemNumber + ") .buttons"));
    }

    public boolean verifyByName(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeItemFromCart() {
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }
}
