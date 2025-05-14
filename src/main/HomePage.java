package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By addToCartBtn = By.xpath("(//span[contains(text(),'Add to Basket')])[1]");
    private final By cartButton = By.cssSelector("button[aria-label='Show the shopping cart']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToCart() {
        click(addToCartBtn);
    }

    public void goToCart() {
        click(cartButton);
    }
}