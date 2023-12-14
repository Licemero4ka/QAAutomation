package Objects;

import Components.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomePage extends BasePage {
    @Step("Get Navigation Block Components")
    public NavigationBlockComponent getNavigationBlockComponents() {
        return new NavigationBlockComponent();
    }

    @Step("Go to https://ricco.kh.ua/ ")
    public HomePage goTo() {
        open("https://ricco.kh.ua/");
        return this;
    }

    @Step("Get product Component")
    public ProductComponent getProductComponent(int index, int index2) {
        return new ProductComponent($x(format("//div[@class='nts-products__wrapper'][%s]//div[@class='nts-products__item'][%s]", index, index2)));
    }

}