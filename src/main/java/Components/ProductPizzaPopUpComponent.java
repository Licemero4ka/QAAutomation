package Components;

import Elements.AddToPizza;
import Elements.ToggleElement;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class ProductPizzaPopUpComponent {
    private SelenideElement title;
    private SelenideElement info;
    private SelenideElement rating;
    private SelenideElement coments;
    private SelenideElement size30;
    private SelenideElement size35;
    private SelenideElement pizzaBoardStandart;
    private SelenideElement pizzaBoardFiladelphia;
    private SelenideElement weight;
    private SelenideElement quantity;
    private SelenideElement buttonPlus;
    private SelenideElement buttonMinus;
    private SelenideElement buttonOrder;
    private static SelenideElement close;

    private List<SelenideElement> pizzaOptions;
    private List<SelenideElement> addToPizza;
    private List<SelenideElement> pizzaRadioButton;


    public ProductPizzaPopUpComponent() {
        this.title = $x("//*[@class='nts-modal__title nts-modal__title-pr']");
        this.info = $x("//*[@class='nts-modal__title-info']");
        this.rating = $x("");
        this.coments = $x("//*[@class='nts-modal__reviews-count nts-modal__feedback-link js-open-feedback']");
        this.pizzaOptions = $$x("//*[@class='nts-modal__modifier']");
        this.weight = $x("//*[@class='nts-modal__info-weight']");
        this.quantity = $x("//*[@id='count_product']");
        this.buttonPlus = $x("//*[@class='nts-button-plus']");
        this.buttonMinus = $x("//*[@class='nts-button-minus']");
        this.buttonOrder = $x("//*[@class='nts-button-red js_add_to_cart']");
        this.addToPizza = $$x("//*[contains(@class, 'js-options-list')]");
        close = $x("//*[@class='nts-modal__close']");

    }

    public ToggleElement getPizzaRadioButton(String title) {
        List<ToggleElement> buttons = new ArrayList<>();
        this.pizzaRadioButton = $$x("//*[@class='nts-modal__modifier']");
        for (SelenideElement button : pizzaRadioButton) {
            buttons.add((ToggleElement) button);
        }
        return buttons.stream().filter(button -> button.getTitle().equals(title)).findFirst().get();

    }

    @Step("Get add to pizza element")
    public AddToPizza getAddToPizzaElement(int index) {
        addToPizza.get(index).click();
        return new AddToPizza();
    }

    @Step("Click order button")
    public void clickOrderButton() {
        buttonOrder.click();
    }

    @Step("Click plus button")
    public ProductPizzaPopUpComponent clickPlusButton() {
        buttonPlus.click();
        return this;
    }

    @Step("Click")
    public static void clickCloseButton() {
        close.click();
    }
}

