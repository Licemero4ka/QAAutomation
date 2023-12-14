package Components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class NavigationBlockComponent {

    private List<SelenideElement> navigationButtons;
    private SelenideElement volontureActivity;

    public NavigationBlockComponent() {
        this.volontureActivity = $x("//a[@class='nts-button-outline-red']");
    }

    @Step("Get foodName text")
    public String getFoodNameText(int index) {
        return navigationButtons
                .get(index)
                .text();
    }

    @Step("Get navigation buttons")
    public void getNavigationButtons() {
        navigationButtons = $$x("//ul[@class='nts-navigation__menu']//a");
    }

    @Step("Get volonture activity Text")
    public String getVolontureActivityText() {
        return volontureActivity.text();
    }
}
