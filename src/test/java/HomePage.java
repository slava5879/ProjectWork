
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {

    private FirefoxDriver driver;

    public HomePage(FirefoxDriver driver) {
        this.driver = driver;
    }

    public ResultPage search(String s) {
        driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys(s);
        return new ResultPage(driver);
    }
}
