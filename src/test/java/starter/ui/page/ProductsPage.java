package starter.ui.page;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class ProductsPage extends PageObject{

    private By shoppingCartItemsBadge = By.className("shopping_cart_badge");
    private By products = By.className("inventory_item");
    private By firstAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");


    private By loginButton = By.id("login-button");

    public ProductsPage checkThatShoppingCartIsEmpty() {
        find(shoppingCartItemsBadge).shouldNotBeEnabled();
        return this;
    }

    public ProductsPage checkThatAddToCartIsDisplayed(String button) {
        find(products).containsText(button);
        return this;
    }

    public ProductsPage clickOnFirstProduct() {
        findAll(products).get(0).find(firstAddToCartButton).click();
        return this;
    }

    public ProductsPage checkAmountOfItemsInTheCart(String items) {
        find(shoppingCartItemsBadge).containsText(items);
        return this;
    }
}
