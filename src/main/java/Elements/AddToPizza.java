package Elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class AddToPizza {
    private List<SelenideElement> title;

    public AddToPizza() {
        this.title = $$x("//*[@class='nts-modal__options js-nts-modal__options group-modificator is-active']/child::*[@class='nts-modal__option-outer']");
    }

    @Step("Get add to pizza title")
    public String getAddToPizzaTitle() {
        String result = "";
        for (SelenideElement element : title) {
            result += element.text() + " ";
        }
        return result;
    }


}
