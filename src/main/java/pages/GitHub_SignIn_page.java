package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// second class for login page
// it contains all UI elements on this page and methods to interact with them

public class GitHub_SignIn_page {
    private WebDriver driver;
    public GitHub_SignIn_page(WebDriver driver) { // constructor
        this.driver = driver;
    }

    // Web elements
        private By usernameField = By.id("login_field");
        private By passwordField = By.id("password");
        private By signInButton = By.name("commit");
   //methods

        public void enterNameEmail(String username) {
            driver.findElement(usernameField).sendKeys(username);

        }
        public void enterPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);

        }
        public void clickSignInButton() {
            driver.findElement(signInButton).click();
        }
    }


