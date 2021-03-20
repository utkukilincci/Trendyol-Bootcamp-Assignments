package base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

public class BaseTest {

    public HomePage homePage;

    public BaseTest(){

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        opt.addArguments("--disable-popup-blocking");
        Configuration.browserCapabilities= opt;
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 3000;
        Configuration.holdBrowserOpen = true;
        homePage = new HomePage();

    }
}
