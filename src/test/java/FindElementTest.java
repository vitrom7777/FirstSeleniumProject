import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        // maximize browser to windows
        driver.manage().window().maximize();
        // wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Test
    public void FindElementByTegName() {
        //tag name -> h1
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getAttribute("class"));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());
    }

    @Test
    public void findElementByPartialLinText() {
        WebElement partialText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //driver.findElement(By.tagName("h1"));
        //tag name "h1"  -> css "h1"
        driver.findElement(By.cssSelector("h1"));
        // id "city" -> css "#city"
        driver.findElement(By.cssSelector("#city"));

        // driver.findElement(By.className("telephone"));
        // class "telephone" -> css ".telephone"
        WebElement element = driver.findElement(By.cssSelector(".telephone"));
        System.out.println(element.getText());
        // [atr='par']
        WebElement element1 = driver.findElement(By.cssSelector("[href='/search']"));
        WebElement element2 = driver.findElement(By.cssSelector("[for='city']"));
        System.out.println(element2.getText());
// contains -> *
        WebElement element3 = driver.findElement(By.cssSelector("[href*='car']"));

        // start -> ^
        WebElement element4 = driver.findElement(By.cssSelector("[href^='/let']"));
        System.out.println(element4.getText());
        // end string  $
        driver.findElement(By.cssSelector("[href$='work']"));

        // composite cssSelector
        //[a.navigation-link[href='/search']=> a -> tag
        // .navigation-link ->class
        // [href='/search'] ->para
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));


        // tag+class
        driver.findElement(By.cssSelector("div.social-networks"));

        driver.findElement(By.cssSelector(".logo>img"));  // > one step below

        driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space >
        // one or more steps below

        //<tag> or <id> or <class>:nth-child(n)
        WebElement element5 = driver.findElement(By.cssSelector(".feedback:nth-child(5)"));
        System.out.println(element5.getText());

        //
        WebElement element6 = driver.findElement(By.cssSelector("[type='submit']"));

        WebElement element7 = driver.findElement(By.cssSelector(".title-container span.title"));
        // class+ <space>+ class
    }

    @Test
    public void findElementByXpath() {
//     //some_tag (*) +[@attribute='value']
        //    //tag[2]
        //    operator ->  //tag[@attr='value1' and(not( @attr2='value2']
        //     funk -> text(); contains();
//driver.findElement(By.tagName("h1"));
        WebElement h1x = driver.findElement(By.xpath("//h1"));
        System.out.println(h1x.getText());
        // driver.findElement(By.id("city"));
        WebElement xpathId = driver.findElement(By.xpath("//input[@id='city']"));
        System.out.println(xpathId.getText());
        //driver.findElement(By.className("telephone"));
        WebElement xpathA = driver.findElement(By.xpath("//a[@class='telephone']"));
        System.out.println(xpathA.getText());
        //driver.findElement(By.cssSelector("[href='/search']"));  para
        driver.findElement(By.xpath("//a[@href='/search']"));
        // driver.findElement(By.cssSelector("[for='city']"));
        WebElement labelXpath = driver.findElement(By.xpath("//label[@for='city']"));
        System.out.println(labelXpath.getText());
        //// contains -> *
        //        WebElement element3 = driver.findElement(By.cssSelector("[href*='car']"));
        WebElement aHref = driver.findElement(By.xpath("//a[contains(@href,'car')]"));
        System.out.println(aHref.getText());
        //        // start -> ^
        //        WebElement element4 = driver.findElement(By.cssSelector("[href^='/let']"));
        driver.findElement(By.xpath("//a[starts-with(@href,'/let')]"));

// text xpath
        //WebElement textXpath = driver.findElement(By.xpath("//*[contains(text(),'This car exceeded my expectations')]"));
        WebElement textXpath = driver.findElement(By.xpath("//*[contains(.,'This car exceeded my expectations')]"));
        System.out.println(textXpath.getText());
        // text = !!!
        driver.findElement(By.xpath("//span[text()=' Latest feedback from our customers ']"));
        driver.findElement(By.xpath("//span[.=' Latest feedback from our customers ']"));
//// composite cssSelector
//        //[a.navigation-link[href='/search']=> a -> tag
//        // .navigation-link ->class
//        // [href='/search'] ->para
//        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));
        driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/search']"));

        //// tag+class
        //        driver.findElement(By.cssSelector("div.social-networks"));
        driver.findElement(By.xpath("//div[@class='social-networks']"));

       //*****
        //        driver.findElement(By.cssSelector(".logo>img"));  // > one step below
        driver.findElement(By.xpath("//a[@class='logo']/img"));

        //****
        //        driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space >
        //        one or more steps below
        driver.findElement(By.xpath("//div[@class='feedback']//*[@class='feedback-date]'"));

    }
@Test
    public void findElementBrXpathFamily(){
        //parent
    driver.findElement(By.xpath("//h1/parent::*"));
    driver.findElement(By.xpath("//h1/parent::div"));
    WebElement h1 = driver.findElement(By.xpath("//h1/.."));
    System.out.println(h1.getText());

    //ancestor !!!
    // html ->main
    driver.findElement(By.xpath("//h1/ancestor::*"));
    // -> 2 steps up
    driver.findElement(By.xpath("//h1/ancestor::div"));
    // 2 steps above(up)
    driver.findElement(By.xpath("//h1/ancestor::div[2]"));


    }
}
//cssSelector -> div>a    xpath -> div/a - one step
//
 // cssSelector -> div a   xpath -> div//a one or more steps