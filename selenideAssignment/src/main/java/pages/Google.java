package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class Google {

    SelenideElement searchBox = $(".gLFyf");

    public void goToHomePage(){
        open("/");
    }

    public ResultPage searchText(String text){
        searchBox.setValue(text).pressEnter();
        return new ResultPage();
    }

}
