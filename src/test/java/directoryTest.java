import com.codeborne.selenide.CollectionCondition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;

public class directoryTest extends BaseTest{

    String usernameValue = "Admin";
    String passwordValue = "admin123";
    String directory = "Directory";


    @Test

    public void directoryProfilesTest(){
        loginPage.enterUserName(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickLoginButton();
        headerSection.getUserDropdownTab().shouldBe(visible);

        sideBar.searchLinkIsVisible();
        sideBar.searchExactLink(directory);

        directoryPage.clickFollowDirectoryLink();
        directoryPage.isListOfNamesVisible();
        directoryPage.isListOfProfilePictureVisible();


    }
}
