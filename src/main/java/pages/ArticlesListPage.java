package pages;

import com.microsoft.playwright.Page;

public class ArticlesListPage {

    Page page;

    // Locator — — — -
    String accountLink = ".author";
    String FavoriteIcon = "//div[@class='article-meta'][1]/div[@class='pull-xs-right'][1]/button[@class='btn btn-sm btn-outline-primary']";
    String favoritesPageTab = "div[class='articles-toggle'] li:nth-child(2)";
    //initialize Page using constructor

    public ArticlesListPage(Page page) {

        this.page =page;}
//Method
    public void goToArticleListPage() {

        page.click(accountLink);
    }
    public void clickOnFavoriteIcon() {
        page.click(FavoriteIcon);
    }
    public void goToFavoritesPage(){
        page.click(favoritesPageTab);
    }
}