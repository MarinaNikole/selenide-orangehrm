import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.className;

public class LoginPage {

    private SelenideElement usernameField = $(By.name("username"));

    private SelenideElement passwordField = $("[placeholder='Password']");

    private SelenideElement loginButton= $(By.tagName("button"));

    private SelenideElement invalidCredentials = $("[class=\"oxd-text oxd-text--p oxd-alert-content-text\"]");
    private SelenideElement forgotPasswordLink = $(className("orangehrm-login-forgot-header"));

    private SelenideElement logo = $(byAttribute("alt", "company-branding"));


    private SelenideElement linkedInIcon =$x("//a[contains(@href, 'linkedin')]");
    private SelenideElement facebookIcon =$x("//a[contains(@href, 'facebook')]");
    private SelenideElement twitterIcon =$x("//a[contains(@href, 'twitter')]");

    private SelenideElement youTubeIcon =$x("//a[contains(@href, 'youtube')]");


    public SelenideElement getLinkedInIcon() {
        return linkedInIcon;
    }

    public SelenideElement getFacebookIcon() {
        return facebookIcon;
    }

    public SelenideElement getTwitterIcon() {
        return twitterIcon;
    }

    public SelenideElement getYouTubeIcon() {
        return youTubeIcon;
    }

    public SelenideElement getLogo() {
        return logo;
    }


      @Step("Enter username of login page")
    public void enterUserName(String usernameValue) {
        usernameField.shouldBe(visible, ofSeconds(10)).setValue(usernameValue);

    }

@Step("Enter user password")
    public void enterPassword(String passwordValue){
        passwordField.setValue(passwordValue);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void invalidCredentialIsDisplayed(String message){
        invalidCredentials.shouldBe(visible).shouldHave(text(message));
    }

    public void clickForgotPasswordButton(){
        forgotPasswordLink.click();
    }

    public SelenideElement getInvalidCredentials() {
        return invalidCredentials;
    }

    public void logoImageIsCorrect () {
        logo.shouldHave(attributeMatching("src", ".*branding.png.*"));
    }

    public void logoIsDisplayed(){
        logo.shouldBe(visible);
    }

    public void linkedInIconIsDisplayed(){
        linkedInIcon.shouldBe(visible);
    }

    public void facebookIconIsDisplayed(){
        facebookIcon.shouldBe(visible);
    }

    public void twitterIconIsDisplayed(){
        twitterIcon.shouldBe(visible);
    }

    public void youTubeIconIsDisplayed(){
        youTubeIcon.shouldBe(visible);
    }

    public void followLinkedInLink(){
        linkedInIcon.click();
    }

    public void followFacebookLink(){
        facebookIcon.click();
    }

    public void followTwitterLink(){
        twitterIcon.click();
    }

    public void followYouTubeLink(){
        youTubeIcon.click();
    }


    public void returnToLogin(){
        switchTo().window(0);
        logo.shouldBe(visible);
    }
}
