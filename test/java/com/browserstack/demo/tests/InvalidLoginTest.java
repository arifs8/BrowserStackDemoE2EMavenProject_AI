package com.browserstack.demo.tests;

import com.browserstack.demo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTest {
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
    public void testEmptyCredentialsLogin() throws Exception {
        loginPage.clickSignIn();
        loginPage.login("", ""); 
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid"), "Error message validation failed");
    }

    @Test(priority = 2)
    public void testIncorrectPasswordLogin() throws Exception {
        loginPage.clickSignIn();
        loginPage.login("demouser", "wrong_password");
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid"), "Error message validation failed for wrong password");
    }

    @Test(priority = 3)
    public void testForgotPasswordRedirection() throws Exception {
        loginPage.clickSignIn();
        loginPage.clickForgotPassword();
        // Verification: Check if redirected to recovery page
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
