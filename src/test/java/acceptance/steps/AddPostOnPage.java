package acceptance.steps;
import com.microsoft.playwright.*;
import data.ArticleData;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.testng.Assert;
import pages.ArticlesListPage;
import pages.SignInPage;
import pages.NewPostPage;
import support.PlaywrightFactory;
import utils.GenerateRandom;

public class AddPostOnPage {
    private String articleHeading;
    private String articleHeadingNew;
    PlaywrightFactory playwrightFactory;
    private Page page;
    SignInPage signIn;
    NewPostPage newPost;

    NewPostPage editPost;

    String title;

    ArticleData articleData = new ArticleData();

    ArticlesListPage articlesListPage;
    @Given("user is on application")
    public void user_is_on_application(){
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initBrowser("chromium");
        signIn = new SignInPage(page);
        newPost = new NewPostPage(page);
        articlesListPage = new ArticlesListPage(page);
    }
    @When("user do login with {string} and {string}")
    public void user_do_login(String userName, String password){
        signIn.signIn();
        signIn.loginIntoApplication(userName,password);
    }
    @And("user add article")
    public void user_add_article(){
        newPost.clickNewPostLink();
        title = articleData.getArticleTitle();
        newPost.addNewPost(title, articleData.getArticleDesc(), articleData.getArticleContent(),articleData.getTags());
        newPost.clickPublish();
    }
    @And("user add article for edit")
    public void user_add_article_edit(){
        newPost.clickNewPostLink();
        newPost.addNewPost(articleData.getArticleTitle(), articleData.getArticleDesc(), articleData.getArticleContent(),articleData.getTags());
        newPost.clickPublish();
    }
    @Then("verify article gets added")
    public void verify_article_gets_added(){
        articleHeading = newPost.getArticleTitle();
        Assert.assertEquals(articleHeading,title );
       // playwrightFactory.closeBrowser();
    }
    @When("user adds article with already used {string}")
    public void user_adds_article(String articleTitle){
        newPost.clickNewPostLink();
        newPost.addNewPost(articleTitle, articleData.getArticleDesc(), articleData.getArticleContent(),articleData.getTags());
        newPost.clickPublish();
    }
    @Then("verify warning should display as {string}")
    public void verify_warning(String warning){
        newPost.verifyWarning();
        Assert.assertEquals(newPost.verifyWarning(),warning );
        //playwrightFactory.closeBrowser();
    }
    @And("user edits article")
    public void user_edit_article(){
        editPost = new NewPostPage(page);
        editPost.clickEditArticleButton();
        editPost.enterTitle("edited article"+ GenerateRandom.randomString(10));
        editPost.enterDesc("edited decription"+ GenerateRandom.randomString(10));
        editPost.enterContent("edited content"+ GenerateRandom.randomString(10));
        editPost.clickPublish();
    }
    @Then("verify article gets updated")
    public void verify_article_gets_updated(){
        articleHeadingNew = newPost.getArticleTitle();
        Assert.assertNotEquals(articleHeading,articleHeadingNew );
        //playwrightFactory.closeBrowser();

    }
    @And("user add article to favorites")
    public void user_adds_articles_to_favorites(){
        articlesListPage.goToArticleListPage();
        articlesListPage.clickOnFavoriteIcon();
    }

    @Then("verify article gets added to favorites")
    public void verify_article_gets_added_to_favorites() throws InterruptedException {
        articlesListPage.goToFavoritesPage();
        page.locator("(//a[@class='preview-link'])/h1[contains(text(),'"+title+"')]").waitFor();
        assert page.locator("(//a[@class='preview-link'])/h1[contains(text(),'"+title+"')]").isVisible();
        //playwrightFactory.closeBrowser();
    }

}