import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import pages.Google;
import pages.ResultPage;

import static com.codeborne.selenide.Selenide.$;

public class SearchLinkedin extends BaseTest {

    SelenideElement linkedinLogo = $(".nav__logo-link");

    @Test
    public void googleSearchTest(){

        Google google = new Google();
        google.goToHomePage();
        ResultPage resultPage =  google.searchText("Linkedin");
        resultPage.clickFirstResult();
        assert  linkedinLogo.isDisplayed();

    }


}
