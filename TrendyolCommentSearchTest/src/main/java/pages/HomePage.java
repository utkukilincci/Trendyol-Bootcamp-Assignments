package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final String URL = "https://www.trendyol.com/";
    private final SelenideElement HOME_PAGE_POPUP_CLOSE = $(".fancybox-close");
    private final SelenideElement SEARCH_BOX = $(".search-box");

    public void goToHomePage(){
        open(URL);
    }

    public void closeHomePagePopup(){
        HOME_PAGE_POPUP_CLOSE.click();
    }

    public ProductPage searchProduct(String text){
        SEARCH_BOX.shouldBe(Condition.visible);
        SEARCH_BOX.sendKeys(text);
        SEARCH_BOX.pressEnter();
        return new ProductPage();
    }
}
