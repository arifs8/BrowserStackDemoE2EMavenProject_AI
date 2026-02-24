package com.browserstack.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Sign In']")
    private WebElement signInLink;

    @FindBy(xpath = "//*[text()='Select Username']")
    private WebElement usernameDropdown;

    @FindBy(xpath = "//*[text()='demouser']")
    private WebElement demoUserOption;

    @FindBy(xpath = "//*[text()='Select Password']")
    private WebElement passwordDropdown;

    @FindBy(xpath = "//*[text()='testing123']")
    private WebElement validPasswordOption;

    @FindBy(xpath = "//button[text()='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class, 'api-error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[text()='iPhone 12 Mini']/following-sibling::div[text()='Add to cart']")
    private WebElement addToCartIPhone12Mini;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        } catch (Exception e) {
            throw new Exception("Sign In link not clickable: " + e.getMessage());
        }
    }

    public void login(String user, String pass) throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(usernameDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(demoUserOption)).click();
            wait.until(ExpectedConditions.elementToBeClickable(passwordDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(validPasswordOption)).click();
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            throw new Exception("Login procedure failed: " + e.getMessage());
        }
    }

    public void addIPhoneToCart() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartIPhone12Mini)).click();
        } catch (Exception e) {
            throw new Exception("Product Add to Cart failed: " + e.getMessage());
        }
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }
}
