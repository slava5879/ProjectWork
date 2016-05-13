package webdriver.pageobject.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

/**
 * Created by Slava on 09.05.2016.
 */
public class DeletePostPage {
    WebDriver driver;
    @FindBy (how = How.LINK_TEXT, using = "Удалить")
    WebElement moveToTrash;


    public DeletePostPage (WebDriver driver) {
        this.driver=driver;
        System.out.println(driver.getCurrentUrl());

    }


    public void delete() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        moveToTrash.click();
    }
}
