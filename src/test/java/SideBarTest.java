import io.qameta.allure.Feature;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class SideBarTest extends BaseTest {
    String usernameValue = "Admin";
    String passwordValue = "admin123";

    String admin = "Admin";
    String pim = "PIM";
    String leave = "Leave";
    String time = "Time";
    String recruitment = "Recruitment";
    String myInfo = "My Info";
    String performance = "Performance";
    String dashboard = "Dashboard";
    String directory = "Directory";
    String maintenance = "Maintenance";
    String claim = "Claim";
    String buzz = "Buzz";


    @Test @Feature("Side Bar") @Category(Smoke.class)
    public void allLinksAreDisplayed(){
//        List<String> sideBarList = new ArrayList<>();
//        sideBarList.add("Admin");
//        sideBarList.add("PIM");
//        sideBarList.add("Leave");
//        sideBarList.add("Time");
//        sideBarList.add("Recruitment");
//        sideBarList.add("My Info");
//        sideBarList.add("Performance");
//        sideBarList.add("Dashboard");
//        sideBarList.add("Directory");
//        sideBarList.add("Maintenance");
//        sideBarList.add("Claim");
//        sideBarList.add("Buzz");

        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();
       // sideBar.sideBarLinksAreVisible(sideBarList );
        sideBar.adminIsVisible(admin);
        sideBar.pimIsVisible(pim);
        sideBar.leaveIsVisible(leave);
        sideBar.timeIsVisible(time);
        sideBar.recruitmentIsVisible(recruitment);
        sideBar.myInfoIsVisible(myInfo);
        sideBar.performanceIsVisible(performance);
        sideBar.dashboardIsVisible(dashboard);
        sideBar.directoryIsVisible(directory);
        sideBar.maintenanceIsVisible(maintenance);
        sideBar.claimIsVisible(claim);
        sideBar.buzzIsVisible(buzz);
    }

    @Test
    public void sideBarRolledOut(){
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

     //   sideBar.sideBarCheck();  // один из вариантов проверки
        sideBar.checkExpandedSideBarPicture();
        sideBar.allIconsAreDisplayed();
        sideBar.clickSideBarArrow();
        sideBar.checkCollapsedSideBarPicture();
        sideBar.allIconsAreDisplayed();
    }



    @Test
    public void sideBarRolledOut2(){
      List<String> sideBarList = new ArrayList<>();
        sideBarList.add("Admin");
        sideBarList.add("PIM");
        sideBarList.add("Leave");
        sideBarList.add("Time");
        sideBarList.add("Recruitment");
        sideBarList.add("My Info");
        sideBarList.add("Performance");
        sideBarList.add("Dashboard");
        sideBarList.add("Directory");
        sideBarList.add("Maintenance");
        sideBarList.add("Claim");
        sideBarList.add("Buzz");

        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.isTextToggled(sideBarList);
    }

    @Test
    public void searchTestUpperCase(){
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.searchExactLink("Admin");
        sideBar.afterSearchShouldHaveNumberLink(1);
        sideBar.afterSearchShouldHaveText("Admin");

    }

    @Test
    public void searchTestWithLowCase(){
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.searchExactLink("admin");
        sideBar.afterSearchShouldHaveNumberLink(1);
        sideBar.afterSearchShouldHaveText("Admin");

    }

    @Test
    public void searchTestWithInvalidParameters(){
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.searchExactLink("summer");
        sideBar.searchResultIsEmpty();
        sideBar.afterSearchShouldHaveNumberLink(0);
    }

    @Test
    public void searchEmptyInput(){
        List<String> sideBarList = new ArrayList<>();
        sideBarList.add("Admin");
        sideBarList.add("PIM");
        sideBarList.add("Leave");
        sideBarList.add("Time");
        sideBarList.add("Recruitment");
        sideBarList.add("My Info");
        sideBarList.add("Performance");
        sideBarList.add("Dashboard");
        sideBarList.add("Directory");
        sideBarList.add("Maintenance");
        sideBarList.add("Claim");
        sideBarList.add("Buzz");

        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.emptyInput();
        sideBar.sideBarLinksAreVisible(sideBarList);

    }

    @Test
    public void searchByPartText_d(){
        List<String> sideBarList = new ArrayList<>();
        sideBarList.add("Admin");
        sideBarList.add("Dashboard");
        sideBarList.add("Directory");

        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.searchExactLink("d");
        sideBar.sideBarLinksAreVisible(sideBarList);
        sideBar.afterSearchShouldHaveNumberLink(3);

    }

    @Test
    public void searchByPartText_re(){
        List<String> sideBarList = new ArrayList<>();
        sideBarList.add("Recruitment");
        sideBarList.add("Directory");

        String query = "re";

        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);
        sideBar.searchLinkIsVisible();

        sideBar.searchExactLink(query);
        sideBar.sideBarLinksAreVisible(sideBarList); // проверяет коллекцию ссылок после поиска
        sideBar.checkAllLinksHasText(query); // проверяет, содержится ли в ссылках комбинация "re" (дополнительная проверка)
        sideBar.afterSearchShouldHaveNumberLink(2);
    }


}