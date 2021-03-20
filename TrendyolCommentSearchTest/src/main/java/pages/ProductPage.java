package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import constant.Constant;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    private final String RATING_COUNT_CLASS_NAME = ".ratingCount";
    private ElementsCollection PRODUCT_LIST = $$(".p-card-wrppr");
    private final SelenideElement POPUP = $(".popup");
    private final SelenideElement OVERLAY = $(".overlay");
    private ProductDetailPage productDetailPage = new ProductDetailPage();
    private SelenideElement product;
    private int counter = 0;


    public CommentsPage findCommentsSearchBox(){

        if(POPUP.isDisplayed()){
            OVERLAY.click();
        }

        Assert.assertTrue(!PRODUCT_LIST.isEmpty(),Constant.EMPTY_PRODUCT_PAGE_MESSAGE);

        boolean productIsFound = false;
        boolean productListNotConsumed = true;
        while (productListNotConsumed){

            if( counter >= PRODUCT_LIST.size()){
                productListNotConsumed = false;
                continue;
            }

            if(counter%20 == 0){
                PRODUCT_LIST = $$(".p-card-wrppr");
            }
            product = PRODUCT_LIST.get(counter);
            counter += 1;
            product.scrollIntoView(true);
            if(!isValidProduct(product)) continue;
            product.click();
            switchTo().window(1);
            CommentsPage commentsPage = productDetailPage.clickAllComments();
            if(commentsPage.isDisplayedSearchBox()){
                productIsFound = true;
                break;
            }
            closeWindow();
            switchTo().window(0);
        }

        Assert.assertTrue(productIsFound, "There are no available product for test");

        return  new CommentsPage();
    }

    private boolean isValidProduct(SelenideElement product){
        if(!product.find(RATING_COUNT_CLASS_NAME).isDisplayed()) return false;
        String text = product.find(RATING_COUNT_CLASS_NAME).getText();
        text = text.substring(1,text.length()-1);
        int ratingCount = Integer.valueOf(text);
        if(ratingCount >= Constant.LOWER_BOUND && ratingCount<Constant.UPPER_BOUND){
            return true;
        }

        return false;
    }
}