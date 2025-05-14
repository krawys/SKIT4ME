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

//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class CartPage {
//    WebDriver driver;
//
//    public CartPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public String getQuantity() {
//        return driver.findElement(By.cssSelector("input[name='quantity']")).getAttribute("value");
//    }
//
//    public void removeItem() {
//        driver.findElement(By.cssSelector("button[aria-label='Remove']")).click();
//    }
//}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartItems = By.cssSelector(".mat-row");
    private final By removeButtons = By.cssSelector("[aria-label='Remove item']");
    private final By cartBadge = By.cssSelector(".mat-badge");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openCart() {
        driver.findElement(By.cssSelector("[aria-label='Show the shopping cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeFirstItem() {
        List<WebElement> items = driver.findElements(removeButtons);
        if (!items.isEmpty()) {
            items.get(0).click();
            wait.until(d -> driver.findElements(cartItems).size() == 0);
        }
    }
    public void removeItem(String itemName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'" + itemName + "')]/../button")
        )).click();
    }

    public int getCartCount() {
    }
}