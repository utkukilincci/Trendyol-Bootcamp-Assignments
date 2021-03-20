package base;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    public BaseTest(){
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.google.com";
        Configuration.holdBrowserOpen = true;
    }

}
