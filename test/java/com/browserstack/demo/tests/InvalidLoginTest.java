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

    @Test
    public void testInvalidLoginFlow() throws Exception {
        loginPage.clickSignIn();
        // Simulating invalid flow by clicking login without selecting credentials
        // On bstackdemo, an error occurs if 'Log In' is clicked without selections
        loginPage.login("", ""); 
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid"), "Error message validation failed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
