import com.codeborne.selenide.WebDriverRunner;

import static org.junit.Assert.assertTrue;

public class FacebookPage {

    public boolean urlContainsFacebook(){
      return   WebDriverRunner.getWebDriver().getCurrentUrl().contains("facebook.com");
    }

    public void facebookLinkIsCorrect(){
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("facebook.com"));
    }
}
