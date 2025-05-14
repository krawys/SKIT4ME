package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private final By addToCartButton = By.cssSelector("button[aria-label='Add to Basket']");
    private final By cartBadge = By.cssSelector(".mat-badge");

    public void addFirstItemToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton))
                .click();

        // Wait for cart badge update
        wait.until(d -> !driver.findElement(cartBadge).getText().isEmpty());
    }
}

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class ProductPage {
//    WebDriver driver;
//
//    public ProductPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void addFirstItemToCart() {
//        driver.findElements(By.cssSelector("mat-card button[aria-label='Add to Basket']")).get(0).click();
//    }
//
//    public void openCart() {
//        driver.findElement(By.cssSelector("button[routerlink='/basket']")).click();
//    }
//}

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//public class ProductPage {
//    WebDriver driver;
//
//    public ProductPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void addFirstItemToCart() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        By addToBasketButton = By.cssSelector("button[aria-label='Add to Basket']");
//
//        // Wait until at least one 'Add to Basket' button is visible
//        wait.until(ExpectedConditions.visibilityOfElementLocated(addToBasketButton));
//
//        // Find all 'Add to Basket' buttons
//        List<WebElement> addButtons = driver.findElements(addToBasketButton);
//
//        // Check if the list is not empty before clicking
//        if (!addButtons.isEmpty()) {
//            addButtons.get(0).click();
//        } else {
//            throw new RuntimeException("No 'Add to Basket' buttons found on the page.");
//        }
//    }
//}