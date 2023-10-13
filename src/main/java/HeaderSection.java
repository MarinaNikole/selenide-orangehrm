import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class HeaderSection {
    private SelenideElement userDropdownTab = $(className("oxd-userdropdown-tab"));

//    private void setUserDropdownTabIsDisplayed(){
//        userDropdownTab.shouldBe(visible);
//    }

    public SelenideElement getUserDropdownTab() {
        return userDropdownTab;
    }


}
