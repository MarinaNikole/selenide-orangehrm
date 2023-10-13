import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class ResetPasswordPage {

    private SelenideElement resetYourPassword = $(className("orangehrm-forgot-password-title"));

    public void resetYourPasswordIsDisplayed(String message){
        resetYourPassword.shouldBe(visible).shouldHave(text(message));
    }

    public SelenideElement getResetYourPassword() {
        return resetYourPassword;
    }
}
