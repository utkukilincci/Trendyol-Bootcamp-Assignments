package pages;


import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage{

    ElementsCollection results = $$(".g");

    public void clickFirstResult(){
        results.first().find(By.tagName("a")).click();
    }

    public void clickResultContainsText(String text){
        results.findBy(Condition.text(text)).find(By.tagName("a")).click();
    }

}
