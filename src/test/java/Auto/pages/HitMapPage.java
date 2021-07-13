package Auto.pages;

import Auto.Utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HitMapPage extends Services {

    private String xpathHeading = "//h1";
    private static final String TITLE="VWO | #1 A/B Testing Tool in the World";
    private static final String Heading="Fast growing companies use VWO for their A/B testing";
    private static final By elementList = By.xpath("//span[text()='Element List'][@data-qa='jepucefiga']");
    private static final By email = By.xpath("//*[@class='element-list-item element-list-item--visible']//*[text()='email']");

    String hitmapiframe="heatmap-iframe";
    String elementListFrame="element-list-iframe";

    public HitMapPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver,20);

    public WebDriver switchtoFrame(String str)
    {
        driver=driver.switchTo().frame(str);
        return  driver;
    }
    public void verifyElementList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementList));
        assertTrue(driver.findElement(elementList).isEnabled());
    }
    public void verifyandClickonEmail() throws InterruptedException {

        assertTrue(driver.findElement(email).isEnabled());
        driver.findElement(email).click();
    }
    public void verifyEmailOptionHighlight()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='email' and @name='email' and @data-qa='form-ft-sec1-inline-su-v1-email']")).isEnabled(),
                "Email option is not Highlighted on Page");
    }
    public void ClickonElementList() throws InterruptedException {
        driver.findElement(elementList).click();
    }
    public void switchtoMainPagefromFrame()
    {
        driver.switchTo().defaultContent();
    }
    public void switchtoHitmapFrame()
    {
        driver.switchTo().frame(hitmapiframe);
    }
    public void switchtoElementListFrame()
    {
        driver.switchTo().frame(elementListFrame);
    }

    public void verifyTitleofPage()
    {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, TITLE,
                "Actual title " + actualTitle + " should be same as expected " + TITLE);
    }
    public void verifyHeadingofPage() throws InterruptedException {
        Thread.sleep(10000);
        String actualHeading = driver.findElement(By.xpath("//h1")).getText();
        assertEquals(actualHeading, Heading,
                "Actual title " + actualHeading + " should be same as expected " + Heading);
    }

}