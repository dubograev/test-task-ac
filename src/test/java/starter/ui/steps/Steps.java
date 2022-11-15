package starter.ui.steps;

import net.thucydides.core.annotations.Step;
import starter.ui.page.ProductsPage;
import starter.ui.page.TestLoginPage;

public class Steps {

    TestLoginPage testLoginPage;
    ProductsPage productsPage;

    @Step("Open main page")
    public void openPage() {
        testLoginPage.open();
    }

    @Step("Enter username")
    public void enterUsername(String username) {
        testLoginPage.enterUsername(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        testLoginPage.enterPassword(password);
    }

    @Step("Click on Login button")
    public void clickOnLoginButton() {
        testLoginPage.clickLoginButton();
    }

    @Step("Check that shopping cart is empty")
    public void checkThatShoppingCartIsEmpty() {
        productsPage.checkThatShoppingCartIsEmpty();
    }

    @Step("Click on Add to Cart button")
    public void clickOnAddToCartButton() {
        productsPage.clickOnFirstProduct();
    }

    @Step("Check that there are {items} items in the shopping cart")
    public void checkAmountOfItemsInTheCart(String items){
        productsPage.checkAmountOfItemsInTheCart(items);
    }
}
