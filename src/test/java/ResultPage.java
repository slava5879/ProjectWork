import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Slava on 07.05.2016.
 */
public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {

        this.driver=driver;
    }

    public String getFirstLink() {

        return driver.findElement(By.xpath("(.//*[@id='rso']//a)[1]")).getText();
    }
}
