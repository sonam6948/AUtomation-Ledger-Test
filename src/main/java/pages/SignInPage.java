package pages;

import com.microsoft.playwright.Page;

public class SignInPage {
    Page page;


    //Locators
    String username = "input[placeholder='Email']";
    String password = "input[placeholder='Password']";
    String clicksignUp = "button[type=\"submit\"]";


    public SignInPage(Page page) {
        this.page = page;
    }

    public void signIn () {
        page.click("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a");
    }

    public void loginIntoApplication(String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        clickLoginButton();}

    public void enterUserName(String email) {
        page.fill(username, email);}

    public void enterPassword(String pass) {
        page.fill(password, pass);}

    public void clickLoginButton() {
        page.click(clicksignUp);}
    }

