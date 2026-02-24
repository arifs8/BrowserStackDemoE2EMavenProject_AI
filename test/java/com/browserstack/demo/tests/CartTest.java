package com.browserstack.demo.tests;

import com.browserstack.demo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void testAddMultipleProducts() throws Exception {
        loginPage.clickSignIn();
        loginPage.login("demouser", "testing123");
        
        loginPage.addIPhoneToCart();
        loginPage.addPixelToCart();
        
        int count = loginPage.getCartQuantity();
        Assert.assertEquals(count, 2, "Cart count mismatch after adding two products");
    }

    @Test(priority = 2)
    public void testRemoveProductFromCart() throws Exception {
        loginPage.clickSignIn();
        loginPage.login("demouser", "testing123");
        
        loginPage.addIPhoneToCart();
        int countBefore = loginPage.getCartQuantity();
        
        loginPage.removeProduct();
        int countAfter = loginPage.getCartQuantity();
        
        Assert.assertEquals(countAfter, countBefore - 1, "Cart count did not decrement after removal");
    }

    @Test(priority = 3)
    public void testCartPersistenceAfterLogout() throws Exception {
        loginPage.clickSignIn();
        loginPage.login("demouser", "testing123");
        
        loginPage.addIPhoneToCart();
        loginPage.logout();
        
        loginPage.clickSignIn();
        loginPage.login("demouser", "testing123");
        
        int count = loginPage.getCartQuantity();
        Assert.assertTrue(count > 0, "Cart items lost after logout/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
