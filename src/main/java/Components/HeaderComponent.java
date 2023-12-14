package Components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderComponent {


    private SelenideElement logo;
    private SelenideElement basket;
    private SelenideElement ru;
    private SelenideElement ua;
    private SelenideElement basketDropdown;
    private SelenideElement basketQuantity;


    public HeaderComponent() {
        this.basket = $x("//*[@class='info_cart nts-header__basket js-info_cart']");
        this.logo = $x("");
        this.ru = $x("//a[@href='https://ricco.kh.ua/locale/ru' and @class='']");
        this.ua = $x("//a[@href='https://ricco.kh.ua/locale/ua' and @class='']");
        this.basketDropdown = $x("//div[@class='header__cart-dropdown header__cart-box']");
        this.basketQuantity = $x("//*[@class='nts-header__basket-inner js-header-count']//span[1]");
    }

    @Step("Get basket quantity")
    public String getBasketQuantity() {
        return basketQuantity.getText();
    }

    @Step("Click basket")
    public HeaderComponent clickBasket() {
        basket.click();
        return new HeaderComponent();
    }


}
