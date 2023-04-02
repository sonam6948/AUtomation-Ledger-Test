package pages;

import com.microsoft.playwright.Page;

public class NewPostPage {

    Page page;

// Locator — — — -

    String newPostLink ="//a[@href='#editor']";
    String articleTitleField = "input[placeholder=\"Article Title\"]";
    String articleDescField = "input[placeholder=\"What's this article about?\"]";
    String articleContentField = "textarea[placeholder='Write your article (in markdown)']";
    String tagField = "input[placeholder='Enter tags']";
    String clickPublish = "button[type='button']";
    String warning = "ul[class='error-messages'] li";
    String editArticle = "//a[normalize-space()='Edit Article']";




    //initialize Page using constructor

    public NewPostPage(Page page) {

        this.page =page;}

//Method

    public void clickNewPostLink() {

        page.click(newPostLink);

    }
    public void addNewPost(String articleTitle, String articleDesc, String articleContent, String tag) {
        enterTitle(articleTitle);
        enterDesc(articleDesc);
        enterContent(articleContent);
        enterTag(tag);
        }


    public void enterTitle(String articleTitle) {
        page.fill(articleTitleField, articleTitle);}

    public void enterDesc(String articleDesc ){
       page.fill(articleDescField,articleDesc );}

    public void enterContent(String articleContent ){
        page.fill(articleContentField,articleContent );}

    public void enterTag(String tag ){
        page.fill(tagField,tag );}

    public void clickPublish() {
        page.click(clickPublish);}

    public String getArticleTitle(){
      String Heading =  page.locator("div[class='container'] h1").textContent();
      return Heading;
    }
    public String verifyWarning() {
       assert page.locator(warning).isVisible();
      String warningMessage = page.locator(warning).textContent();
      return warningMessage;
    }

    public void clickEditArticleButton(){
        page.click(editArticle);
    }
}




