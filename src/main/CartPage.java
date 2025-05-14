package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By cartItem = By.cssSelector(".mat-row");
    private final By removeButton = By.cssSelector("mat-icon[aria-label='Remove item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInCart() {
        return isVisible(cartItem);
    }

    public void removeItem() {
        click(removeButton);
    }
}