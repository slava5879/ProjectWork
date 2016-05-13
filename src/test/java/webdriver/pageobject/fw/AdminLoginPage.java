package webdriver.pageobject.fw;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by Slava on 09.05.2016.
 */
public class AdminLoginPage extends LoadableComponent<AdminLoginPage>{
    WebDriver driver;
    @FindBy (how= How.XPATH, using=".//input[@id='user_login']")
    WebElement email;
    @FindBy (how=How.XPATH, using = ".//*[@id='user_pass']")
    WebElement password;
    @FindBy (how = How.XPATH, using = ".//*[@id='wp-submit']")
    WebElement submit;

    public AdminLoginPage (WebDriver driver) {
        this.driver=driver;
        driver.manage().window().maximize();
        driver.get("https://slava981.wordpress.com/wp-admin/");
    }

    public AllPostsPage login () {
        email.sendKeys("slava981");
        password.sendKeys("hex:a2-c4");
        submit.click();
        return PageFactory.initElements(driver, AllPostsPage.class);
    }
    @Override
    protected void load(){
        driver.get("https://slava981.wordpress.com/wp-admin/");
    }

    @Override
    protected void isLoaded() throws Error{
        Assert.assertTrue(driver.getCurrentUrl().contains("wp-admin"));
    }



}
