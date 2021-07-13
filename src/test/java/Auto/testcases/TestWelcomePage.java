package Auto.testcases;

import Auto.Utility.CommonUtility;
import Auto.Utility.Init;
import Auto.pages.HitMapPage;
import Auto.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class TestWelcomePage extends Init {
    CommonUtility commonUtility;

    @Test
    public void test1() throws InterruptedException {
        Init.browser = "chrome";
        System.out.println("Title is:" + driver.getTitle());
        WelcomePage welcomepage = new WelcomePage(driver);
        welcomepage.verifyWelcomePageHeader();
        String parentBrowser = driver.getWindowHandle();
        welcomepage.clickonHeatmap();
        Set s = driver.getWindowHandles();
        driver = commonUtility.getOtherWindowDriverReference(driver,s,parentBrowser);
        HitMapPage hitMapPage = new HitMapPage(driver);
        hitMapPage.verifyHeadingofPage();
        hitMapPage.switchtoHitmapFrame();
        hitMapPage.verifyElementList();
        hitMapPage.ClickonElementList();
        hitMapPage.switchtoMainPagefromFrame();
        hitMapPage.switchtoElementListFrame();
        hitMapPage.verifyandClickonEmail();
        hitMapPage.switchtoMainPagefromFrame();
        hitMapPage.verifyEmailOptionHighlight();
     }
}
