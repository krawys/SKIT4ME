package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import main.CartPage;
import main.HomePage;
import main.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartTests {

    private WebDriver driver;
    private final String baseUrl = "https://juice-shop.herokuapp.com/#/";

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    @Order(1)
    void testAddToCart() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        login.login("admin@juice-sh.op", "admin123");
        Thread.sleep(2000);

        home.addFirstProductToCart();
        home.goToCart();

        assertTrue(cart.isItemInCart(), "Item should be visible in the cart.");
    }

    @Test
    @Order(2)
    void testRemoveFromCart() {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        // Consider moving credentials to configuration
        login.login("admin@juice-sh.op", "admin123");

        home.addFirstProductToCart();
        home.goToCart();

        assertTrue(cart.isItemInCart(), "Item should be added to cart");

        cart.removeItem();
        assertFalse(cart.isItemInCart(), "Item should be removed from cart");
    }

//    @Test
//    @Order(2)
//    void testRemoveFromCart() throws InterruptedException {
//        LoginPage login = new LoginPage(driver);
//        HomePage home = new HomePage(driver);
//        CartPage cart = new CartPage(driver);
//
//        login.login("admin@juice-sh.op", "admin123");
//        Thread.sleep(2000);
//
//        home.addFirstProductToCart();
//        home.goToCart();
//
//        assertTrue(cart.isItemInCart(), "Item should be added.");
//
//        cart.removeItem();
//        Thread.sleep(1000);
//    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
