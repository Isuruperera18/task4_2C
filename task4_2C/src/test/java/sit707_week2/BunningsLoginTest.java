package sit707_week2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class BunningsLoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @Test
    public void testValidLogin() {
        driver.get("https://www.bunnings.com.au/login");
        WebElement usernameField = driver.findElement(By.id("username")); // Adjust ID accordingly
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("valid_user@example.com");
        passwordField.sendKeys("correct_pass");
        loginButton.click();

        String expectedUrl = "https://www.bunnings.com.au/dashboard"; // Adjust URL accordingly
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testInvalidUsername() {
        driver.get("https://www.bunnings.com.au/login");
        WebElement usernameField = driver.findElement(By.id("username")); // Adjust ID accordingly
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("invalid_user@example.com");
        passwordField.sendKeys("correct_pass");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message")); // Adjust ID accordingly
        assertEquals("Invalid username", errorMessage.getText()); // Adjust error message accordingly
    }

    @Test
    public void testInvalidPassword() {
        driver.get("https://www.bunnings.com.au/login");
        WebElement usernameField = driver.findElement(By.id("username")); // Adjust ID accordingly
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("valid_user@example.com");
        passwordField.sendKeys("incorrect_pass");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message")); // Adjust ID accordingly
        assertEquals("Invalid password", errorMessage.getText()); // Adjust error message accordingly
    }

    @Test
    public void testEmptyUsername() {
        driver.get("https://www.bunnings.com.au/login");
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        passwordField.sendKeys("correct_pass");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message")); // Adjust ID accordingly
        assertEquals("Username required", errorMessage.getText()); // Adjust error message accordingly
    }

    @Test
    public void testEmptyPassword() {
        driver.get("https://www.bunnings.com.au/login");
        WebElement usernameField = driver.findElement(By.id("username")); // Adjust ID accordingly
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("valid_user@example.com");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message")); // Adjust ID accordingly
        assertEquals("Password required", errorMessage.getText()); // Adjust error message accordingly
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        driver.get("https://www.bunnings.com.au/login");
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message")); // Adjust ID accordingly
        assertEquals("Username and password required", errorMessage.getText()); // Adjust error message accordingly
    }
}
