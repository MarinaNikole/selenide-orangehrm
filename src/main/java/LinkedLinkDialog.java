import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LinkedLinkDialog {
    private SelenideElement linkedInElement = $("[class=\"contextual-sign-in-modal__join-now m-auto font-sans text-md text-color-text\"]");

    public void isLinkedInElementAppear(){
        linkedInElement.shouldBe(visible, Duration.ofSeconds(5)).shouldHave(text("LinkedIn"));
    }


}
