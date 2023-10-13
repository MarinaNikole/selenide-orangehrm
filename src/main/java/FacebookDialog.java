import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class FacebookDialog {
    private SelenideElement facebookElement = $(By.id(":rr:"));

    public void isFacebookElementAppear(){
        facebookElement.shouldBe(visible).shouldHave(text("Facebook"));
    }

}
