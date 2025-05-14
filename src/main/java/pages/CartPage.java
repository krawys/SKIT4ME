//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class CartPage extends BasePage {
//    private final By cartItem = By.cssSelector(".mat-row");
//    private final By removeButton = By.cssSelector("mat-icon[aria-label='Remove item']");
//
//    public CartPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public boolean isItemInCart() {
//        return isVisible(cartItem);
//    }
//
//    public void removeItem() {
//        click(removeButton);
//    }
//}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getQuantity() {
        return driver.findElement(By.cssSelector("input[name='quantity']")).getAttribute("value");
    }

    public void removeItem() {
        driver.findElement(By.cssSelector("button[aria-label='Remove']")).click();
    }
}