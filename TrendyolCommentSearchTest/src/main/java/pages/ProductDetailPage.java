package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductDetailPage {

    private final SelenideElement ALL_COMMENTS = $(".rvw-cnt-tx");

    public CommentsPage clickAllComments() {

            ALL_COMMENTS.shouldBe(Condition.visible);
            ALL_COMMENTS.click();
            return new CommentsPage();
    }

}