import com.codeborne.selenide.WebDriverRunner;

import static org.junit.Assert.assertTrue;

public class LinkedInPage {
    public void linkedInLinkIsCorrect(){
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("linkedin.com"));
    }
}
