package webdriver.pageobject.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import webdriver.pageobject.fw.AdminLoginPage;
import webdriver.pageobject.fw.AllPostsPage;

/**
 * Created by Slava on 12.05.2016.
 */
public class Test03_DeletePost {
    @Test
    public void testDeletePost (){
        System.setProperty("webdriver.chrome.driver", "e:\\chromedriver_win32_2.21\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = adminLoginPage.login();
        allPostsPage.deletePost("Edit post");

        driver.close();


    }
}
