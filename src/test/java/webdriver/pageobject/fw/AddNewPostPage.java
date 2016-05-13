package webdriver.pageobject.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Slava on 09.05.2016.
 */
public class AddNewPostPage {
    WebDriver driver;
    @FindBy(how= How.XPATH, using = ".//iframe[@id='content_ifr']")
    WebElement newPostContentFrame;
    @FindBy(how = How.XPATH, using = ".//*[@id='tinymce']")
    WebElement newPostContentBody;
    @FindBy(how = How.XPATH, using = ".//*[@id='title']")
    WebElement newPostTitle;
    @FindBy(how = How.XPATH, using = ".//*[@id='save-post']")
    WebElement newPostPublish;
    @FindBy(how = How.XPATH, using = ".//*[@id='menu-posts']/a")
    WebElement goToAllPosts;

    public AddNewPostPage(WebDriver driver){
        this.driver=driver;
        System.out.println(driver.getCurrentUrl());
    }

    public AllPostsPage addNewPost (String title, String descContent){
        driver.switchTo().frame(newPostContentFrame);
        newPostContentBody.sendKeys(descContent);
        driver.switchTo().defaultContent();
        newPostTitle.click();
        newPostTitle.sendKeys(title);
        newPostPublish.click();
        goToAllPosts.click();

        return PageFactory.initElements(driver, AllPostsPage.class);

    }
}
