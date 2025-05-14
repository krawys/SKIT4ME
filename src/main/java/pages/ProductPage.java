package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstItemToCart() {
        driver.findElements(By.cssSelector("mat-card button[aria-label='Add to Basket']")).get(0).click();
    }

    public void openCart() {
        driver.findElement(By.cssSelector("button[routerlink='/basket']")).click();
    }
}