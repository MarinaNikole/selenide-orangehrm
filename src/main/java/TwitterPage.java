import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class TwitterPage {
    private SelenideElement twitterElement = $x("//span[contains(text(),'Twitter will receive your device ')]");

    public void isTwitterElementAppear(){
        twitterElement.shouldBe(visible).shouldHave(text("Twitter"));
    }

    public void twitterLinkIsCorrect(){
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("twitter"));
    }
}
