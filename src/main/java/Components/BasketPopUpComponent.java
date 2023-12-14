package Components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPopUpComponent {
    private List<SelenideElement> basketItems;
    private SelenideElement basketCloseButton;
    private SelenideElement removeItem;

    public BasketPopUpComponent() {
        this.basketItems = $$x("//*[@class='header__cart-list']");
        this.basketCloseButton = $x("//*[@class='header__cart-dd-top-close']");
        this.removeItem = $x("//*[@class='remove-item remove-item-product']");
    }

    @Step("Get basket size")
    public int getbasketItems() {
        return basketItems.size();
    }

    @Step("Verify if product is in basket")
    public boolean isProductInBasket(String productName) {
        for (SelenideElement basketItem : basketItems) {
            if (basketItem.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    @Step("Close basket")
    public BasketPopUpComponent closeBasket() {
        basketCloseButton.click();
        return this;
    }

    @Step("Remove-item from basket")
    public BasketPopUpComponent removeItem() {
        removeItem.click();
        return this;
    }
}
