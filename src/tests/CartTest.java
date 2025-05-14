package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartTest {
    WebDriver driver;
    HomePage home;
    ProductPage product;
    CartPage cart;

    @BeforeAll
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://juice-shop.herokuapp.com/#/");
        home = new HomePage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);
    }

    @Test
    void testAddAndRemoveFromCart() throws InterruptedException {
        Thread.sleep(3000); // Use WebDriverWait in production!
        home.dismissWelcomeBanner();
        product.addFirstItemToCart();
        product.openCart();

        Assertions.assertEquals("1", cart.getQuantity());
        cart.removeItem();
        Thread.sleep(2000); // Wait for UI update
    }

    @AfterAll
    void teardown() {
        driver.quit();
    }
}


//package tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.CartPage;
//import pages.HomePage;
//import pages.LoginPage;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class CartTest {
//
//    private WebDriver driver;
//    private final String baseUrl = "https://juice-shop.herokuapp.com/#/";
//
//    @BeforeAll
//    void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(baseUrl);
//    }
//
//    @Test
//    @Order(1)
//    void testAddToCart() throws InterruptedException {
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
//        Assertions.assertTrue(cart.isItemInCart(), "Item should be visible in the cart.");
//    }
//
//    @Test
//    @Order(2)
//    void testRemoveFromCart() {
//        LoginPage login = new LoginPage(driver);
//        HomePage home = new HomePage(driver);
//        CartPage cart = new CartPage(driver);
//
//        // Consider moving credentials to configuration
//        login.login("admin@juice-sh.op", "admin123");
//
//        home.addFirstProductToCart();
//        home.goToCart();
//
//        Assertions.assertTrue(cart.isItemInCart(), "Item should be added to cart");
//
//        cart.removeItem();
//        Assertions.assertFalse(cart.isItemInCart(), "Item should be removed from cart");
//    }
//
////    @Test
////    @Order(2)
////    void testRemoveFromCart() throws InterruptedException {
////        LoginPage login = new LoginPage(driver);
////        HomePage home = new HomePage(driver);
////        CartPage cart = new CartPage(driver);
////
////        login.login("admin@juice-sh.op", "admin123");
////        Thread.sleep(2000);
////
////        home.addFirstProductToCart();
////        home.goToCart();
////
////        assertTrue(cart.isItemInCart(), "Item should be added.");
////
////        cart.removeItem();
////        Thread.sleep(1000);
////    }
//
//    @AfterEach
//    void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
