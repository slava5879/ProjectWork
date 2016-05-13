package webdriver.pageobject.tests;

import org.junit.Test;

import org.openqa.selenium.support.PageFactory;
import webdriver.pageobject.fw.AdminLoginPage;
import webdriver.pageobject.fw.AllPostsPage;
import webdriver.pageobject.fw.CommonMethods;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Slava on 09.05.2016.
 * the test was placed on Git
 */
public class Test01_AddNewPost extends CommonMethods {

    @Test
    public void testAddNewPost (){

        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = loginPage.login();
        allPostsPage.createNewPost("New post", "My first post");

        assertTrue(allPostsPage.getPostName().equals("New post"));

    }

}
