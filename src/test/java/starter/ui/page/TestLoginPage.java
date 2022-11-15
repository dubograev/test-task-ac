package starter.ui.page;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/")
public class TestLoginPage extends PageObject {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public TestLoginPage enterUsername(String username) {
        find(usernameField).sendKeys(username);
        return this;
    }

    public TestLoginPage enterPassword(String password) {
        find(passwordField).sendKeys(password);
        return this;
    }

    public TestLoginPage clickLoginButton() {
        find(loginButton).click();
        return this;
    }
}
