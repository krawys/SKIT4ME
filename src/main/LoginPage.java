package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By accountButton = By.id("navbarAccount");
    private final By loginButton = By.id("navbarLoginButton");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginSubmit = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(accountButton);
        click(loginButton);
        type(emailInput, email);
        type(passwordInput, password);
        click(loginSubmit);
    }
}