import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp(){
//        Configuration.timeout = 10000;  // можно задать неявное ожидание
//        Configuration.browserSize = "300x300";  // можно регулировать размер окна
//        Configuration.headless = true;  // запустит тест в невидимом режиме
      //  Configuration.fastSetValue = true; // sendKeys через JavaScript
//        Configuration.clickViaJs = true; // click через JavaScript
     // Configuration.browser ="firefox"; //по умолчанию стоит chrome, если хотим поменять браузер следует прописывать эту строчку
    //  Configuration.browser ="edge";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); //чтобы делать скриншоты и шаги в аллюротчёте
        open(BASE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }
    public void switchToTab(int tabNum){
        switchTo().window(tabNum);
    }

    LoginPage loginPage = new LoginPage();
    HeaderSection headerSection = new HeaderSection();
    ResetPasswordPage resetPassword = new ResetPasswordPage();
    LinkedInPage linkedInPage = new LinkedInPage();
    LinkedLinkDialog linkedLinkDialog = new LinkedLinkDialog();
    FacebookPage facebookPage = new FacebookPage();
    TwitterPage twitterPage = new TwitterPage();
    YouTubePage youTubePage = new YouTubePage();
    SideBar sideBar = new SideBar();
    DirectoryPage directoryPage = new DirectoryPage();

}
