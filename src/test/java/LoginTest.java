import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.className;

public class LoginTest extends BaseTest {

    String usernameValue = "Admin";
    String passwordValue = "admin123";


    //@Test
    public void forgotYourPassword1() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        $(className("orangehrm-login-forgot-header")).click();
        $(className("orangehrm-forgot-password-title")).shouldBe(visible).shouldHave(text("Reset Password"));
    }

    @Test
    public void successLogin() {
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
    }

    @Test
    public void invalidPassword() {
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword("123321");
        loginPage.clickLoginButton();
        loginPage.invalidCredentialIsDisplayed("Invalid credentials");
        //  loginPage.getInvalidCredentialField().shouldHave(text("Invalid credentials"));
    }

    @Test
    public void forgotYourPassword() {
        loginPage.clickForgotPasswordButton();
        resetPassword.resetYourPasswordIsDisplayed("Reset Password");
        // resetYourPassword.getResetYourPassword().shouldBe(visible).shouldHave(text("Reset Password"));
    }

    @Test
    public void elementsAreDisplayed() {
        loginPage.logoIsDisplayed();
   //   loginPage.getLogo().shouldBe(visible);
        loginPage.logoImageIsCorrect();
        //loginPage.getLinkedInIcon().shouldBe(visible);
        loginPage.linkedInIconIsDisplayed();
        loginPage.facebookIconIsDisplayed();
        loginPage.twitterIconIsDisplayed();
        loginPage.youTubeIconIsDisplayed();
    }



    @Test
   public void linksAreValid() {
        loginPage.followLinkedInLink();
        switchTo().window(1);
       // linkedInPage.linkedInLinkIsCorrect();
        linkedLinkDialog.isLinkedInElementAppear();
        closeWindow();
//        loginPage.returnToLogin();
//
//        loginPage.followFacebookLink();
//        switchToTab(2);
//        facebookPage.facebookLinkIsCorrect();
//        loginPage.returnToLogin();
//
//        loginPage.followTwitterLink();
//        switchTo().window(3);
//        twitterPage.twitterLinkIsCorrect();
//        loginPage.returnToLogin();
//
//        loginPage.followYouTubeLink();
//        switchTo().window(4);
//        youTubePage.youTubeLinkIsCorrect();
//        loginPage.returnToLogin();

    }
}


