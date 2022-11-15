package starter.ui;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.ui.steps.Steps;

@RunWith(SerenityRunner.class)
public class Tests {

    @net.thucydides.core.annotations.Steps
    Steps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void addToCartTest() {
        steps.openPage();
        steps.enterUsername("standard_user");
        steps.enterPassword("secret_sauce");
        steps.clickOnLoginButton();
        steps.checkThatShoppingCartIsEmpty();
        steps.clickOnAddToCartButton();
        steps.checkAmountOfItemsInTheCart("1");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
