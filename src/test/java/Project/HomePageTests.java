package Project;

import Components.*;
import Objects.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.String.format;

public class HomePageTests extends BaseTest {

    @Test
    @Description("Check navigation block buttons")
    public void verifyNavigationBlock() {
        SoftAssert softAssert = new SoftAssert();

        NavigationBlockComponent navigationBlock = new HomePage().goTo().getNavigationBlockComponents();
        navigationBlock.getNavigationButtons();

        String promotionsCategoryText = navigationBlock.getFoodNameText(0);
        String comboCategoryText = navigationBlock.getFoodNameText(2);

        softAssert.assertEquals(promotionsCategoryText, "Акції", format("Expected 'Акції', but was %s", promotionsCategoryText));
        softAssert.assertEquals(comboCategoryText, "Комбо", format("Expected 'Комбо', but was %s", comboCategoryText));

        softAssert.assertAll();
    }

    @Test
    @Description("Get pizza component details on the homepage")
    public void verifyPizzaComponent() {
        HomePage homePage = new HomePage().goTo();
        ProductComponent pizzaComponent = homePage.getProductComponent(1, 13);

        String pizzaProductName = pizzaComponent.getProductName();
        String pizzaProductDescription = pizzaComponent.getProductDescription();
        String pizzaProductOrder = pizzaComponent.getProductOrder();
        String pizzaProductPrice = pizzaComponent.getProductPrice();

        System.out.println("Product Name: " + pizzaProductName);
        System.out.println("Product Description: " + pizzaProductDescription);
        System.out.println("Product Order: " + pizzaProductOrder);
        System.out.println("Product Price: " + pizzaProductPrice);
    }

    @Test
    @Description("Verify Pizza Pop Up Component")
    public void verifyPizzaPopUpComponent() {
        HomePage homePage = new HomePage().goTo();
        ProductComponent pizzaPopUpComponent = homePage.getProductComponent(1, 13);
        String additionalPizzaTitle = homePage
                .getProductComponent(1, 13)
                .getProductPizzaPopUpComponent()
                .getAddToPizzaElement(1)
                .getAddToPizzaTitle();
        System.out.println(additionalPizzaTitle);

        ProductPizzaPopUpComponent.clickCloseButton();
    }

    @Test
    @Description("Add pizza to the basket and verify basket quantity")
    public void addPizzaToBasket() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage().goTo();
        String expectedProductTextForPizza = "1";

        homePage
                .getProductComponent(1, 1)
                .getProductPizzaPopUpComponent()
                .clickOrderButton();

        String basketQuantity = new HeaderComponent().clickBasket().getBasketQuantity();
        softAssert.assertEquals(basketQuantity, expectedProductTextForPizza, "Product not added to basket");

        softAssert.assertAll();
    }

    @Test
    @Description("Check if the user can add multiple quantity product in the basket")
    public void verifyMultipleQuantityInBasket() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage().goTo();
        String expectedProductTextForMultiplePizza = "2";

        homePage
                .getProductComponent(1, 1)
                .getProductPizzaPopUpComponent()
                .clickPlusButton()
                .clickOrderButton();

        String basketMultipleQuantity = new HeaderComponent()
                .clickBasket()
                .getBasketQuantity();
        softAssert.assertEquals(basketMultipleQuantity, expectedProductTextForMultiplePizza, "Products not added to basket");

        softAssert.assertAll();
    }

    @Test
    @Description("Verify deletion of a product from the basket")
    public void verifyDeleteItemInBasket() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage().goTo();

        // Add a product to the basket
        homePage
                .getProductComponent(1, 1)
                .getProductPizzaPopUpComponent()
                .clickOrderButton();

        // Check if the product is added to the basket
        String initialBasketQuantity = new HeaderComponent()
                .clickBasket()
                .getBasketQuantity();

        softAssert.assertNotEquals(initialBasketQuantity, "0", "Product not added to basket");

        // Remove the added product from the basket
        new BasketPopUpComponent().removeItem();

        // Check if the product is deleted from the basket
        String finalBasketQuantity = new HeaderComponent()
                .clickBasket()
                .getBasketQuantity();

        softAssert.assertEquals(finalBasketQuantity, "0", "The product was not removed from the basket  ");

        softAssert.assertAll();
    }
     @Test
    @Description("Verify Product Added To Cart")
    public void verifyProductAddedToCart() {

        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage().goTo();


        int productIndex = 1;
        int pizzaIndex = 1;

        ProductComponent selectedProduct = homePage.getProductComponent(productIndex, pizzaIndex);
        String productName = selectedProduct.getProductName();


        selectedProduct.getProductPizzaPopUpComponent().clickOrderButton();


        BasketPopUpComponent basketPopUpComponent = new BasketPopUpComponent();


        boolean isProductAdded = basketPopUpComponent.isProductInBasket(productName);

        softAssert.assertTrue(isProductAdded, "Product not added to the cart");

        softAssert.assertAll();
    }

}

