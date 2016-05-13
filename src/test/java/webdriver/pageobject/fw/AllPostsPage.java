package webdriver.pageobject.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Slava on 09.05.2016.
 */
public class AllPostsPage {
    WebDriver driver;
    @FindBy(how = How.XPATH, using = ".//*[@id='the-list']")
    WebElement postsContainer;
    @FindBy(how = How.XPATH, using = ".//*[@id='post-search-input']")
    WebElement searchPosts;
    @FindBy(how = How.XPATH, using = ".//*[@id='cat']")
    WebElement viewByCategories;
    @FindBy(how =How.XPATH, using = ".//a[@class='page-title-action']")
    WebElement addNewPost;
    @FindBy(how = How.XPATH, using = ".//*[@id='post-58']/td/strong/a")
    WebElement postName;



    public AllPostsPage (WebDriver driver) {
        this.driver=driver;
        driver.get("https://slava981.wordpress.com/wp-admin/edit.php");
    }

    public void createNewPost (String title, String description){
        addNewPost.click();
        AddNewPostPage newPost = PageFactory.initElements(driver, AddNewPostPage.class);
        newPost.addNewPost(title, description);
    }

    public void editPost (String presentTitle, String newTitle, String description) {
        goToParticularPostPage (presentTitle);
        EditPostPage editPost = PageFactory.initElements(driver, EditPostPage.class);
        editPost.editPost(newTitle, description);
    }

    public void deletePost (String title) {
        goToParticularPostPage (title);
        DeletePostPage deletePost = PageFactory.initElements(driver, DeletePostPage.class);
        deletePost.delete();

    }

    public String getPostName(){
        return postName.getText();

    }

    public void filterPostsByCategory (String category){}

    public void searchInPost (String searchText){}

    public int getAllPostsCount(){
        List <WebElement> postsList = postsContainer.findElements(By.tagName("tr"));
        return postsList.size();
    }

    private void goToParticularPostPage(String presentTitle) {
        List <WebElement> allPosts = postsContainer.findElements(By.xpath(".//*/td/strong/a"));
        for (int i=0; i<allPosts.size(); i++) {
            if (allPosts.get(i).getText().equals(presentTitle)) {
                Actions builder = new Actions(driver);
                builder.moveToElement(allPosts.get(i));

                List <WebElement> allPostsEditButton = postsContainer.findElements(By.cssSelector(".edit>a"));
                builder.click(allPostsEditButton.get(i));

                Action compositeAction = builder.build();
                compositeAction.perform();
                break;
            }
        }
    }

}
