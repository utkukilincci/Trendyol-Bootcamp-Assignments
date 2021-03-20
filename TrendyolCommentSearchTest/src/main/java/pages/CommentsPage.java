package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constant.Constant;

import static com.codeborne.selenide.Selenide.*;

public class CommentsPage {

    private final SelenideElement COMMENT_SEARCH_BOX = $("input[placeholder='Yorumlarda Ara']");
    private SelenideElement COMMENT;

    public boolean isDisplayedSearchBox() {
        return COMMENT_SEARCH_BOX.isDisplayed();
    }

    public void searchComment(String commentKeyword){
        COMMENT_SEARCH_BOX.sendKeys(commentKeyword);
        COMMENT_SEARCH_BOX.pressEnter();
    }

    public boolean checkComment(String commentKeyword){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        COMMENT = $(".rnr-com-w");
        if(!COMMENT.isDisplayed()) return true;
        System.out.println("yorum : " + COMMENT.getText());
        System.out.println("Aradiginiz keyword : " + commentKeyword);
        return COMMENT.getText().toUpperCase().contains(commentKeyword.toUpperCase());
    }
}