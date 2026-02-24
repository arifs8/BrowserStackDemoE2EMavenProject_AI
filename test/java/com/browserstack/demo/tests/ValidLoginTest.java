package com.browserstack.demo.tests;

import com.browserstack.demo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidLoginTest {
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
    public void testValidLoginAndAddToCart() throws Exception {
        loginPage.clickSignIn();
        loginPage.login("demouser", "testing123");
        loginPage.addIPhoneToCart();
    }

    @Test(priority = 2)
    public void testLoginWithRememberMe() throws Exception {
        loginPage.clickSignIn();
        loginPage.clickRememberMe();
        loginPage.login("demouser", "testing123");
        // Verification would typically involve checking cookies or session persistence
    }

    @Test(priority = 3)
    public void testCreateAccountRedirection() throws Exception {
        loginPage.clickSignIn();
        loginPage.clickCreateAccount();
        // Verification: Check if URL changed or specific registration element is present
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
