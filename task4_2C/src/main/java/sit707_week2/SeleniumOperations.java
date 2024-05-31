package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.util.concurrent.TimeUnit;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        // Set implicit wait to handle reCAPTCHA
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Load a webpage in chromium browser.
        driver.get(url);

        // Fill out registration form for Officeworks
        try {
            WebElement firstNameElement = driver.findElement(By.id("firstname"));
            firstNameElement.sendKeys("Deelaka");

            WebElement lastNameElement = driver.findElement(By.id("lastname"));
            lastNameElement.sendKeys("Rathnayake");

            WebElement phoneNumberInputElement = driver.findElement(By.id("phoneNumber"));
            phoneNumberInputElement.sendKeys("0123456789");

            WebElement emailElement = driver.findElement(By.id("email"));
            emailElement.sendKeys("deelaka.rathnayake@gmail.com");

            WebElement passwordElement = driver.findElement(By.id("password"));
            passwordElement.sendKeys("1234");

            WebElement confirmPasswordElement = driver.findElement(By.id("confirmPassword"));
            confirmPasswordElement.sendKeys("1234");

            // Submit the form
            WebElement createAccountButton = driver.findElement(By.xpath("//button[@type='submit']"));
            createAccountButton.click();

            // Take screenshot after submission
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("officeworks_registration_page.png"));
            
            // Sleep for 2 seconds
            sleep(2);
        } catch (Exception e) {
            System.err.println("Error occurred while filling out the registration form: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
             driver.quit();
        }
    }
    
    public static void linkedin_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load the LinkedIn signup page
        driver.get(url);

        // Fill out registration form for LinkedIn
        try {
            WebElement emailElement = driver.findElement(By.id("email-address"));
            emailElement.sendKeys("deelaka.rathnayake@gmail.com");

            WebElement passwordElement = driver.findElement(By.id("password"));
            passwordElement.sendKeys("1234");

            // Submit the form using JavaScriptExecutor
            WebElement joinButton = driver.findElement(By.id("join-form-submit"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", joinButton);

            // Take screenshot after submission
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("linkedin_registration_page.png"));

            // Sleep for 2 seconds
            sleep(2);
        } catch (Exception e) {
            System.err.println("Error occurred while filling out the registration form: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

}

