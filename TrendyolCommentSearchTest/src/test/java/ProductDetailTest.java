import base.BaseTest;
import constant.Constant;
import org.testng.annotations.Test;
import pages.CommentsPage;
import pages.ProductPage;

public class ProductDetailTest extends BaseTest {

    @Test
    public void commentSearchTest(){

        homePage.goToHomePage();
        homePage.closeHomePagePopup();
        //Selenide.open("https://www.trendyol.com/sr?fl=encoksatanurunler");
        ProductPage productPage = homePage.searchProduct(Constant.PRODUCT_NAME);
        CommentsPage commentsPage = productPage.findCommentsSearchBox();
        commentsPage.searchComment(Constant.COMMENT_KEYWORD);
        assert  commentsPage.checkComment(Constant.COMMENT_KEYWORD);

    }
}