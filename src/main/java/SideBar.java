import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SideBar {

    private ElementsCollection hrmPictures = $$(By.cssSelector("[alt*=\"client brand\"]"));
    private ElementsCollection sideBarTextElements = $$(By.cssSelector("[class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]"));
    private ElementsCollection sideBarIconElements = $$(By.cssSelector("[class=\"oxd-icon oxd-main-menu-item--icon\"]"));
    private SelenideElement adminLink = $(By.cssSelector("[href*=\"admin/viewAdminModule\"]"));
    private SelenideElement PIMLink = $(By.cssSelector("[href*=\"php/pim/viewPimModule\"]"));
    private SelenideElement leave =$(By.cssSelector("[href*=\"leave/viewLeaveModule\"]"));
    private SelenideElement time =$(By.cssSelector("[href*=\"time/viewTimeModule\"]"));
    private SelenideElement recruitment = $(By.cssSelector("[href*=\"recruitment/viewRecruitmentModule\"]"));
    private SelenideElement myInfo = $(By.cssSelector("[href*=\"pim/viewMyDetails\"]"));
    private SelenideElement performance = $(By.cssSelector("[href*=\"performance/viewPerformanceModule\"]"));
    private SelenideElement dashboard =$(By.cssSelector("[href*=\"dashboard/index\"]"));
    private SelenideElement directory =$(By.cssSelector("[href*=\"directory/viewDirectory\"]"));
    private SelenideElement maintenance = $(By.cssSelector("[href*=\"maintenance/viewMaintenanceModule\"]"));
    private SelenideElement claim = $(By.cssSelector("[href*=\"claim/viewClaimModule\"]"));
    private SelenideElement buzz = $(By.cssSelector("[href*=\"buzz/viewBuzz\"]"));
    private SelenideElement searchLink = $(By.cssSelector("[class=\"oxd-input oxd-input--active\"]"));

    private SelenideElement sideBarArrowButton = $(By.cssSelector("[class=\"oxd-icon-button oxd-main-menu-button\"]"));
    private SelenideElement sideBarToggled = $(By.cssSelector("[class=\"oxd-input oxd-input--active toggled\"]"));
    private SelenideElement sideBarWithLogo = $(By.cssSelector("[src*='orangehrm-logo']"));
    private SelenideElement sideBarWithoutLogo = $(By.cssSelector("[src*='images/orange']"));
    private SelenideElement sideBarElement = $(By.className("oxd-sidepanel"));

    public void allIconsAreDisplayed(){
        for (SelenideElement icon : sideBarIconElements){
            icon.shouldBe(visible);
        }
    }

    public void checkExpandedSideBarPicture(){
        SelenideElement visiblePicture = hrmPictures.filter(visible).get(0);
        visiblePicture.shouldHave
                (attributeMatching("src", ".*orangehrm-logo.png.*"));
    }

    public void checkCollapsedSideBarPicture(){
        SelenideElement visiblePicture = hrmPictures.filter(visible).get(0);
        visiblePicture.shouldHave
                (attributeMatching("src", ".*orange.png.*"));
    }

    public void isTextToggled(List<String> expectedList){
        sideBarTextElements.shouldBe(CollectionCondition.texts(expectedList));
        sideBarIconElements.shouldHave(CollectionCondition.size(12));
        sideBarArrowButton.click();
        sideBarTextElements.isEmpty();
        sideBarArrowButton.click();
        sideBarIconElements.shouldHave(CollectionCondition.size(12));
        sideBarTextElements.shouldBe(CollectionCondition.texts(expectedList));

    }
public void sideBarCheck(){
    sideBarWithLogo.shouldBe(visible);
    sideBarArrowButton.click();
    sideBarWithoutLogo.shouldBe(visible);
    sideBarElement.shouldHave(attributeMatching("class", ".*toggled.*"));
    sideBarArrowButton.click();
    sideBarWithLogo.shouldBe(visible);

}



public void adminIsVisible(String text){
    adminLink.shouldBe(visible).shouldHave(text(text));
}
    public void pimIsVisible(String text){
        PIMLink.shouldBe(visible).shouldHave(text(text));
    }
    public void leaveIsVisible(String text){
        leave.shouldBe(visible).shouldHave(text(text));
    }
    public void timeIsVisible(String text){
        time.shouldBe(visible).shouldHave(text(text));
    }
    public void recruitmentIsVisible(String text){
        recruitment.shouldBe(visible).shouldHave(text(text));
    }
    public void myInfoIsVisible(String text){
        myInfo.shouldBe(visible).shouldHave(text(text));
    }
    public void performanceIsVisible(String text){
        performance.shouldBe(visible).shouldHave(text(text));
    }
    public void dashboardIsVisible(String text){
        dashboard.shouldBe(visible).shouldHave(text(text));
    }
    public void directoryIsVisible(String text){
        directory.shouldBe(visible).shouldHave(text(text));
    }
    public void maintenanceIsVisible(String text){
        maintenance.shouldBe(visible).shouldHave(text(text));
    }
    public void claimIsVisible(String text){
        claim.shouldBe(visible).shouldHave(text(text));
    }
    public void buzzIsVisible(String text){
        buzz.shouldBe(visible).shouldHave(text(text));
    }




    public void sideBarLinksAreVisible(List<String> expectedList){
        sideBarTextElements.shouldBe(CollectionCondition.containExactTextsCaseSensitive(expectedList));
    }

    public void searchLinkIsVisible(){
        searchLink.shouldBe(visible);
    }

    public void linkPr(){
    sideBarTextElements.shouldHave(CollectionCondition.texts());
    }


    public void searchExactLink(String expectedText){
    searchLink.setValue(expectedText);
    }

    public void afterSearchShouldHaveText(String expectedText){
    sideBarTextElements.shouldHave(CollectionCondition.texts(expectedText));
    }

    public void afterSearchShouldHaveNumberLink(int  expectedLinksQuantity){
      sideBarTextElements.shouldHave(CollectionCondition.size(expectedLinksQuantity));
    }

    public void searchIsEmpty(){
        for(SelenideElement element: sideBarTextElements){
            element.shouldNotBe(visible);
        }
    }

    public void emptyInput(){
        searchLink.click();
    }

}

/*
public void enterValueToSearchInput(String query){
        searchInputField.setValue(query);
    }


    public void checkLinksQuantity(int expectedLinksQuantity){
        availableLinks.filter(visible).shouldHave(size(expectedLinksQuantity));
    }
public void checkLinkHasText(String expectedText){
        availableLinks.filter(visible).get(0).shouldHave(exactText(expectedText));
    }

    sideBar.enterValueToSearchInput(queryValue);
        sideBar.checkLinksQuantity(1);
        sideBar.checkLinkHasText(queryValue);

        public void checkAllLinksHasText(String expectedPartText){
        for (SelenideElement link: availableLinks.filter(visible)) {
            link.shouldHave(text(expectedPartText));
        }
    }
 */
