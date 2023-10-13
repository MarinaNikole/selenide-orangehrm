import com.codeborne.selenide.WebDriverRunner;

import static org.junit.Assert.assertTrue;

public class YouTubePage {
    public void youTubeLinkIsCorrect(){
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("youtube.com"));
    }
}
