import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class GoogleTestPage {
    private FirefoxDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testSearch() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ResultPage result = home.search("ivanyshyn");

        driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();

        List<WebElement> links=driver.findElements(By.xpath(".//*[@id='rso']/div/div/div/h3/a"));
        System.out.println(links.size());

        for (int i=0; i<links.size(); i++) {
            links.get(i).click();
            Thread.sleep(4000);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            links = driver.findElements(By.xpath(".//*[@id='rso']/div/div/div/h3/a"));



        }


        assertTrue(result.getFirstLink().contains("automated"));


    }
}
