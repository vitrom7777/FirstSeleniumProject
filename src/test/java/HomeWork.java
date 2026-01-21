import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class HomeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @Test
    public void FindElementByTegName(){
        //1.tag name -> h3 Information
        WebElement h3 = driver.findElement(By.tagName("h3"));
        System.out.println(h3.getText());
        //2.tag name -> All h3
        List<WebElement> all_h3 = driver.findElements(By.tagName("h3"));
        System.out.println(all_h3.size());
        //3.tag name -> All a
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }
    @Test
    public void findElementById(){
        //1. By id
        WebElement topcartlink = driver.findElement(By.id("topcartlink"));
        System.out.println(topcartlink.getAttribute("id"));
        //2. By id
       WebElement flyout = driver.findElement(By.id("flyout-cart"));
       System.out.println(flyout.getAttribute("id"));
    }
    @Test
    public void findElementByClassName(){
       WebElement topMenu = driver.findElement(By.className("top-menu"));
        System.out.println(topMenu.getText());
        // result:
        // BOOKS
        //COMPUTERS
        //ELECTRONICS
        //APPAREL & SHOES
        //DIGITAL DOWNLOADS
        //JEWELRY
        //GIFT CARDS

        WebElement headerLinks = driver.findElement(By.className("header-links-wrapper"));
        System.out.println(headerLinks.getText());
        // result
        //Register
        //Log in
        //Shopping cart
        //(0)
        //Wishlist
        //(0)
        WebElement footerPoweredBy = driver.findElement(By.className("footer-poweredby"));
        System.out.println(footerPoweredBy.getText());
        // result: Powered by nopCommerce
    }
    @AfterMethod
    public void tearDown(){
        if(driver !=null){
            driver.quit();
        }

    }

}
