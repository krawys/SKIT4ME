//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class HomePage extends BasePage {
//    private final By addToCartBtn = By.xpath("(//span[contains(text(),'Add to Basket')])[1]");
//    private final By cartButton = By.cssSelector("button[aria-label='Show the shopping cart']");
//
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }
//
//    public void addFirstProductToCart() {
//        click(addToCartBtn);
//    }
//
//    public void goToCart() {
//        click(cartButton);
//    }
//}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//public class HomePage {
//    WebDriver driver;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void dismissWelcomeBanner() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Dismiss')]"))).click();
//    }

    public class HomePage {
        private final WebDriver driver;
        private final WebDriverWait wait;

        // Updated constructor to accept both driver and wait
        public HomePage(WebDriver driver, WebDriverWait wait) {  // Add wait parameter
            this.driver = driver;
            this.wait = wait;
        }

        public void dismissWelcomeBanner() {
            // Implementation using both driver and wait
            driver.findElement(By.cssSelector(".close-dialog")).click();
        }


    public void addFirstItemToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Add to Basket']")));
        driver.findElements(By.cssSelector("button[aria-label='Add to Basket']")).get(0).click();
    }

//    public void dismissWelcomeBanner() {
//        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
//    }

    public void navigateToShop() {
        driver.findElement(By.cssSelector("button[aria-label='Dismiss Welcome Banner']")).click();
    }
}