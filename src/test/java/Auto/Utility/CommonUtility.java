package Auto.Utility;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class CommonUtility
{
    static WebDriver driver;
    public static void initialize(WebDriver d)
    {
        driver= d;
    }

    public static WebDriver getOtherWindowDriverReference(WebDriver driver,Set s, String parent)
    {
        initialize(driver);

        Iterator itr = s.iterator();
        while(itr.hasNext())
        {
            String str = (String)itr.next();
            if(!(parent.equalsIgnoreCase(str)))
            {
                driver=driver.switchTo().window(str);
                return driver;
            }
        }
        return driver;
    }

}
