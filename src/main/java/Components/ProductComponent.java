package Components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ProductComponent {
    private SelenideElement title;
    private SelenideElement description;
    private SelenideElement price;
    private SelenideElement order;
    private SelenideElement productComponent;


    public ProductComponent(SelenideElement element) {
        this.title = element.$x(".//div[@class='nts-product__name']");
        this.description = element.$x(".//div[@class='nts-product__description']");
        this.order = element.$x(".//span[@class='nts-button-red']");
        this.price = element.$x(".//div[@class='nts-product__price']");
        this.productComponent = element;
    }

    @Step("Get product mame")
    public String getProductName() {
        return this.title.text();
    }

    @Step("Get product description")
    public String getProductDescription() {
        return this.description.text();
    }

    @Step("Get product order")
    public String getProductOrder() {
        return this.order.text();
    }

    @Step("Get product price")
    public String getProductPrice() {
        return this.price.text();
    }

    @Step("Click")
    public void click() {
    }

    @Step("Get product pizza pop up component")
    public ProductPizzaPopUpComponent getProductPizzaPopUpComponent() {
        productComponent.click();
        return new ProductPizzaPopUpComponent();
    }

}
