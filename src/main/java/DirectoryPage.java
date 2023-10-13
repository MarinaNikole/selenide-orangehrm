import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DirectoryPage {
private ElementsCollection listOfPeopleNames = $$(By.cssSelector("[class=\"oxd-text oxd-text--p orangehrm-directory-card-header --break-words\"]"));
private ElementsCollection listOfProfilePictures = $$(By.cssSelector("[alt=\"Profile Picture\"]"));
private SelenideElement directoryLink = $(By.cssSelector("[class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]"));

    public ElementsCollection getListOfPeopleNames() {
        return listOfPeopleNames;
    }

    public ElementsCollection getListOfProfilePictures() {
        return listOfProfilePictures;
    }

    public SelenideElement getDirectoryLink() {
        return directoryLink;
    }

    public  void clickFollowDirectoryLink() {
    directoryLink.click();
 }

 public void isListOfNamesVisible(){
    for(SelenideElement name: listOfPeopleNames){
        name.shouldBe(visible);
    }
 }
    public void isListOfProfilePictureVisible(){
        for(SelenideElement name: listOfProfilePictures){
            name.shouldBe(visible);
        }
    }


}
