package webdriver.pageobject.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Slava on 09.05.2016.
 */
public class EditPostPage {
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

    public EditPostPage(WebDriver driver) {
        this.driver=driver;
        driver.getCurrentUrl();
    }

    public void editPost (String title, String descContent){
        driver.switchTo().frame(newPostContentFrame);
        newPostContentBody.clear();
        newPostContentBody.sendKeys(descContent);
        driver.switchTo().defaultContent();
        newPostTitle.click();
        newPostTitle.clear();
        newPostTitle.sendKeys(title);
        newPostPublish.click();
        goToAllPosts.click();


    }

}
