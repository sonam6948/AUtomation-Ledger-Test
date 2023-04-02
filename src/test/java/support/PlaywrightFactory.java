package support;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @Before()
    public Page initBrowser(String browserName) {
        System.out.println("browser is .." + browserName);
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://react-redux.realworld.io/#/?_k=cafszz");
        return page;
    }
    @After
    public void afterScenario() {
        browser.close();
    }
}
